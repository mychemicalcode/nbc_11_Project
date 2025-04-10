import java.util.Scanner;

public class KioskService {
    private Scanner sc;
    private Kiosk kiosk;
    private CartService cartService;

    public KioskService(Scanner sc, Kiosk kiosk, CartService cartService) {
        this.sc = sc;
        this.kiosk = kiosk;
        this.cartService = cartService;
    }

    public void start() {
        System.out.println("키오스크에 오신 것을 환영합니다.");


    }

}
