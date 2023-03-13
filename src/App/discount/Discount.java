package App.discount;

public class Discount {
    DiscountCondition [] discountConditions; // 할인조건이 한개가 아닌 여러개이기 때문에 배열 생성


    public Discount(DiscountCondition[] discountConditions) {
        this.discountConditions = discountConditions;
    }

    public int discountCal(int price){
        int discountPrice = price;

        for(DiscountCondition discountCondition : discountConditions){
            discountCondition.checkDiscountCondition();
            if(discountCondition.isSatisfied()) discountCondition.applyDiscount(price);
    }
    //if(cozDiscountCondition.isSatisfied()) finalPrice = cozDiscountCondition.applyDiscount(finalPrice);
    //if(kidDiscountCondition.isSatisfied()) finalPrice = kidDiscountCondition.applyDiscount(finalPrice);
        return discountPrice;
    }
}
