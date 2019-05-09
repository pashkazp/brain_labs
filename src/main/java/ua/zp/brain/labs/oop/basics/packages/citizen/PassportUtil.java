package ua.zp.brain.labs.oop.basics.packages.citizen;

/**
 * The class {@code PassportUtil} contains methods for performing basic
 * operations such as the fix the marriage of two persons..
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class PassportUtil {

    private PassportUtil() {
        // denied instantiate class
    }

    /**
     * This method emulates the registration of a marriage of two persons by cross
     * registration in appropriate fields in his Passports.
     * <p> Registration approved if:
     * <ul>
     * <li> Both Passport objects is not null
     * <li> Passports is not equal
     * </ul>
     *
     * @param passportA {@link Passport}
     * @param passportB {@link Passport}
     */
    public static void marriageRegistrate(Passport passportA, Passport passportB) {
        if (passportA != null
                && passportB != null
                && passportA.getId() != null
                && passportB.getId() != null) {
            passportA.setSpouseId(passportB.getId());
            passportB.setSpouseId(passportA.getId());
        }
    }

}
