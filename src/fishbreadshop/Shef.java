package fishbreadshop;

public class Shef {
    FishBread fishBread;
    public FishBread cook(FishBreadType fishBreadType, int fishBreadCount) {
        if (fishBreadType == FishBreadType.RED_BEAN) {
            fishBread = new RedBeanFishBread(fishBreadCount);
        } else if (fishBreadType == FishBreadType.CHOUXCREAM) {
            fishBread = new ChouxCreamFishBread(fishBreadCount);
        } else if (fishBreadType == FishBreadType.PIZZA) {
            fishBread = new PizzaFishBread(fishBreadCount);
        }

        return fishBread;
    }

    public FishBread serve(FishBread fishBread) {
        return fishBread;
    }
}
