package com.tech.kj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TenantContext {
    private static final Logger log = LoggerFactory.getLogger(TenantContext.class);
    private static final ThreadLocal<String> tenantId = new ThreadLocal<>();

    public static void setTenantId(String tenant){
        log.debug("Setting the current tenant to {}",tenant);
        tenantId.set(tenant);
    }

    public static String getTenantId(){
        return tenantId.get();
    }

    public static void clear(){
        tenantId.remove();
    }
}
