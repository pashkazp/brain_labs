package ua.zp.brain.labs.oop.basics.lab20;

public class DocumentProcessorUtil {
    private static long ID_COUNTER;

    private DocumentProcessorUtil() {
    }

    public static <T extends AbstractData & Storeable> StringData convert(T data) {
        StringData stringData = new StringData(getCouter(), data.getType(),data);
        return stringData;
    }

    public static <T> void build(Storeable storeObj, T data) {
        storeObj.write(data);
    }

    public static void main(String[] args) {
        XmlData xmlData = new XmlData(getCouter());
        NumericData numericData = new NumericData(getCouter());
        BinaryData binaryData = new BinaryData(getCouter());
        System.out.println(xmlData);
        System.out.println(numericData);
        System.out.println(binaryData);

        System.out.println();

        String xmlString = "<?xml version=\"1.0\"?><Tests>qwerty</Tests>";
        Double d = 123.456789;
        byte[] b = "Данные в байтах".getBytes();

        build(xmlData, xmlString);
        build(numericData, d);
        build(binaryData, b);

        StringData sdXml = convert(xmlData);
        StringData sdNum = convert(numericData);
        StringData sdBin = convert(binaryData);

        System.out.println(xmlData);
        System.out.println(numericData);
        System.out.println(binaryData);

        System.out.println();

        System.out.println(sdXml.toString());
        System.out.println(sdNum.toString());
        System.out.println(sdBin.toString());

    }

    public static long getCouter() {
        return ID_COUNTER++;
    }
}
