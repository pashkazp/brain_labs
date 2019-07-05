package ua.zp.brain.labs.oop.basics.lab26;

public enum CardType {
    CARD_VISA("VISA"),
    CARD_MC("MASTER CARD");

    private final String cardType;

    /**
     * Construct Role
     *
     * @param cardType String representation Credit Card type
     */
    CardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardType() {
        return cardType;
    }
}
