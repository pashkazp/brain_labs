package ua.zp.brain.labs.oop.basics.packages.transport;

import java.util.Date;

/**
 * The class {@code PassportUtil} contains methods for performing basic
 * operations such as the set new owner of transport.
 */
class PassportUtil {
    private PassportUtil() {
        // Denied instantiate class
    }

    /**
     * Method emulates change warranty Date to new Date. Old Passport object must be not null.
     * New owner must be not null and length of String must be great zero size.
     * Issued date for new Passport is set to now.
     *
     * @param oldPassport Old {@link Passport} of transport
     * @param newOwner    String name of new owner
     * @return new {@link Passport}
     */
     static Passport changeOwner(Passport oldPassport, String newOwner) {
        if (oldPassport != null && newOwner != null && newOwner.length() > 0) {
            Passport passport = new Passport(oldPassport.getModel(), oldPassport.getColor(),
                    oldPassport.getEngineNumber(), newOwner, new Date());
            return passport;
        } else return null;
    }
}
