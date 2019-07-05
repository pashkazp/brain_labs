package ua.zp.brain.labs.oop.basics.lab26;

import java.io.*;
import java.util.Objects;

/**
 * Class that represents simple Credit Card
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class CreditCard implements Serializable, Externalizable {
    private static final long serialVersionUID = -4312450334808717373L;
    private CardType cardType;
    private String bankName;
    private String cardNumber;
    private transient String exp;
    private transient String cvv;

    /**
     * Construct Credit Card with specified values
     *
     * @param cardType {@link CardType} type of Credit Card
     * @param bankName String name of bank issuer
     * @param cardNumber String card number
     * @param exp String Card expire of date
     * @param cvv Card verification value
     */
    public CreditCard(CardType cardType, String bankName, String cardNumber, String exp, String cvv) {
        this.cardType = cardType;
        this.bankName = bankName;
        this.cardNumber = cardNumber;
        this.exp = exp;
        this.cvv = cvv;
    }

    /**
     * Construct Credit Card without values
     */
    public CreditCard() {
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cardType=" + cardType +
                ", bankName='" + bankName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", exp='" + exp + '\'' +
                ", cvv='" + cvv + '\'' +
                '}';
    }

    /**
     * The object implements the writeExternal method to save its contents
     * by calling the methods of DataOutput for its primitive values or
     * calling the writeObject method of ObjectOutput for objects, strings,
     * and arrays.
     *
     * @param out the stream to write the object to
     * @throws IOException Includes any I/O exceptions that may occur
     * @serialData Overriding methods should use this tag to describe
     * the data layout of this Externalizable object.
     * List the sequence of element types and, if possible,
     * relate the element to a public/protected field and/or
     * method of this Externalizable class.
     */
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.cardType);
        out.writeObject(this.bankName);
        out.writeObject(this.cardNumber);
        out.writeObject(this.cvv);
        out.writeObject(this.exp);
    }

    /**
     * The object implements the readExternal method to restore its
     * contents by calling the methods of DataInput for primitive
     * types and readObject for objects, strings and arrays.  The
     * readExternal method must read the values in the same sequence
     * and with the same types as were written by writeExternal.
     *
     * @param in the stream to read data from in order to restore the object
     * @throws IOException            if I/O errors occur
     * @throws ClassNotFoundException If the class for an object being
     *                                restored cannot be found.
     */
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.cardType = (CardType) in.readObject();
        this.bankName = (String) in.readObject();
        this.cardNumber = (String) in.readObject();
        this.cvv = (String) in.readObject();
        this.exp = (String) in.readObject();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreditCard)) return false;
        CreditCard that = (CreditCard) o;
        return Objects.equals(getCardNumber(), that.getCardNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCardNumber());
    }

}
