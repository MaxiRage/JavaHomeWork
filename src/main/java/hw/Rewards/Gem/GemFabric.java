package hw.Rewards.Gem;

import hw.IGameItem;
import hw.ItemGenerator;

public class GemFabric extends ItemGenerator {
    @Override
    public IGameItem createItem() {
        return new Gem();
    }
}
