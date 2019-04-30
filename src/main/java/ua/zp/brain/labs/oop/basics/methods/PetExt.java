package ua.zp.brain.labs.oop.basics.methods;

import ua.zp.brain.labs.oop.basics.classes.Pet;

/**
 * Extended version of Pet
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class PetExt extends Pet {

    /**
     * method of eating food.
     *
     * @param feeds portions
     */
    public void eat(int feeds) {
        System.out.println(getClass().getName() + " see " + feeds + " portions of fud.");
        for (int i = 0; i < feeds; i++) {
            System.out.println("Takes a piece of food.");
            for (int j = 0; j < 5; j++) {
                System.out.println("chaw");
            }
            System.out.println("gulp");
        }
        System.out.println("sated");
    }
}
