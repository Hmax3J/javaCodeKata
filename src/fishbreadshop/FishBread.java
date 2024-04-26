package fishbreadshop;

import java.util.HashMap;
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

    public Map<FishBreadType, Integer> randomFishBread(FishBread fishBread) {
        Map<FishBreadType, Integer> anythingFishBread = new HashMap<>();
        return anythingFishBread;
    }

    @Override
    public String toString() {
        return fishBreadType + "fishBread : " + fishBreadCount + "EA";
    }
}
