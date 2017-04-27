package by.training.nc.dev5.utils;

import by.training.nc.dev5.logger.TestingSystemLogger;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

public class TransactionUtil {
    private static final String TRANSACTION_ROLLBACK_FAILED = "Error while rollback transaction: ";

    private TransactionUtil() {
    }

    public static void rollback(Transaction transaction) {
        if (transaction != null) {
            try {
                transaction.rollback();
            } catch (HibernateException e) {
                TestingSystemLogger.INSTANCE.logError(TransactionUtil.class, TRANSACTION_ROLLBACK_FAILED);
            }
        }
    }
}
