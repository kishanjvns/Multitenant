package com.tech.kj;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "multitenancy.http")
public class TenantHttpProperties {
    private String tenantHeaderName;
    public void setTenantHeaderName(String tenantHeaderName){
        this.tenantHeaderName = tenantHeaderName;
    }
    public String getHeaderName() {
       return tenantHeaderName;
    }
}
