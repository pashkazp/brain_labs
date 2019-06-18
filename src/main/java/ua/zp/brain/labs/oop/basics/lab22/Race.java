package ua.zp.brain.labs.oop.basics.lab22;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

import static java.lang.Thread.sleep;

/**
 * Emulate multithreaded Car racing with  Thread start
 */
public class Race {

    private static AtomicLong startRaceTime;

    public static void main(String[] args) {
        List<RaceCarRunnable> cars = new ArrayList<>();

        CountDownLatch cdl = new CountDownLatch(5);
        startRaceTime = new AtomicLong();

        cars.add(new RaceCarRunnable("Killer", 100, 1000, cdl, startRaceTime));
        cars.add(new RaceCarRunnable("Beeper", 95, 1000, cdl, startRaceTime));
        cars.add(new RaceCarRunnable("Bomber", 77, 1000, cdl, startRaceTime));
        cars.add(new RaceCarRunnable("Joker", 99, 1000, cdl, startRaceTime));
        cars.add(new RaceCarRunnable("Turtle", 88, 1000, cdl, startRaceTime));

        List<Thread> threads = new ArrayList<>();

        for (RaceCarRunnable rc : cars) {
            threads.add(new Thread(rc));
        }
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

                startRaceTime.set(System.currentTimeMillis());

                for (Thread t : threads) {
                    t.start();
                }

            }
        }
        ).start();

    }
}
