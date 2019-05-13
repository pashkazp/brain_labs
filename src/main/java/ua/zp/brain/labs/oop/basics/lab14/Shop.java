package ua.zp.brain.labs.oop.basics.lab14;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Simple Java object that represents anybody person
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class Shop {
    private static Manager manager;
    private static Cashier cashier;
    private static Guardian guardian;
    private static Client client;
    private String title = "";
    private String address = "";


    public Shop() {
    }

    public Shop(String title, String address) {
        this.title = title;
        this.address = address;
    }

    public static void main(String[] args) {

        Shop shop = new Shop("Ikea", "Somewhere nearby.");

        manager = new Manager("Petro", "Petrenko", "Petrovich",
                LocalDate.of(1966, 10, 15), "32223223",
                LocalDate.of(2018, 12, 12),
                8000L, "Sales department");

        cashier = new Cashier("Valya", "Petrova", "Olegovna",
                LocalDate.of(1996, 02, 1), "3456-09-09",
                LocalDate.of(2019, 03, 11),
                4000L, 25);

        guardian = new Guardian("Vasya", "Sidorenko", "Hvedorytch",
                LocalDate.of(1996, 02, 1), "98734979345",
                LocalDate.of(2019, 03, 11),
                5000L);

        client = new Client("Valya", "Petrova", "Olegovna",
                LocalDate.of(1996, 02, 1), "3456-09-09",
                500000L, "1234-5678-9012-3456");

        // Shop is opening
        shop.openUp();

        // sale Goods
        shop.saleGoods();

        // aperitif
        shop.goToLunch();

        //Actors and performers
        System.out.println("\nActors and performers");
        System.out.println(shop);
        System.out.println();
        System.out.println(manager);
        System.out.println();
        System.out.println(cashier);
        System.out.println();
        System.out.println(guardian);
        System.out.println();
        System.out.println(client);

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null) {
            return;
        }
        this.title = title;
    }

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
            System.out.print("\nGuardian:  ");
            guardian.comeToWork();
        }

        if (cashier != null) {
            System.out.print("\nCashier:   ");
            cashier.comeToWork();
        }

        if (manager != null) {
            System.out.print("\nManager:   ");
            manager.comeToWork();
        }

        if (guardian != null) {
            System.out.print("\nGuardian:  ");
            guardian.sayHello();
        }

        if (cashier != null) {
            System.out.print("\nCashier:   ");
            cashier.sayHello();
        }

        if (manager != null) {
            System.out.print("\nManager:   ");
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
            System.out.print("\nGuardian:  ");
            guardian.goToHaveLunch();
        }

        if (cashier != null) {
            System.out.print("\nCashier:   ");
            cashier.goToHaveLunch();
        }

        if (manager != null) {
            System.out.print("\nManager:   ");
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

        System.out.print("\nClient:    ");
        client.sayHello();

        System.out.print("\nGuardian:  ");
        guardian.talkOnTheRadio();

        System.out.print("\nClient:    ");
        client.sayMeAbout();

        System.out.print("\nManager:   ");
        manager.toWork();

        System.out.print("\nClient:    ");
        client.buyProduct();

        System.out.print("\nCashier:   ");
        cashier.toWork();

        System.out.print("\nGuardian:  ");
        guardian.toWork();

        System.out.print("\nClient:    ");
        client.sayGoodBye();


        System.out.println("\nShop:      The case is done\n");

    }

    @Override
    public String toString() {
        return "Shop{ " +
                "title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", manager=" + manager +
                ", cashier=" + cashier +
                ", guardian=" + guardian +
                ", client=" + client +
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
