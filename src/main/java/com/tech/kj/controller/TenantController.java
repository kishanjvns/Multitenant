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
    @GetMapping("/system-info")
    public Map<String, String> getSystemInfo() throws UnknownHostException {
        Map<String, String> systemInfo = new HashMap<>();

        InetAddress localHost = InetAddress.getLocalHost();
        String ipAddress = localHost.getHostAddress();
        String hostName = localHost.getHostName();

        systemInfo.put("IP Address", ipAddress);
        systemInfo.put("Host Name", hostName);
        systemInfo.put("Canonical Host Name", localHost.getCanonicalHostName());
        systemInfo.put("Operating System", System.getProperty("os.name"));
        systemInfo.put("OS Version", System.getProperty("os.version"));
        systemInfo.put("OS Architecture", System.getProperty("os.arch"));
        systemInfo.put("User", System.getProperty("user.name"));

        return systemInfo;
    }
}
