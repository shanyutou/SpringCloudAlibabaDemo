package ml.yixiu.config;

import com.alibaba.cloud.sentinel.SentinelProperties;
import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ExceptionHandlerPage implements UrlBlockHandler {
    @Override
    public void blocked(HttpServletRequest httpServletRequest,
                        HttpServletResponse httpServletResponse,
                        BlockException e) throws IOException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        ResponseData responseData = null;
        if (e instanceof FlowException) {
            responseData = new ResponseData(-1, "接口限流");
        }else if (e instanceof DegradeException) {
            responseData = new ResponseData(-1, "接口降级");
        }else {
            responseData = new ResponseData(-1, "其它限制");
        }
        httpServletResponse.getWriter().write(JSON.toJSONString(responseData));

    }
}


@Data
@AllArgsConstructor
@NoArgsConstructor
class ResponseData {
    private int code;
    private String msg;
}