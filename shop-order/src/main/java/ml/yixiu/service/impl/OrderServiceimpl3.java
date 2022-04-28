package ml.yixiu.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import ml.yixiu.service.OrderService3;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceimpl3 implements OrderService3 {

    @Override
    @SentinelResource(value = "OrderService")
    public void message() {
        System.out.println("OsderServiceimpl3");
    }
}
