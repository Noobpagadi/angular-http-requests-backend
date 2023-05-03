package com.SpringBootTest.SpringBootArtifact.Services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DefaultService<T> {

    T create(T object);

    T read(String id);

    List<T> readAll();

    T update(T object);

    void delete(String id);
}