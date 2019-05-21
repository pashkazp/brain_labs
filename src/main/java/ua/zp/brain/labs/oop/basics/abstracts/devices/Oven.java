package ua.zp.brain.labs.oop.basics.abstracts.devices;

/**
 * Create dumb electrical Oven, that extends {@link AbstractMultiCooker} Device
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class Oven extends AbstractMultiCooker {

    /**
     * Create empty Oven device
     */
    public Oven() {
        super();
    }

    /**
     * Create the Oven with the given values
     *
     * @param name
     * @param serial
     */
    public Oven(String name, String serial) {
        super(name, serial);
    }

    /**
     * Cet cooking timer for appropriate value
     */
    public void initTimer() {
        powerOn();
        System.out.println("Turn the timer knob so that the pointer points to the required cooking time");
    }

    /**
     * Performing the cooking process
     */
    @Override
    public void cook() {
        initTimer();
        System.out.println("Put the food inside the oven and press the start button");

    }

    /**
     * Performing a power switching process
     */
    @Override
    public void switchPower() {
        powerOn();
        System.out.println("else");
        powerOff();
    }

    /**
     * Processes Power on Device
     */
    @Override
    public void powerOn() {
        System.out.println("If power switch is off, turn on the toggle switch.");
    }

    /**
     * Processes Power off Device
     */
    @Override
    public void powerOff() {
        System.out.println("If power switch is on, turn off the toggle switch.");
    }

    @Override
    public String toString() {
        return "Oven{ " + super.toString() + " } ";
    }
}
