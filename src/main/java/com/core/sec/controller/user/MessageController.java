package com.core.sec.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class MessageController {

    @GetMapping("/messages")
    public String messages() {
        return "user/messages";
    }

}
