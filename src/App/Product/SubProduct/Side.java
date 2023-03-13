package App.Product.SubProduct;

import App.Product.Product;

public class Side extends Product {

    private int kechup;

    public Side(int id, String name, int price, int kcal, int kechup) {
        super(id, name, price, kcal);
        this.kechup = kechup;
    }

    public Side(Side side) {
        super(side.getName(), side.getPrice(), side.getKcal());
        this.kechup = side.kechup;
    }

    public int getKechup() {
        return kechup;
    }

    public void setKechup(int kechup) {
        this.kechup = kechup;
    }
}
