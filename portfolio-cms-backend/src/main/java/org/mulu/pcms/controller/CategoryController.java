package org.mulu.pcms.controller;

import java.util.List;

import org.mulu.pcms.dto.request.CategoryRequestDTO;
import org.mulu.pcms.dto.response.CategoryResponseDTO;
import org.mulu.pcms.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;


    @PostMapping("/create")
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryRequestDTO category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/category/{name}")
    public ResponseEntity<CategoryResponseDTO> getCategoryByName(@PathVariable String name) {
        return ResponseEntity.ok(categoryService.getCategoryByName(name));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(@RequestBody CategoryRequestDTO category, @PathVariable Long id) {
        return ResponseEntity.ok(categoryService.updateCategory(id, category));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }




    
}
