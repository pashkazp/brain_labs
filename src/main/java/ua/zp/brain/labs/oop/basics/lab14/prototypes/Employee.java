package ua.zp.brain.labs.oop.basics.lab14.prototypes;

import java.time.LocalDate;
import java.util.Objects;

/**
 * A simple Java object that represents any {@link Person}-based Employee
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class Employee extends Person {

    private LocalDate employmentDateFrom = LocalDate.now();
    private Long salary = 0L;

    /**
     * Construct empty Employee
     */
    public Employee() {
    }

    /**
     * Construct Employee with given values.
     *
     * @param firstName          String that specifies Persons First Name
     * @param lastName           String  that specifies Persons Last Name
     * @param patronymic         String that specifies Persons Patronymic Name
     * @param phone              String that specifies Phone number
     * @param birthDay           LocalDate that specifies BirthDay
     * @param employmentDateFrom LocalDate that specifies the date of hiring to work.
     * @param salary             LocalDate that specifies  the size of the salary.
     */
    public Employee(String firstName, String lastName, String patronymic, LocalDate birthDay,
                    String phone, LocalDate employmentDateFrom, Long salary) {

        super(firstName, lastName, patronymic, phone);
        setBirthDay(birthDay);
        this.employmentDateFrom = employmentDateFrom;
        this.salary = salary;
    }

    public LocalDate getEmploymentDateFrom() {
        return employmentDateFrom;
    }

    public void setEmploymentDateFrom(LocalDate employmentDateFrom) {
        if (employmentDateFrom == null) {
            return;
        }
        this.employmentDateFrom = employmentDateFrom;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        if (salary == null) {
            return;
        }
        this.salary = salary;
    }

    public void comeToWork() {
        System.out.println("\nSomeone:   Come to work on time");
    }

    public void goToHaveLunch() {
        System.out.println("\nSomeone:   Go to have lunch");
    }

    public void toWork() {
        System.out.println("\nSomeone:   To work in working time for money.");
    }

    @Override
    public void sayHello() {
        System.out.println("\nSomeone:   Good morning!");
    }

    @Override
    public void sayGoodBye() {
        System.out.println("\nSomeone:   See you tomorrow.");
    }

    @Override
    public String toString() {
        return "Employee{ " + super.toString() +
                " employmentDateFrom=" + getEmploymentDateFrom() +
                ", salary=" + getSalary() +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return employmentDateFrom.equals(employee.employmentDateFrom) &&
                salary.equals(employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), employmentDateFrom);
    }
}
