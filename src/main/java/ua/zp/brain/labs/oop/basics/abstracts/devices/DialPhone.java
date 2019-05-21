package ua.zp.brain.labs.oop.basics.abstracts.devices;

import java.util.Objects;

/**
 * Creates java object that represents simple Dialing Phone. It is the enlargement of the {@link AbstractPhone}
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class DialPhone extends AbstractPhone {

    private boolean answerphone;

    /**
     * Create empty DialPhone
     */
    public DialPhone() {
        super();
    }

    /**
     * Create DialPhone with given values
     *
     * @param name        String name of Phone
     * @param serial      String serial number of Phone
     * @param answerphone boolean have auto answer option
     */
    public DialPhone(String name, String serial, boolean answerphone) {
        super(name, serial);
        this.answerphone = answerphone;
    }

    public boolean hasAnswerphone() {
        return answerphone;
    }

    public void setAnswerphone(boolean answerphone) {
        this.answerphone = answerphone;
    }

    /**
     * Performing auto answer if present
     */
    public void autoAnswer() {
        if (answerphone) {
            System.out.println("If an incoming call arrives, waits for a few rings, picks up the handset, "
                    + "plays the greetings message, and switches to the recording mode.");
        } else {
            System.out.println("do nothing");
        }
    }

    /**
     * Make a Pphone call
     */
    @Override
    public void call() {
        System.out.println("If connected to outlet and interrupt button is pressed, for each digit of the "
                + "telephone number of the calling party, insert the finger into the hole with the numbers, "
                + "turn it clockwise until it stops, pull the finger out of the hole.");
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
        System.out.println("If device not connected to outlet connect to a telephone outlet");
    }

    /**
     * Processes Power off Device
     */
    @Override
    public void powerOff() {
        System.out.println("If device connected to outlet disconnect from telephone outlet");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DialPhone)) return false;
        if (!super.equals(o)) return false;
        DialPhone dialPhone = (DialPhone) o;
        return answerphone == dialPhone.answerphone;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), answerphone);
    }

    @Override
    public String toString() {
        return "DialPhone{ " + super.toString() +
                "answerphone=" + answerphone +
                " }";
    }
}
