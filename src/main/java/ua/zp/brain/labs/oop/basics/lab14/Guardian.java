package ua.zp.brain.labs.oop.basics.lab14;

import java.time.LocalDate;

/**
 * A simple Java object that represents any {@link Employee}-based Guardian
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class Guardian extends Employee {
    /**
     * Construct empty Guardian
     */
    public Guardian() {
    }

    /**
     * Construct Guardian with given values.
     *
     * @param firstName          String that specifies Persons First Name
     * @param lastName           String  that specifies Persons Last Name
     * @param patronymic         String that specifies Persons Patronymic Name
     * @param phone              String that specifies Phone number
     * @param birthDay           LocalDate that specifies BirthDay
     * @param employmentDateFrom LocalDate that specifies the date of hiring to work.
     * @param salary             LocalDate that specifies  the size of the salary.
     */
    public Guardian(String firstName, String lastName, String patronymic, LocalDate birthDay, String phone, LocalDate employmentDateFrom, Long salary) {
        super(firstName, lastName, patronymic, birthDay, phone, employmentDateFrom, salary);
    }

    public void talkOnTheRadio() {
        System.out.println("(to radio) Bu-bu-bu-bu-bu");
    }

    @Override
    public void goToHaveLunch() {
        System.out.println("Getting a cucumber from the holster and tasting about half of it.");
    }

    @Override
    public void comeToWork() {
        System.out.println("Get to work before everyone.");
    }

    @Override
    public void toWork() {
        talkOnTheRadio();
        System.out.println("Walks on departments and suspects everyone.");
        talkOnTheRadio();
    }

    /**
     * This Method is not needed at this level and is created for demonstration purposes.
     *
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    /**
     * This Method is not needed at this level and is created for demonstration purposes.
     *
     * @return superclass hashCode
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Guardian{ " + super.toString() + "}";
    }
}
