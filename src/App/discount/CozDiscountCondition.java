package App.discount;

import java.util.Scanner;

public class CozDiscountCondition implements DiscountCondition {

    //FixedRateDiscountPolicy fixedRateDiscountPolicy = new FixedRateDiscountPolicy(20);
    DiscountPolicy discountPolicy;


    private boolean isSatisfied;

    public CozDiscountCondition(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public boolean isSatisfied(){
        return isSatisfied;
    }

    private void setSatisfied(boolean satisfied){
        isSatisfied = satisfied;
    }

    public void checkDiscountCondition(){
        Scanner sc = new Scanner(System.in);

        System.out.println("코드스테이츠 수강생입니까? (1)_예  (2)_아니오");
        String input = sc.nextLine();

        if(input.equals("1")) setSatisfied(true);
        else if(input.equals("2")) setSatisfied(false);
    }
    public int applyDiscount(int price) {
        return discountPolicy.CaculaterAmountDiscount(price);
    }

}

