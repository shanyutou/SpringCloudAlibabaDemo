package ml.yixiu.contorller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import ml.yixiu.domain.Order;
import ml.yixiu.domain.Product;
import ml.yixiu.service.OrderService;
import ml.yixiu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Autowired
//    private DiscoveryClient discoveryClient;

    @Autowired
    ProductService productService;

    @RequestMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid){
        log.info("order prod id: {}", pid);
//        Product product = restTemplate.getForObject("http://localhost:8081/product/" + pid, Product.class);
        //修改为nacos注册中心获取服务
//        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("service-product");
//        int index = (int) (Math.random() * serviceInstances.size());
//        ServiceInstance instance = serviceInstances.get(index);
////        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/product/" + pid;
//        String url = "http://" + "service-product" + "/product/" + pid;
//
//        log.info("url: {}", url);
//        Product product = restTemplate.getForObject(url, Product.class);

        Product product = productService.findById(pid);

        log.info("product: {}", JSON.toJSONString(product));

        if (product.getPid() == -1) {
            Order order = new Order();
            order.setPname("下单失败");
            return order;
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



}
