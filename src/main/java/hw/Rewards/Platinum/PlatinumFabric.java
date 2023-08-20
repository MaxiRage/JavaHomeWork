package hw.Rewards.Platinum;

import hw.IGameItem;
import hw.ItemGenerator;

public class PlatinumFabric extends ItemGenerator {

    @Override
    public IGameItem createItem() {
        return new Platinum();
    }
}
