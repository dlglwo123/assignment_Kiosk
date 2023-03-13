package App.Product;
// 1. 공통적인 부분을 상위 추상클래스에 구현한다.
// => 이름,열량,가격 그리고 Primary Key가 존재한다.

public class Product {
    private int id; //Primary Key
    private String name; // 메뉴 이름
    private int price; // 메뉴 가격
    private int kcal; // 메뉴 열량


    public Product(int id, String name, int price, int kcal) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.kcal = kcal;
    }
    public Product(String name, int price, int kcal) // 생성자 오버로딩 : new burgerSet을 통해 햄버거 인스턴스를 생성할때 id가 굳이 필요하지않다. 그래서 구현을 빼버림 하지만 오류가 발생하는데 이를 생성자 오버로딩을 통해 해결가능하다.
    {
        this.name = name;
        this.price = price;
        this.kcal = kcal;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }
}
