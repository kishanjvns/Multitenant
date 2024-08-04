package com.tech.kj.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TenantInterceptor implements HandlerInterceptor {
    private final Logger log = LoggerFactory.getLogger(TenantInterceptor.class);
    private final HttpHeaderTenantResolver headerTenantResolver;
    public TenantInterceptor(HttpHeaderTenantResolver headerTenantResolver){
        this.headerTenantResolver = headerTenantResolver;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle interceptor {}",request.getHeader("X-TenantId") );
        var tenantId = headerTenantResolver.resolveTenant(request);
        TenantContext.setTenantId(tenantId);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        clear();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        clear();
    }
    private void clear(){
        TenantContext.clear();
    }
}
