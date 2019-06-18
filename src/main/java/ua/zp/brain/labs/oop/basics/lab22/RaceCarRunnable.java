package ua.zp.brain.labs.oop.basics.lab22;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

import static java.lang.Thread.sleep;

/**
 * Simple Race Car that extend {@link Car}
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class RaceCarRunnable extends Car {

    private boolean finish;
    private int passed;
    private int distance;
    private CountDownLatch cdl;
    private long finishTime;
    private AtomicLong startRaceTime;

    /**
     * Cunstruct Race Car with specified values
     *
     * @param name     String name of Car
     * @param speed    int Max speed of Car
     * @param distance int Distance of Race
     * @param cdl      CountDownLatch for Finish
     */
    public RaceCarRunnable(String name, int speed, int distance, CountDownLatch cdl, AtomicLong startRaceTime) {
        super(name, speed);
        this.distance = distance;
        this.cdl = cdl;
        this.startRaceTime = startRaceTime;
    }

    public long getFinishTime() {
        return finishTime;
    }

    /**
     * @return int random speed from half of max speed to max speed
     */
    public int getRandomSpeed() {
        return ThreadLocalRandom.current().nextInt(getMaxSpeed() / 2, getMaxSpeed() + 1);
    }

    public boolean isFinish() {
        return finish;
    }

    /**
     * thread process that continued until car is finished.
     */
    @Override
    public void run() {
        if (startRaceTime == null) {
            startRaceTime = new AtomicLong(System.currentTimeMillis());
        }
        while (!isFinish()) {
            try {

                sleep(1000);

                int currentSpeed = getRandomSpeed();
                passed += currentSpeed;

                if (passed >= distance) {
                    cdl.countDown();
                    finish = true;
                    finishTime = System.currentTimeMillis() - startRaceTime.get();
                    System.out.println(getName() + " finished in " + finishTime/1000 + " time intervals !!!");
                } else {
                    System.out.printf("\'%s\' => speed: %d; progress: %d/%d\n", getName(), currentSpeed, passed, distance);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
