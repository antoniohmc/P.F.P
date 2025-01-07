package com.tcc.tela_login.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DayTimePreference {
    
    private DayOfWeek day;

    private LocalTime startTime;

    private LocalTime endTime;

}
