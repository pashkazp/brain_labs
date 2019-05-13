package ua.zp.brain.labs.oop.basics.lab14;

import java.time.LocalDate;
import java.util.Objects;

/**
 * A simple Java object that represents any {@link Person}-based Client
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class Client extends Person {

    private Long money = 0L;
    private String discountCard = "";

    /**
     * Construct empty Client
     */
    public Client() {
    }

    /**
     * Construct Client with given values.
     *
     * @param firstName    String that specifies Persons First Name
     * @param lastName     String  that specifies Persons Last Name
     * @param patronymic   String that specifies Persons Patronymic Name
     * @param phone        String that specifies Phone number
     * @param birthDay     LocalDate that specifies BirthDay
     * @param money        Long that specifies Money
     * @param discountCard Spring that specifies DiscountCard
     */
    public Client(String firstName, String lastName, String patronymic, LocalDate birthDay,
                  String phone, Long money, String discountCard) {
        super(firstName, lastName, patronymic, phone);

        setBirthDay(birthDay);
        if (money != null) {
            this.money = money;
        }
        if (discountCard != null) {
            this.discountCard = discountCard;
        }
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        if (money == null) {
            return;
        }
        this.money = money;
    }

    public String getDiscountCard() {
        return discountCard;
    }

    public void setDiscountCard(String discountCard) {
        if (discountCard == null) {
            return;
        }
        this.discountCard = discountCard;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello!");
    }

    @Override
    public void sayGoodBye() {
        System.out.println("Goodbye!");
    }

    public void sayMeAbout() {
        System.out.println("Please tell me about this product.");
    }

    public void buyProduct() {
        System.out.println("To go nuts! Give two!");
    }

    @Override
    public String toString() {
        return "Client{ " + super.toString() +
                "money=" + money +
                ", discountCard='" + discountCard + '\'' +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return money.equals(client.money) &&
                discountCard.equals(client.discountCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discountCard);
    }
}
