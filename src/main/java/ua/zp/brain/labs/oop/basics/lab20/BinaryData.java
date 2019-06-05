package ua.zp.brain.labs.oop.basics.lab20;

import java.util.Arrays;

/**
 * Class that represents Byte[] data keeper
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class BinaryData extends AbstractData implements Storeable<byte[]> {
    private static final Type type = Type.BIN;
    private byte[] data;

    /**
     * Construct Class with specifies values
     *
     * @param id long unique id
     */
    public BinaryData(long id) {
        super(id);
    }

    /**
     * @return String representation of stored Byte[] data
     */
    @Override
    public String convertToString() {
        return new String(data);
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public byte[] read() {
        return data;
    }

    @Override
    public void write(byte[] data) {
        this.data = data;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "BinaryData{  " + super.toString() +
                "type=" + type +
                ", data=" + Arrays.toString(data) +
                " } ";
    }
}
