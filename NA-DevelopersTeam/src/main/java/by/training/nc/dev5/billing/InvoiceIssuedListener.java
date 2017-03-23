package by.training.nc.dev5.billing;

/**
 * Created by Nikita on 21.03.2017.
 */
@FunctionalInterface
public interface InvoiceIssuedListener {
    void onInvoiceIssued(InvoiceIssuedArgs args);
}
