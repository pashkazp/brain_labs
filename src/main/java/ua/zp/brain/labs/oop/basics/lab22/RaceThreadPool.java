package ua.zp.brain.labs.oop.basics.lab22;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

import static java.lang.Thread.sleep;

/**
 * Emulate multithreading Car Racing with ThreadPool
 */
public class RaceThreadPool {

    private static AtomicLong startRaceTime;
    private static ExecutorService executor;

    public static void main(String[] args) {
        ArrayList<RaceCarRunnable> cars = new ArrayList<>();

        CountDownLatch cdl = new CountDownLatch(5);
        startRaceTime = new AtomicLong();

        cars.add(new RaceCarRunnable("Killer", 100, 1000, cdl, null));
        cars.add(new RaceCarRunnable("Beeper", 95, 1000, cdl, null));
        cars.add(new RaceCarRunnable("Bomber", 77, 1000, cdl, null));
        cars.add(new RaceCarRunnable("Joker", 99, 1000, cdl, null));
        cars.add(new RaceCarRunnable("Turtle", 88, 1000, cdl, null));

        executor = Executors.newFixedThreadPool(2);
        startRace(cars);

        executor.shutdown();
        while (!executor.isTerminated()) {
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
        System.out.println(cars.get(winner).getName() + " winner of the race with time " + bestTime + " !!!");
    }

    public static void startRace(ArrayList<RaceCarRunnable> cars) {

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

        for (RaceCarRunnable car : cars) {
            executor.execute(car);
        }
    }
}
