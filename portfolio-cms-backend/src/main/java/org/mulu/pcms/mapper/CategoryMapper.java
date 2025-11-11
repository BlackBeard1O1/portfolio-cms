package org.mulu.pcms.mapper;

import org.mulu.pcms.dto.request.CategoryRequestDTO;
import org.mulu.pcms.dto.response.CategoryResponseDTO;
import org.mulu.pcms.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    // Convert DTO → Entity for CREATE
    public Category toEntity(CategoryRequestDTO dto) {
        if (dto == null)
            return null;
        Category category = new Category();
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        return category;
    }

    //only for project creation, where we need to convert from response DTO to entity
    public Category toEntity(CategoryResponseDTO dto) {
        if (dto == null)
            return null;
        Category category = new Category();
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        return category;
    }

    public CategoryResponseDTO toDto(Category savedCategory) {
        if (savedCategory == null)
            return null;
        return new CategoryResponseDTO(
                savedCategory.getId(),
                savedCategory.getName(),
                savedCategory.getDescription());
    }

    public void updateCategory(Category category, Category existingCategory) {
        if (category == null || existingCategory == null) {
            throw new IllegalArgumentException("Category and existingCategory must not be null");
        }

        if (category.getName() != null) {
            existingCategory.setName(category.getName());
        }
        if (category.getDescription() != null) {
            existingCategory.setDescription(category.getDescription());
        }
    }
}
