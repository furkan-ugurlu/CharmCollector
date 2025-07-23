package com.merlin.category;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    // Delete by name
    @DeleteMapping("/{name}")
    public void deleteCategoryByName(@PathVariable String name) {
        categoryService.deleteByName(name);
    }

    // Delete all categories
    @DeleteMapping
    public void deleteAllCategories() {
        categoryService.deleteAll();
    }

    @PostMapping("/{categoryId}/charms/{charmId}")
    public ResponseEntity<Void> addCharmToCategory(@PathVariable Long categoryId, @PathVariable Long charmId) {
        categoryService.addCharmToCategory(categoryId, charmId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{categoryId}/charms/{charmId}")
    public ResponseEntity<Void> removeCharmFromCategory(@PathVariable Long categoryId, @PathVariable Long charmId) {
        categoryService.removeCharmFromCategory(categoryId, charmId);
        return ResponseEntity.ok().build();
    }
}
