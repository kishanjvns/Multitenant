package com.tech.kj.config;

import org.hibernate.cfg.AvailableSettings;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

@Component
public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver, HibernatePropertiesCustomizer {

    @Override
    public String resolveCurrentTenantIdentifier() {
        //PUBLIC is the default schema only available in postgres
        //If no tenant received it will fallback under PUBLIC
        return Objects.requireNonNullElse(TenantContext.getTenantId(),"PUBLIC");
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return false;
    }

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
       /* Hibernate does not allow spring to tell it to use this identifier
       * resolver to resolve tenant even this(TenantIdentifierResolver) marked
       * as @Component, and we have to tell it to spring explicitly */
        hibernateProperties.put(AvailableSettings.MULTI_TENANT_IDENTIFIER_RESOLVER,this);
    }
}
