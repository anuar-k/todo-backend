package kz.java.backend.todo.repo;

import kz.java.backend.todo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByUserEmailOrderByTitleAsc(String email);

    @Query("SELECT c FROM Category c WHERE " +
            "(c.title is null  or c.title='' " +
            "or lower(c.title) like lower(concat('%', :title, '%')))" +
            "and c.user.email = :email " +
            "order by c.title asc ")
    List<Category> findByTitleAndEmail(String title, String email);
}