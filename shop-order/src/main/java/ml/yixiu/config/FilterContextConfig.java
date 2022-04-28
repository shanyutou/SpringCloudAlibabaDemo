package ml.yixiu.config;

import com.alibaba.csp.sentinel.adapter.servlet.CommonFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonFilter {
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new CommonFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        // 入口资源关闭聚合
        filterRegistrationBean.addInitParameter(CommonFilter.WEB_CONTEXT_UNIFY, "false");
        filterRegistrationBean.setName("sentinelFilter");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
}
