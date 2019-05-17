package ua.zp.brain.labs.oop.basics.abstracts.devices;

public class Test {

    public static void main(String[] args) {

        System.out.println("\nTry equals two iPads:");
        Pad p1 = new Pad("iPad", 20_000);
        Pad p2 = new Pad("iPad", 20_000);
        System.out.println(p1.equals(p2));

        System.out.println("\nTry Pad toString:");
        System.out.println(p1);


        System.out.println("\nTry own equals and toString:");
        // TODO this is not work! Create equals and hashCode in SmartPhone class
        // TODO create toString
        SmartPhone s1 = new SmartPhone("Galaxy S8", 10_000);
        SmartPhone s2 = new SmartPhone("Galaxy S8", 10_000);
        System.out.println(s1.equals(s2));

    }
}
