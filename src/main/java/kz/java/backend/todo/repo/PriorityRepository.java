package kz.java.backend.todo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import kz.java.backend.todo.entity.Priority;

import java.util.List;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {

    List<Priority> findByUserEmailOrderByIdAsc(String email);

    @Query("SELECT c FROM Priority c WHERE " +
            "(c.title is null  or c.title='' " +
            "or lower(c.title) like lower(concat('%', :title, '%')))" +
            "and c.user.email = :email " +
            "order by c.title asc ")
    List<Priority> findByTitleAndEmail(String title, String email);
}