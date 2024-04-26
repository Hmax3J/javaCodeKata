package fishbreadshop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shop shop = new Shop(); // 가게 출현
        Owner owner = new Owner(); // 사장 출현
        Shef shef = new Shef(); // 쉐프 고용

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
        FishBread shefCook = shef.cook(ownerShefOrderDelivery, ownerTakeOrder);
        FishBread shefOwnerServe = shef.serve(shefCook);
        FishBread ownerReceiveFishBread = owner.receiveFishBread(shefOwnerServe);

        // 사장 손님에게 붕어빵 전달, 손님 붕어빵 받기
        FishBread ownerServe = owner.serve(amugaeOneOrder, ownerReceiveFishBread);
        amugaeOne.receiveFishBread(ownerServe);

        // 사장 포스기에 판매 현황 입력하기, 판매 현황 보기, 포스기에 보관된 잔액 보기
        shop.pos(amugaeOneOrder, owner.deposit(amugaeOneOrder));
//        shop.salesStatus(owner);
//        shop.posAmount(owner);
    }
}
