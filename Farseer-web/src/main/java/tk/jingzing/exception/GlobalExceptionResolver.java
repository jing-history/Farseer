package tk.jingzing.exception;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import tk.jingzing.dto.BaseResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Description: 错误信息统一处理
 * 对未处理的错误信息做一个统一处理
 * Created by Louis Wang on 2016/8/30.
 */

public class GlobalExceptionResolver implements HandlerExceptionResolver {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        log.error("访问" + request.getRequestURI() + " 发生错误, 错误信息:" + ex.getMessage());
        //这里有2种选择
        //跳转到定制化的错误页面
	    /*ModelAndView error = new ModelAndView("error");
		error.addObject("exMsg", ex.getMessage());
		error.addObject("exType", ex.getClass().getSimpleName().replace("\"", "'"));*/

        //返回json格式的错误信息
        try{
            PrintWriter writer = response.getWriter();
            BaseResult<String> result=new BaseResult(false, ex.getMessage());
            writer.write(JSON.toJSONString(result));
            writer.flush();
        }catch (Exception e){
            log.error("Exception",e);
        }
        return null;
    }
}
