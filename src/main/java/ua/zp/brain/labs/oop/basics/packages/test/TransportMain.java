package ua.zp.brain.labs.oop.basics.packages.test;

import ua.zp.brain.labs.oop.basics.packages.transport.Passport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class TransportMain {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        Passport passport = new Passport("Volga", "Black", "1234567678",
                null, formatter.parse("12-Jan-2018"));

        System.out.println(passport);

        passport = passport.changeOwner("Иванов Иван Иванович");

        System.out.println(passport);

    }

}
