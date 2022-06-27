package com.ronilsonalves.movieservice.controller;

import com.ronilsonalves.movieservice.model.Movie;
import com.ronilsonalves.movieservice.service.impl.MovieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieServiceImpl movieService;

    @PostMapping("/save")
    public ResponseEntity<?> addNewMovie(@RequestBody Movie movie) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.saveMovie(movie));
    }

    @GetMapping("/{genre}")
    public ResponseEntity<?> getMoviesByGenre(@PathVariable String genre) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getAllByGenre(genre));
    }

    @GetMapping("/id/{movieId}")
    public ResponseEntity<?> getMovieById(@PathVariable Long movieId) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getMovieById(movieId));
    }
}
