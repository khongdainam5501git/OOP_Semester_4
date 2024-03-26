package BankProject.Accounts;

import BankProject.Exceptions.AccountException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class DepositAccount extends Account{

    private LocalDateTime accountTerm;
    public DepositAccount(UUID accountId, UUID clientID, BigDecimal balance, BigDecimal transactionLimit, BigDecimal interestRate, BigDecimal commissionForUse, LocalDateTime accountTerm) {
        super(accountId, clientID, balance, transactionLimit, interestRate, commissionForUse);
        this.accountTerm = accountTerm;
    }

    @Override
    public void withdrawMoney(BigDecimal amount) {
        if (LocalDateTime.now().isBefore(accountTerm)) {
            throw new AccountException();
        }
        addInterest();
        super.withdrawMoney(amount);
    }

    public LocalDateTime getAccountTerm() {
        return accountTerm;
    }
}
