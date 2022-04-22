package ml.yixiu.service.impl;

import ml.yixiu.dao.ProductDao;
import ml.yixiu.domain.Product;
import ml.yixiu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceimpl implements ProductService {
    @Autowired
    private ProductDao productDao;


    public Product findById(Integer pid) {
        Optional<Product> product = productDao.findById(pid);
        return product.isPresent() ? product.get() : null;
    }
}
