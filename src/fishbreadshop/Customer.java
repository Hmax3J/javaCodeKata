package fishbreadshop;

import java.util.Scanner;

public class Customer {
    private int amount;
    private int fishBreadCount;
    private FishBreadType fishBreadType;

    public Customer(int amount) {
        this.amount = amount;
        System.out.println("고객님이 출현했습니다.");
    }

    public int getAmount() {
        return amount;
    }

    public Order order(Order order, Scanner sc) {
        while (true) {
            if (0 >= order.getMenuChoice() || order.getMenuChoice() > 4) {
                System.out.println("없는 메뉴 입니다. 다시 입력해주세요.");
                order = new Order(sc.nextInt(), sc.nextInt());
            } else {
                break;
            }
        }

        System.out.print(order.getMenuChoice() + "번 메뉴를 선택했습니다." + "\n" +
                        order.getFishBreadCount() + "개를 주문했습니다." + "\n");
        return order;
    }

    public void receive(FishBread fishBread) {
        this.fishBreadType = fishBread.getFishBreadType();
        this.fishBreadCount = fishBread.getFishBreadCount();
    }

    public int payInCash(int amount) {
        return amount;
    }

    public void getChange(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "amount = " + amount + ", " +
                fishBreadType + "fishBread : " + fishBreadCount + "EA";
    }
}
