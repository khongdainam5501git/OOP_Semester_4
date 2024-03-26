package BankProject.Accounts;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author Khong Dai Nam
 * @version 1.0
 */
public interface IAccount
{
    void withdrawMoney(BigDecimal amount);

    void addMoney(BigDecimal amount);
    void transferMoney(BigDecimal amount, IAccount recipient);

    void addInterest();

    void addCommissionForUse();

    void updateInterest(int interest);

    void updateTransactionLimit(BigDecimal newTransactionLimit);
}
