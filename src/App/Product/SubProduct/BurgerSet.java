package App.Product.SubProduct;
import App.Product.Product;


// 세트를 구성할 때에 생성자를 통해서 세트를 구성하기 때문에 Setter는 만들지 않는다.
public class BurgerSet extends Product {
    private Burger SetBuger;
    private Side SetSide;
    private Drink SetDrink;

    public BurgerSet(String name, int price, int kcal, Burger setBuger, Side setSide, Drink setDrink) {
        super(name, price, kcal);
        SetBuger = setBuger;
        SetSide = setSide;
        SetDrink = setDrink;
    }


    public Burger getSetBuger() {
        return SetBuger;
    }

    public Side getSetSide() {
        return SetSide;
    }
    public Drink getSetDrink() {
        return SetDrink;
    }
}
