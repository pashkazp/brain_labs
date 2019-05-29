package ua.zp.brain.labs.oop.basics.lab18;

public class UserBank {
    public static void main(String[] args) {
        try {
            MoneyTransactionUtil.sendTo("1234-5678-9012-3456", "1234-5678-9012-3456", 1000);
        } catch (AccountException e) {
            System.err.println("Ошибка с реквизитами банка. " + e.getMessage());
        } catch (MoneyValueException e) {
            System.err.println("Ошибка с суммой отправки. " + e.getMessage());
        }

        try {
            MoneyTransactionUtil.sendTo("1234-5678-9012-3456", "1234-5678-9012-3452", 1000);
        } catch (AccountException e) {
            System.err.println("Ошибка с реквизитами банка. " + e.getMessage());
        } catch (MoneyValueException e) {
            System.err.println("Ошибка с суммой отправки. " + e.getMessage());
        }

        try {
            MoneyTransactionUtil.sendTo("1234-5678-9012-3456", "1234-5678-9012-3452", 1);
        } catch (AccountException e) {
            System.err.println("Ошибка с реквизитами банка. " + e.getMessage());
        } catch (MoneyValueException e) {
            System.err.println("Ошибка с суммой отправки. " + e.getMessage());
        }

        try {
            MoneyTransactionUtil.sendTo("1234-5678-9012-3456", "1234-5678-9012-3452", 0);
        } catch (AccountException e) {
            System.err.println("Ошибка с реквизитами банка. " + e.getMessage());
        } catch (MoneyValueException e) {
            System.err.println("Ошибка с суммой отправки. " + e.getMessage());
        }

        try {
            MoneyTransactionUtil.sendTo("1234-5678-9012-3456", "1234-5678-9012-3452", 100_000);
        } catch (AccountException e) {
            System.err.println("Ошибка с реквизитами банка. " + e.getMessage());
        } catch (MoneyValueException e) {
            System.err.println("Ошибка с суммой отправки. " + e.getMessage());
        }

        try {
            MoneyTransactionUtil.sendTo("1234-5678-9012-3456", "1234-5678-9012-3452", 100_101);
        } catch (AccountException e) {
            System.err.println("Ошибка с реквизитами банка. " + e.getMessage());
        } catch (MoneyValueException e) {
            System.err.println("Ошибка с суммой отправки. " + e.getMessage());
        }
    }
}
