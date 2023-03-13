package App;

import App.Product.Product;
import App.Product.ProductRepository;
import App.discount.*;

import java.util.Scanner;

/*
    [주문 앱]
    1. 메뉴 출력
    2. 메뉴를 선택한 경우
    3. 장바구니 누른경우 -> 출력 -> 다시 메뉴 출력
    4. 주문 내역 출력 -> 프로그램 종료
    ==============================
    프로그램의 기능 분산

 */
public class OrderApp {

    Scanner sc = new Scanner(System.in);
    private ProductRepository productRepository;
    private Menu menu;
    private Cart cart;
    private Order order;

    public OrderApp(ProductRepository productRepository, Menu menu, Cart cart, Order order) {
        this.productRepository = productRepository;
        this.menu = menu;
        this.cart = cart;
        this.order = order;
    }


    public void operator() {

        System.out.println("🍔 BurgerQueen Order Service");
        while (true) {
            menu.printMenu();
            String Input = sc.nextLine();

            if (Input.equals("+")) // 사용자의 입력이 + 인경우 : 주문내역 출력
            {
                order.makeOrder();
                break;

            } else //사용자의 입력이 0인경우 : 장바구니 출력
            {
                int menuNumber = Integer.parseInt(Input);
                if (menuNumber == 0) cart.printCart();
                else if (1 <= menuNumber && menuNumber <= products.length) cart.addToCart(menuNumber);
            }

        }
    }
}
