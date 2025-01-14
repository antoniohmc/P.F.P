package com.tcc.tela_login.model.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "DayTimePreference")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DayTimePreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private DayOfWeek day;

    private LocalTime startTime;

    private LocalTime endTime;
}
