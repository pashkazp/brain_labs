package ua.zp.brain.labs.oop.basics.lab14;

import java.time.LocalDate;

/**
 * A simple Java object that represents any {@link Employee}-based Cashier
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class Cashier extends Employee {

    private Integer cashDeskNumber = 0;

    /**
     * Construct empty Cashier
     */
    public Cashier() {
    }

    /**
     * Construct Cashier with given values.
     *
     * @param firstName          String that specifies Persons First Name
     * @param lastName           String  that specifies Persons Last Name
     * @param patronymic         String that specifies Persons Patronymic Name
     * @param phone              String that specifies Phone number
     * @param birthDay           LocalDate that specifies BirthDay
     * @param employmentDateFrom LocalDate that specifies the date of hiring to work.
     * @param salary             LocalDate that specifies  the size of the salary.
     * @param cashDeskNumber     Integer that specifies Cashiers DeskNumber
     */
    public Cashier(String firstName, String lastName, String patronymic, LocalDate birthDay, String phone, LocalDate employmentDateFrom, Long salary, Integer cashDeskNumber) {
        super(firstName, lastName, patronymic, birthDay, phone, employmentDateFrom, salary);
        this.cashDeskNumber = cashDeskNumber;
    }

    public Integer getCashDeskNumber() {
        return cashDeskNumber;
    }

    public void setCashDeskNumber(Integer cashDeskNumber) {
        if (cashDeskNumber == null) {
            return;
        }
        this.cashDeskNumber = cashDeskNumber;
    }

    public void countMoney() {
        System.out.println("Count money. Recount money.");
    }

    @Override
    public void comeToWork() {
        System.out.println("Come to work in advance");
    }

    @Override
    public void goToHaveLunch() {
        System.out.println("Quickly go to the utility room. Swallow pieces. Go back to the work place.");
    }

    @Override
    public void toWork() {
        sayHello();
        countMoney();
        sayGoodBye();
    }

    @Override
    public void sayHello() {
        System.out.println("Hello. Do you need a bag?");
    }

    @Override
    public void sayGoodBye() {
        System.out.println("Collect chips? Do not want to pay for your phone?");
    }

    @Override
    public String toString() {
        return "Cashier{ " + super.toString() +
                "cashDeskNumber=" + cashDeskNumber +
                "}";
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cashier cashier = (Cashier) o;
        return cashDeskNumber.equals(cashier.cashDeskNumber);
    }
}
