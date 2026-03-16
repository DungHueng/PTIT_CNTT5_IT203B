package Bai_02;

public class Main {
    public static void main(String[] args) {
        double total = 1000000;

        System.out.println("Đơn hàng: tổng tiền 1.000.000, áp dụng PercentageDiscount 10%");
        OrderCalculator percent = new OrderCalculator(new PercentageDiscount(10));
        System.out.println("Số tiền sau giảm: " + (int)percent.calculate(total));

        System.out.println();

        System.out.println("Đơn hàng: tổng tiền 1.000.000, áp dụng FixedDiscount 50.000");
        OrderCalculator fixed = new OrderCalculator(new FixedDiscount(50000));
        System.out.println("Số tiền sau giảm: " + (int)fixed.calculate(total));

        System.out.println();

        System.out.println("Đơn hàng: tổng tiền 1.000.000, áp dụng NoDiscount");
        OrderCalculator none = new OrderCalculator(new NoDiscount());
        System.out.println("Số tiền sau giảm: " + (int)none.calculate(total));

        System.out.println();

        System.out.println("Thêm HolidayDiscount 15%");
        OrderCalculator holiday = new OrderCalculator(new HolidayDiscount());
        System.out.println("Số tiền sau giảm: " + (int)holiday.calculate(total));
    }

}
