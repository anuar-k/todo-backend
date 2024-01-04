package kz.java.backend.todo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import kz.java.backend.todo.entity.Category;
import kz.java.backend.todo.repo.CategoryRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> findAll(String email) {
        return categoryRepository.findByUserEmailOrderByTitleAsc(email);
    }

    public Category add(Category category) {
        return categoryRepository.save(category);
    }

    public void update(Category category) {
        categoryRepository.save(category);
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    public List<Category> findByTitleAndEmail(String title, String email) {
        return categoryRepository.findByTitleAndEmail(title, email);
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }
}
