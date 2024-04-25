package fishbreadshop;

public class Order {
    private int menuChoice;
    private int fishBreadCount;
    private int price;

    public Order(int menuChoice, int fishBreadCount) {
        this.menuChoice = menuChoice;
        this.fishBreadCount = fishBreadCount * 10;
        this.price = fishBreadCount * 2000;
    }

    public int getMenuChoice() {
        return menuChoice;
    }

    public int getFishBreadCount() {
        return fishBreadCount;
    }

    public int getPrice() {
        return price;
    }

    public void setMenuChoice(int menuChoice) {
        this.menuChoice = menuChoice;
    }

    public void setFishBreadCount(int fishBreadCount) {
        this.fishBreadCount = fishBreadCount * 10;
    }

    public void setPrice(int fishBreadCount) {
        this.price = fishBreadCount * 200;
    }
}
