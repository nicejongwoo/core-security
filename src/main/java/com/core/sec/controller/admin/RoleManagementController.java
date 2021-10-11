package com.core.sec.controller.admin;

import com.core.sec.domain.dto.RoleDto;
import com.core.sec.domain.entity.Role;
import com.core.sec.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@RequestMapping("/admin/roles")
@RequiredArgsConstructor
@Controller
public class RoleManagementController {

    private final RoleService roleService;

    @GetMapping("")
    public String list(Model model) {
        List<Role> roles = roleService.getRoles();
        model.addAttribute("roles", roles);
        return "admin/role/list";
    }

    @GetMapping("/{id}")
    public String editForm(@PathVariable("id") String id, Model model) {
        RoleDto role = roleService.getRole(id);
        log.debug("role = " + role);
        model.addAttribute("role", role);
        return "admin/role/addOrEdit";
    }


}
