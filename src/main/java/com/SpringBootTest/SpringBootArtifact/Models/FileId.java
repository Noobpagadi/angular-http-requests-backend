package com.SpringBootTest.SpringBootArtifact.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileId {
    /*    Now i know this is painful to look at,
        like why am i even creating a class which contains only one Strin field
        the answer is that i had a problem with the parsing of the ID for a GridFs file for some reason
        and was too lazy to investigate where exactly was the error (as the workshop was angular oriented anyways)*/
    String fileId;
}
