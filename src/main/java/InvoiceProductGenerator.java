import java.math.BigDecimal;
import java.math.RoundingMode;

public class InvoiceProductGenerator {
    private final DiscountCalculator discountCalculator;

    public InvoiceProductGenerator() {
        this.discountCalculator = new DiscountCalculator();
    }

    public InvoiceProduct generate(Product product, BigDecimal totalPrice, BigDecimal discount) {
        return new InvoiceProduct(product.getName(), discountCalculator.calculateItemDiscount(product.getPrice(), totalPrice, discount).setScale(2, RoundingMode.HALF_UP), product.getPrice());
    }
}
