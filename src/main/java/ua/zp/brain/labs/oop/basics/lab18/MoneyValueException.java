package ua.zp.brain.labs.oop.basics.lab18;

/**
 * An exception that throws when there are some misunderstandings in transaction amount
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class MoneyValueException extends RuntimeException {
    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public MoneyValueException() {
        super();
    }

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public MoneyValueException(String message) {
        super(message);
    }
}
