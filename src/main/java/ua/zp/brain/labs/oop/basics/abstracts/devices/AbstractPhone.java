package ua.zp.brain.labs.oop.basics.abstracts.devices;

import ua.zp.brain.labs.oop.basics.abstracts.devices.AbstractDevice;

/**
 * A telephone is an abstract telephone that is intended for building a tree of telephone devices
 * and is included in the {@link AbstractDevice} home appliances tree.
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public abstract class AbstractPhone extends AbstractDevice {
    /**
     * Construct abstract
     */
    protected AbstractPhone() {
    }

    /**
     * Construct Abstract phone with given values
     *
     * @param name   String name of Phone
     * @param serial String serial number of Phone
     */
    protected AbstractPhone(String name, String serial) {
        super(name, serial);
    }

    /**
     * Make call by AbstractPhone
     */
    protected abstract void call();

}
