import java.math.BigDecimal;
import java.util.List;

public class Invoice {
    private final List<DefaultInvoiceProduct> defaultInvoiceProductList;
    private final BigDecimal totalDiscount;
    private final BigDecimal total;

    public Invoice(List<DefaultInvoiceProduct> defaultInvoiceProductList, BigDecimal discount, BigDecimal totalPrice) {
        this.defaultInvoiceProductList = defaultInvoiceProductList;
        this.totalDiscount = discount;
        this.total = totalPrice;
    }

    @Override
    public String toString() {
        return "Products: \n" + defaultInvoiceProductList +
                "\nTotal price: " + total +
                "\nTotal discount: " + totalDiscount;
    }

}
