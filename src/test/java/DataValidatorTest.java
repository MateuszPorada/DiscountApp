import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataValidatorTest {
    private static final List<Product> productsList = new ArrayList<>() {
        {
            add(new Product("TV", new BigDecimal("3000")));
            add(new Product("Fridge", new BigDecimal("1500")));
            add(new Product("Microwave oven", new BigDecimal("400")));
            add(new Product("PC", new BigDecimal("3000")));
            add(new Product("Headphones", new BigDecimal("130")));
        }
    };
    DataValidator dataValidator = new DataValidator();

    @Test
    void shouldThrowsMaximumListSizeException() {
        productsList.add(new Product("TV", new BigDecimal("3000")));
        Exception exception = assertThrows(RuntimeException.class, () -> dataValidator.validateList(productsList));
        String expectedMessage = "Maximum product list size is 5";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void shouldNotThrowsMaximumListSizeException() {
        assertDoesNotThrow(() -> dataValidator.validateList(productsList));
    }

    @Test
    void shouldThrowMinimumListSizeException() {
        List<Product> emptyList = new ArrayList<>();
        Exception exception = assertThrows(RuntimeException.class, () -> dataValidator.validateList(emptyList));
        String expectedMessage = "Minimum product list size is 1";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void shouldNotThrowsMinimumListSizeException() {
        List<Product> list = new ArrayList<>();
        list.add(new Product("TV", new BigDecimal("3000")));
        assertDoesNotThrow(() -> dataValidator.validateList(list));
    }

    @Test
    void shouldThrowDiscountMinimalException() {
        Exception exception = assertThrows(RuntimeException.class, () -> dataValidator.validateDiscount(new BigDecimal("-1"), new BigDecimal("10")));
        String expectedMessage = "Discount must be greater or equal 0";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void shouldNotThrowDiscountException() {
        assertDoesNotThrow(() -> dataValidator.validateDiscount(new BigDecimal("0"), new BigDecimal("10")));
    }

    @Test
    void shouldThrowDiscountMoreThanPriceException() {
        Exception exception = assertThrows(RuntimeException.class, () -> dataValidator.validateDiscount(new BigDecimal("300"), new BigDecimal("20")));
        String expectedMessage = "Discount cannot be higher then total price";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void shouldNotThrowDiscountMoreThanPriceException() {
        assertDoesNotThrow(() -> dataValidator.validateDiscount(new BigDecimal("10"), new BigDecimal("10")));
    }

    @Test
    void shouldThrowItemPriceException() {
        Product product = new Product("TV", new BigDecimal("-1"));
        Exception exception = assertThrows(RuntimeException.class, () -> dataValidator.validateItem(product));
        String expectedMessage = "Price must be higher than 0";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void shouldNotThrowItemPriceException() {
        assertDoesNotThrow(() -> dataValidator.validateItem(new Product("TV", new BigDecimal("0.1"))));
    }
}