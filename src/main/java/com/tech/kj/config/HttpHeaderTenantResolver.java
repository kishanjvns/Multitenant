package com.tech.kj.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class HttpHeaderTenantResolver implements TenantResolver<HttpServletRequest>{
    private final  TenantHttpProperties tenantHttpProperties;
    public HttpHeaderTenantResolver(TenantHttpProperties tenantHttpProperties){
        this.tenantHttpProperties = tenantHttpProperties;
    }
    @Override
    public String resolveTenant(HttpServletRequest object) {
        return object.getHeader(tenantHttpProperties.getHeaderName());
    }
}
