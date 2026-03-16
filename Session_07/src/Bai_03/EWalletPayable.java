package Bai_03;

public interface EWalletPayable extends PaymentMethod {
    void processEWallet(double totalAmount);
}
