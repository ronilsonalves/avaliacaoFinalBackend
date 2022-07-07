package com.ronilsonalves.serieservice.service.impl;

import com.ronilsonalves.serieservice.model.Chapter;
import com.ronilsonalves.serieservice.model.Season;
import com.ronilsonalves.serieservice.model.Serie;
import com.ronilsonalves.serieservice.repository.SerieRepository;
import com.ronilsonalves.serieservice.repository.SeasonRepository;
import com.ronilsonalves.serieservice.repository.ChapterRepository;
import com.ronilsonalves.serieservice.service.SerieService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class SerieServiceImpl implements SerieService {

    private static Logger log = Logger.getLogger(SerieServiceImpl.class.getName());

    private RabbitTemplate rabbitTemplate;

    private final SerieRepository serieRepository;
    private final SeasonRepository seasonRepository;
    private final ChapterRepository chapterRepository;

    public SerieServiceImpl( SerieRepository serieRepository, SeasonRepository seasonRepository, ChapterRepository chapterRepository) {
        this.serieRepository = serieRepository;
        this.seasonRepository = seasonRepository;
        this.chapterRepository = chapterRepository;
    }

    @Override
    public List<Serie> getSeriesByGenre(String genre) {
        return serieRepository.findAllByGenre(genre);
    }

    @Override
    public List<Serie> getSeries() {
        return serieRepository.findAll();
    }

    @Override
    public Serie getSerieById(String serieId) {
        return serieRepository.findById(serieId).orElse(null);
    }

    @Override
    public Serie saveSerie(Serie serie) {
        //log.info("Starting to save on mongo: "+serie.getName()+"...");
        List<Season> seasonsToBeCreated = serie.getSeasons().stream().filter(season -> season.getId() == null).collect(Collectors.toList());

        for(Season season : seasonsToBeCreated){
            if(!season.getChapters().isEmpty()) {
                for(Chapter chapter : season.getChapters()){
                    Chapter chapterToAux = new Chapter();
                    chapterToAux = chapterRepository.save(chapter);
                    chapter.setId(chapterToAux.getId());
                }
            }
        }
        //log.info("... all chapters from all seasons have been saved on mongo.\nNow starting to save all seasons...");

        List<Season> seasonsSaved = seasonsToBeCreated.stream().map(seasonRepository::save).collect(Collectors.toList());

        //log.info("The seasons has been saved!\nStarting to save the serie on mongo database...");
        serie.getSeasons().clear();
        serie.getSeasons().addAll(seasonsSaved);
        rabbitTemplate.convertAndSend("SerieServiceQueue",serie);
        return serieRepository.save(serie);
    }
}
