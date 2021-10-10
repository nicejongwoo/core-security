package com.core.sec.controller.admin;

import com.core.sec.domain.dto.AccountDto;
import com.core.sec.domain.entity.Account;
import com.core.sec.domain.entity.Role;
import com.core.sec.service.RoleService;
import com.core.sec.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@RequestMapping("/admin")
@RequiredArgsConstructor
@Controller
public class UserManagementController {

    private final UserService userService;
    private final RoleService roleService;

    @GetMapping("/users")
    public String list(Model model) {
        List<Account> users = userService.getUsers();
        model.addAttribute("users", users);
        return "admin/user/list";
    }

    @GetMapping("/users/{username}")
    public String detail(@PathVariable("username") String username, Model model) {
        AccountDto user = userService.getUser(username);
        List<Role> roles = roleService.getRoles();

        log.debug("roles = " + roles);
        log.debug("user = " + user);

        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return "admin/user/detail";
    }

}
