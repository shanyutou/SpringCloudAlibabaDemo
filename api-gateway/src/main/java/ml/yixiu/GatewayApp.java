package ml.yixiu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApp {
    public static void main(String[] args) {
        System.out.println("GatewayApp");
        SpringApplication.run(GatewayApp.class,args);
    }
}
