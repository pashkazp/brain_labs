package ua.zp.brain.labs.oop.basics.abstracts.devices;

import ua.zp.brain.labs.oop.basics.abstracts.devices.AbstractDevice;

/**
 * A AbstractMultiCooker is an abstract cook device that is intended for building a tree of cook devices
 * and is included in the {@link AbstractDevice} home appliances tree.
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public abstract class AbstractMultiCooker extends AbstractDevice {

    /**
     * Create empty AbstractMultiCooker
     */
    protected AbstractMultiCooker() {
        super();
    }

    /**
     * Create AbstractMultiCooker with given values
     */
    protected AbstractMultiCooker(String name, String serial) {
        super(name, serial);
    }

    /**
     * Performing the cooking process
     */
    protected abstract void cook();
}
