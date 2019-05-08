package ua.zp.brain.labs.oop.basics.lab13;

/**
 * Application that assist to understand Wrapper classes
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class WrapperTest {
    public static void main(String[] args) {

        // wrapper samples for primitive types
        Integer i1 = 10;
        Integer i2 = Integer.valueOf(10);
        Integer i3 = new Integer(10);
        Integer i4 = Integer.parseInt("10");

        Byte b1 = (byte) 11;
        Byte b2 = Byte.valueOf((byte) 11);
        Byte b3 = new Byte((byte) 11);
        Byte b4 = Byte.parseByte("11");

        Short s1 = (short) 12;
        Short s2 = Short.valueOf((short) 12);
        Short s3 = new Short((short) 12);
        Short s4 = Short.parseShort("12");

        Long l1 = 13L;
        Long l2 = Long.valueOf(13L);
        Long l3 = new Long(13L);
        Long l4 = Long.parseLong("13");

        Float f1 = 1.0F;
        Float f2 = Float.valueOf(1F);
        Float f3 = new Float(1F);
        Float f4 = Float.parseFloat("1.0");

        Double d1 = 1.0D;
        Double d2 = Double.valueOf(1D);
        Double d3 = new Double(1D);
        Double d4 = Double.parseDouble("1.0");

        Character c1 = 'c';
        Character c2 = Character.valueOf('c');
        Character c3 = new Character('c');

        // work for float values NaN and Infinity
        Double dd1 = 10D;
        Double dd2 = 0D;

        Double dd3 = dd1 / dd2;

        if (dd3.isNaN()) {
            System.out.println("Variable dd3 is NaN");
        }

        if (dd3.isInfinite()) {
            System.out.println("Variable dd3 is Infinity");
        }

        System.out.println(dd3);

        dd3 = dd2 / dd2;

        if (dd3.isNaN()) {
            System.out.println("Variable dd3 is NaN");
        }

        if (dd3.isInfinite()) {
            System.out.println("Variable dd3 is Infinity");
        }

        System.out.println(dd3);

        // convert double values to  primitive types
        byte bb1 = dd1.byteValue();
        long ll1 = dd1.longValue();
        int ii1 = dd1.intValue();
        short ss1 = dd1.shortValue();
        float ff1 = dd1.floatValue();

        // Show trick vis Wrappers that consist small values
        Long q1 = 120L;
        Long q2 = 120L;
        System.out.println(q1 == q2);

        Long m1 = 1200L;
        Long m2 = 1200L;
        System.out.println(m1 == m2);

    }
}
