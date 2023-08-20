package hw.Rewards.Sapphire;

import hw.IGameItem;
import hw.ItemGenerator;

public class SapphireFabric extends ItemGenerator {
    @Override
    public IGameItem createItem() {
        return new Sapphire();
    }
}
