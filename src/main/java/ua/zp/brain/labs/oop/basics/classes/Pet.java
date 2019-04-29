package ua.zp.brain.labs.oop.basics.classes;

/**
 * Simple Java class that represents object Pet
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class Pet {
    public static final String CATEGORY_DOG = "dog";
    public static final String CATEGORY_CAT = "cat";
    public static final String CATEGORY_BIRD = "bird";
    public static final String CATEGORY_HAMSTER = "hamster";
    public static final String CATEGORY_ELEFANT = "elefant";

    private String category; // "dog", "cat" and so on
    private String name;


    private int weight; //gramms
    private int heigh;  //millimeters
    private int width; //millimeters

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeigh() {
        return heigh;
    }

    public void setHeigh(int heigh) {
        this.heigh = heigh;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Имя класса: " + getClass().getName() +
                "\ncategory = \"" + category + '"' +
                "\nname = \"" + name + '"' +
                "\nwidth = " + width +
                "\nheigh = " + heigh +
                "\nweight = " + weight;
    }
}
