package fishbreadshop;

import java.util.List;

public class Owner {
    FishBreadType fishBreadType;

    public void greetCustomer() {
        System.out.println("        메뉴를 선택해주세요 !");
    }

    public FishBreadType orderDelivery(Order order) {
        if (order.getMenuChoice() == 1) {
            fishBreadType = FishBreadType.RED_BEAN;
        } else if (order.getMenuChoice() == 2) {
            fishBreadType = FishBreadType.CHOUXCREAM;
        } else if (order.getMenuChoice() == 3) {
            fishBreadType = FishBreadType.PIZZA;
        } else if (order.getMenuChoice() == 4) {
            fishBreadType = FishBreadType.ANYTHING;
        }

        return fishBreadType;
    }

    public int takeOrder(Order fishBreadCount) {
        return fishBreadCount.getFishBreadCount();
    }

    public List<FishBread> receiveFishBread(List<FishBread> fishBread) {
        return fishBread;
    }

    public List<FishBread> serve(List<FishBread> fishBread) {
        if (fishBread.size() == 1) {
            System.out.print("주문하신 " + fishBread.get(0).getFishBreadType() + "붕어빵 " +
                    fishBread.get(0).getFishBreadCount() + "개 여기 있습니다.\n" +
                    "기다려 주셔서 감사합니다.\n");
        } else if (fishBread.size() == 2) {
            System.out.print(
                    "아무거나 붕어빵의 시그니처 랜덤 주문입니다.\n" +
                    fishBread.get(0).getFishBreadType() + "붕어빵 " +
                    fishBread.get(0).getFishBreadCount() + "개, " +
                    fishBread.get(1).getFishBreadType() + "붕어빵 " +
                    fishBread.get(1).getFishBreadCount() + "개 여기 있습니다.\n" +
                    "기다려 주셔서 감사합니다.\n");
        } else if (fishBread.size() == 3) {
            System.out.print(
                    "아무거나 붕어빵의 시그니처 랜덤 주문입니다.\n" +
                    fishBread.get(0).getFishBreadType() + "붕어빵 " +
                    fishBread.get(0).getFishBreadCount() + "개, " +
                    fishBread.get(1).getFishBreadType() + "붕어빵 " +
                    fishBread.get(1).getFishBreadCount() + "개, " +
                    fishBread.get(2).getFishBreadType() + "붕어빵 " +
                    fishBread.get(2).getFishBreadCount() + "개 여기 있습니다.\n" +
                    "기다려 주셔서 감사합니다.\n");
        }
        return fishBread;
    }

    public int receiveCash(Order order, int amount) {
        System.out.print("붕어빵 " + order.getFishBreadCount() + "개, 주문 받았습니다." + "\n" +
                        "결제 금액 " + order.getPrice() + "원 입니다." + "\n" +
                        amount + "원 받았습니다." + "\n");
        return amount;
    }

    public int giveChange(Order order, int amount) {
        int change = amount - order.getPrice();
        if (change != 0) {
            System.out.print(order.getPrice() + "원 결제 했습니다." + "\n" +
                    "결제 후 잔액 " + change + "원 여기 있습니다." + "\n" +
                    "붕어빵 금방 드리겠습니다. 잠시만 기다려주세요." + "\n");
        } else {
            System.out.print(order.getPrice() + "원 결제 했습니다." + "\n" +
                            "붕어빵 금방 드리겠습니다. 잠시만 기다려주세요." + "\n");
        }
        return change;
    }

    public int deposit(Order order) {
        return order.getPrice();
    }

    public int withdrawPos(int salesAmount) {
        return salesAmount;
    }

    public int depositSafe(int salesAmount) {
        return salesAmount;
    }
}
