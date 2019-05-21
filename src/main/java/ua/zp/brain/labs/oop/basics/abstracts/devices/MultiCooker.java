package ua.zp.brain.labs.oop.basics.abstracts.devices;

/**
 * Create MultiCook Device that inherited from {@link AbstractMultiCooker}
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class MultiCooker extends AbstractMultiCooker {

    /**
     * Create empty MultiCooker Device
     */
    public MultiCooker() {
        super();
    }

    /**
     * Create MultiCooker device with the given values
     *
     * @param name
     * @param serial
     */
    public MultiCooker(String name, String serial) {
        super(name, serial);
    }

    /**
     * Make selection of appropriate cooking program
     */
    public void switchProgram() {
        powerOn();
        System.out.println("Select the program in the menu by pressing the appropriate buttons.");
    }

    /**
     * Performing the cooking process
     */
    @Override
    public void cook() {
        System.out.println("Place the ingredients in the cooking container, close the container with the lid");
        switchProgram();
        System.out.println("select the program in the menu by pressing the buttons, start the cooking process.");
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
        System.out.println("If device not connected to outlet connect device to outlet");
    }

    /**
     * Processes Power off Device
     */
    @Override
    public void powerOff() {
        System.out.println("If device connected to outlet disconnect device from outlet");
    }
}
