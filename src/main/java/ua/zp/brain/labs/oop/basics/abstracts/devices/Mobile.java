package ua.zp.brain.labs.oop.basics.abstracts.devices;

import java.util.Objects;

/**
 * Creates java object that represents simple mobile Phone
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class Mobile extends AbstractPhone {

    private int simCount;
    private String display;

    /**
     * Create empty Phone
     */
    public Mobile() {
        super();
    }

    /**
     * Create Phone with given values
     *
     * @param name     String name of Phone
     * @param serial   String serial number of Phone
     * @param simCount int SIM Card q-ty
     * @param display  String
     */
    public Mobile(String name, String serial, int simCount, String display) {
        super(name, serial);
        this.simCount = simCount;
        this.display = display;
    }

    public int getSimCount() {
        return simCount;
    }

    public void setSimCount(int simCount) {
        this.simCount = simCount;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
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
        System.out.println("if phone is turned off, turns it on by the press and hold the \"red\" button.");
    }

    /**
     * Processes Power off Device
     */
    @Override
    public void powerOff() {
        System.out.println("if phone is turned on, turns it off by the press and hold \"red\" button.");
    }

    /**
     * Make a Phone call
     */
    @Override
    public void call() {
        System.out.println("\"Phone call sequence\". When the phone is powered on and is on waiting mode, the number of the called party "
                + "is dialed by pressing the corresponding buttons, and the green button with the image of the "
                + "handset is pressed, then a phone call is made.");
    }

    @Override
    public String toString() {
        return "Mobile{ " + super.toString() +
                "simCount=" + simCount +
                ", display='" + display + '\'' +
                " } ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mobile)) return false;
        if (!super.equals(o)) return false;
        Mobile mobile = (Mobile) o;
        return simCount == mobile.simCount &&
                Objects.equals(display, mobile.display);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), simCount, display);
    }
}
