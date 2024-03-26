package BankProject.Observer;

import BankProject.Clients.Client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    Map<String, List<Client>> subscribers = new HashMap<>();

    public void Subscribe(String event, Client client) {
        subscribers.get(event).add(client);
    }

    public void Notify(String event) {
        subscribers.get(event).forEach(Client::Update);
    }
}