package com.core.sec.security.common;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

public class FormWebAuthenticationDetails extends WebAuthenticationDetails {

    private String param1;

    public FormWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        param1 = request.getParameter("param1");
    }

    public String getParam1() {
        return param1;
    }
}
