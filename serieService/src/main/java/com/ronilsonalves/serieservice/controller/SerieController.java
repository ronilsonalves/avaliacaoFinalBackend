package com.ronilsonalves.serieservice.controller;

import com.ronilsonalves.serieservice.model.Serie;
import com.ronilsonalves.serieservice.service.impl.SerieServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/serie")
@AllArgsConstructor
public class SerieController {
    private final SerieServiceImpl serieService;

    @GetMapping("/genre/{genreName}")
    public ResponseEntity<?> getSeriesByGenre(@PathVariable String genreName) {
        return ResponseEntity.status(HttpStatus.OK).body(serieService.getSeriesByGenre(genreName));
    }

    @GetMapping
    public ResponseEntity<?> getSeries() {
        return ResponseEntity.status(HttpStatus.OK).body(serieService.getSeries());
    }

    @GetMapping("/{serieId}")
    public ResponseEntity<?> getSerieById(@PathVariable String serieId) {
        return ResponseEntity.status(HttpStatus.OK).body(serieService.getSerieById(serieId));
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveSerie(@RequestBody Serie serie) {
        serieService.saveSerie(serie);
        return ResponseEntity.status(HttpStatus.CREATED).body("SERIE CREATED SUCCESSFULLY!");
    }
}
