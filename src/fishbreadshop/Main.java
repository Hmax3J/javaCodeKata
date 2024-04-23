package fishbreadshop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shop shop = new Shop();
        Owner owner = new Owner();
        Shef shef = new Shef();

        // 손님 출현, 주문
        Customer amugaeOne = new Customer(sc.nextInt());
        shop.menu();
        owner.greetCustomer();
        Order amugaeOneOrder = amugaeOne.order(new Order(sc.nextInt(), sc.nextInt()), sc);

        // 사장 주문 받기, 쉐프에게 주문 전달
        int ownerTakeOrder = owner.takeOrder(amugaeOneOrder);
        FishBreadType ownerShefOrderDelivery = owner.orderDelivery(amugaeOneOrder);

        // 쉐프 붕어빵 만들기, 사장에게 붕어빵 전달
        FishBread shefOwnerServe = shef.cook(ownerShefOrderDelivery, ownerTakeOrder);
        FishBread ownerReceive = owner.receive(shefOwnerServe);

        // 사장 손님에게 붕어빵 전달, 손님 붕어빵 받기
        FishBread ownerServe = owner.serve(ownerReceive);
        amugaeOne.receive(ownerServe);

        System.out.println(amugaeOne);
    }
}
