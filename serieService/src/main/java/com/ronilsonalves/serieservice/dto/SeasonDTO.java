package com.ronilsonalves.serieservice.dto;

import com.ronilsonalves.serieservice.model.Chapter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SeasonDTO {

    private ObjectId id;

    private Integer seasonNumber;

    private List<Chapter> chapters;
}
