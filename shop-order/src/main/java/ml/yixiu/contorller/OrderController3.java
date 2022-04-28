package ml.yixiu.contorller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import ml.yixiu.service.OrderService3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController3 {

    @Autowired
    OrderService3 orderService3;

    int i = 0;

    @RequestMapping("/order/message1")
    public String message1() {
        orderService3.message();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "message1";
    }
    @RequestMapping("/order/message2")
    public String message2() {
//        orderService3.message();

        i++;
        if (i % 3 == 0) {
            throw new RuntimeException();
        }
        return "message2";
    }

    @RequestMapping("/order/message3")
    @SentinelResource(value = "message3", blockHandler = "handleExceptionHandler", fallback = "fallback")
    public String message3() {
        i++;
        if (i % 3 == 0) {
            throw new RuntimeException();
        }
        return "message3";
    }

    public String handleExceptionHandler(BlockException exception) {
        return "接口被限流或者降级了...";
    }

    public String fallback(Throwable throwable) {
        log.error("{}", throwable);
        return "接口发生异常了...";
    }

}
