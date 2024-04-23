package fishbreadshop;

public class Order {
    private int menuChoice;
    private int fishBreadCount;

    public Order(int menuChoice, int fishBreadCount) {
        this.menuChoice = menuChoice;
        this.fishBreadCount = fishBreadCount;
    }

    public int getMenuChoice() {
        return menuChoice;
    }

    public int getFishBreadCount() {
        return fishBreadCount * 10;
    }
}
