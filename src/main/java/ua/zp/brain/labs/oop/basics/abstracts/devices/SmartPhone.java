package ua.zp.brain.labs.oop.basics.abstracts.devices;

import java.util.Objects;

/**
 * Creates simple object that represents dumb SmartPhone. It is the enlargement of the {@link Mobile}
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class SmartPhone extends Mobile {

    private String os;

    /**
     * Create empty SmartPhone
     */
    public SmartPhone() {
        super();
    }

    /**
     * Create SmartPhone with given values
     *
     * @param name     String name of Phone
     * @param serial   String serial number of Phone
     * @param simCount int SIM Card q-ty
     * @param display  String
     * @param os    String the name Operation System of SmartPone
     */
    public SmartPhone(String name, String serial, int simCount, String display, String os) {
        super(name, serial, simCount, display);
        this.os = os;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    /**
     * Performing the launch application
     */
    public static void runApp() {
        System.out.println("If device if powered on, device is unlocked, touch the icon of the appropriated icon");
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
        System.out.println("If device if powered off, press and hold the \"Power button\" and release it after 5 sec.");
    }

    /**
     * Processes Power off Device
     */
    @Override
    public void powerOff() {
        System.out.println("If device if powered on, press the \"Power button\". Touch the \"power off\" icon on the device screen and confirm your choice..");
    }

    /**
     * Make a Phone call
     */
    @Override
    public void call() {
        super.call();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SmartPhone)) return false;
        if (!super.equals(o)) return false;
        SmartPhone that = (SmartPhone) o;
        return Objects.equals(os, that.os);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), os);
    }

    @Override
    public String toString() {
        return "SmartPhone{ " + super.toString() +
                "os='" + os + '\'' +
                " } ";
    }
}
