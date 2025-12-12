package org.mulu.pcms.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.mulu.pcms.dto.request.CategoryRequestDTO;
import org.mulu.pcms.dto.response.CategoryResponseDTO;
import org.mulu.pcms.entity.Category;
import org.mulu.pcms.mapper.CategoryMapper;
import org.mulu.pcms.repository.CategoryRepository;
import org.mulu.pcms.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl  implements CategoryService {


    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper){
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequest) {
        Category category = categoryMapper.toEntity(categoryRequest);

        Category savedCategory = categoryRepository.save(category);

        return categoryMapper.toDto(savedCategory);

    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        return categoryRepository.findAll().stream().map(categoryMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public CategoryResponseDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));

        return categoryMapper.toDto(category);
    }

    @Override
    public CategoryResponseDTO getCategoryByName(String name) {
        Category category = categoryRepository.findByName(name);

        return categoryMapper.toDto(category);
    }

    @Override
    public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO category) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));

        categoryMapper.updateCategory(category, existingCategory);

        Category updatedCategory = categoryRepository.save(existingCategory);

        return categoryMapper.toDto(updatedCategory);

    }

    @Override
    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found with id: " + id);
        }
        categoryRepository.deleteById(id);
    }


}
