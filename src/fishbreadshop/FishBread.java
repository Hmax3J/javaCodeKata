package fishbreadshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FishBread {
    private FishBreadType fishBreadType;
    private int fishBreadCount;

    public FishBread(FishBreadType fishBreadType, int fishBreadCount) {
        this.fishBreadType = fishBreadType;
        this.fishBreadCount = fishBreadCount;
    }

    public FishBreadType getFishBreadType() {
        return fishBreadType;
    }

    public int getFishBreadCount() {
        return fishBreadCount;
    }

    public List<FishBread> randomFishBread(FishBread fishBread) {
        List<FishBread> anythingFishBread = new ArrayList<>();

        if (fishBread.getFishBreadType() == FishBreadType.ANYTHING) {
            Map<FishBreadType, Integer> anythingCountMap = new HashMap<>(); // 각 타입별 붕어빵 개수를 관리하기 위한 맵
            int totalFishBreadCount = 0;

            while (totalFishBreadCount < fishBread.getFishBreadCount()) {
                int selectRandomType = (int) (Math.random() * 3) + 1;
                int selectRandomFishBreadCount = Math.min(fishBread.getFishBreadCount() - totalFishBreadCount, (int) (Math.random() * 5) + 1);

                FishBreadType type = null;
                switch (selectRandomType) {
                    case 1:
                        type = FishBreadType.RED_BEAN;
                        break;
                    case 2:
                        type = FishBreadType.CHOUXCREAM;
                        break;
                    case 3:
                        type = FishBreadType.PIZZA;
                        break;
                }

                if (type != null) {
                    // 이미 같은 타입의 붕어빵이 리스트에 있는 경우 count를 합침
                    if (anythingCountMap.containsKey(type)) {
                        anythingCountMap.put(type, anythingCountMap.get(type) + selectRandomFishBreadCount);
                    } else {
                        anythingCountMap.put(type, selectRandomFishBreadCount);
                    }
                }

                totalFishBreadCount += selectRandomFishBreadCount;
            }

            for (Map.Entry<FishBreadType, Integer> entry : anythingCountMap.entrySet()) {
                FishBreadType type = entry.getKey();
                int count = entry.getValue();

                switch (type) {
                    case RED_BEAN:
                        anythingFishBread.add(new RedBeanFishBread(count));
                        break;
                    case CHOUXCREAM:
                        anythingFishBread.add(new ChouxCreamFishBread(count));
                        break;
                    case PIZZA:
                        anythingFishBread.add(new PizzaFishBread(count));
                        break;
                }

            }
        }
        return anythingFishBread;
    }
}
