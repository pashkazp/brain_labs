package ua.zp.brain.labs.oop.basics.abstracts.devices;

import java.util.Objects;

/**
 * The class of the Abstract Device, which is intended to build a typical household appliance tree.
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public abstract class AbstractDevice {
    private String name;
    private String serial;

    /**
     * Construct Abstract Device
     */
    protected AbstractDevice() {
        powerOn();
    }

    /**
     * Construct Abstract Device with given values
     *
     * @param name   String name of Device
     * @param serial String name Device Serial Number
     */
    protected AbstractDevice(String name, String serial) {
        this();
        this.name = name;
        this.serial = serial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getPasport() {
        return name + "#" + serial;
    }

    /**
     * Performing a power switching process
     */
    protected abstract void switchPower();

    /**
     * Processes Power on Device
     */
    protected abstract void powerOn();

    /**
     * Processes Power off Device
     */
    protected abstract void powerOff();

    @Override
    public String toString() {
        return "AbstractDevice{ " +
                "name='" + name + '\'' +
                ", serial=" + serial +
                " } ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractDevice)) return false;
        AbstractDevice that = (AbstractDevice) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(serial, that.serial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, serial);
    }
}
