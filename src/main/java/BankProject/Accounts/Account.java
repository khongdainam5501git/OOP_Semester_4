package BankProject.Accounts;

import BankProject.Exceptions.AccountException;
import BankProject.Exceptions.TransactionException;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;
/**
 * @author Khong Dai Nam
 * @version 1.0
 */
public abstract class Account implements IAccount
{
    /* UUID - Globally Unique Identifier */
    private final UUID accountId;
    private UUID clientID;
    private BigDecimal balance;
    private BigDecimal transactionLimit;
    private BigDecimal interestRate;
    private BigDecimal commissionForUse;

    public Account(UUID accountId, UUID clientID, BigDecimal balance, BigDecimal transactionLimit, BigDecimal interestRate, BigDecimal commissionForUse)
    {
            this.accountId = accountId;
            this.clientID = clientID;
            this.balance = balance;
            this.transactionLimit = transactionLimit;
            this.interestRate = interestRate;
            this.commissionForUse = commissionForUse;
    }

    @Override
    public void withdrawMoney(BigDecimal amount)
    {
        /* return to -1 if amount < 0 */
        if (amount.compareTo(BigDecimal.ZERO) < 0 && Objects.isNull(amount)) {
            throw new TransactionException();
        }
        balance = balance.subtract(amount);
    }

    @Override
    public void addMoney(BigDecimal amount)
    {
        /* return to -1 if amount < 0 */
        if (amount.compareTo(BigDecimal.ZERO) < 0 && Objects.isNull(amount)){
            throw new TransactionException();
        }
        balance = balance.add(amount);
    }

    @Override
    public void transferMoney(BigDecimal amount, IAccount recipient) {
        if (amount.compareTo(BigDecimal.ZERO) < 0 && Objects.isNull(amount)){
            throw new TransactionException();
        }

        if (Objects.isNull(recipient)){
            throw new AccountException();
        }

        withdrawMoney(amount);
        recipient.addMoney(amount);
    }

    @Override
    public void addInterest() {
        addMoney(balance.multiply(interestRate));
    }

    @Override
    public void updateInterest(int interest) {

    }

    @Override
    public void updateTransactionLimit(BigDecimal newTransactionLimit) {
        if (newTransactionLimit.compareTo(BigDecimal.ZERO) < 0 && Objects.isNull(newTransactionLimit)){
            throw new TransactionException();
        }

        this.transactionLimit = newTransactionLimit;
    }

    @Override
    public void addCommissionForUse() {
        if (balance.compareTo(BigDecimal.ZERO) < 0){
            withdrawMoney(commissionForUse);
        }
    }

    /**
     * all about getter & setter of fields
     */
    public UUID getAccountID() {
        return accountId;
    }

    public UUID getClientID() {
        return clientID;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getTransactionLimit() {
        return transactionLimit;
    }

    public void setTransactionLimit(BigDecimal transactionLimit) {
        this.transactionLimit = transactionLimit;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getCommission() {
        return commissionForUse;
    }

    public void setCommission(BigDecimal commissionForUse) {
        this.commissionForUse = commissionForUse;
    }
}
