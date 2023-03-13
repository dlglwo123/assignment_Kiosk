package App.Product.SubProduct;

import App.Product.Product;

public class Drink extends Product {
    private boolean hasStraw;

    public Drink(int id, String name, int price, int kcal, boolean straw) {
        super(id, name, price, kcal);
        this.hasStraw = straw;
    }

    public Drink(Drink drink) {
        super(drink.getName(), drink.getPrice(),drink.getKcal());
        this.hasStraw = drink.hasStraw;
    }


    public boolean isHasStraw() {
        return hasStraw;
    }

    public void setHasStraw(boolean hasStraw) {
        this.hasStraw = hasStraw;
    }
}

