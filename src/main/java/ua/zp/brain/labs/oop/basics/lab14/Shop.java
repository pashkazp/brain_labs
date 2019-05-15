package ua.zp.brain.labs.oop.basics.lab14;

import ua.zp.brain.labs.oop.basics.lab14.actors.Cashier;
import ua.zp.brain.labs.oop.basics.lab14.actors.Client;
import ua.zp.brain.labs.oop.basics.lab14.actors.Guardian;
import ua.zp.brain.labs.oop.basics.lab14.actors.Manager;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Simple Java object that represents anybody person
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class Shop {
    private Manager manager;
    private Cashier cashier;
    private Guardian guardian;
    private Client client;
    private String title = "";
    private String address = "";

    /**
     * Construct Shop with specifies Title and Address
     *
     * @param title   String that specifies the Shop Title
     * @param address String that specifies the Shop Address
     */
    public Shop(String title, String address) {
        this.title = title;
        this.address = address;
    }

    /**
     * Construct empty Shop
     */
    public Shop() {
    }

    public static void main(String[] args) {

        Shop shop = shopInit("Ikea", "Somewhere nearby.");

        // Shop is opening
        shop.openUp();

        // sale Goods
        shop.saleGoods();

        // aperitif
        shop.goToLunch();

        //Actors and performers
        shop.showTitles();
    }

    /**
     * Instantiates Shop with specifies Title and Address and fill all Employees with demo data
     *
     * @param title   String that specifies Title of the Shop
     * @param address String that specifies Address of the Shop
     * @return {@link Shop}
     */
    private static Shop shopInit(String title, String address) {
        Shop shop = new Shop(title, address);

        shop.setManager(new Manager("Petro", "Petrenko", "Petrovich",
                LocalDate.of(1966, 10, 15), "32223223",
                LocalDate.of(2018, 12, 12),
                8000L, "Sales department"));

        shop.setCashier(new Cashier("Valya", "Petrova", "Olegovna",
                LocalDate.of(1996, 02, 1), "3456-09-09",
                LocalDate.of(2019, 03, 11),
                4000L, 25));

        shop.setGuardian(new Guardian("Vasya", "Sidorenko", "Hvedorytch",
                LocalDate.of(1996, 02, 1), "98734979345",
                LocalDate.of(2019, 03, 11),
                5000L));

        shop.setClient(new Client("Valya", "Petrova", "Olegovna",
                LocalDate.of(1996, 02, 1), "3456-09-09",
                500000L, "1234-5678-9012-3456"));
        return shop;
    }

    /**
     * Prints all data of Shop and employees
     */
    private void showTitles() {
        System.out.println("\nActors and performers");
        System.out.println();
        System.out.println(this);
        System.out.println();
        System.out.println(getManager());
        System.out.println();
        System.out.println(getCashier());
        System.out.println();
        System.out.println(getGuardian());
        System.out.println();
        System.out.println(getClient());
    }

    /**
     * @return String Shop Title
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null) {
            return;
        }
        this.title = title;
    }

    /**
     * @return String Shop Address
     */
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null) {
            return;
        }
        this.address = address;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public Guardian getGuardian() {
        return guardian;
    }

    public void setGuardian(Guardian guardian) {
        this.guardian = guardian;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Shop is open Up
     */
    public void openUp() {
        System.out.println("\nShop:      The time of the beginning of working time is approaching.");

        if (guardian != null) {
            guardian.comeToWork();
        }

        if (cashier != null) {
            cashier.comeToWork();
        }

        if (manager != null) {
            manager.comeToWork();
        }

        if (guardian != null) {
            guardian.sayHello();
        }

        if (cashier != null) {
            cashier.sayHello();
        }

        if (manager != null) {
            manager.sayHello();
        }

        System.out.println("\nShop:  WORK IS BEGINNING!!!\n");
    }

    /**
     * Shop is go to Lunch
     */
    public void goToLunch() {
        System.out.println("\nShop:      The dinner time is approaching.");

        if (guardian != null) {
            guardian.goToHaveLunch();
        }

        if (cashier != null) {
            cashier.goToHaveLunch();
        }

        if (manager != null) {
            manager.goToHaveLunch();
        }
    }

    /**
     * Shop make sale of goods
     */
    public void saleGoods() {
        if (guardian == null || manager == null || cashier == null || cashier == null) {
            return;
        }
        System.out.println("\nThe client comes in..");
        System.out.println("\nShop:    Time to make money.");

        guardian.talkOnTheRadio();

        client.sayHello();

        client.sayMeAbout();

        manager.toWork();

        client.buyProduct();

        cashier.toWork();

        guardian.toWork();

        client.sayGoodBye();

        System.out.println("\nShop:      The case is done\n");
    }

    @Override
    public String toString() {
        return "Shop{ " +
                "title='" + getTitle() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", manager=" + getManager() +
                ", cashier=" + getCashier() +
                ", guardian=" + getGuardian() +
                ", client=" + getClient() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shop)) return false;
        Shop shop = (Shop) o;
        return title.equals(shop.title) &&
                address.equals(shop.address) &&
                Objects.equals(manager, shop.manager) &&
                Objects.equals(cashier, shop.cashier) &&
                Objects.equals(guardian, shop.guardian) &&
                Objects.equals(client, shop.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, address);
    }
}
