package ml.yixiu.service;

import lombok.extern.slf4j.Slf4j;
import ml.yixiu.domain.Product;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductServiceFallBack implements ProductService {
    @Override
    public Product findById(int id) {
        Product product = new Product();
        product.setPid(-1);
        return product;
    }
}
