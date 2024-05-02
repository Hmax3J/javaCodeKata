package fishbreadshopplusjdbc;

import java.util.List;

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

    public void pos(Owner owner, List<FishBread> fishBread, int deposit) {
        for (FishBread fishBreadAll : fishBread) {
            switch (fishBreadAll.getFishBreadType()) {
                case RED_BEAN:
                    redBeanFishBreadCount += fishBreadAll.getFishBreadCount();
                    break;
                case CHOUXCREAM:
                    chouxcreamFishBreadCount += fishBreadAll.getFishBreadCount();
                    break;
                case PIZZA:
                    pizzaFishBreadCount += fishBreadAll.getFishBreadCount();
                    break;
                default:
                    break;
            }
        }
        this.posAmount += deposit;
    }

    public void posAmount(Owner owner, int salesAmount) {
        if (salesAmount == 0) {
            System.out.println("POS에 보관되어 있는 금액 : " + this.posAmount + "원");
        } else {
            System.out.println("POS에 보관되어 있는 금액 : " + (this.posAmount - salesAmount) + "원");
        }

    }

    public int salesAmount(Owner owner) {
        return this.posAmount - 100000;
    }

    public void salesStatus(Owner owner) {
        System.out.print("   ↓        매출 현황        ↓   \n" +
                         "=================================\n" +
                         "        팥 붕어빵빵빵 : " + redBeanFishBreadCount + "\n" +
                         "        슈크림 붕어빵 : " + chouxcreamFishBreadCount + "\n" +
                         "        피자 붕어빵빵 : " + pizzaFishBreadCount + "\n" +
                         "        매출 금액 : " +
                                        (redBeanFishBreadCount +
                                         chouxcreamFishBreadCount +
                                         pizzaFishBreadCount) * 200 + "원\n" +
                         "=================================\n");
    }
}
