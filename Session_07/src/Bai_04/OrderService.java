package Bai_04;

public class OrderService {
    private OrderRepository orderRepository;
    private NotificationService notificationService;


    public OrderService(OrderRepository repo, NotificationService noti) {
        this.orderRepository = repo;
        this.notificationService = noti;
    }
    public void createOrder(String id) {
        Order order = new Order(id);

        orderRepository.save(order);

        notificationService.send("Đơn hàng " + id + " đã được tạo", "user");
    }
}
