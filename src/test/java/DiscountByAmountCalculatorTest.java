import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscountByAmountCalculatorTest {
    private final DiscountByAmountCalculator discountCalculator = new DiscountByAmountCalculator();

    @Test
    void calculateItemDiscount() {
        assertEquals(discountCalculator.calculateItemDiscount(
                        new BigDecimal(1500), new BigDecimal(2000), new BigDecimal(100)
                )
                .setScale(2, RoundingMode.UP), new BigDecimal("75.00"));
    }

}