package ua.zp.brain.labs.oop.basics.lab10;

/**
 * Simple program that represents {@link Library} of {@link Film}'s.
 * The program creates a exemplar of the Library and tries to add several Films to it.
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Library library = new Library("Favorites");

        int i = library.getFreeIndex();
        if (i == -1) {
            System.out.println("Capacity limit is reached.");
        } else {
            library.getFilms()[i] = new Film("The Shawshank Redemption", "02:22:00",
                    Film.GENRE_DRAMA);
        }

        i = library.getFreeIndex();
        if (i == -1) {
            System.out.println("Capacity limit is reached.");
        } else {
            library.getFilms()[i] = new Film("The Silence of the Lambs", "02:22:00",
                    Film.GENRE_CRIME, Film.GENRE_DRAMA, Film.GENRE_THRILLER);
        }

        i = library.getFreeIndex();
        if (i == -1) {
            System.out.println("Capacity limit is reached.");
        } else {
            library.getFilms()[i] = new Film("Back to the Future", "01:56:00",
                    Film.GENRE_ADVENTURE, Film.GENRE_COMEDY, Film.GENRE_SCI_FI);
        }

        i = library.getFreeIndex();
        if (i == -1) {
            System.out.println("Capacity limit is reached.");
        } else {
            library.getFilms()[i] = new Film("Alien", "01:57:00",
                    Film.GENRE_HORROR, Film.GENRE_SCI_FI);
        }
    }
}
