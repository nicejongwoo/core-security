package com.core.sec.controller.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class ConfigController {

    @GetMapping("/config")
    public String config() {
        return "admin/config";
    }

}
