package ua.zp.brain.labs.oop.basics.oop.edu.inheritance.compose;

public class TestB extends TestA {

    @Override
    public void test() {
        System.out.println("test in B");
    }

    @Override
    public void check() {
        System.out.println("check in B");
        super.check();
    }
}
