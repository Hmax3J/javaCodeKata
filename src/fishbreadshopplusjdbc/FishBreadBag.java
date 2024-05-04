package fishbreadshopplusjdbc;

import java.util.List;

public class FishBreadBag {
    List<FishBread> fishBread;

    public FishBreadBag(List<FishBread> fishBread) {
        this.fishBread = fishBread;
    }

    public List<FishBread> getFishBread() {
        return fishBread;
    }
}
