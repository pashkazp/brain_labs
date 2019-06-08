package ua.zp.brain.labs.oop.basics.lab20;

public class DocumentProcessorUtil {
    private static long ID_COUNTER;

    private DocumentProcessorUtil() {
    }

    public static <T extends AbstractData & Storeable> StringData convert(T data) {
        StringData stringData = new StringData(getCounter(), data.getType(),data);
        return stringData;
    }

    public static <T> void build(Storeable storeObj, T data) {
        storeObj.write(data);
    }

    public static void main(String[] args) {
        XmlData xmlData = new XmlData(getCounter());
        NumericData numericData = new NumericData(getCounter());
        BinaryData binaryData = new BinaryData(getCounter());

        System.out.println(xmlData);
        System.out.println(numericData);
        System.out.println(binaryData);
        System.out.println("================");

        String xmlString = "<?xml version=\"1.0\"?><Tests>qwerty</Tests>";
        Double d = 123.456789;
        byte[] b = "Данные в байтах".getBytes();

        build(xmlData, xmlString);
        build(numericData, d);
        build(binaryData, b);

        System.out.println(xmlData);
        System.out.println(numericData);
        System.out.println(binaryData);
        System.out.println("================");

        StringData sdXml = convert(xmlData);
        StringData sdNum = convert(numericData);
        StringData sdBin = convert(binaryData);

        System.out.println(sdXml.toString());
        System.out.println(sdNum.toString());
        System.out.println(sdBin.toString());
    }

    public static long getCounter() {
        return ID_COUNTER++;
    }
}
