package ua.zp.brain.labs.oop.basics.packages.transport;

import java.util.Date;

/**
 * Simple Java object that represents passport of transport. Consist Id, model name, color, engine number,
 * owner name and issued Date
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class Passport {
    private Long id;
    private String model;
    private String color;
    private String engineNumber;
    private String ownerName;
    private Date issuedDate;

    /**
     * Construct empty passport of transport. Initiate Id field by randomly generated value
     */
    public Passport() {
        this.id = (long) (Math.random() * 10000000D);
    }

    /**
     * Construct technical passport with given values. Initiate Id field by randomly generated value
     * Manufacturer Date should be earlier than Warranty Start Date or Sales Date,
     * if such dates are set. If something is inappropriate, then the dates mentioned are corrected by
     * the manufacturer date
     *
     * @param model        String that specified Model Name.
     * @param color        String that specified Color of transport.
     * @param engineNumber String that specified the aggregate number.
     * @param ownerName    String that specified owner name if it is specified.
     * @param issuedDate   Date that specified Date of issue of Passport.
     */
    public Passport(String model, String color, String engineNumber, String ownerName, Date issuedDate) {
        this();
        this.model = model;
        this.color = color;
        this.engineNumber = engineNumber;
        this.ownerName = ownerName;
        this.issuedDate = issuedDate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Passport changeOwner(String newName){
        return PassportUtil.changeOwner(this,newName);
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", engineNumber='" + engineNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", issuedDate=" + issuedDate +
                '}';
    }
}
