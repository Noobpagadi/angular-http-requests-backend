package com.SpringBootTest.SpringBootArtifact.Services;

import com.SpringBootTest.SpringBootArtifact.Models.Dog;
import com.SpringBootTest.SpringBootArtifact.Repositories.DogRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DogService implements DefaultService<Dog> {

    private final DogRepository dogRepository;

    @Override
    public Dog create(Dog dog) {
        dog.setId(null);
        return this.dogRepository.save(dog);
    }

    @Override
    public Dog read(String id) {
        return this.dogRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Dog> readAll() {
        return this.dogRepository.findAll();
    }

    @Override
    public Dog update(Dog newDog) {
        return this.dogRepository.save(newDog);
    }

    public Page<Dog> readPage(int pageNumber, int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        Page<Dog> dogPage = this.dogRepository.findAll(page);
        System.out.print(dogPage);
        return dogPage;
    }

    @Override
    public void delete(String id) {
        this.dogRepository.deleteById(id);
    }

}
