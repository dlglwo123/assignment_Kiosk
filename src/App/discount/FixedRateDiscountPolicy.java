package App.discount;

public class FixedRateDiscountPolicy implements DiscountPolicy {
    private int discountRate;

    public FixedRateDiscountPolicy(int discountRate) {
        this.discountRate = discountRate;
    }

    public int CaculaterAmountDiscount(int price){
        return price = price - (price * discountRate/100);
    }
}
