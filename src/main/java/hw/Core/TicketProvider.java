package hw.Core;

import hw.Interfaces.ITicketRepo;
import hw.Models.Ticket;
import hw.Services.TicketRepository;

import java.util.List;

public class TicketProvider {

    private final ITicketRepo ticketRepo;

    public TicketProvider() {
        this.ticketRepo = TicketRepository.getTicketRepository();
    }

    public List<Ticket> getTickets(int routeNumber) throws RuntimeException {
        return ticketRepo.readAll(routeNumber);
    }

    public boolean updateTicketStatus(Ticket ticket) {
        ticket.setValid(false);
        return ticketRepo.update(ticket);
    }
}
