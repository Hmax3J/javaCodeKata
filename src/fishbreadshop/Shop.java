package fishbreadshop;

public class Shop {
    int redBeanFishBreadCount;
    int chouxcreamFishBreadCount;
    int pizzaFishBreadCount;
    public Shop() {
        System.out.print("  당신은 2천원으로 행복할 수 있다." + "\n" +
                        "   어서오세요. 해피붕어빵 입니다." + "\n" +
                        "=================Menu=================" + "\n" +
                        "    1. 팥 붕어빵빵빵 : 10개 2천원" + "\n\n" +
                        "           ↓ !! Best !! ↓        " + "\n" +
                        "    2. 슈크림 붕어빵 : 10개 2천원" + "\n" +
                        "           ↑ !! Best !! ↑        " + "\n\n" +
                        "    3. 피자 붕어빵빵 : 10개 2천원" + "\n" +
                        "    4. 아무거나 빵빵 : 10개 2천원" + "\n" +
                        "======================================" + "\n" +
                        "        메뉴를 선택해주세요!     ");
    }

    public void pos(Owner owner, FishBread fishBread, int order) {
        //if (fishBread instanceof )
    }
}