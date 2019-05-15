package ua.zp.brain.labs.oop.basics.lab14.actors;

import ua.zp.brain.labs.oop.basics.lab14.prototypes.Employee;

import java.time.LocalDate;

/**
 * A simple Java object that represents any {@link Employee}-based Manager
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class Manager extends Employee {

    private String department = "";

    /**
     * Construct empty Manager
     */
    public Manager() {
    }

    /**
     * Construct Manager with given values.
     *
     * @param firstName          String that specifies Persons First Name
     * @param lastName           String  that specifies Persons Last Name
     * @param patronymic         String that specifies Persons Patronymic Name
     * @param phone              String that specifies Phone number
     * @param birthDay           LocalDate that specifies BirthDay
     * @param employmentDateFrom LocalDate that specifies the date of hiring to work.
     * @param salary             LocalDate that specifies  the size of the salary.
     * @param department         String that specifies the Manager Department
     */
    public Manager(String firstName, String lastName, String patronymic, LocalDate birthDay,
                   String phone, LocalDate employmentDateFrom, Long salary, String department) {
        super(firstName, lastName, patronymic, birthDay, phone, employmentDateFrom, salary);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if (department == null) {
            return;
        }
        this.department = department;
    }

    public void advise() {
        System.out.println("\nManager:   Look at this novelty. This is just what you do not have enough in life!");
    }

    public void sayAboutDiscount() {
        System.out.println("\nManager:   It's worth a trifle. Just 1 million. But today we will give a big discount - a cap as a gift.");
    }

    public void imposePurchase() {
        System.out.println("\nManager:   Take it! Offer is limited.");
    }

    @Override
    public void comeToWork() {
        System.out.println("\nManager:   After all, the leadership is not late. It is delayed.");
    }

    @Override
    public void goToHaveLunch() {
        System.out.println("\nManager:   I'm at a conference. When I come back - I'll check everyone.");
    }

    @Override
    public void toWork() {
        advise();
        sayAboutDiscount();
        imposePurchase();
    }

    @Override
    public void sayHello() {
        System.out.println("\nManager:   Hello everyone!");
    }

    @Override
    public void sayGoodBye() {
        System.out.println("\nManager:   Goodbye to everyone. Tomorrow I will come before everyone and check how you are all working late.");
    }

    @Override
    public String toString() {
        return "Manager{ " + super.toString() +
                "department='" + getDepartment() + "}";
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
        Manager manager = (Manager) o;
        return department.equals(manager.department);
    }
}
