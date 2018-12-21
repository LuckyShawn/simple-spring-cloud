package com.shawn.serverzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description: TODO
 * @Author: yang.xiao
 * @Date: 2018/12/21 0021
 */
@Component
public class Myfilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(Myfilter.class);

    //   filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
    //    pre：路由之前
    //    routing：路由之时
    //    post： 路由之后
    //    error：发送错误调用
    @Override
    public String filterType() {
        return "pre";
    }

    //filterOrder：过滤的顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    //shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        Object password = request.getParameter("password");
        if(null == password){
            logger.warn("密码为空！");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(500);
            try {
                ctx.getResponse().getWriter().write("登录失败！");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        if("123456".equals(password)){
            logger.info("登录成功！");
            return "登录成功";
        }else{
            logger.info("密码错误！");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(500);
            try {
                ctx.getResponse().getWriter().write("登录失败！");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
