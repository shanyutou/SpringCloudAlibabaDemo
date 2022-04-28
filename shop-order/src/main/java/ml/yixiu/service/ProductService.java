package ml.yixiu.service;

import ml.yixiu.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "service-product", fallback = ProductServiceFallBack.class)
public interface ProductService {

    @RequestMapping(value = "/product/{id}")
    Product findById(@PathVariable("id") int id);

}
