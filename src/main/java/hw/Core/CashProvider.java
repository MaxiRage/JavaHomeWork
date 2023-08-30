package hw.Core;

import hw.Interfaces.ICarrierRepo;
import hw.Interfaces.ICashRepo;
import hw.Models.Carrier;
import hw.Models.Ticket;
import hw.Models.User;
import hw.Services.CarrierRepository;
import hw.Services.CashRepository;

public class CashProvider {

    private long cardNumber;
    private boolean isAuthorized = false;
    private final ICarrierRepo carrierRepository;
    private final ICashRepo cashRepository;

    public CashProvider() {
        this.carrierRepository = CarrierRepository.getCarrierRepository();
        this.cashRepository = CashRepository.getCashRepository();
    }

    public boolean buy(Ticket ticket) {
        if (isAuthorized) {
            Carrier carrier = carrierRepository.read(1);
            return cashRepository.transaction(ticket.getPrice(), cardNumber, carrier.cardNumber());
        }
        return false;
    }

    public void authorization(User client) {
        cardNumber = client.cardNumber();
        isAuthorized = true;
    }

}
