package ml.yixiu.predicates;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
public class AgeRoutePredicateFactory extends AbstractRoutePredicateFactory<AgeRoutePredicateFactory.Config> {


    public AgeRoutePredicateFactory() {
        super(AgeRoutePredicateFactory.Config.class);
    }

    //用于从配置文件读取到配置类中
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("minAge", "maxAge");
    }


    //断言
    @Override
    public Predicate<ServerWebExchange> apply(AgeRoutePredicateFactory.Config config) {
        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                String ageStr = serverWebExchange.getRequest().getQueryParams().getFirst("age");
                if (StringUtils.isNotEmpty(ageStr)) {
                    int age = Integer.parseInt(ageStr);
                    return  age > config.getMinAge() && age < config.getMaxAge();
                }
                return true;
            }
        };
    }

    @Data
    static class Config {
        private int minAge;
        private int maxAge;

    }
}
