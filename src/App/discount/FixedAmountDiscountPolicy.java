package App.discount;

public class FixedAmountDiscountPolicy implements DiscountPolicy {
    private int discountAmount;

    public FixedAmountDiscountPolicy(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public int CaculaterAmountDiscount(int price){
        return price - discountAmount;
    }
}
