package ua.zp.brain.labs.oop.basics.lab9;

/**
 * A simple program that represents the {@link Pizza} object. The program creates a menu - the pizza list is offered.
 * Then he creates some pizzas and puts them in the menu. After that, the program displays the proposed menu.
 */
public class Pizzeria {

    public static void main(String[] args) {
        Pizza[] menu = new Pizza[10];
        menu[0] = new Pizza("Итальяно", "Курица;Грибы;Специи;Зелень", 525, 150);
        menu[1] = new Pizza("Перчино", "Анчоусы;Сыр;Томаты;Специи", 716, 200);
        menu[2] = new Pizza("Офигевано", "Апельсины;Сицилийские груши", 2456, 300);

        System.out.println(   "Меню пиццерии\n=============");
        for (Pizza p : menu) {
            if (p != null) {
                System.out.println(p + "\n..........");
            }
        }
    }
}
