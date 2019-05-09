package ua.zp.brain.labs.oop.basics.packages.test;

import ua.zp.brain.labs.oop.basics.packages.citizen.Passport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static ua.zp.brain.labs.oop.basics.packages.citizen.PassportUtil.marriageRegistrate;

public class CitizenMain {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        Passport passportM = new Passport("Иванов", "Иван", "Иванович",
                "IX-ЖС 706827", formatter.parse("7-Jun-1993"));
        Passport passportW = new Passport("Петрова", "Петра", "Петровна",
                "XШШ-СФ 567890", formatter.parse("11-Oct-1990"));

        System.out.println(passportM);
        System.out.println(passportW);

        marriageRegistrate(passportM, passportW);

        System.out.println(passportM);
        System.out.println(passportW);
    }
}
