package fishbreadshop;

public class Owner {
    private FishBread serve(FishBread fishBread) {
        return fishBread;
    }

    private int deposit(Safe safe, int amount) {
        int result = safe.store(amount, this);
        return result;
    }

    private int withdraw(Safe safe, int amount) {
        int result = safe.store(amount, this) - amount;
        return result;
    }
}
