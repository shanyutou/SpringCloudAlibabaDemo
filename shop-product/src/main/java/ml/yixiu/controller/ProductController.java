package ml.yixiu.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import ml.yixiu.domain.Product;
import ml.yixiu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductController {


    @Autowired
    private ProductService productService;

    @RequestMapping("/product/{pid}")
    public Product product(@PathVariable("pid") Integer pid) {
        log.info("pid: {}", pid);
        Product product = productService.findById(pid);
        log.info("product: {}", JSON.toJSONString(product));
        return product;

    }

}
