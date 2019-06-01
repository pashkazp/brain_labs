package ua.zp.brain.labs.oop.basics.lab19;

/**
 * An exception  that throws when there is no activity on {@link GameConsole} for a long time
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class NoActivityException extends Exception {
    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public NoActivityException() {
        super();
    }

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public NoActivityException(String message) {
        super(message);
    }
}
