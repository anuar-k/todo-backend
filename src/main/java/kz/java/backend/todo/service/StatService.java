package kz.java.backend.todo.service;

import kz.java.backend.todo.repo.StatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import kz.java.backend.todo.entity.Stat;

@Service
@AllArgsConstructor
public class StatService {

    private final StatRepository statRepository;

    public Stat findStat(String email) {
        return statRepository.findByUserEmail(email).get();
    }
}