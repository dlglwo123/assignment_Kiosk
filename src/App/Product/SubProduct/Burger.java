package App.Product.SubProduct;

import App.Product.Product;

public class Burger extends Product {

    private boolean isSetBuger; //세트 여부 값으로 값을 변경하고 읽어들이기 떄문에 getter,setter
    private int SetBurgerPrice; // 버거 세트의 가격

    public Burger(int id, String name, int price, int kcal, boolean isSetBuger,int SetBurgerPrice) {
        super(id, name, price, kcal);
        this.isSetBuger = isSetBuger;
        this.SetBurgerPrice = SetBurgerPrice;
    }

    public Burger(Burger burger) //생성자가 생성될때마다 Burger burger = new Burger 로서 생성자의 매게변수를 새로운 객체로 받는다.
    {
        super(burger.getName(), burger.getPrice(), burger.getKcal());
        this.isSetBuger = burger.isSetBuger;
        this.SetBurgerPrice = getSetBurgerPrice();
    }

    public boolean isSetBuger() {
        return isSetBuger;
    }

    public void setSetBuger(boolean setBuger) {
        isSetBuger = setBuger;
    }

    public int getSetBurgerPrice() {
        return SetBurgerPrice;
    }

    public void setSetBurgerPrice(int setBurgerPrice) {
        SetBurgerPrice = setBurgerPrice;
    }
}
