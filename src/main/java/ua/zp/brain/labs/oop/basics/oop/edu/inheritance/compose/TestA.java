package ua.zp.brain.labs.oop.basics.oop.edu.inheritance.compose;

public class TestA {

    public void test() {
        System.out.println("test in A");
    }

    public void check() {
        System.out.println("check in A");
        test();
    }
}
