package ua.zp.brain.labs.oop.basics.packages.technics;

import java.util.Date;

/**
 * Simple Java object that represents passport of technical passport. Consist Id, model name,
 * serial number, manufactured Date, warranty start Date and sale Date
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class Passport {
    private Long id;
    private String modelName;
    private String serialNumber;
    private Date manufacturedDate;
    private Date warrantyStartDate;
    private Date saleDate;

    /**
     * Construct empty passport of technical product. Initiate Id field by randomly generated value
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
     * @param modelName         String that specifies Model Name
     * @param serialNumber      String that specifies Serial Number
     * @param manufacturedDate  Date that specifies manufacturer Date
     * @param warrantyStartDate Date that specifies Warranty Start Date
     * @param saleDate          Date that specifies Sales Date
     */
    public Passport(String modelName, String serialNumber, Date manufacturedDate,
                    Date warrantyStartDate, Date saleDate) {
        this();
        this.modelName = modelName;
        this.serialNumber = serialNumber;
        setManufacturedDate(manufacturedDate);
        setWarrantyStartDate(warrantyStartDate);
        setSaleDate(saleDate);
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getManufacturedDate() {
        return manufacturedDate;
    }

    /**
     * Methods set the Date of manufacture technical product. Manufacturer Date should be earlier than Warranty
     * Start Date or Sales Date, if such dates are set. If something is inappropriate, then the dates mentioned
     * are corrected to the manufacturer date.
     *
     * @param manufacturedDate Date that specifies manufacturer Date
     */
    public void setManufacturedDate(Date manufacturedDate) {
        this.manufacturedDate = manufacturedDate;
        if (warrantyStartDate != null && manufacturedDate != null && warrantyStartDate.before(manufacturedDate)) {
            warrantyStartDate = manufacturedDate;
        }
        if (saleDate != null && manufacturedDate != null && saleDate.after(manufacturedDate)) {
            saleDate = manufacturedDate;
        }
    }

    public Date getWarrantyStartDate() {
        return warrantyStartDate;
    }

    /**
     * Method set the Date of start new warranty. The specifies Date must be late than manufactured Date,
     * if such dates are set. If something is inappropriate, then the newWarrantyStartDate are corrected
     * to the manufacturer date.
     *
     * @param newWarrantyStartDate Date that specifies Date of start warranties
     */
    public void setWarrantyStartDate(Date newWarrantyStartDate) {
        if (manufacturedDate != null
                && newWarrantyStartDate != null
                && newWarrantyStartDate.before(manufacturedDate)) {
            this.warrantyStartDate = manufacturedDate;
        } else {
            this.warrantyStartDate = newWarrantyStartDate;
        }
    }

    public Date getSaleDate() {
        return saleDate;
    }

    /**
     * Method set the Sales Date. The specifies Date must be late than manufactured Date, if such dates are set.
     * If something is inappropriate, then the saleDate are corrected to the manufacturer date.
     *
     * @param saleDate Date that specifies Sales Date
     */
    public void setSaleDate(Date saleDate) {
        if (manufacturedDate != null
                && manufacturedDate != null
                && saleDate.before(manufacturedDate)) {
            this.saleDate = manufacturedDate;
        } else {
            this.saleDate = saleDate;
        }
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", manufacturedDate=" + manufacturedDate +
                ", warrantyStartDate=" + warrantyStartDate +
                ", saleDate=" + saleDate +
                '}';
    }
}
