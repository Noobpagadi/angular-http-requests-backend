package com.SpringBootTest.SpringBootArtifact.Controllers;

import com.SpringBootTest.SpringBootArtifact.Models.Dog;
import com.SpringBootTest.SpringBootArtifact.Services.DogService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/dog")
@AllArgsConstructor
public class DogController implements DefaultController<Dog> {

    private final DogService dogService;

    @Override
    public Dog read(String id) {
        return dogService.read(id);
    }

    @Override
    public List<Dog> readAll() {
        return dogService.readAll();
    }

    @GetMapping(params = {"page", "size"})
    public Page<Dog> readPage(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "6") int size) {
        return dogService.readPage(page, size);
    }

    @Override
    public Dog create(Dog dog) {
        return dogService.create(dog);
    }

    @Override
    public Dog update(Dog newDog) {
        return dogService.update(newDog);
    }

    @Override
    public void delete(String id) {
        dogService.delete(id);
    }


}
