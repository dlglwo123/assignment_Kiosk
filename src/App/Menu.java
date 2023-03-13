package App;

import App.Product.Product;
import App.Product.SubProduct.Burger;
import App.Product.SubProduct.Drink;
import App.Product.SubProduct.Side;

import javax.swing.*;

public class Menu {
    private Product[] products; // 값을 저장할 변수를 선언한다.


    public Menu(Product[] products) // 생성자에 어떠한 값이 들어오면 그 값은 선언한 변수에 저장한다.
    {
        this.products = products;
    }

    //인스턴스 instance of 클래스 => 좌항의 인스턴스를 생성한 클래스가 우항의 클래스와 같거나,우항 클래스의 하위클래스라면 true, 그렇지 않다면 false
    //[Check] 그리고 아까 ProductRepository에 업캐스팅을 참고(업캐스팅 : 상위클래스형 객체를 생성하고자 할때 하위클래스 정보를 좌변에 제공한다.)

    public void printMenu(){
        System.out.println("[🔻] 메뉴");
        System.out.println("-".repeat(60));

        printBurger(true); //메서드 추출을 이용해서 간단화한 출력문구
        printSide(true);
        printDrink(true);
        System.out.println();
        System.out.println("🧺 (0) 장바구니");
        System.out.println("📦 (+) 주문하기");
        System.out.println("-".repeat(60));
        System.out.print("[📣] 메뉴를 선택해주세요 : ");
    }

    // 선언한 변수에 저장된 값들을 순회하면서 타입변환이 된다면
    // 아래 구문을 실행하게 만듬(햄버거는 Product와 햄버거로 타입변환이 가능하다.)
    // Products에 저장된값은 각각 Burger,Side,Drink 즉 new Burger 값만이 if문을 실행할 수 있다.
    protected void printDrink(boolean printPrice) {
        System.out.println("🥤 음료");
        for(Product product : products){
            if(product instanceof Drink){
                printEachMenu(product,printPrice);
            }
        }
        System.out.println();
    }

    protected void printSide(boolean printPrice) {
        System.out.println("🍟 사이드");
        for(Product product :products){
            if(product instanceof Side){
                printEachMenu(product,printPrice);
            }
        }
        System.out.println();
    }

    private void printBurger(boolean printPrice) {
        System.out.println("🍔 햄버거");
        for(Product product : products) //[check] Product product : new Buger,new Side,new Drink 이런식으로 순회
        {
            if(product instanceof Burger){
                printEachMenu(product,printPrice);
            }
        }
        System.out.println();
    }

    private static void printEachMenu(Product product,boolean printPrice) // 코드의 중복이 있을경우 메서드 추출기능을 통해서 구현이 가능하다. 리펙토링 -> 메서드 추출
    {
        if(printPrice) System.out.printf("    (%d) %s %5dKcal  %d원 \n", product.getId(), product.getName(), product.getKcal(), product.getPrice()); //만약 true이면 가격이 보여져서 나옴
        else System.out.printf(    "(%d) %s %5dKcal\n", product.getId(), product.getName(), product.getKcal()); //false면 가격이 가려져서 나옴
    }

}
