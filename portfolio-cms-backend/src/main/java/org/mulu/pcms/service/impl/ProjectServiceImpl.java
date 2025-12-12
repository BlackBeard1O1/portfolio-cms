package org.mulu.pcms.service.impl;

import java.util.List;

import org.mulu.pcms.dto.request.ProjectRequestDTO;
import org.mulu.pcms.dto.response.ProjectResponseDTO;
import org.mulu.pcms.entity.Category;
import org.mulu.pcms.entity.Project;
import org.mulu.pcms.entity.User;
import org.mulu.pcms.mapper.ProjectMapper;
import org.mulu.pcms.repository.CategoryRepository;
import org.mulu.pcms.repository.ProjectRepository;
import org.mulu.pcms.repository.UserRepository;
import org.mulu.pcms.service.ProjectService;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper,
            CategoryRepository categoryRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;

    }

    @Override
    public ProjectResponseDTO createProject(ProjectRequestDTO project, String userEmail) {
        Category category = categoryRepository.findByName(project.getCategoryName());
        if (category == null) {
            throw new RuntimeException("Category not found");
        }

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Project newProject = projectMapper.toEntity(project, category, user);

        Project savedProject = projectRepository.save(newProject);
        return projectMapper.toResponseDTO(savedProject);
    }

    @Override
    public List<ProjectResponseDTO> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream()
                .map(projectMapper::toResponseDTO)
                .toList();
    }

    @Override
    public ProjectResponseDTO getProjectById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        return projectMapper.toResponseDTO(project);
    }

    @Override
    public List<ProjectResponseDTO> getProjectsByCategory(Long categoryId) {
        List<Project> projects = projectRepository.findByCategoryId(categoryId);
        return projects.stream()
                .map(projectMapper::toResponseDTO)
                .toList();
    }

    @Override
    public ProjectResponseDTO updateProject(Long id, ProjectRequestDTO project) {
        Project existingProject = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        Project updatedProject = projectMapper.updateEntity(existingProject, project);
        Project savedProject = projectRepository.save(updatedProject);
        return projectMapper.toResponseDTO(savedProject);
    }

    @Override
    public void deleteProject(Long id) {
        Project existingProject = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        projectRepository.delete(existingProject);
    }

}
