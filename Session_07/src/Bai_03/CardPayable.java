package Bai_03;

public interface CardPayable extends PaymentMethod {
    void processCard(double totalAmount);
}
