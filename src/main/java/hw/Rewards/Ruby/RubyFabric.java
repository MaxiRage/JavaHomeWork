package hw.Rewards.Ruby;

import hw.IGameItem;
import hw.ItemGenerator;

public class RubyFabric extends ItemGenerator {
    @Override
    public IGameItem createItem() {
        return new Ruby();
    }
}
