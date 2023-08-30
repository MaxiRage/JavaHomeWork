package hw.Services;

import hw.Interfaces.ICarrierRepo;
import hw.Models.Carrier;

import java.util.ArrayList;
import java.util.List;

public class CarrierRepository implements ICarrierRepo {
    private static CarrierRepository carrierRepository;
    private final List<Carrier> carriers;

    private CarrierRepository() {
        carriers = new ArrayList<>();
        carriers.add(new Carrier(1, 1));

    }

    public static CarrierRepository getCarrierRepository() {
        if (carrierRepository == null) {
            carrierRepository = new CarrierRepository();
        }
        return carrierRepository;
    }

    @Override
    public Carrier read(int id) throws RuntimeException {
        for (var carrier : carriers) {
            if (carrier.id() == id) {
                return carrier;
            }
        }
        throw new RuntimeException("Перевозчик с этим идентификатором не найден");
    }
}
