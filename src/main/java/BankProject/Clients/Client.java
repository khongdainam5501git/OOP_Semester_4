package BankProject.Clients;

import BankProject.Observer.IObserver;

import java.util.Objects;
import java.util.UUID;

public class Client implements IObserver {
    private final UUID clientId;
    private String name;
    private String address;
    private String phoneNumber;
    private String passport;

    public Client(UUID clientId, String name, String address, String phoneNumber, String passport) {

        this.clientId = clientId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this. passport = passport;
    }

    public boolean isClientAuthentic() {
        return Objects.requireNonNullElse(address, "").isEmpty() || passport.isEmpty();
    }

    /**
     * all about getter & setter of fields
     */
    public UUID getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void Update() {
    }
}
