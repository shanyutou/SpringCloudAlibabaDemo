package ml.yixiu.service;

import ml.yixiu.domain.Product;
import org.springframework.stereotype.Service;


public interface ProductService {
    Product findById(Integer pid);
}
