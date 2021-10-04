package com.core.sec.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class UserController {

    @GetMapping("/mypage")
    public String myPage() {
        return "user/mypage";
    }

}
