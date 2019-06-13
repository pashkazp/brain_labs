package ua.zp.brain.labs.oop.basics.lab22;

import java.util.Objects;

/**
 * Simple Java object that represents abstract prototype of Car
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public abstract class Car implements Runnable {

    private String name;
    private int maxSpeed;

    /**
     * Construct Car with specified values
     *
     * @param name     String specified name of Car
     * @param maxSpeed int specified max Speed of Car
     */
    public Car(String name, int maxSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    public String getName() {
        return name;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return maxSpeed == car.maxSpeed &&
                name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, maxSpeed);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
