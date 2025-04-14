import java.awt.*;
import java.util.List;
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

        while (true) {
            System.out.println("\n[메인메뉴]");
            List<Menu> menus = kiosk.getMenus();
            for (int i = 0; i < menu.size(); i++) {
                System.out.println((i + 1) + ". " + menus.get(i).getName);
            }
            System.out.println("0. 종료");

            if (!cartService.isEmpty()) {
                System.out.println("4. 주문하기");
                System.out.println("5. 장바구니 비우기");
            }

            System.out.print("메뉴 선택: ");
            int input = sc.nextInt();
            sc.nextLine(); // 개행 제거

            if (input == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (input == 4) {
                if (cartService.isEmpty()) {
                    System.out.println("장바구니가 비어있습니다.");
                } else {
                    System.out.println("장바구니 내용:");
                    cartService.displayCartItems();

                    System.out.println("할인 정보를 선택하세요:");
                    System.out.println("1. 국가유공자");
                    System.out.println("2. 군인");
                    System.out.println("3. 학생");
                    System.out.println("4. 일반");

                    int discountInput = sc.nextInt();
                    sc.nextLine();

                    UserType userType;
                    if (discountInput == 1) {
                        userType = UserType.NATIONAL_MERIT;
                    } else if (discountInput == 2) {
                        userType = UserType.MILITARY;
                    } else if (discountInput == 3) {
                        userType = UserType.STUDENT;
                    } else {
                        userType = UserType.NORMAL;
                    }

                    double total = cartService.getDiscountedTotalPrice(userType);
                    System.out.printf("최종 금액: W %.1f\n", total);
                    System.out.println("1. 결제하기");
                    System.out.println("2. 취소");

                    int payInput = sc.nextInt();
                    sc.nextLine();

                    if (payInput == 1) {
                        System.out.println("결제가 완료되었습니다!");
                        cartService.clearCart();
                    } else {
                        System.out.println("결제를 취소했습니다.");
                    }
                }
            } else if (input == 5) {
                cartService.clearCart();
                System.out.println("장바구니를 비웠습니다.");
            } else if (input >= 1 && input <= menus.size()) {
                Menu selectedMenu = menus.get(input - 1);
                List<MenuItem> items = selectedMenu.getMenuItems();

                System.out.println("\n[" + selectedMenu.getName() + " 메뉴]");
                for (int i = 0; i < items.size(); i++) {
                    MenuItem item = items.get(i);
                    System.out.printf("%d. %s (W %.1f) - %s\n", i + 1, item.getName(), item.getPrice(), item.getDescription());
                }
                System.out.println("0. 뒤로가기");
                System.out.print("선택: ");
                int itemInput = sc.nextInt();
                sc.nextLine();

                if (itemInput >= 1 && itemInput <= items.size()) {
                    MenuItem selectedItem = items.get(itemInput - 1);
                    System.out.println("1. 장바구니에 추가");
                    System.out.println("2. 취소");
                    int confirm = sc.nextInt();
                    sc.nextLine();
                    if (confirm == 1) {
                        cartService.addItem(selectedItem);
                        System.out.println("추가되었습니다.");
                    }
                }
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}






