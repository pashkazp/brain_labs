package ua.zp.brain.labs.oop.basics.statics;

/**
 * Simple class with static methods, for demonstrate working with cycles in Java.
 * Help to calc several math sequences.
 *
 * @author Vladimir Bratchikov
 */
public class MathUtil {

    /**
     * Sum of several values.
     *
     * @param values values sequence
     * @return sum result.
     */
    public static int sum(int ...values) {
        int result = 0;
        for(int a: values) {
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
    public static int mul(int ...values) {
        int result = 0;
        // TODO  complete this.
        return result;
    }

    /**
     * Print all numbers unless {@param interrupt }
     *
     * @param skipValue skipped value
     * @param values  values sequence
     */
    public static void printWithSkip(int skipValue, int ...values) {
        //TODO modify this method to complete the output of characters but skip the specified value.
        for(int a: values) {
            System.out.print(a+" ");
        }
    }

    /**
     * Print all numbers before reaching {@param interrupt }
     *
     * @param interruptValue force end value
     * @param values  values sequence
     */
    public static void printToValue(int interruptValue, int ...values) {
        //TODO modify this method to complete the output of characters upon reaching the specified interrupt parameter
        for(int a: values) {
            System.out.print(a+" ");
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
        // TODO complete this. Calc FACTORIAL for 'a'
        return result;
    }

    /**
     * Calc harmonic progression for value with ratio.
     *
     * @param a base value
     * @param q ratio
     * @param count calc count
     * @return harmonic progression result.
     */
    public static int harmonicProgression(int a, int q, int count) {
        int result = a;
        // TODO complete this. Calc Harmonic Progression.
        return result;
    }

    /**
     * Calc harmonic arithmetic for value with ratio.
     *
     * @param a base value
     * @param q ratio
     * @param count calc count
     * @return arithmetic progression result.
     */
    public static int arithmeticProgression(int a, int q, int count) {
        int result = a;
        // TODO complete this. Calc Arithmetic Progression.
        return result;
    }

    private MathUtil() {
        // Denied to create instance of this class
    }
}
