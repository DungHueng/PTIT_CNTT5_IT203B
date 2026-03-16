package Bai_03;

public class Main {
    public static void main(String[] args) {

        PaymentProcess processor = new PaymentProcess();

        System.out.println("COD");
        PaymentMethod cod = new CODPayment();
        processor.processPayment(cod, 500000);

        System.out.println();

        System.out.println("Thẻ tín dụng");
        PaymentMethod card = new CreditCardPayment();
        processor.processPayment(card, 1000000);

        System.out.println();

        System.out.println("Ví MoMo");
        PaymentMethod momo = new MomoPayment();
        processor.processPayment(momo, 750000);

        System.out.println();

        System.out.println("Thay thế CreditCardPayment bằng MomoPayment");

        PaymentMethod test = new MomoPayment();
        processor.processPayment(test, 1000000);

    }
}
