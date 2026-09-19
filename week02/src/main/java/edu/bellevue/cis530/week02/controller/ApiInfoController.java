package edu.bellevue.cis530.week02.controller;

import edu.bellevue.cis530.week02.model.ApiInfoBean;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiInfoController {

    private final ObjectProvider<ApiInfoBean> apiInfoBeanProvider;

    public ApiInfoController(ObjectProvider<ApiInfoBean> apiInfoBeanProvider) {
        this.apiInfoBeanProvider = apiInfoBeanProvider;
    }

    @GetMapping("/info")
    public ApiInfoBean getInfo() {
        return apiInfoBeanProvider.getObject();
    }
}
