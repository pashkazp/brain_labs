package ua.zp.brain.labs.oop.basics.lab9;

/**
 * Circle class that represents simple circle object. Circle has color, radius, area, and circumference length..
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class Circle {
    private double radius;
    private double circumference;
    private double square;
    private String color = "#000000";

    /**
     * Constructs a Circle based on the specified radius.
     *
     * @param radius double
     */
    public Circle(double radius) {
        this.radius = radius;
        circumference = 2 * Math.PI * radius;
        square = Math.PI * radius * radius;
    }

    /**
     * Constructs a Circle based on the specified radius and color.
     *
     * @param radius double
     * @param color  String
     */
    public Circle(double radius, String color) {
        this(radius);
        this.color = color;
    }

    /**
     * Creates the Circle based on specified radius and color and prints information of newly created Circle
     *
     * @param args String[] (unused)
     */
    public static void main(String[] args) {
        Circle circle = new Circle(11, "#FF0000");
        System.out.println(circle);
    }

    /**
     * Return radius of the Circle
     *
     * @return double
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Changes the radius to the specified one and recalculates the remaining Circuit parameters
     *
     * @param radius double
     */
    public void setRadius(double radius) {
        this.radius = radius;
        circumference = 2 * Math.PI * radius;
        square = Math.PI * radius * radius;
    }

    /**
     * Return circumference length of the Circle
     *
     * @return double
     */
    public double getCircumference() {
        return circumference;
    }

    /**
     * Changes the circumference length to the specified one and recalculates the remaining Circuit parameters
     *
     * @param circumference double
     */
    public void setCircumference(double circumference) {
        this.circumference = circumference;
        radius = circumference / (2 * Math.PI);
        square = Math.PI * radius * radius;
    }

    /**
     * Return square of the Circle
     *
     * @return double
     */
    public double getSquare() {
        return square;
    }

    /**
     * Return square of the Circle
     *
     * @param square double
     */
    public void setSquare(double square) {
        this.square = square;
        radius = Math.sqrt(square / Math.PI);
        circumference = 2 * Math.PI * radius;
    }

    /**
     * Return color of the Circle
     *
     * @return String
     */
    public String getColor() {
        return color;
    }

    /**
     * Set color of the Circle
     *
     * @param color String
     */
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle" +
                "\ncircumference : " + circumference +
                "\nsquare        : " + square +
                "\ncolor         : " + color;
    }
}
