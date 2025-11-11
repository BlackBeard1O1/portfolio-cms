package org.mulu.pcms.service;

import java.util.List;

import org.mulu.pcms.dto.request.CategoryRequestDTO;
import org.mulu.pcms.dto.response.CategoryResponseDTO;
import org.mulu.pcms.entity.Category;

public interface CategoryService {
    CategoryResponseDTO createCategory(CategoryRequestDTO category);

    List<CategoryResponseDTO> getAllCategories();

    CategoryResponseDTO getCategoryById(Long id);

    CategoryResponseDTO getCategoryByName(String name);

    CategoryResponseDTO updateCategory(Long id, Category category);

    void deleteCategory(Long id);
}
