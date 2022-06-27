package com.ronilsonalves.catalogservice.dto;

import com.ronilsonalves.catalogservice.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CatalogDTO {
    String name;
    List<Movie> movies;
}
