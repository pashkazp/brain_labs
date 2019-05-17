package ua.zp.brain.labs.oop.basics.oop.edu.inheritance.compose;


public class Test {

    public static void main(String[] args) {

        System.out.println("\nTry call super from child class method:");
        // TODO learn to use 'super' in 'is-a'
        TestA a = new TestB();
        a.check();
    }
}
