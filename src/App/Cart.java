package ;


import App.Product.Product;
import App.Product.ProductRepository;
import App.Product.SubProduct.Burger;
import App.Product.SubProduct.BurgerSet;
import App.Product.SubProduct.Drink;
import App.Product.SubProduct.Side;

import java.util.Arrays;
import java.util.Scanner;

public class Cart {

   // 정의 파일

    private Menu menu;
    private Product[] items = new Product[0]; // 장바구니 배열
    Scanner sc = new Scanner(System.in);

    ProductRepository productRepository = new ProductRepository(); // 먼저 상품을 장바구니에 담기 위해서는 입력값으로 productId를 입력값으로 받는 id의 상품을 찾아야함

    public Cart(ProductRepository productRepository,Menu menu)
    {
        this.productRepository = productRepository;
        this.menu = menu;
    }


    //1. 장바구니 담기 -> addToCart();

    public void addToCart(int productId){
        Product product = productRepository.findById(productId); // 입력값이 들어오면 ProductRepository에 있는 FindByid에서 아이디와 맞는 제품을 리턴한다.
        chooseOption(product);

        if(product instanceof Burger) // 정보를 순회하다 버거를 입력받고 만일 버거 클래스가 isSetBuger : true라는 것은 세트의 의미이기 때문에 composeSet 실행
        {
            Burger burger = (Burger) product;
            if(burger.isSetBuger()) product = composeSet(burger);
        }

        Product newProduct;
        if(product instanceof Burger) newProduct = new Burger((Burger) product); // 새로운 객체를 만들어서 중복을 해결
        else if(product instanceof Side) newProduct = new Side ((Side) product);
        else if(product instanceof Drink) newProduct = new Drink ((Drink) product);
        else newProduct = product;


        Product[] newItems = new Product[items.length + 1]; //배열의 길이를 1만큼 넓힌다.
        System.arraycopy(items,0,newItems,0,items.length); // items 0번값부터 newItems 0번지에 Items 길이만큼 복사한다.
        newItems[items.length] = product; //??
        items = newItems;
        System.out.printf("[📣] %s를(을) 장바구니에 담았습니다.\n", product.getName());
    }
    /* 2. 특정 상품에 대하여 옵션을 선택할 수 있게 해주는 역할 -> chooseOption
           - 입력값 : 제품마다 선택옵션이 다르므로 상품이 입력값
           - 반환값 : isBurgerSer,isHasStraw,Kechup은 Setter을 통해서 값을 변경해주기만 하면되므로 반환값 필요없음
           - 접근 범위 : addToCart 내부(private)
    */
    private void chooseOption(Product product){

        String Input;

        if(product instanceof Burger){
            System.out.printf("단품으로 주문하시겠어요? (1)_단품(%d원), (2)_세트(%d)원 \n",
                    product.getPrice(),
                    ((Burger) product).getSetBurgerPrice());
            Input = sc.nextLine();
            if(Input.equals("2")) {
                ((Burger) product).setSetBuger(true); // 2면 버거클래스의 isSetBurger가 true로 바뀜
            }
        }
        else if(product instanceof Side){
            System.out.println("케찹은 몇개 필요하신가요?");
            Input = sc.nextLine();
            ((Side) product).setKechup(Integer.parseInt(Input)); //Kechup 클래스에 개수 부여
        }
        else if(product instanceof Drink){
            System.out.println("빨대가 필요하신가요? (1)_예 (2)_아니요");
            Input = sc.nextLine();
            if(Input.equals("2")) ((Drink) product).setHasStraw(false); //Drink 클래스에 만약 빨대가 필요없다 2번을 선택했을시 setter 메서드로 값을 false로 변환
        }
    }
    /* 4. composeSet -> 햄버거 세트를 구성해주는 역할
       - 리턴 값이 burgerSet인 이유는 composeSet 햄버서 세트를 구성해주고 있으므로 햄버거,사이드,콜라의 세트 정보를 리턴받아 정볼를 저장하기 위해서
       - 입력값이 햄버거인 이유? 햄버거의 isBurgerSet(Burger 클래스에 있다.)의 값이 true이면 아래 메서드 출력 아니면 X
     */

    private BurgerSet composeSet(Burger burger){

        System.out.println("사이드를 골라주세요.");
        menu.printSide(false);
        String sideId = sc.nextLine();
        Side side = (Side) productRepository.findById(Integer.parseInt(sideId)); //findById가 Product형이기 때문에 다운캐스팅 후 실행
        Side newSide = new Side(side); //위의 side로 값이 전달되고 아래구문으로 내려와 side의 값으로 새로운 객체를 생성하고 newSide에 값을 대입한다.
        chooseOption(newSide); //새로운 객체로 값을 저장

        System.out.println("음료를 골라주세요");
        menu.printDrink(false);
        String drinkId = sc.nextLine();
        Drink drink = (Drink) productRepository.findById(Integer.parseInt(drinkId));
        Drink newdrink = new Drink(drink);
        chooseOption(newdrink);

        String name = burger.getName() + "세트";
        int price = burger.getSetBurgerPrice();
        int kcal = burger.getKcal() + side.getKcal() + drink.getKcal();

        return new BurgerSet(name,price,kcal,burger,newSide,newdrink);
    }

    /*4. 장바구니 출력하기 - PrintCart()
     - 장바구니의 상품들을 단순히 출력해주는 기능
     - Cart 객체의 items를 메게변수로 받지 않아도 되기 때문에 입력값 필요없음
     - pritCart()는 OderApp의 start() 메서드에 호출되어야 하므로 Public 선언
    */

    public void printCart() {
        System.out.println("🧺 장바구니");
        System.out.println("-".repeat(60));

        printCartItemDetails();

        System.out.println("-".repeat(60));
        System.out.printf(" 합계 : %d원\n", calculateTotalPrice());

        System.out.println("이전으로 돌아가려면 엔터를 누르세요. "); //엔터를 누르면 OrderApp 실행할때 while문을 빠져나옴
        sc.nextLine();
    }

    /*
        2. 장바구니 상품들을 옵션 정보와 함께 출력 -> printCartItemDetails()
        - [입력값] : Cart 클래스의 필드인 items를 출력할 것이기 때문에 입력값이 필요없다.
        - [반환값] : 단순 출력 메서드이기 때문에,반환값 X
        - [접근 범위] : Cart내부(PrintCart)에서 출력할 것이기 때문에 Private
     */
    protected void printCartItemDetails() {
        for (Product product : items) {
            if (product instanceof BurgerSet) {
                BurgerSet burgerSet = (BurgerSet) product; //Burger,Side,Drink,BurgerSet은 업캐스팅이 되어있는 상태이기 때문에 상위 클래스의 필드와 메서드만 접근이 가능하다.
                System.out.printf(" %s %6d원(%s(케첩 %d개), %s(빨대 %s)\n",  //그래서 다운캐스팅을 함.
                        product.getName(),
                        product.getPrice(), // 햄버거는 다운캐스팅 참조변수를 참조하지않아도 된다(햄버거의 단품과 세트의 여부가 결정되었기때문(세트).
                        burgerSet.getSetSide().getName(),
                        burgerSet.getSetSide().getKechup(),
                        burgerSet.getSetDrink().getName(),
                        burgerSet.getSetDrink().isHasStraw() ? "있음" : "없음");
            }
        }
        // 버거(장바구니 옵션 출력) : 버거는 세트가 아니면 단품이기 때문에 따로 옵션을 구현 안해주어도된다.
        for (Product product : items) {
            if (product instanceof Burger) {
                System.out.printf(" %-8s  %6d원(단품)\n",
                        product.getName(),
                        product.getPrice());
            }
        }
        // 사이드(장바구니 옵션 출력)
        for (Product product : items) {
            if (product instanceof Side) {
                System.out.printf(" %-8s  %6d원(케첩 %d개)\n",
                        product.getName(),
                        product.getPrice(),
                        ((Side) product).getKechup());
            }
        }
        // 음료(장바구니 옵션 출력)
        for (Product product : items) {
            if (product instanceof Drink) {
                System.out.printf(" %-8s  %6d원(빨대 %s)",
                        product.getName(),
                        product.getPrice(),
                        ((Drink) product).isHasStraw() ? "있음" : "없음");
            }
        }
    }

    /*
     장바구니 배열들을 순회하면서 금액의 합계를 알려주는 메서드 -> calculateTotalPrice()
     */
    protected int calculateTotalPrice(){
        int PriceTotal = 0;
        for(Product product : items){
            PriceTotal += product.getPrice();
        }
        return PriceTotal;
    }
}