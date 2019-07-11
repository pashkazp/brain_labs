package ua.zp.brain.labs.oop.basics.lab31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProxySessionClient {

    private static final String IP_ADDRESS = "localhost";
    private static final int PORT = 8888;

    private static Socket socket;
    private static BufferedReader in;
    private static PrintWriter out;
    private static BufferedReader inputUser;
    private static CountDownLatch cdl = new CountDownLatch(1);

    public static void main(String[] args) {
        try {
            ExecutorService executor;            socket = new Socket(IP_ADDRESS, PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            inputUser = new BufferedReader(new InputStreamReader(System.in));
            executor = Executors.newFixedThreadPool(2);
            executor.execute(new ReadMsg());
            executor.execute(new WriteMsg());
            executor.shutdown();

            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(-1);
            } finally {
                executor.shutdownNow();
                System.exit(0);
            }

        } catch (UnknownHostException e) {
            System.err.println("Э-э-э-э—э... А куда это мы пошли?" + e.getMessage());
            System.exit(-1);
        } catch (IllegalArgumentException e) {
            System.err.println("Что-то с номером порта не то. Проверь. " + e.getMessage());
            System.exit(-1);
        } catch (SecurityException e) {
            System.err.println("Отмычки не подошли. Бозопасность алярмит. Валим отсюда! " + e.getMessage());
            System.exit(-1);
        } catch (IOException e) {
            System.err.println("Непонятки ввода-вывода. " + e.getMessage());
            System.exit(-1);
        }
    }

    private static void exitClient() {
        try {
            if (!socket.isClosed()) {
                out.println("--quit");
                socket.close();
                System.out.println("Матрица закрыла соединение...");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            cdl.countDown();
        }
    }

    /**
     * Thread that read messages from server and prints it to console
     */
    private static class ReadMsg extends Thread {
        @Override
        public void run() {
            String str;
            try {
                while (true) {
                    str = in.readLine();
                    if (str.equals("--stop")) {
                        exitClient();
                        break;
                    }
                    System.out.println(str);
                }
            } catch (IOException | NullPointerException e) {
                System.err.println(e.getMessage());
                exitClient();
            }
        }
    }

    /**
     * Thread that read user input and send it to server
     */
    public static class WriteMsg extends Thread {
        @Override
        public void run() {
            while (true) {
                String message;
                try {
                    message = inputUser.readLine();
                    if (message.equals("--quit")) {
                        exitClient();
                        break;
                    } else {
                        out.println(message);
                    }
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                    exitClient();
                }
            }
        }
    }
}
