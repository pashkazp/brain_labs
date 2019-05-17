package ua.zp.brain.labs.oop.basics.oop.edu.polymorphism;

public class Test {

    public static void main(String[] args) {

        System.out.println("\nTry some CAST:");
        // TODO try cast
        Specific specific = new Specific();
        Simple simple = specific;
        System.out.println(specific.data + " " + simple.data); // no cast
        System.out.println(((Simple)specific).data + " " + ((Specific)simple).data); // cast both
        System.out.println(specific.getData() + " " + simple.getData()); // no cast
        System.out.println(((Simple)specific).getData() + " " + simple.getData());// cast but use dynamic linking
    }
}
