package ua.zp.brain.labs.oop.basics.classes;

/**
 * Java object that represents simple bookshelf
 *
 * @author Pavlo Degtyarev
 * @version 1.0
 */
public class Bookshelf {
    public static final String MATERIAL_WOOD = "wood";
    public static final String MATERIAL_METALL = "metal";
    public static final String MATERIAL_PLASTIC = "plastic";
    public static final String COLOR_RED = "#FF0000";
    public static final String COLOR_GREEN = "#00FF00";
    public static final String COLOR_BLUE = "#0000FF";

    private String material; // "wood", "metal" and so on
    private String color; // "#FFFFFF"
    private int width; // millimeters
    private int depth; // millimeters
    private int height; // millimeters

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Имя класса: " + getClass().getName() +
                "\nmaterial = \"" + material + '"' +
                "\ncolor = \"" + color + '"' +
                "\nwidth = " + width +
                "\ndepth = " + depth +
                "\nheight = " + height;
    }
}
