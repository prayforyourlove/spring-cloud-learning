package com.itmuch.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * 博客地址可参考: https://medium.com/netflix-techblog/announcing-zuul-edge-service-in-the-cloud-ab3af5be08ee
 */
@Slf4j
public class PreZuulFilter   extends ZuulFilter {

    /**
     * 过滤器类型
     * PRE 在请求被路由之前调用  例 实现身份验证,记录调试信息  在集群中选择请求的微服务
     * ROUTING  将请求路由到微服务   用于构建发送给微服务的请求,使用Apache HttpClient 或 netfix ribbon的请求微服务
     * POST   在路由到微服务之后执行   用于为响应添加标准的http header  收集信息 和指标  将响应从微服务发送给客户端
     * ERROR 在其他阶段发生错误执行该过滤器
     * 其他定制过滤器 有 STATIC  直接在Zuul 中生成响应 而不将请求转发给后端微服务
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 执行的顺序  数值越大 越靠后
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否执行该过滤器
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 拦截执行的方法
     * @return
     */
    @Override
    public Object run() {
        HttpServletRequest httpServletRequest = RequestContext.getCurrentContext().getRequest();
        String remoteHost = httpServletRequest.getRemoteHost();
        log.info("remoteHost: {}",remoteHost);
        return null;
    }
}
