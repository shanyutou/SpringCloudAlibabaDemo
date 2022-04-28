package ml.yixiu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Slf4j
@EnableDiscoveryClient
@EnableFeignClients
public class OrderApp {
    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class, args);
        log.info("OrderApp start...");
    }

//    @Bean
//    @LoadBalanced//负载均衡，pring-cloud-netflix-ribbon 拦截到后查找服务列表，然后根据服务注册列表进行负载均衡
//    RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
}
