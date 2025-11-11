package org.mulu.pcms.service;

import java.util.List;

import org.mulu.pcms.dto.request.ProjectRequestDTO;
import org.mulu.pcms.dto.response.ProjectResponseDTO;

public interface ProjectService {

    ProjectResponseDTO createProject(ProjectRequestDTO project);

    List<ProjectResponseDTO> getAllProjects();

    ProjectResponseDTO getProjectById(Long id);

    List<ProjectResponseDTO> getProjectsByCategory(Long categoryId);

    ProjectResponseDTO updateProject(Long id, ProjectRequestDTO project);

    void deleteProject(Long id);
}
