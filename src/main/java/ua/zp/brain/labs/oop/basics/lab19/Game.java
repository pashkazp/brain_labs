package ua.zp.brain.labs.oop.basics.lab19;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Java class  that represent Game for {@link GameConsole}
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class Game {

    private final Genre genre;
    private final GameType type;
    private final String name;

    /**
     * Construct Game with specifies values
     *
     * @param name  Game name
     * @param genre Genre of the Game
     * @param type  Type of media
     */
    private Game(String name, Genre genre, GameType type) {
        this.genre = genre;
        this.type = type;
        this.name = name;
    }

    /**
     * Create Game Disk with specified values
     *
     * @param name        Game title
     * @param genre       Game genre
     * @param description Game description
     * @return Created Disk of Game
     */
    public static GameDisk getDisk(String name, Genre genre, String description) {
        return new GameDisk(name, genre, description);
    }

    /**
     * Create Virtual Game with specified values
     *
     * @param name  Game title
     * @param genre Game genre
     * @return Created Virtual Game
     */
    public static VirtualGame getVirtualGame(String name, Genre genre) {
        return new VirtualGame(name, genre);
    }

    public Genre getGenre() {
        return genre;
    }

    public GameType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Game{ " +
                " name='" + name + '\'' +
                ", genre=" + genre +
                ", type=" + type +
                " } ";
    }

    /**
     * Possibility's Genre of the Game
     */
    enum Genre {
        GENRE_ACTION,
        GENRE_SPORT,
        GENRE_RACE;
    }

    /**
     * Possibility Types of the Game
     */
    enum GameType {
        TYPE_VIRTUAL,
        TYPE_PHYSICAL;

    }

    /**
     * Static class that extends of {@link Game} class and represents Game on Disk
     */
    public static class GameDisk extends Game {
        private final String description;

        /**
         * Construct Game Disk vith specified values
         *
         * @param name        Game title
         * @param genre       Game genre
         * @param description Game description
         */
        private GameDisk(String name, Genre genre, String description) {
            super(name, genre, GameType.TYPE_PHYSICAL);
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return "GameDisk{ " + super.toString() +
                    " description='" + description + '\'' +
                    " } ";
        }
    }

    /**
     * Static class that extends of {@link Game} class and represents Virtual Game
     */
    public static class VirtualGame extends Game {

        private Integer rating;

        /**
         * Construct Virtual Game with specifies values
         *
         * @param name  Game title
         * @param genre Game genre
         */
        private VirtualGame(String name, Genre genre) {
            super(name, genre, GameType.TYPE_VIRTUAL);
            rating = ThreadLocalRandom.current().nextInt(0, 5 + 1);
        }

        public Integer getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        @Override
        public String toString() {
            return "VirtualGame{ " + super.toString() +
                    ", rating=" + rating +
                    " } ";
        }
    }
}
