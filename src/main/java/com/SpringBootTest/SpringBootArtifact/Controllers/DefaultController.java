package com.SpringBootTest.SpringBootArtifact.Controllers;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface DefaultController<T> {

    @PostMapping
    T create(@RequestBody T object);

    @GetMapping({"/{id}"})
    T read(@PathVariable("id") String id);

    @GetMapping
    List<T> readAll();

    @PutMapping
    T update(@RequestBody T object);

    @DeleteMapping({"/{id}"})
    void delete(@PathVariable("id") String id);
}
