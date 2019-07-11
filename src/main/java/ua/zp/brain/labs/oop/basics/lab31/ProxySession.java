package ua.zp.brain.labs.oop.basics.lab31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Simple java chat with blackjack and girls...
 */
public class ProxySession {

    private static final String HELP = "--help - эта подсказка\n"
            + "--quit - выход\n"
            + "--list - список активных пользователей\n"
            + "сообщение отпрвлять в формате: '@nickname текст' - для конкретного пользователя или 'текст' - для всех";

    private static final int PORT = 8888;
    private static final int MAX_MESSAGES = 10000;
    private static final int OLD_MES_CLEAN_INTERVAL_MILS = 60 * 60 * 10 * 1000; //10 min
    private static final int MES_DEAD_AFTER_DAYS = 10; //10 days
    private static final int DEAD_CLIENT_CLEAN_INTERVAL_MILS = 60 * 1000; //1 min
    private static final int CLIENT_DEAD_AFTER_MIN = 10; //10 min
    private static final int DEAD_USER_CLEAN_INTERVAL_MILS = 60 * 60 * 24 * 1000; //24 hours
    private static final int USER_DEAD_AFTER_DAY = 30; //30 days
    private static final int MES_QUEUE_SEND_INTERVAL_MILS = 3000; //3 sec
    private static final Pattern pattern = Pattern.compile("^@[a-zA-Z0-9]{8,}");
    private static HashSet<User> users = new HashSet<>(500);
    private static List<Message> messages = new LinkedList<>();
    private static List<Client> clients = new LinkedList<>();
    private static Iterator<Client> ic = clients.iterator();
    private static Iterator<User> iu = users.iterator();
    private static Iterator<Message> im = messages.iterator();

    public static void main(String[] args) {
        System.out.println("Запущен супер-дупер транс-атлантический сверхсекретный мессенджер");
        ExecutorService pool = Executors.newFixedThreadPool(500);
        pool.execute(new OldMessagesCleaner());
        pool.execute(new DeadClientsCleaner());
        pool.execute(new DeadUserCleaner());
        pool.execute(new MessagesSender());
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                pool.execute(new Client(server.accept()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Thread that clean old messages from list of messages.
     * Make cleaning periodically
     */
    private static class OldMessagesCleaner extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println(this.getClass().getName() + " Чистим авгиевы конюшни в сообщениях");
                int i = 0;
                synchronized (im) {
                    im = messages.iterator();
                    while (im.hasNext()) {
                        Message message = im.next();
                        i++;
                        long periodDays = Math.abs(message.getDate().until(LocalDateTime.now(), ChronoUnit.DAYS));
                        if (periodDays >= MES_DEAD_AFTER_DAYS) {
                            System.out.println(this.getClass().getName() + " Вычистили: " + message.toString());
                            im.remove();
                        }
                    }
                }
                try {
                    System.out.println(this.getClass().getName() + " Чистку авгиевых конюшен в "
                            + i + " сообщениях закончили. спим...");
                    sleep(OLD_MES_CLEAN_INTERVAL_MILS); //10 min
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Thread that clean clients without activity
     */
    private static class DeadClientsCleaner extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println(this.getClass().getName() + " Чистим заснувших пользователей.");
                int i = 0;
                synchronized (ic) {
                    ic = clients.iterator();
                    while (ic.hasNext()) {
                        Client client = ic.next();
                        i++;
                        long minutes = client.lastActivity.until(LocalDateTime.now(), ChronoUnit.MINUTES);
                        if (minutes >= CLIENT_DEAD_AFTER_MIN || client.socket.isClosed()) {
                            System.out.println(this.getClass().getName() + " Выкинули: " + client.getUser().getName());
                            if (!client.socket.isClosed()) {
                                try {
                                    if (client.getOut() != null) {
                                        client.getOut().println("--stop");
                                    }
                                    client.socket.close();

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            //client.exitClient();
                            ic.remove();
                            client.interrupt();
                        }
                    }
                }
                try {
                    System.out.println(this.getClass().getName()
                            + " Чистку заснувших пользователей закончили. Проверили список из " + i + ". Cпим...");
                    sleep(DEAD_CLIENT_CLEAN_INTERVAL_MILS); // 1min
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Thread that clean lis of users who do not enter for long time
     */
    private static class DeadUserCleaner extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println(this.getClass().getName() + " Чистим пропавших безвести пользователей.");
                int i = 0;
                synchronized (ic) {
                    synchronized (iu) {
                        iu = users.iterator();
                        label:
                        while (iu.hasNext()) {
                            User user = iu.next();
                            i++;
                            Period period = Period.between(LocalDate.now(), user.getLastLogin());
                            if (period.getDays() >= USER_DEAD_AFTER_DAY) {
                                ic = clients.iterator();
                                while (ic.hasNext()) {
                                    Client client = ic.next();
                                    if (client.getUser().equals(user)) {
                                        user.setLastLogin(LocalDate.now());
                                        continue label;
                                    }
                                }
                                System.out.println(this.getClass().getName() + " Попрощались с: " + user.getName());
                                iu.remove();
                            }
                        }
                    }
                }
                try {
                    System.out.println(this.getClass().getName() + " Чистку безвести пропавших среди "
                            + i + " пользователей закончили. спим...");
                    sleep(DEAD_USER_CLEAN_INTERVAL_MILS); //24 hour
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Thread that send message from list messages to active clients and remove this messages from list
     */
    private static class MessagesSender extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (ic) {
                    synchronized (im) {
                        ic = clients.iterator();
                        while (ic.hasNext()) { //for all active clients
                            Client client = ic.next();
                            im = messages.iterator();
                            while (im.hasNext()) { // for all messages
                                Message message = im.next();
                                // find message for some active user,
                                // send it and remove message from list
                                if (message.toUser.equals(client.getUser().getName())) {
                                    String d =  message.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                                    client.getOut().println("("+ d + ") " + client.getUser().getName() + " : " + message.getMessage());
                                    im.remove();
                                }
                            }
                        }
                    }
                }
                try {
                    //System.out.println(this.getClass().getName() + " отправили. спим...");
                    sleep(MES_QUEUE_SEND_INTERVAL_MILS); // 3sec
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private static class Client extends Thread {
        private Socket socket;

        private BufferedReader in;
        private PrintWriter out;
        private User user;
        private LocalDateTime lastActivity;

        Client(Socket socket) {
            this.socket = socket;
        }

        public PrintWriter getOut() {
            return out;
        }

        User getUser() {
            return user;
        }

        @Override
        public void run() {
            try {
                String name;
                String pass;
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Вас приветствует супер-дупер транс-атлантический сверхсекретный мессенджер.");


                label:
                for (int i = 0; i < 3; i++) {
                    out.println("Введи свой никнейм длиной 8 символов минимум (на латыни, циферки можно):");
                    name = in.readLine();
                    if (name != null && !name.matches("^[a-zA-Z0-9]{8,}$")) {
                        out.println("Ну я же просил латынь с циферками... А ты что написал? Хорошо, что не нарисовал...");
                        continue;
                    }
                    out.println("А теперь введи волшебное слово длиной 8 символов минимум (на латыни, циферки можно):");
                    pass = in.readLine();
                    if (pass != null && !pass.matches("^[a-zA-Z0-9]{8,}$")) {
                        out.println("Ну я же просил латынь с циферками... А ты что написал? Хорошо, что не нарисовал...");
                        continue;
                    }
                    if (name != null && pass != null) {
                        synchronized (iu) {
                            iu = users.iterator();
                            while (iu.hasNext()) {
                                User user = iu.next();
                                if (user.getName().equals(name)) {
                                    if (!user.getPass().equals(pass)) {
                                        switch (i) {
                                            case 0:
                                                out.println("Пароль не тот. Ошибся? Пробуй еще раз...");
                                                continue label;
                                            case 1:
                                                out.println("Хакер? Пробуй еще раз...");
                                                continue label;
                                            default:
                                                out.println("Точно хакер. Я твой адрес по IP вычислил и записал...");
                                                out.println("--stop");
                                                break label;
                                        }
                                    } else {
                                        this.user = user;
                                        this.user.setLastLogin(LocalDate.now());
                                        System.out.println("Зашел пользователь: " + this.getUser().getName());
                                        break;
                                    }
                                }
                            }
                            if (this.user == null) {
                                this.user = new User(name, pass);
                                System.out.println("Зарегистрировался новый пользователь: " + this.getUser().getName());
                                users.add(this.user);
                                break;
                            }
                        }
                    }
                }
                if (this.user != null) {
                    synchronized (ic) {
                        clients.add(this);
                    }
                } else {
                    if (!socket.isClosed())
                        socket.close();
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            String message;
            try {
                try {
                    out.println("Добро пожаловать, " + user.getName() + "!");
                    out.println(HELP);
                    while (true) {
                        this.lastActivity = LocalDateTime.now();
                        message = in.readLine();
                        if (message == null) {
                            continue;
                        }
                        if (message.equals("--quit")) {
                            this.exitClient();
                            break;
                        }
                        if (message.equals("--help")) {
                            out.println(HELP);
                            continue;
                        }
                        if (message.equals("--list")) {
                            synchronized (ic) {
                                out.println("числятся активными:");
                                for (Client c : clients) {
                                    out.println(c.getUser().getName());
                                }
                            }
                            continue;
                        }
                        if (message.startsWith("@")) {
                            Matcher matcher = pattern.matcher(message);
                            if (matcher.find()) {
                                String username = message.substring(matcher.start() + 1, matcher.end());
                                message = message.substring(matcher.end());
                                if (message.length() > 0) {
                                    synchronized (iu) {
                                        for (User user : users) {
                                            if (user.getName().equals(username)) {
                                                synchronized (im) {
                                                    messages.add(new Message(this.getUser().getName(), user.getName(), message));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            continue;
                        }
                        if (message.length() > 100) {
                            out.println("спамим? флудим?");
                        } else {
                            synchronized (ic) {
                                synchronized (im) {
                                    for (Client client : clients) {
                                        if (messages.size() >= MAX_MESSAGES) {
                                            break;
                                        }
                                        if (client != this) {
                                            messages.add(new Message(this.getUser().getName(), client.getUser().getName(), message));
                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch (NullPointerException e) {
                    System.err.println(e.getMessage());
                }
            } catch (IOException e) {
                this.exitClient();
            }
        }

        void exitClient() {
            System.out.println(this.getClass().getName() + " " + this.getUser() + " ушел...");
            try {
                if (!socket.isClosed()) {
                    out.println("--stop");
                    socket.close();
                }
                synchronized (ic) {
                    ic = clients.iterator();
                    while (ic.hasNext()) {
                        Client client = ic.next();
                        if (client.equals(this))
                            ic.remove();
                    }
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * simple representation of User entity
     */
    private static class User {
        private String name;
        private String pass;
        private LocalDate lastLogin;

        User(String name, String pass) {
            this.name = name;
            this.pass = pass;
            this.lastLogin = LocalDate.now();
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", lastLogin=" + lastLogin +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof User)) return false;
            User user = (User) o;
            return getName().equals(user.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getName());
        }

        public String getName() {
            return name;
        }

        String getPass() {
            return pass;
        }

        LocalDate getLastLogin() {
            return lastLogin;
        }

        void setLastLogin(LocalDate lastLogin) {
            this.lastLogin = lastLogin;
        }
    }

    /**
     * Simple representation of chat message
     */
    private static class Message {
        private String fromUser;
        private String toUser;
        private String message;
        private LocalDateTime date;

        Message(String fromUser, String toUser, String message) {
            this.fromUser = fromUser;
            this.toUser = toUser;
            this.message = message;
            this.date = LocalDateTime.now();
        }

        @Override
        public String toString() {
            return "Message{" +
                    "fromUser=" + fromUser +
                    ", toUser=" + toUser +
                    ", message='" + message + '\'' +
                    ", date=" + date +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Message)) return false;
            Message message1 = (Message) o;
            return getFromUser().equals(message1.getFromUser()) &&
                    getToUser().equals(message1.getToUser()) &&
                    getMessage().equals(message1.getMessage()) &&
                    getDate().equals(message1.getDate());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getFromUser(), getToUser(), getMessage(), getDate());
        }

        String getFromUser() {
            return fromUser;
        }

        String getToUser() {
            return toUser;
        }

        String getMessage() {
            return message;
        }

        public LocalDateTime getDate() {
            return date;
        }
    }

}
