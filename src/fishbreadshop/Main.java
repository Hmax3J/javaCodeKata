package fishbreadshop;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        runShop();
    }

    public static void runShop() {
        Scanner sc = new Scanner(System.in);
        Shop shop = new Shop(); // 가게 출현
        Safe safe = new Safe(); // 금고 설치
        Owner owner = new Owner(); // 사장 출현
        Shef shef = new Shef(); // 쉐프 고용

        while (true) {
            System.out.print("====================================================================\n" +
                             "     1. 붕어빵을 구매한다. 2. 붕어빵을 확인한다. 3. 집으로 돌아간다. \n" +
                             "====================================================================\n");
            int goShopOrHome = sc.nextInt();
            if (goShopOrHome == 3) {
                System.out.println("집으로 가야겠다.");
                break;
            } else if (goShopOrHome == 2) {
                System.out.println("붕어빵 확인 해볼까나.");
            } else if (goShopOrHome == 1) {
                System.out.println("붕어빵을 사볼까나. 얼마를 들고가지 ?");
                // 손님 출현, 붕어빵 구매 금액 챙기기
                Customer amugaeOne = new Customer();
                amugaeOne.setAmount(sc.nextInt(), sc);

                // 메뉴판 표시, 사장 손님 맞이 인사, 손님 주문
                shop.menu();
                owner.greetCustomer();
                Order amugaeOneOrder = amugaeOne.order(new Order(sc.nextInt(), sc.nextInt()), sc);

                // 손님 결제 요청, 사장 결제 하기, 사장 잔돈 계산, 손님에게 잔돈 주기
                int amugaeOnePayMent = amugaeOne.payInCash(amugaeOne.getAmount());
                int ownerReceiveCash = owner.receiveCash(amugaeOneOrder, amugaeOnePayMent);
                int ownerGiveChange = owner.giveChange(amugaeOneOrder, ownerReceiveCash);
                amugaeOne.receiveChange(ownerGiveChange);

                // 사장 주문 받기, 쉐프에게 주문 전달
                int ownerTakeOrder = owner.takeOrder(amugaeOneOrder);
                FishBreadType ownerShefOrderDelivery = owner.orderDelivery(amugaeOneOrder);

                // 쉐프 붕어빵 만들기, 사장에게 붕어빵 전달, 사장 붕어빵 받기
                List<FishBread> shefCook = shef.cook(ownerShefOrderDelivery, ownerTakeOrder);
                List<FishBread> shefOwnerServe = shef.serve(shefCook);
                List<FishBread> ownerReceiveFishBread = owner.receiveFishBread(shefOwnerServe);

                // 사장 손님에게 붕어빵 전달, 손님 붕어빵 받기
                List<FishBread> ownerServe = owner.serve(ownerReceiveFishBread);
                FishBreadBag fishBreadBag = new FishBreadBag(ownerServe);
                amugaeOne.receiveFishBread(fishBreadBag);

                // 사장 pos기에 판매 현황 입력하기, 판매 현황 보기, 포스기에 보관된 잔액 보기
                shop.pos(owner, ownerServe, owner.deposit(amugaeOneOrder));
                shop.salesStatus(owner);

                // 사장 pos기에서 매출 금액 출금, 금고에 매출 금액 입금, 금고 잔액 조회, pos기 잔액 조회
                int salesAmount = shop.salesAmount(owner);
                int withdrawPos = owner.withdrawPos(salesAmount);
                int depositSafe = owner.depositSafe(withdrawPos);
                safe.keepBalance(owner, depositSafe);
                safe.checkBalance(owner);
                shop.posAmount(owner, salesAmount);
            }
        }
    }
}
