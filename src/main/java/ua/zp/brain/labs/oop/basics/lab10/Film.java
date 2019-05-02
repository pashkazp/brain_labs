package ua.zp.brain.labs.oop.basics.lab10;

import java.sql.Time;

/**
 * Simple class that represents object Film. Film has Name, Duration and Genres
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class Film {
    public static final String GENRE_ACTION = "Action";
    public static final String GENRE_ADVENTURE = "Adventure";
    public static final String GENRE_ANIMATION = "Animation";
    public static final String GENRE_BIOGRAPHY = "Biography";
    public static final String GENRE_COMEDY = "Comedy";
    public static final String GENRE_CRIME = "Crime";
    public static final String GENRE_DOCUMENTARY = "Documentary";
    public static final String GENRE_DRAMA = "Drama";
    public static final String GENRE_FAMILY = "Family";
    public static final String GENRE_FANTASY = "Fantasy";
    public static final String GENRE_FILM_NOIR = "Film Noir";
    public static final String GENRE_HISTORY = "History";
    public static final String GENRE_HORROR = "Horror";
    public static final String GENRE_MUSIC = "Music";
    public static final String GENRE_MUSICAL = "Musical";
    public static final String GENRE_MYSTERY = "Mystery";
    public static final String GENRE_ROMANSE = "Romance";
    public static final String GENRE_SCI_FI = "Sci-Fi";
    public static final String GENRE_SHORT = "Short";
    public static final String GENRE_SPORT = "Sport";
    public static final String GENRE_SUPERHERO = "Superhero";
    public static final String GENRE_THRILLER = "Thriller";
    public static final String GENRE_WAR = "War";
    public static final String GENRE_WESTERN = "Western";

    private String name;
    private Time duration;
    private String[] genres;

    /**
     * block of instance initialisation that prints service information
     */ {
        System.out.println("Creates new Film");
    }

    /**
     * Construct Film based on Film Name, Time duration and Film Genres
     *
     * @param filmName String
     * @param duration {@link Time}
     * @param genres   String[]
     */
    Film(String filmName, Time duration, String[] genres) {
        this.name = filmName;
        this.duration = duration;
        this.genres = genres;
        System.out.println("Film \"" + this.name + "\" successfully created.");
    }

    /**
     * Construct Film based on Film Name, Duration (time in format "hh:mm:ss") and varargs of Genres
     *
     * @param filmName String
     * @param duration String
     * @param genres   String...
     */
    Film(String filmName, String duration, String... genres) {
        this(filmName, Time.valueOf(duration), genres);
    }

    /**
     * Return current Film Name
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Set the new Film Name
     *
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return duration of the Film
     *
     * @return Time
     */
    public Time getDuration() {
        return duration;
    }

    /**
     * Set the Duration of the current Film
     *
     * @param duration Time
     */
    public void setDuration(Time duration) {
        this.duration = duration;
    }

    /**
     * Set the Duration of the current Film by String (time in format "hh:mm:ss")
     *
     * @param duration String
     */
    public void setDuration(String duration) {
        this.duration = Time.valueOf(duration);
    }

    /**
     * Return a string representation of the Duration of the Film (time in format "hh:mm:ss")
     *
     * @return String
     */
    public String getDurationStr() {
        return duration.toString();
    }

    /**
     * Returns an array of strings representing a list of Film genres.
     *
     * @return String[]
     */
    public String[] getGenres() {
        return genres;
    }

    /**
     * Set new movie Genres. Genres are represented by strings separated by commas.
     *
     * @param genres String...
     */
    public void setGenres(String... genres) {
        this.genres = genres;
    }

    /**
     * Set new movie Genres. Genres are represented by one string where genres separated by semicolon.
     *
     * @param genre String
     */
    public void setGenres(String genre) {
        setGenres(genre.split(";"));
    }
}
