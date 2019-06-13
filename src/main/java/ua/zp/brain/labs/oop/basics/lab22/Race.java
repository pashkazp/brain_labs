package ua.zp.brain.labs.oop.basics.lab22;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

public class Race {

    public static AtomicLong startRaceTime;

    public static void main(String[] args) {
        ArrayList<RaceCarRunnable> cars = new ArrayList<>();

        CountDownLatch cdl = new CountDownLatch(5);

        cars.add(new RaceCarRunnable("Killer", 100, 1000, cdl));
        cars.add(new RaceCarRunnable("Beeper", 95, 1000, cdl));
        cars.add(new RaceCarRunnable("Bomber", 77, 1000, cdl));
        cars.add(new RaceCarRunnable("Joker", 99, 1000, cdl));
        cars.add(new RaceCarRunnable("Turtle", 88, 1000, cdl));

        startRace(cars);

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
        System.out.println(cars.get(winner).getName() + " winner of the race!");
    }

    public static void startRace(ArrayList<RaceCarRunnable> cars) {
        ArrayList<Thread> threads = new ArrayList<>();

        for (RaceCarRunnable rc : cars) {
            threads.add(new Thread(rc));
        }

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
        }

        startRaceTime = new AtomicLong(System.currentTimeMillis());

        for (Thread t : threads) {
            t.start();
        }
    }
}
