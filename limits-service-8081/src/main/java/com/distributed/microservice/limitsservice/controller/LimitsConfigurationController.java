package com.distributed.microservice.limitsservice.controller;

import com.distributed.microservice.limitsservice.configuration.LimitsConfig;
import com.distributed.microservice.limitsservice.models.LimitsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("limits")
@RefreshScope
public class LimitsConfigurationController {

    @Autowired
    private LimitsConfig limitsConfig;

    @GetMapping("/config")
    public ResponseEntity<?> retriveLimitsFromConfigurations() {
        LimitsConfiguration limitsConfiguration = new LimitsConfiguration();
        limitsConfiguration.setMaximum(100);
        limitsConfiguration.setMinimum(10);

        return new ResponseEntity<>(limitsConfig, HttpStatus.OK);
    }

}
