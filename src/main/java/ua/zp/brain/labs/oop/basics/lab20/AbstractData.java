package ua.zp.brain.labs.oop.basics.lab20;

/**
 * Abstract Class that represents the keeper of some data.
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public abstract class AbstractData {
    private long id;

    /**
     * Construct abstract class and remember specifies Id
     *
     * @param id long
     */
    public AbstractData(long id) {
        this.id = id;
    }


    /**
     * @return data keeper's Id
     */
    public long getId() {
        return id;
    }

    /**
     * Convert stored any data to string
     *
     * @return String representation of stored data
     */
    public abstract String convertToString();

    @Override
    public String toString() {
        return "AbstractData{ " +
                "id=" + id +
                " } ";
    }
}
