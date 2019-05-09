package ua.zp.brain.labs.oop.basics.packages.technics;

import java.util.Date;

/**
 * The class {@code PassportUtil} contains methods for performing basic
 * operations such as the set the new warranty start Date.
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class PassportUtil {

    private PassportUtil() {
        // denied instantiate class
    }

    /**
     * Method emulates change warranty Date to new Date. Passport object must be not null.
     *
     * @param passport             {@link Passport} of technical product
     * @param newWarrantyStartDate Date of start new warranty
     */
    public static void warrantyReplace(Passport passport, Date newWarrantyStartDate) {
        if (passport != null) {
            passport.setWarrantyStartDate(newWarrantyStartDate);
        }
    }
}
