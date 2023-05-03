package com.SpringBootTest.SpringBootArtifact.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dog {
    @Id
    private String id;
    private String refId;
    private String name;
    private Gender gender;
    private int age;
}
