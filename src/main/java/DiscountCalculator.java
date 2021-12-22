import java.math.BigDecimal;

public interface DiscountCalculator {
    BigDecimal calculateItemDiscount(BigDecimal price, BigDecimal totalPrice, BigDecimal discount);
}
