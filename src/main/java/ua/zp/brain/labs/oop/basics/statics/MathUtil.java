package ua.zp.brain.labs.oop.basics.statics;

/**
 * Simple class with static methods, for demonstrate working with cycles in Java.
 * Help to calc several math sequences.
 *
 * @author Vladimir Bratchikov
 */
public class MathUtil {

    private MathUtil() {
        // Denied to create instance of this class
    }

    /**
     * Sum of several values.
     *
     * @param values values sequence
     * @return sum result.
     */
    public static int sum(int... values) {
        int result = 0;
        for (int a : values) {
            result += a;
        }
        return result;
    }

    /**
     * Multiply of several values.
     *
     * @param values values sequence
     * @return multiply result.
     */
    public static int mul(int... values) {
        int result = 0;
        if (values != null && values.length > 0) {
            result = values[0];
            for (int i = 1; i < values.length; i++) {
                result *= values[i];
            }
        }
        return result;
    }

    /**
     * Print all numbers unless {@param interrupt }
     *
     * @param skipValue skipped value
     * @param values    values sequence
     */
    public static void printWithSkip(int skipValue, int... values) {
        if (values != null && values.length > 0) {
            for (int a : values) {
                if (a != skipValue) {
                    System.out.print(a + " ");
                }
            }
        }
    }

    /**
     * Print all numbers before reaching {@param interrupt }
     *
     * @param interruptValue force end value
     * @param values         values sequence
     */
    public static void printToValue(int interruptValue, int... values) {
        if (values != null && values.length > 0) {
            for (int a : values) {
                if (a == interruptValue) {
                    break;
                }
                System.out.print(a + " ");
            }
        }
    }

    /**
     * Calc factorial value.
     *
     * @param a factorial value.
     * @return factorial result of {@param a}.
     */
    public static int factorial(int a) {
        int result = 1;
        if (a >= 0) {
            while (a > 1) {
                result *= a--;
            }
        } else {
            return 0;
        }
        return result;
    }

    /**
     * Calc harmonic progression for value with ratio.
     *
     * @param a     base value
     * @param q     ratio
     * @param count calc count
     * @return harmonic progression result.
     */
    public static int harmonicProgression(int a, int q, int count) {
        int result = a;
        if (count > 1) { // is it an geometric progression?
            for (int i = 1; i < count; i++) {
                result += result * q;
            }
        } else {
            return 0;
        }
        return result;
    }

    /**
     * Calc harmonic arithmetic for value with ratio.
     *
     * @param a     base value
     * @param q     ratio
     * @param count calc count
     * @return arithmetic progression result.
     */
    public static int arithmeticProgression(int a, int q, int count) {
        int result = a;
        if (count > 1) { // is it an arithmetic progression?
            result = (2 * a + q * (count - 1)) / 2 * count;
        } else {
            return 0;
        }
        return result;
    }
}
