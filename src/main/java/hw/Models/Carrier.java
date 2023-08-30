package hw.Models;

import java.util.ArrayList;
import java.util.List;

public record Carrier(int id, long cardNumber) {

    public Carrier(int id, long cardNumber) {
        this.id = id;
        this.cardNumber = cardNumber;

        List<Integer> zones = new ArrayList<>();
        zones.add(0);
        zones.add(1);
    }

}
