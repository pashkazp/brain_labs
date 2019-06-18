package ua.zp.brain.labs.oop.basics.lab22;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

/**
 * Emulate multithreading Car Racing with ThreadPool
 */
public class RaceThreadPool {

    private static ExecutorService executor;

    public static void main(String[] args) {
        List<RaceCarRunnable> cars = new ArrayList<>();

        CountDownLatch cdl = new CountDownLatch(5);

        cars.add(new RaceCarRunnable("Killer", 100, 1000, cdl, null));
        cars.add(new RaceCarRunnable("Beeper", 95, 1000, cdl, null));
        cars.add(new RaceCarRunnable("Bomber", 77, 1000, cdl, null));
        cars.add(new RaceCarRunnable("Joker", 99, 1000, cdl, null));
        cars.add(new RaceCarRunnable("Turtle", 88, 1000, cdl, null));

        List<Thread> threads = new ArrayList<>();

        for (RaceCarRunnable rc : cars) {
            threads.add(new Thread(rc));
        }
        executor = Executors.newFixedThreadPool(2);
        startRace(threads);

        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int winner = -1;
        long bestTime = Long.MAX_VALUE;
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getFinishTime() < bestTime) {
                winner = i;
                bestTime = cars.get(winner).getFinishTime();
            }
        }
        System.out.println("\nAll finished--------------------------------------------------------");
        System.out.println(cars.get(winner).getName() + " winner of the race with time " + bestTime / 1000 + " !!!");
    }

    public static void startRace(List<Thread> threads) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                int countStart = 3;
                while (countStart >= 0) {
                    switch (countStart) {
                        case 0:
                            System.out.println("GO!!!\n");
                            break;
                        default:
                            System.out.printf("%d...\n", countStart);
                    }
                    countStart--;
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (Thread t : threads) {
                    executor.execute(t);
                }
                executor.shutdown();
            }
        }).start();
    }
}
