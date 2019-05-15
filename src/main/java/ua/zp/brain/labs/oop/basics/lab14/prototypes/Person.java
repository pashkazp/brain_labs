package ua.zp.brain.labs.oop.basics.lab14.prototypes;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Simple Java object that represents anybody person
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class Person {

    private String firstName = "";
    private String lastName = "";
    private String patronymic = "";
    private LocalDate birthDay = LocalDate.now();
    private String phone = "";

    /**
     * Construct empty Person.
     */
    public Person() {
    }

    /**
     * Construct Person with given values.
     *
     * @param firstName  String that specifies Persons First Name
     * @param lastName   String  that specifies Persons Last Name
     * @param patronymic String that specifies Persons Patronymic Name
     * @param phone      String that specifies Phone number
     */
    public Person(String firstName, String lastName, String patronymic, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            return;
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            return;
        }
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        if (birthDay == null) {
            return;
        }
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void sayHello() {
        System.out.println("Hi!");
    }

    public void sayGoodBye() {
        System.out.println("Bye!");
    }

    @Override
    public String toString() {
        return "Person{ " +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", patronymic='" + getPatronymic() + '\'' +
                ", birthDay=" + getBirthDay() +
                ", phone='" + getPhone() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return firstName.equals(person.firstName) &&
                lastName.equals(person.lastName) &&
                Objects.equals(patronymic, person.patronymic) &&
                birthDay.equals(person.birthDay) &&
                Objects.equals(phone, person.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthDay);
    }
}
