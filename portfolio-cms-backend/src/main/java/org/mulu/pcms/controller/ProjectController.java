package org.mulu.pcms.controller;

import java.util.List;

import org.mulu.pcms.dto.request.ProjectRequestDTO;
import org.mulu.pcms.dto.response.ProjectResponseDTO;
import org.mulu.pcms.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/create")
    public ResponseEntity<ProjectResponseDTO> createProject(@RequestBody ProjectRequestDTO project) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedInEmail = authentication.getName();
        return ResponseEntity.ok(projectService.createProject(project, loggedInEmail));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProjectResponseDTO>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProjectResponseDTO> getProjectById(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.getProjectById(id));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProjectResponseDTO>> getProjectsByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(projectService.getProjectsByCategory(categoryId));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ProjectResponseDTO> updateProject(@PathVariable Long id,
            @RequestBody ProjectRequestDTO project) {
        return ResponseEntity.ok(projectService.updateProject(id, project));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}
