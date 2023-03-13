package App.Product;

import App.Product.SubProduct.Burger;
import App.Product.SubProduct.Drink;
import App.Product.SubProduct.Side;

/*
 [상품 정보 저장소]
 1. 상품 정보는 프로그램 실행중에 바뀌는 값이 아니기 때문에 그리고 바뀌어서도 안되기 때문에 상수로 설정
 2. 햄버거 세트는 사용자의 선택이기 때문에 상품저장소엔 따로 할당 X
 3. 상품 옵션은 사용자에 의해 선택되기 때문에 임의로 최소값들을 지정
 [행버거] -> 단품을 기본값으로 [isSetBuger : false 으로 초기화]
 [케찹] -> 케찹 최소값 1개로 지정 [Kechup : 1 으로 초기화]
 [빨대] -> 기본적으로 주기떄문에 [hasStraw : true 으로 초기화]
 */
public class ProductRepository {
    public static final Product[] PRODUCT= //Burger,Side,Drink 클래스는 Product 클래스를 상속받고 있으므로 Product가 이들의 상위클래스가 되며 하위 클래스들의 인스턴스는 아래와 같이 Product 타입의 변수에 할당할 수 있다.(업캐스팅)
            {
            new Burger(1,"새우버거",3500,500,false,4500),
            new Burger(2,"치킨버거",4000,600,false,5000),
            new Side(3,"감자튀김",1000,300,1),
            new Side(4,"어니언링",1000,300,1),
            new Drink(5,"코카콜라",1000,200,true),
            new Drink(6,"제로코카콜라",1000,0,true)
    };

    public Product[] getProduct() // 메뉴 출력
    {
        return PRODUCT;
    }

    public Product findById(int productId){
        for(Product product : PRODUCT){
            if(product.getId() == productId){
                return product;
            }
        }
        return null;
    }
}
