package Bai_04;

public class Main {
    public static void main(String[] args) {
        OrderRepository repo1 = new FileOrderRepository();
        NotificationService noti1 = new EmailService();

        OrderService service1 = new OrderService(repo1, noti1);
        service1.createOrder("ORD001");

        System.out.println("--------------------");


        OrderRepository repo2 = new DatabaseOrderRepository();
        NotificationService noti2 = new SMSNotification();

        OrderService service2 = new OrderService(repo2, noti2);
        service2.createOrder("ORD002");
    }
}
