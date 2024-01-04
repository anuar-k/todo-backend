package kz.java.backend.todo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import kz.java.backend.todo.entity.Stat;

import java.util.Optional;

@Repository
public interface StatRepository extends CrudRepository<Stat, Long> {

    Optional<Stat> findByUserEmail(String email);
}