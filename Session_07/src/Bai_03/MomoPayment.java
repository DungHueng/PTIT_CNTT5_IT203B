package Bai_03;

public class MomoPayment implements EWalletPayable {
    @Override
    public void processEWallet(double totalAmount) {
        System.out.println("Xử lý thanh toán MoMo: " + (int)totalAmount + " - Thành công");
    }
}
