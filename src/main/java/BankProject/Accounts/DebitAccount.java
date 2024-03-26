package BankProject.Accounts;

import BankProject.Exceptions.TransactionException;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author Khong Dai Nam
 * @version 1.0
 */

public class DebitAccount extends Account {
    public DebitAccount(UUID accountId, UUID clientID, BigDecimal balance, BigDecimal transactionLimit, BigDecimal interestRate, BigDecimal commissionForUse) {
        super(accountId, clientID, balance, transactionLimit, interestRate, commissionForUse);
    }

    @Override
    public void withdrawMoney(BigDecimal amount) {
        if (getBalance().subtract(amount).compareTo(BigDecimal.ZERO) < 0) {
            throw new TransactionException();
        }
        super.withdrawMoney(amount);

        addInterest();
    }
}
