package Bai_02;

public class OrderCalculator {
    private DiscountStrategy discountStrategy;

    public OrderCalculator(PercentageDiscount percentageDiscount) {
        this.discountStrategy = percentageDiscount;
    }

    public OrderCalculator(FixedDiscount fixedDiscount) {
        this.discountStrategy = fixedDiscount;
    }

    public OrderCalculator(NoDiscount noDiscount) {
        this.discountStrategy = noDiscount;
    }

    public OrderCalculator(HolidayDiscount holidayDiscount) {
        this.discountStrategy = holidayDiscount;
    }

    public void OrderCalculator(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculate(double totalAmount) {
        return discountStrategy.applyDiscount(totalAmount);
    }
}
