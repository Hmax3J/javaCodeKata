package fishbreadshop;

public class Safe {
    private int balance;

    public int store(int amount, Owner owner) {
        this.balance += amount;
        return balance;
    }
}
