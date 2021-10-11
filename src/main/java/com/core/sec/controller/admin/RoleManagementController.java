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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("/{id}/edit")
    public String edit(@PathVariable("id") String id, RoleDto roleDto, RedirectAttributes redirectAttributes) {
        roleDto.setId(Long.valueOf(id));
        roleService.updateRole(roleDto);
        redirectAttributes.addFlashAttribute("message", "수정을 완료했습니다.");
        return "redirect:/admin/roles";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("role", new RoleDto());
        return "admin/role/addOrEdit";
    }

    @PostMapping("/add")
    public String add(RoleDto roleDto, RedirectAttributes redirectAttributes) {
        roleService.createRole(roleDto);
        redirectAttributes.addFlashAttribute("message", "등록을 완료했습니다.");
        return "redirect:/admin/roles";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        String message = "권한을 삭제했습니다.";
        try {
            roleService.deleteRole(id);
        } catch (IllegalStateException ise) {
            message = ise.getMessage();
            log.error(String.format("권한 삭제 에러: %s", ise.getMessage()));
        } finally {
            redirectAttributes.addFlashAttribute("message", message);
        }
        return "redirect:/admin/roles";
    }

}
