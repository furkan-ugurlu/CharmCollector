package com.merlin.category;

import com.merlin.charm.Charm;
import com.merlin.charm.CharmRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;
    private final CharmRepository  charmRepository;

    public CategoryService(CategoryRepo categoryRepo, CharmRepository charmRepository) {
        this.categoryRepo = categoryRepo;
        this.charmRepository = charmRepository;
    }

    public Category createCategory(Category category) {
        // Null check
        if (category == null || category.getName() == null || category.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Category and category name cannot be null or empty");
        }

        // Normalize name
        String normalizedName = category.getName().trim();
        category.setName(normalizedName);

        // Check if exists
        Optional<Category> existing = categoryRepo.findByName(normalizedName);
        if (existing.isPresent()) {
            throw new RuntimeException("Category with name '" + normalizedName + "' already exists");
        }

        return categoryRepo.save(category);
    }
    public Category findCategoryById(Long id) {
        return categoryRepo.findById(id).orElse(null);
    }

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public void deleteAll() {
        categoryRepo.deleteAll();
    }

    public void deleteByName(String name) {
        categoryRepo.deleteByName(name);
    }
    @Transactional
    public void addCharmToCategory(Long categoryId, Long charmId) {
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Charm charm = charmRepository.findById(charmId)
                .orElseThrow(() -> new RuntimeException("Charm not found"));

        category.getCharms().add(charm);
        charm.setCategory(category); // Assuming Charm has a Category field to maintain the relationship
        categoryRepo.save(category);
    }

    @Transactional
    public void removeCharmFromCategory(Long categoryId, Long charmId) {
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Charm charm = charmRepository.findById(charmId)
                .orElseThrow(() -> new RuntimeException("Charm not found"));

        category.getCharms().remove(charm);
        // Ensure the relationship is cleared on the charm side as well
        charm.setCategory(null);
        categoryRepo.save(category);
    }

}




