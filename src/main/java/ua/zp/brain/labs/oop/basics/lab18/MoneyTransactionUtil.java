package ua.zp.brain.labs.oop.basics.lab18;

/**
 * Simple transaction util that perform transaction between two accounts
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class MoneyTransactionUtil {
    // do not instantiate that Class
    private MoneyTransactionUtil() {
    }

    /**
     * Method perform check source and destination accounts and verifiers transaction Sum.
     *
     * @param fromCard String specifies source account
     * @param toCard   String specifies destination account
     * @param transSum int specifies transaction sum
     * @throws AccountException    exception extends {@link RuntimeException} and fires when source and destination accounts is equal
     * @throws MoneyValueException exception extends {@link RuntimeException} and fires when transaction sum not in allowable interval
     */
    public static void sendTo(String fromCard, String toCard, int transSum) throws AccountException, MoneyValueException {
        if (fromCard.equals(toCard)) {
            throw new AccountException("счета источник и получатель совпадают");
        }
        if (transSum <= 0 || transSum > 100_000) {
            throw new MoneyValueException("сумма транзакции выходит за допустимый диапазон (0, 100_000]");
        }

        System.out.printf("«Сумма %d, со счета %s успешно переведена на счет %s\n", transSum, fromCard, toCard);
    }
}
