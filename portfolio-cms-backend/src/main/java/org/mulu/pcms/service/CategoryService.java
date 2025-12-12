package org.mulu.pcms.service;

import java.util.List;

import org.mulu.pcms.dto.request.CategoryRequestDTO;
import org.mulu.pcms.dto.response.CategoryResponseDTO;

public interface CategoryService {
    CategoryResponseDTO createCategory(CategoryRequestDTO category);

    List<CategoryResponseDTO> getAllCategories();

    CategoryResponseDTO getCategoryById(Long id);

    CategoryResponseDTO getCategoryByName(String name);

    CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO category);

    void deleteCategory(Long id);
}
