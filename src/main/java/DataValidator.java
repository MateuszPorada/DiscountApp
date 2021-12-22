import java.math.BigDecimal;
import java.util.List;

public class DataValidator implements InvoiceDataValidator {
    public void validate(List<Product> productList, BigDecimal discount, BigDecimal totalPrice) {
        validateList(productList);
        validateDiscount(discount, totalPrice);
    }

    void validateDiscount(BigDecimal discount, BigDecimal totalPrice) {
        if (discount.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Discount must be greater or equal 0");
        } else if (discount.compareTo(totalPrice) > 0) {
            throw new RuntimeException("Discount cannot be higher then total price");
        }
    }

    void validateList(List<Product> productList) {
        if (productList.size() > 5) {
            throw new RuntimeException("Maximum product list size is 5");
        } else if (productList.size() < 1) {
            throw new RuntimeException("Minimum product list size is 1");
        }
        productList.forEach(this::validateItem);
    }

    void validateItem(Product product) {
        if (!(product.getPrice().compareTo(BigDecimal.ZERO) > 0)) {
            throw new RuntimeException("Price must be higher than 0");
        }
    }
}
