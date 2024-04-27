package fishbreadshop;

import java.util.ArrayList;
import java.util.List;

public class Shef {

    public List<FishBread> cook(FishBreadType fishBreadType, int fishBreadCount) {
        List<FishBread> fishBread = new ArrayList<>();
        if (fishBreadType == FishBreadType.RED_BEAN) {
            fishBread.add(new RedBeanFishBread(fishBreadCount));
        } else if (fishBreadType == FishBreadType.CHOUXCREAM) {
            fishBread.add(new ChouxCreamFishBread(fishBreadCount));
        } else if (fishBreadType == FishBreadType.PIZZA) {
            fishBread.add(new PizzaFishBread(fishBreadCount));
        } else if (fishBreadType == FishBreadType.ANYTHING) {
            FishBread anythingFishBread = new AnythingFishBread(fishBreadCount);
            List<FishBread> randomAnythingFishBread = anythingFishBread.randomFishBread(anythingFishBread);
            fishBread.addAll(randomAnythingFishBread);
        }
        return fishBread;
    }

    public List<FishBread> serve(List<FishBread> fishBread) {
        return fishBread;
    }
}
