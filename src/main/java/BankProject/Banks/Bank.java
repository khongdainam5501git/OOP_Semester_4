package BankProject.Banks;

import BankProject.Accounts.IAccount;
import BankProject.Clients.Client;
import BankProject.Observer.EventManager;

import java.math.BigDecimal;
import java.util.*;

public class Bank
{
    public String Name;
    private BigDecimal creditLimit;
    private BigDecimal interestRate;
    private BigDecimal minInterestRate;
    private BigDecimal midInterestRate;
    private BigDecimal maxInterestRate;
    private BigDecimal commission;
    private BigDecimal transactionLimit;
    private Map<UUID, IAccount> accounts; // stores key-value pairs
    private List<Client> clients;
    private EventManager eventManager;

    public Bank(String name, BigDecimal creditLimit, BigDecimal interestRate, BigDecimal minInterestRate, BigDecimal midInterestRate, BigDecimal maxInterestRate, BigDecimal commission, BigDecimal transactionLimit, Map<UUID, IAccount> accounts, List<Client> clients, EventManager eventManager){
        Name = name;
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
        this.minInterestRate = minInterestRate;
        this.midInterestRate = midInterestRate;
        this.maxInterestRate = maxInterestRate;
        this.commission = commission;
        this.transactionLimit = transactionLimit;
        this.accounts = new HashMap<>();
        this.clients = new ArrayList<>();
        this.eventManager = eventManager;
    }


}
