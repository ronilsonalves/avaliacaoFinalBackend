package com.ronilsonalves.serieservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "chapters")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Chapter {

    @Id
    private String id;
    private String name;
    private Integer number;
    private String urlStream;
}
