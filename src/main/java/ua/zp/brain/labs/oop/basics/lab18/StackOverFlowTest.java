package ua.zp.brain.labs.oop.basics.lab18;

public class StackOverFlowTest {
    private static int count;

    public static void main(String[] args) {
        try {
            test();
        } catch (StackOverflowError e) {
            System.out.println("переполнение стека");
        }
    }

    public static void test() {
        count++;
        System.out.println(count);
        test();
    }
}
