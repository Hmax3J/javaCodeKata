package fishbreadshop;

public class Owner {
    FishBreadType fishBreadType;

    public void greetCustomer() {
        System.out.println("        메뉴를 선택해주세요 !");
    }

    public FishBreadType orderDelivery(Order type) {
        if (type.getMenuChoice() == 1) {
            fishBreadType = FishBreadType.RED_BEAN;
        } else if (type.getMenuChoice() == 2) {
            fishBreadType = FishBreadType.CHOUXCREAM;
        } else if (type.getMenuChoice() == 3) {
            fishBreadType = FishBreadType.PIZZA;
        }

        return fishBreadType;
    }

    public int takeOrder(Order fishBreadCount) {
        return fishBreadCount.getFishBreadCount();
    }

    public FishBread receive(FishBread fishBread) {
        return fishBread;
    }

    public FishBread serve(FishBread fishBread) {
        return fishBread;
    }

    public int getCash(int amount) {
        return amount;
    }

    public int giveChange(Order order, int amount) {
        return amount - order.getPrice();
    }

    public int deposit(Order order) {
        return order.getPrice();
    }
}
