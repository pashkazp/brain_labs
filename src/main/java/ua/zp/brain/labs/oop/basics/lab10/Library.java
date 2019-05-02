package ua.zp.brain.labs.oop.basics.lab10;

/**
 * Simple class that represents elementary {@link Film}'s Library
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class Library {
    private final String name;
    private Film[] films;

    /**
     * block of instance initialisation that creates {@link Film} array[5] and instantiated two favorite Films
     */
    {
        films = new Film[5];
        films[0] = new Film("Matrix", "02:16:00", Film.GENRE_ACTION, Film.GENRE_SCI_FI);
        films[1] = new Film("Exam", "01:41:00", Film.GENRE_HORROR,
                Film.GENRE_MYSTERY, Film.GENRE_THRILLER);
        System.out.println("Added favorite movies.");
    }

    /**
     * Construct {@link Film}'s Library with the given Name
     *
     * @param name String
     */
    Library(String name) {
        this.name = name;
        System.out.println("Films library \"" + this.name + "\" successfully created.");
    }

    /**
     * Return the name of the Library
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Return an array of stored Films
     *
     * @return {@link Film}[]
     */
    public Film[] getFilms() {
        return films;
    }

    /**
     * Set tne new array of Films
     *
     * @param films {@link Film}[]
     */
    public void setFilms(Film[] films) {
        this.films = films;
    }

    /**
     * Searches for a free slot in the Film list and returns its index or -1 otherwise.
     *
     * @return int
     */
    public int getFreeIndex() {
        if (films != null && films.length > 0) {
            int i = 0;
            for (Film film : films) {
                if (film == null) {
                    return i;
                } else {
                    i++;
                }
            }
        }
        return -1;
    }
}
