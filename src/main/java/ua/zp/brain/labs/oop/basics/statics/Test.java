package ua.zp.brain.labs.oop.basics.statics;

import static ua.zp.brain.labs.oop.basics.statics.MathUtil.*;

public class Test {

    public static void main(String[] args) {

        // Part 1
        System.out.println("Sum of values: " + sum(3, 3, 5, 10));
        System.out.println("Multiply of values: " + mul(1, 1, 5, 10));
        System.out.println("Multiply of values: " + mul(1, 1, 5, 10, -100, 15));
        System.out.println("Multiply of values: " + mul(1));
        System.out.println("Multiply of values: " + mul());
        System.out.println("Multiply of values: " + mul(null));
        // Part 2
        int[] a = new int[0];

        System.out.print("\nPrint with skipping: ");

        System.out.println("\nskip: 1 in" + " sequence: 1, 5, 10, 1, 2, 1, 5, 1, 8, 8");
        printWithSkip(1, 1, 5, 10, 1, 2, 1, 5, 1, 8, 8);

        System.out.println("\nskip: 8 in" + " sequence: 1, 5, 10, 1, 2, 1, 5, 1, 8, 8");
        printWithSkip(8, 1, 5, 10, 1, 2, 1, 5, 1, 8, 8);

        System.out.println("\nskip: 8 in" + " sequence: 1");
        printWithSkip(8, 1);

        System.out.println("\nskip: 1 in" + " sequence: 1");
        printWithSkip(1, 1);

        System.out.println("\nskip: 1 in" + " sequence: empty");
        printWithSkip(1, a);

        System.out.println("\nskip: 1 in" + " sequence: null");
        printWithSkip(1, null);

        System.out.println("\nskip: 3 in" + " sequence: 1, 5, 10, 1, 2, 1, 5, 1, 8, 8");
        printWithSkip(3, 1, 5, 10, 1, 2, 1, 5, 1, 8, 8);


        System.out.print("\n\nPrint with interrupt: ");

        System.out.println("\ninterrupt: 15" + " sequence: 1, 5, 10, 1, 2, 1, 15, 1, 8, 8");
        printToValue(15, 1, 5, 10, 1, 2, 1, 15, 1, 8, 8);

        System.out.println("\ninterrupt: 15" + " sequence: empty");
        printToValue(15, a);

        System.out.println("\ninterrupt: 15" + " sequence: null");
        printToValue(15, null);

        System.out.println("\ninterrupt: 1" + " sequence: 1, 5, 10, 1, 2, 1, 15, 1, 8, 8");
        printToValue(1, 1, 5, 10, 1, 2, 1, 15, 1, 8, 8);

        System.out.println("\ninterrupt: 8" + " sequence: 1, 5, 10, 1, 2, 1, 15, 1, 8, 8");
        printToValue(8, 1, 5, 10, 1, 2, 1, 15, 1, 8, 8);

        System.out.println("\ninterrupt: 3" + " sequence: 1, 5, 10, 1, 2, 1, 15, 1, 8, 8");
        printToValue(3, 1, 5, 10, 1, 2, 1, 15, 1, 8, 8);

        // Part 3
        System.out.println("\nFactorial of value 0: " + factorial(0));
        System.out.println("Factorial of value 1: " + factorial(1));
        System.out.println("Factorial of value 2: " + factorial(2));
        System.out.println("Factorial of value 3: " + factorial(3));
        System.out.println("Factorial of value 5: " + factorial(5));
        System.out.println("Factorial of value -1: " + factorial(-1));
        System.out.println("Factorial of value -10: " + factorial(-10));


        System.out.println("\nHarmonic progression a:2 q:4 c:2 : " + harmonicProgression(2, 4, 2));
        System.out.println("Harmonic progression a:2 q:4 c:1 : " + harmonicProgression(2, 4, 1));
        System.out.println("Harmonic progression a:2 q:4 c:0 : " + harmonicProgression(2, 4, 0));
        System.out.println("Harmonic progression a:2 q:4 c:-1 : " + harmonicProgression(2, 4, -1));
        System.out.println("Harmonic progression a:0 q:4 c:2 : " + harmonicProgression(0, 4, 2));
        System.out.println("Harmonic progression: a:1 q:0 c:10 : " + harmonicProgression(2, 0, 10));

        System.out.println("\nArithmetic progression a:2 q:4 c:3 : " + arithmeticProgression(2, 4, 3));
        System.out.println("Arithmetic progression a:2 q:4 c:1 : " + arithmeticProgression(2, 4, 1));
        System.out.println("Arithmetic progression a:2 q:4 c:0 : " + arithmeticProgression(2, 4, 0));
        System.out.println("Arithmetic progression a:2 q:4 c:-1 : " + arithmeticProgression(2, 4, -1));
        System.out.println("Arithmetic progression a:2 q:0 c:3 : " + arithmeticProgression(2, 0, 3));
        System.out.println("Arithmetic progression a:0 q:4 c:3 : " + arithmeticProgression(0, 4, 3));
    }
}
