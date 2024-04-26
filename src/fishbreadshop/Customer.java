package fishbreadshop;

import java.util.Scanner;

public class Customer {
    private int amount;
    private int fishBreadCount;
    private FishBread fishBread;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount, Scanner sc) {
        System.out.println("붕어빵 사러 가야겠다. 돈 챙겨야지");
        while (amount < 2000) {
            System.out.println("아! 맞다. 2천원 부터였지.");
            amount = sc.nextInt();
        }
        this.amount = amount;
    }

    public void orderCheck(Order order, Scanner sc) {
        // 1 ~ 4번 메뉴가 아니면 다시 선택 할 수 있게 무한 루프
        while (!(0 < order.getMenuChoice() && order.getMenuChoice() < 5)
                || order.getPrice() > this.amount) {

            System.out.println("한도 초과 입니다. 다시 주문 해주세요.");

            if (!(0 < order.getMenuChoice() && order.getMenuChoice() < 5)) {
                System.out.println("없는 메뉴 입니다. 다시 입력해주세요.");
                order.setMenuChoice(sc.nextInt());
            }

            // 1 ~ 4번 메뉴를 선택 했을 때
            if (0 < order.getMenuChoice() && order.getMenuChoice() < 5) {
                order.setFishBreadCount(0); // 다시 선택 할 때 값 초기화
                order.setPrice(0);

                // 다시 붕어빵 개수 입력
                while (order.getFishBreadCount() == 0) {
                    order.setFishBreadCount(sc.nextInt());
                    order.setPrice(order.getFishBreadCount());

                    if (order.getFishBreadCount() == 0) {
                        System.out.println("0개는 판매하지 않습니다. 다시 주문 해주세요.");
                    }

                    if (order.getPrice() > this.amount) {
                        System.out.println("한도 초과 입니다. 다시 주문 해주세요.");
                        order.setFishBreadCount(0);
                        order.setPrice(0);
                    }
                }
            }
        }
    }

    public Order order(Order order, Scanner sc) {
        orderCheck(order, sc);
        System.out.print(order.getMenuChoice() + "번 메뉴를 선택했습니다." + "\n" +
                        order.getFishBreadCount() + "개를 주문했습니다." + "\n");
        return order;
    }

    public void receiveFishBread(FishBread fishBread) {
        this.fishBread = fishBread;
        this.fishBreadCount = fishBread.getFishBreadCount();
    }

    public int payInCash(int amount) {
        return amount;
    }

    public void receiveChange(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "amount = " + amount + ", " +
                fishBread.getFishBreadType() + "fishBread : " + fishBreadCount + "EA";
    }
}
