package hw.Rewards.Silver;

import hw.IGameItem;
import hw.ItemGenerator;

public class SilverFabric extends ItemGenerator {
    @Override
    public IGameItem createItem() {
        return new Silver();
    }
}
