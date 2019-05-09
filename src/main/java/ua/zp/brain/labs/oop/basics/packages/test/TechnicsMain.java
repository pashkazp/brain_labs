package ua.zp.brain.labs.oop.basics.packages.test;

import ua.zp.brain.labs.oop.basics.packages.technics.Passport;
import ua.zp.brain.labs.oop.basics.packages.technics.PassportUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TechnicsMain {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        Passport passport = new Passport(
                "Viola 203", "123897890234978",
                formatter.parse("01-Apr-1970"),
                formatter.parse("02-May-1970"),
                formatter.parse("03-Jun-1970"));

        System.out.println(passport);

        PassportUtil.warrantyReplace(passport, new Date());

        System.out.println(passport);

    }
}
