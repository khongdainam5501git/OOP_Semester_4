package BankProject.Clients;

import BankProject.Exceptions.ClientException;

import java.util.UUID;

public class ClientBuilder {
    private String name;
    private String address;
    private String phoneNumber;
    private String passport;

    public ClientBuilder withName(String name) {
        this.name = name;
        return this;
    }public ClientBuilder withAddress(String address) {
        this.address = address;
        return this;
    }public ClientBuilder withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }public ClientBuilder withPassport(String passport) {
        this.passport = passport;
        return this;
    }

    public Client Build(){
        if(!isValidClientInfomation()){
            throw new ClientException();
        }

        UUID clientId = UUID.randomUUID();
        return new Client(clientId, name, address, phoneNumber, passport);
    }
    private boolean isValidClientInfomation(){
        if(this.name.isEmpty() || this.address.isEmpty() || this.phoneNumber.isEmpty() || this.passport.isEmpty()){
            return false;
        }

        return true;
    }
}
