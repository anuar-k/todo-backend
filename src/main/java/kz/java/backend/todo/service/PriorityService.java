package kz.java.backend.todo.service;

import kz.java.backend.todo.repo.PriorityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import kz.java.backend.todo.entity.Priority;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PriorityService {

    private final PriorityRepository priorityRepository;

    public List<Priority> findAll(String email) {
        return priorityRepository.findByUserEmailOrderByIdAsc(email);
    }

    public Priority add(Priority priority) {
        return priorityRepository.save(priority);
    }

    public void update(Priority priority) {
        priorityRepository.save(priority);
    }

    public void delete(Long id) {
        priorityRepository.deleteById(id);
    }

    public List<Priority> findByTitleAndEmail(String title, String email) {
        return priorityRepository.findByTitleAndEmail(title, email);
    }

    public Priority findById(Long id) {
        return priorityRepository.findById(id).get();
    }
}