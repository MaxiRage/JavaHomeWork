package hw.Rewards.Bronze;

import hw.IGameItem;
import hw.ItemGenerator;

public class BronzeFabric extends ItemGenerator {

    @Override
    public IGameItem createItem() {
        return new Bronze();
    }
}
