package ua.zp.brain.labs.oop.basics.lab9;

/**
 * Pizza class that represent the pizza object. Pizza has Name, Cost, Composition and shape as {@link Circle} class
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class Pizza {
    private Circle basic;
    private String[] composition;
    private String name;
    private int cost;

    /**
     * Construct Pizza based on specified Name, Composition, Cost and diameter.
     *
     * @param name        String
     * @param composition String in which the components are separated by a semicolon
     * @param cost        double
     * @param diametr     double
     */
    Pizza(String name, String composition, int cost, int diametr) {
        this.name = name;
        setComposition(composition);
        this.cost = cost;
        this.basic = new Circle(diametr / 2);
    }

    /**
     * Return diameter of Pizza. Diameter based on shape of {@link Circle}
     *
     * @return double
     */
    public double getDiameter() {
        return basic.getRadius() * 2;
    }

    /**
     * Changes the shape of Pizza based on {@link Circle}
     *
     * @param diameter double
     */
    public void setDiameter(double diameter) {
        basic.setRadius(diameter / 2);
    }

    /**
     * Return the shape of Pizza
     *
     * @return {@link Circle}
     */
    public Circle getBasic() {
        return basic;
    }

    /**
     * Set the shape of Pizza
     *
     * @param basic {@link Circle}
     */
    public void setBasic(Circle basic) {
        this.basic = basic;
    }

    /**
     * Return the String array that represents compositions of Pizza
     *
     * @return String[]
     */
    public String[] getComposition() {
        return composition;
    }

    /**
     * Set composition of Pizza represents by array of components.
     *
     * @param composition String[]
     */
    public void setComposition(String[] composition) {
        this.composition = composition;
    }

    /**
     * Set composition of Pizza represents by String in which the components are separated by a semicolon
     *
     * @param composition String
     */
    public void setComposition(String composition) {
        this.composition = composition.split(";");
    }

    /**
     * Return the Name of Pizza
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of Pizza
     *
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return cost of Pizza
     *
     * @return int
     */
    public int getCost() {
        return cost;
    }

    /**
     * Set new cost of Pizza
     *
     * @param cost int
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Пицца : " + getName() +
                "\nсостав : \n " + String.join("\n ", composition) +
                "\nдиаметр : " + getDiameter() +
                "\nцена : " + ((double) getCost() / 100) + " денег";
    }
}
