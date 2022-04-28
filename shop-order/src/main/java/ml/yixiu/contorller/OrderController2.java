package ml.yixiu.contorller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import ml.yixiu.domain.Order;
import ml.yixiu.domain.Product;
import ml.yixiu.service.OrderService;
import ml.yixiu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Slf4j
public class OrderController2 {

    @Autowired
    private OrderService orderService;



    @Autowired
    ProductService productService;

    @RequestMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid){
        log.info("order prod id: {}", pid);
        Product product = productService.findById(pid);
        log.info("product: {}", JSON.toJSONString(product));

        try {
            Thread.sleep(3000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        Order order = new Order();
//        order.setUid(1);
        order.setUsername("测试用户");
        order.setPid(pid);
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
        orderService.create(order);
        log.info("order: {}", JSON.toJSONString(order));
        return order;
    }

    @RequestMapping("/order/message")
    public String message() {
        return "高并发下的问题测试";
    }



}
