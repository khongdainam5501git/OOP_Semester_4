package BankProject.Accounts;

import BankProject.Exceptions.TransactionException;
import java.math.BigDecimal;
import java.util.UUID;
/**
 * @author Khong Dai Nam
 * @version 1.0
 */
public class CreditAccount extends Account{

    private BigDecimal creditLimit;
    private BigDecimal commissionForUse;
    public CreditAccount(UUID accountId, UUID clientID, BigDecimal balance, BigDecimal transactionLimit, BigDecimal interestRate, BigDecimal commissionForUse, BigDecimal creditLimit) {
        super(accountId, clientID, balance, transactionLimit, interestRate, commissionForUse);

        this.commissionForUse = commissionForUse;
        this.creditLimit = creditLimit;
    }

    @Override
    public void withdrawMoney(BigDecimal amount) {
        if (getBalance().subtract(amount).add(creditLimit).compareTo(BigDecimal.ZERO) < 0){
            throw new TransactionException();
        }

        super.withdrawMoney(amount);
        super.addCommissionForUse();
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getCommissionForUse() {
        return commissionForUse;
    }

    public void setCommissionForUse(BigDecimal commissionForUse) {
        this.commissionForUse = commissionForUse;
    }
}
