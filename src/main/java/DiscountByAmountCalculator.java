import java.math.BigDecimal;
import java.math.RoundingMode;

public class DiscountByAmountCalculator implements DiscountCalculator {
    public BigDecimal calculateItemDiscount(BigDecimal price, BigDecimal totalPrice, BigDecimal discount) {
        return price.divide(totalPrice, 10, RoundingMode.HALF_UP).multiply(discount);
    }
}
