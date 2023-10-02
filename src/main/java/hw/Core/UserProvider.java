package hw.Core;

import hw.Interfaces.IUserRepo;
import hw.Models.User;
import hw.Services.UserRepository;

import java.util.List;

public class UserProvider {
    private final IUserRepo clientRepository;

    public UserProvider() {
        this.clientRepository = UserRepository.getClientRepository();
    }

    public int createClient(String userName, int passwordHash, long cardNumber) throws RuntimeException {
        return clientRepository.create(userName, passwordHash, cardNumber);
    }

    public User getClientByName(String userName) throws RuntimeException {
        return clientRepository.read(userName);
    }

    public List<User> getAllClients() throws RuntimeException {
        return clientRepository.readAll();
    }
}
