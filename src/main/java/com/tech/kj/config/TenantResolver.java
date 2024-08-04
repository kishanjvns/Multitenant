package com.tech.kj.config;

import org.springframework.lang.NonNull;

public interface TenantResolver <T>{
    String resolveTenant(@NonNull T object);
}
