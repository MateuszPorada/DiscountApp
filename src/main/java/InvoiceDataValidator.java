import java.math.BigDecimal;
import java.util.List;

public interface InvoiceDataValidator {
    void validate(List<Product> productList, BigDecimal discount, BigDecimal totalPrice);
}
