package org.mulu.pcms.service.impl;

import java.util.List;

import org.mulu.pcms.dto.request.ProjectRequestDTO;
import org.mulu.pcms.dto.response.CategoryResponseDTO;
import org.mulu.pcms.dto.response.ProjectResponseDTO;
import org.mulu.pcms.dto.response.UserResponseDTO;
import org.mulu.pcms.entity.Category;
import org.mulu.pcms.entity.Project;
import org.mulu.pcms.entity.User;
import org.mulu.pcms.mapper.CategoryMapper;
import org.mulu.pcms.mapper.ProjectMapper;
import org.mulu.pcms.mapper.UserMapper;
import org.mulu.pcms.repository.ProjectRepository;
import org.mulu.pcms.service.ProjectService;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final CategoryServiceImpl categoryService;
    private final UserServiceImpl userService;
    private final UserMapper userMapper;
    private final CategoryMapper categoryMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper,
            CategoryServiceImpl categoryService, UserServiceImpl userService, UserMapper userMapper,
            CategoryMapper categoryMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
        this.categoryService = categoryService;
        this.userService = userService;
        this.userMapper = userMapper;
        this.categoryMapper = categoryMapper;

    }

    @Override
    public ProjectResponseDTO createProject(ProjectRequestDTO project) {

        CategoryResponseDTO categoryDTO = categoryService.getCategoryByName(project.getCategoryName());
        if (categoryDTO == null) {
            throw new RuntimeException("Category not found");
        }
        Category category = categoryMapper.toEntity(categoryDTO);

        // update to get user from session later
        UserResponseDTO userDTO = userService.getUserByEmail("henos.job@gmail.com");
        if (userDTO == null) {
            throw new RuntimeException("User not found");
        }
        User user = userMapper.toEntity(userDTO);

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
