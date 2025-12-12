package org.mulu.pcms.mapper;

import java.time.LocalDate;

import org.mulu.pcms.dto.request.ProjectRequestDTO;
import org.mulu.pcms.dto.response.ProjectResponseDTO;
import org.mulu.pcms.entity.Category;
import org.mulu.pcms.entity.Project;
import org.mulu.pcms.entity.User;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    public Project toEntity(ProjectRequestDTO project, Category category, User user) {
        if (project == null) {
            return null;
        }

        Project entity = new Project();
        entity.setTitle(project.getTitle());
        entity.setDescription(project.getDescription());
        entity.setImageUrl(project.getImageUrl());
        entity.setGithubLink(project.getGithubLink());
        entity.setDemoLink(project.getDemoLink());
        entity.setDateCreated(LocalDate.now());
        entity.setCategory(category);
        entity.setUser(user);

        return entity;
    }

    public ProjectResponseDTO toResponseDTO(Project savedProject) {
        if (savedProject == null) {
            return null;
        }

        ProjectResponseDTO responseDTO = new ProjectResponseDTO();
        responseDTO.setId(savedProject.getId());
        responseDTO.setTitle(savedProject.getTitle());
        responseDTO.setDescription(savedProject.getDescription());
        responseDTO.setImageUrl(savedProject.getImageUrl());
        responseDTO.setGithubLink(savedProject.getGithubLink());
        responseDTO.setDemoLink(savedProject.getDemoLink());
        responseDTO.setUser(savedProject.getUser().getEmail());

        return responseDTO;
    }

    public Project updateEntity(Project existingProject, ProjectRequestDTO project) {
        if (existingProject == null || project == null) {
            return existingProject;
        }

        existingProject.setTitle(project.getTitle());
        existingProject.setDescription(project.getDescription());
        existingProject.setImageUrl(project.getImageUrl());
        existingProject.setGithubLink(project.getGithubLink());
        existingProject.setDemoLink(project.getDemoLink());
        existingProject.setDateCreated(LocalDate.now());
        existingProject.setDateUpdated(LocalDate.now());

        return existingProject;
    }
    
}
