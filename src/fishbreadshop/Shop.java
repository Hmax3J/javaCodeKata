package fishbreadshop;

public class Shop {
    private int redBeanFishBreadCount;
    private int chouxcreamFishBreadCount;
    private int pizzaFishBreadCount;
    private int posAmount = 100000;

    public void menu() {
        System.out.print("  당신은 2천원으로 행복할 수 있다." + "\n" +
                "   어서오세요. 해피붕어빵 입니다." + "\n" +
                "=================Menu=================" + "\n" +
                "    1. 팥 붕어빵빵빵 : 10개 2천원" + "\n\n" +
                "           ↓ !! Best !! ↓        " + "\n" +
                "    2. 슈크림 붕어빵 : 10개 2천원" + "\n" +
                "           ↑ !! Best !! ↑        " + "\n\n" +
                "    3. 피자 붕어빵빵 : 10개 2천원" + "\n" +
                "    4. 아무거나 빵빵 : 10개 2천원" + "\n" +
                "======================================" + "\n");
    }

    public void pos(Order order, int deposit) {
        if (order.getMenuChoice() == 1) {
            redBeanFishBreadCount += order.getFishBreadCount();
        } else if (order.getMenuChoice() == 2) {
            chouxcreamFishBreadCount += order.getFishBreadCount();
        } else if (order.getMenuChoice() == 3) {
            pizzaFishBreadCount += order.getFishBreadCount();
        }
        this.posAmount += deposit;
    }

    public void posAmount(Owner owner) {
        System.out.println("POS에 보관되어 있는 금액 : " + this.posAmount + "원");
    }

    public void salesStatus(Owner owner) {
        System.out.print("팥 붕어빵빵빵 : " + redBeanFishBreadCount + "\n" +
                         "슈크림 붕어빵 : " + chouxcreamFishBreadCount + "\n" +
                         "피자 붕어빵빵 : " + pizzaFishBreadCount + "\n" +
                         "매출 금액 : " +
                                        (redBeanFishBreadCount +
                                            chouxcreamFishBreadCount +
                                            pizzaFishBreadCount) * 200 + "원" + "\n");
    }
}
