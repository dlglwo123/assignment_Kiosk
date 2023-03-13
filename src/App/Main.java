package App;
/* App 패키지로 정리해야하는 이유 : 이전에 상태에서 모든 클래스들은 패키지 지정이 되어있지 않다.그럼 자동으로 default 패키지로 자동으로 포함되는데
원칙적으로 default 패키지의 클래스들을 다른 클래스에서 import 할 수 없다.
 */

//  [실행 파일]
public class Main
{
    public static void main(String[] args) {

        AppConfigurer appConfigurer = new AppConfigurer();
        OrderApp orderApp = new OrderApp(appConfigurer.productRepository(),appConfigurer.menu(),appConfigurer.cart(),appConfigurer.order()); // 메인 메서드에 정의하지 않고 OrderApp에 실행파일을 만든 이유 : main 메서드에 모든 프로그램의 로직을 작성하면 Main 클래스에 정의한 모든 인스턴스 필드사용 X
        orderApp.operator();
    }
}