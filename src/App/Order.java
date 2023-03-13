package App;

import App.discount.*;

/*
       [주문하기]
      1. 주문하기는 장바구니에 담긴 상품을 기반을로 한다.
 */
public class Order {
    private Cart cart;

    Discount discount;
    public Order(Cart cart,Discount discount){
        this.cart = cart;
        this.discount = discount;
    }

    public void makeOrder(){
        //CozDiscountCondition cozDiscountCondition = new CozDiscountCondition(new FixedRateDiscountPolicy(10));
        //KidDiscountCondition kidDiscountCondition = new KidDiscountCondition(new FixedAmountDiscountPolicy(500));

        //kidDiscountCondition.checkDiscountCondition()
        //CozdDiscountCondition.checkDiscountCondition()

        int total = cart.calculateTotalPrice();
        int finalTotal = discount.discountCal(total);

        //if(cozDiscountCondition.isSatisfied()) finalPrice = cozDiscountCondition.applyDiscount(finalPrice);
        //if(kidDiscountCondition.isSatisfied()) finalPrice = kidDiscountCondition.applyDiscount(finalPrice);


        System.out.println("[📣] 주문이 완료되었습니다. ");
        System.out.println("[📣] 주문 내역은 다음과 같습니다. ");
        System.out.println("-".repeat(60));

        cart.printCartItemDetails();


        System.out.println("-".repeat(60));
        System.out.printf("금액 합계      : %d원\n", cart.calculateTotalPrice());

    }
}
