package Bai_03;

public class CreditCardPayment implements CardPayable {
    @Override
    public void processCard(double totalAmount) {
        System.out.println("Xử lý thanh toán COD: " + (int)totalAmount + " - Thành công");
    }
}
