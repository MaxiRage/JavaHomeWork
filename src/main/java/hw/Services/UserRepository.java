package hw.Services;

import hw.Interfaces.IUserRepo;
import hw.Models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepo {
    private static UserRepository clientRepository;
    private final List<User> clients;

    private UserRepository() {
        clients = new ArrayList<>();
        clients.add(new User(1, "Ваня", "1111".hashCode(), 2));
        clients.add(new User(2, "Василий", "2222".hashCode(), 3));
        clients.add(new User(3, "Кирилл", "123".hashCode(), 4));
        clients.add(new User(4, "Макс", "123".hashCode(), 5));
    }

    public static UserRepository getClientRepository() {
        if (clientRepository == null) {
            clientRepository = new UserRepository();
        }
        return clientRepository;
    }

    @Override
    public int create(String userName, int passwordHash, long cardNumber) throws RuntimeException {
        int id = clients.size() + 1;
        User client = new User(id, userName, passwordHash, cardNumber);
        for (var currentClient : clients) {
            if (currentClient.id() == client.id()) {
                throw new RuntimeException("Клиент уже существует");
            }
        }
        clients.add(client);
        return client.id();
    }

    @Override
    public User read(int id) throws RuntimeException {
        for (var client : clients) {
            if (client.id() == id) {
                return client;
            }
        }
        throw new RuntimeException("Клиент с этим идентификатором не найден");
    }

    @Override
    public User read(String userName) throws RuntimeException {
        for (var client : clients) {
            var clientName = client.userName();
            if (clientName.equals(userName)) {
                return client;
            }
        }
        throw new RuntimeException("Клиент с этим идентификатором не найден");
    }

    @Override
    public List<User> readAll() throws RuntimeException {
        if (clients.isEmpty()) {
            throw new RuntimeException("Список клиентов пуст");
        }
        return clients;
    }

    @Override
    public boolean update(User client) {
        for (User currentClient : clients) {
            if (currentClient.id() == client.id()) {
                clients.remove(currentClient);
                clients.add(client);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(User client) {
        for (User currentClient : clients) {
            if (currentClient.equals(client)) {
                clients.remove(currentClient);
                return true;
            }
        }
        return false;
    }
}
