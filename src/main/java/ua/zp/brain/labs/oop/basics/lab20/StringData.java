package ua.zp.brain.labs.oop.basics.lab20;

/**
 * Class that represents String data keeper
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class StringData extends AbstractData {
    private Type type;
    private String data;

    /**
     * Construct class with specifies values
     *
     * @param id   long unique id
     * @param type {@link Type} type of stored data
     * @param data String data
     * @param <T>  generic type that represents abstract {@link AbstractData} and interface {@link Storeable}
     */
    public <T extends AbstractData> StringData(long id, Type type, T data) {
        super(id);
        this.type = type;
        this.data = data.convertToString();
    }

    @Override
    public String toString() {
        return "StringData{  " + super.toString() +
                "type=" + type +
                ", data='" + data + '\'' +
                " } ";
    }

    /**
     * @return String representation of stored data
     */
    @Override
    public String convertToString() {
        return data;
    }
}
