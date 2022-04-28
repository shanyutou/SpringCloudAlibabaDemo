package ml.yixiu.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.RequestOriginParser;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

//@Component
public class RequestOriginParserDefinition implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        String serviceName = httpServletRequest.getParameter("serviceName");
        if (serviceName == null) {
            throw new IllegalArgumentException("serviceName is not allowed null.");
        }
        return serviceName;
    }
}
