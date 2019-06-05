package ua.zp.brain.labs.oop.basics.lab20;

/**
 * Class that represents Xml data keeper
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class XmlData extends AbstractData implements Storeable<String> {
    private static final Type type = Type.XML;
    private String data;

    /**
     * Construct Class with specifies values
     *
     * @param id  long unique id
     */
    public XmlData(long id) {
        super(id);
    }

    @Override
    public String read() {
        return data;
    }

    @Override
    public void write(String data) {
        this.data = data;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "XmlData{     " + super.toString() +
                "type=" + type +

                ", data='" + data + '\'' +
                " } ";
    }

    /**
     * @return String representation of stored Xml data
     */
    @Override
    public String convertToString() {
        return data;
    }
}
