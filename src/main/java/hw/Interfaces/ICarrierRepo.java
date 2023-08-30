package hw.Interfaces;

import hw.Models.Carrier;

public interface ICarrierRepo {
    Carrier read(int id);
}
