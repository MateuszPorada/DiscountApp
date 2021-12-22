import java.math.BigDecimal;

public class InvoiceProduct {
    private final String name;
    private final BigDecimal discount;
    private final BigDecimal price;

    public InvoiceProduct(String name, BigDecimal discount, BigDecimal price) {
        this.name = name;
        this.discount = discount;
        this.price = price;
    }

    @Override
    public String toString() {
        return "(" + name +
                ", Discount:" + discount +
                ", Price:" + price + ")";
    }

}
