import java.math.BigDecimal;
import java.util.List;

public class Invoice {
    private final List<InvoiceProduct> invoiceProductList;
    private final BigDecimal totalDiscount;
    private final BigDecimal total;

    public Invoice(List<InvoiceProduct> invoiceProductList, BigDecimal discount, BigDecimal totalPrice) {
        this.invoiceProductList = invoiceProductList;
        this.totalDiscount = discount;
        this.total = totalPrice;
    }

    @Override
    public String toString() {
        return "Products: \n" + invoiceProductList +
                "\nTotal price: " + total +
                "\nTotal discount: " + totalDiscount;
    }

}
