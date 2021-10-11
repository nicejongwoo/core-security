package com.core.sec.controller.admin;

import com.core.sec.domain.dto.ResourceDto;
import com.core.sec.domain.entity.Resource;
import com.core.sec.domain.entity.Role;
import com.core.sec.service.ResourceService;
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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@RequestMapping("/admin/resources")
@RequiredArgsConstructor
@Controller
public class ResourceManagementController {

    private final ResourceService resourceService;
    private final RoleService roleService;

    @GetMapping("")
    public String list(Model model) {
        List<Resource> resources = resourceService.getResources();
        model.addAttribute("resources", resources);
        return "admin/resource/list";
    }

    @GetMapping("/{id}")
    public String editForm(@PathVariable("id") String id, Model model) {
        ResourceDto resourceDto = resourceService.getResource(id);
        log.debug("resourceDto = " + resourceDto);

        List<Role> roles = roleService.getRoles();

        model.addAttribute("roles", roles);
        model.addAttribute("resource", resourceDto);
        return "admin/resource/addOrEdit";
    }

    @PostMapping("/{id}/edit")
    public String edit(@PathVariable("id") String id, ResourceDto resourceDto, RedirectAttributes redirectAttributes) {
        resourceDto.setId(id);
        resourceService.updateResource(resourceDto);
        redirectAttributes.addFlashAttribute("message", "수정을 완료했습니다.");
        return "redirect:/admin/resources";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        ResourceDto resourceDto = new ResourceDto();
        List<Role> roles = roleService.getRoles();
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(new Role());
        resourceDto.setRoleSet(roleSet);

        model.addAttribute("roles", roles);
        model.addAttribute("resource", resourceDto);
        return "admin/resource/addOrEdit";
    }

    @PostMapping("/add")
    public String add(ResourceDto resourceDto, RedirectAttributes redirectAttributes) {
        resourceService.createResource(resourceDto);
        redirectAttributes.addFlashAttribute("message", "등록을 완료했습니다.");
        return "redirect:/admin/resources";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        String message = "리소스를 삭제했습니다.";
        resourceService.deleteResource(id);
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/admin/resources";
    }

}
