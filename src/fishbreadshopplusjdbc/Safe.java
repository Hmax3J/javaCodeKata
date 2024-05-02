package fishbreadshopplusjdbc;

public class Safe {
    private int balance;

    // 금고 구현 해야함

    public void checkBalance(Owner owner) {
        System.out.println("금고에 보관되어 있는 금액은 " + balance + "원 입니다.");
    }

    public void keepBalance(Owner owner, int salesAmount) {
        this.balance += salesAmount;
    }
}
