package hw.Rewards.Gold;

import hw.IGameItem;
import hw.ItemGenerator;

public class GoldFabric extends ItemGenerator {
    @Override
    public IGameItem createItem() {
        return new Gold();
    }
}
