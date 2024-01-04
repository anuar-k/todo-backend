package kz.java.backend.todo.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import kz.java.backend.todo.entity.Task;

import java.util.Date;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t from Task t where " +
            "(:title is null or :title='' or lower(:title) like lower(concat('%', :title, '%'))) and" +
            "(:completed is null or t.completed=:completed) and " +
            "(:priorityId is null or t.priority.id=:priorityId) and " +
            "(:categoryId is null or t.category.id=:categoryId) and " +
            "(" +
                "(cast(:dateFrom as timestamp ) is null or t.taskDate>=:dateFrom) and" +
                "(cast(:dateTo as timestamp ) is null or t.taskDate<=:dateTo)" +
            ") and " +
            "(t.user.email=:email)"
    )
    Page<Task>findByParams(@Param("title") String title,
                           @Param("completed") Boolean completed,
                           @Param("priorityId") Long priorityId,
                           @Param("categoryId") Long categoryId,
                           @Param("email") String email,
                           @Param("dateFrom") Date dateFrom,
                           @Param("dateTo") Date dateTo,
                           Pageable pageable
    );

    List<Task> findByUserEmailOrderByTitleAsc(String email);
}