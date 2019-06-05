package ua.zp.brain.labs.oop.basics.lab19;

import java.util.Arrays;
import java.util.Optional;

public class PlayRoom {

    public static void main(String[] args) {

        Game[] gamesD = {
                Game.getDisk("Белоснежка и семь гомов", Game.Genre.GENRE_SPORT,
                        "Игра, в которой одна грустная устрица наблюдает за спортивными упражнениями."),
                Game.getDisk("Резиновая Зина", Game.Genre.GENRE_RACE,
                        "Игра, в которой резиновую Зину растягивают и мнут."),
                Game.getDisk("Глубокая глотка", Game.Genre.GENRE_ACTION,
                        "Игра, в которой проводятся научные исследования глубины горла."),
                Game.getDisk("Немецкие истории", Game.Genre.GENRE_SPORT,
                        "Игра, которая никогда не закончится свадьбой.")
        };

        Game[] gamesV = {
                Game.getVirtualGame("Декамерон", Game.Genre.GENRE_SPORT),
                Game.getVirtualGame("Калигула", Game.Genre.GENRE_RACE),
                Game.getVirtualGame("Греческая смоковница", Game.Genre.GENRE_ACTION),
                Game.getVirtualGame("Итальянские паравозики", Game.Genre.GENRE_ACTION)
        };

        System.out.println("Game disks:");
        for (Game game : gamesD) {
            System.out.println(game);
        }

        System.out.println("\nsort by genre name...");
        Arrays.sort(gamesD, (o1, o2) -> o1.getGenre().name().compareTo(o2.getGenre().name()));

        for (Game game : gamesD) {
            System.out.println(game);
        }

        System.out.println("\nVirtual games:");
        for (Game game : gamesV) {
            System.out.println(game);
        }

        System.out.println("\nsort by rating...");
        Arrays.sort(gamesV, (o1, o2) -> ((Game.VirtualGame) o1).getRating().compareTo(((Game.VirtualGame) o2).getRating()));

        for (Game game : gamesV) {
            System.out.println(game);
        }

        System.out.println("\n\n=================================Construct new my precious ========================================");
        GameConsole console = new GameConsole(GameConsole.Brand.BRAND_SONY, "PS4 PRO", "XC123QeWR");
        System.out.println(console);

        System.out.println("\n-- Second gamePad switch on --");
        Optional.ofNullable(console.getSecondGamePad()).ifPresent(GameConsole.GamePad::powerOn);
        System.out.println(console);

        System.out.println("\n-- First gamePad switch on --");
        Optional.ofNullable(console.getFirstGamePad()).ifPresent(GameConsole.GamePad::powerOn);
        System.out.println(console);


        System.out.println("\n-- Switch all power off --");
        console.powerOff();
        Optional.ofNullable(console.getFirstGamePad()).ifPresent(GameConsole.GamePad::powerOff);
        Optional.ofNullable(console.getSecondGamePad()).ifPresent(GameConsole.GamePad::powerOff);
        System.out.println(console);

        System.out.println("\n-- Insert Game --");
        console.loadGame(gamesD[0]);
        console.powerOn();
        System.out.println("\n-- Reinsert Game after powerOn --");
        console.loadGame(gamesD[0]);

        System.out.println("\n-- Playing Game with one GamePad--");
        Optional.ofNullable(console.getSecondGamePad()).ifPresent(GameConsole.GamePad::powerOn);
        try {
            for (int i = 0; i < 5; i++) {
                console.playGame();
            }
        } catch (NoActivityException e) {
            System.out.println("\n"+e.getClass().getName()+": "+e.getMessage());
            System.out.println(console);
        }

        System.out.println("\n-- Playing Game with two GamePads--");
        Optional.ofNullable(console.getFirstGamePad()).ifPresent(GameConsole.GamePad::powerOn);
        try {
            for (int i = 0; i < 25; i++) {
                console.playGame();
            }
        } catch (NoActivityException e) {
            System.out.println("\n"+e.getClass().getName()+": "+e.getMessage());
            System.out.println(console);
        }

        System.out.println("===+=== G A M E  O V E R ===+===");
    }

}

