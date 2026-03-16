package Bai_03;

public class PaymentProcess {
    public void processPayment(PaymentMethod payment, double amount) {

        if (payment instanceof CODPayable) {
            ((CODPayable) payment).processCOD(amount);
        } else if (payment instanceof CardPayable) {
            ((CardPayable) payment).processCard(amount);
        } else if (payment instanceof EWalletPayable) {
            ((EWalletPayable) payment).processEWallet(amount);
        }
    }
}
