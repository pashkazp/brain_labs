package ua.zp.brain.labs.oop.basics.packages.citizen;

import java.util.Date;

/**
 * Simple Java object that represents Citizen civil passport. Consist Id, first name, last name, patronymic name, passport number, birthday and spouseId
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class Passport {
    private Long id;
    private String firstName;
    private String lastName;
    private String patronymicName;
    private String number;
    private Date birthDay;
    private Long spouseId;

    /**
     * Construct empty passport of person. Initiate Id field by randomly generated value
     */
    public Passport() {
        this.id = (long) (Math.random() * 10000000D);
    }

    /**
     * Construct civil passport of person with given values. Initiate Id field by randomly generated value
     *
     * @param firstName      String that specifies Persons First Name
     * @param lastName       String  that specifies Persons Last Name
     * @param patronymicName String that specifies Persons Patronymic Name
     * @param number         String that specifies Passport number
     * @param birthDay       Date that specifies Persons BirthDay
     */
    public Passport(String firstName, String lastName, String patronymicName, String number, Date birthDay) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymicName = patronymicName;
        this.number = number;
        this.birthDay = birthDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Long getSpouseId() {
        return spouseId;
    }

    public void setSpouseId(Long spouseId) {
        this.spouseId = spouseId;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymicName='" + patronymicName + '\'' +
                ", number='" + number + '\'' +
                ", birthDay=" + birthDay +
                ", spouseId=" + spouseId +
                '}';
    }
}
