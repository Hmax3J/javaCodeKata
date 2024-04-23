package fishbreadshop;

public class FishBread {
    private FishBreadType fishBreadType;
    private int fishBreadCount;

    public FishBread(FishBreadType fishBreadType, int fishBreadCount) {
        this.fishBreadType = fishBreadType;
        this.fishBreadCount = fishBreadCount;
//        if (fishBreadType == FishBreadType.ANYTHING) {
//
//        } else {
//            this.fishBreadCount = fishBreadCount;
//        }
    }

    public int getFishBreadCount() {
        return fishBreadCount;
    }

    @Override
    public String toString() {
        return fishBreadType + "fishBread" +
                ", FishBreadCount : " + fishBreadCount + "EA";
    }
}
