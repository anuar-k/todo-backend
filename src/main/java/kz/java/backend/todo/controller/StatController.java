package kz.java.backend.todo.controller;

import kz.java.backend.todo.entity.Stat;
import kz.java.backend.todo.service.StatService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;

@RestController
@Transactional
@AllArgsConstructor
public class StatController {

    private final StatService statService;

    @PostMapping("/stat")
    public ResponseEntity<Stat> findByEmail(@RequestBody String email) {
        Stat stat = null;
        try {
            stat = statService.findStat(email);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return new ResponseEntity("not found stat with email: " + email, HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(stat);
    }
}