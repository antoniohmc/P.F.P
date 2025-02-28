package com.tcc.tela_login.model.player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.DayOfWeek;
import java.time.LocalTime;


@Document(collection = "day_time_preference")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DayTimePreference {

    @Id
    private String id;

    private Player player;

    private DayOfWeek day;

    private LocalTime startTime;

    private LocalTime endTime;
}
