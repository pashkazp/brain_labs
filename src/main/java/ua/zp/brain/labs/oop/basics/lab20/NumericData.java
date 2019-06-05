package ua.zp.brain.labs.oop.basics.lab20;

/**
 * Class that represents Numeric data keeper
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class NumericData extends AbstractData implements Storeable<Number> {
    private static final Type type = Type.NUM;
    private Number data;

    /**
     * Construct Class with specifies values
     *
     * @param id  long unique id
     */
    public  NumericData(long id) {
        super(id);
    }

    @Override
    public Number read() {
        return data;
    }

    @Override
    public void write(Number data) {
        this.data = data;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public String convertToString() {
        return String.valueOf(data);
    }

    /**
     * @return String representation of stored Numeric data
     */
    @Override
    public String toString() {
        return "NumericData{ " + super.toString() +
                "type=" + type +
                ", data=" + data +
                " } ";
    }
}
