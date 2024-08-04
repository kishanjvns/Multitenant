package com.tech.kj.controller;

import com.tech.kj.config.TenantContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tenant")
public class TenantController {
    @GetMapping
    String getTenant(){
        System.out.println("test "+ TenantContext.getTenantId());
        return TenantContext.getTenantId();
    }
}