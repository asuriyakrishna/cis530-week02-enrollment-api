package edu.bellevue.cis530.week02.model;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiInfoBean {

    private static final Logger logger = LoggerFactory.getLogger(ApiInfoBean.class);

    private final String appName = "Bellevue University CIS 530";
    private final String description = "Student Enrollment REST API";

    @PostConstruct
    public void init() {
        logger.info("ApiInfoBean initialized: appName={}, description={}", appName, description);
    }

    @PreDestroy
    public void cleanup() {
        logger.info("ApiInfoBean destroyed: appName={}, description={}", appName, description);
    }

    public String getAppName() {
        return appName;
    }

    public String getDescription() {
        return description;
    }
}
