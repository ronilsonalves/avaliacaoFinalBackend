package com.ronilsonalves.catalogservice.controller;

import com.ronilsonalves.catalogservice.model.Movie;
import com.ronilsonalves.catalogservice.service.impl.CatalogServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogServiceImpl catalogService;

    @GetMapping("/movie/{genre}")
    public ResponseEntity<?> getMovieCatalogByGenre(@PathVariable String genre) {
        return ResponseEntity.status(HttpStatus.OK).body(catalogService.getMoviesByGenre(genre));
    }

    @GetMapping("/movie/id/{movieId}")
    public ResponseEntity<?> getMovieById(@PathVariable Long movieId) {
        return ResponseEntity.status(HttpStatus.OK).body(catalogService.getMovieById(movieId));
    }

    @PostMapping("/movie/save")
    public ResponseEntity<?> saveMovie(@Valid @RequestBody Movie movie) {
        catalogService.addNewMovie(movie);
        return ResponseEntity.status(HttpStatus.OK).body("MOVIE SAVE SUCCESSFULLY");
    }

}
