package com.tcc.tela_login.model;

import static com.tcc.tela_login.model.Genders.ACTION;
import static com.tcc.tela_login.model.Genders.ADVENTURE;
import static com.tcc.tela_login.model.Genders.COMPETITIVE;
import static com.tcc.tela_login.model.Genders.MOBA;
import static com.tcc.tela_login.model.Genders.RPG;
import static com.tcc.tela_login.model.Genders.STRATEGY;
import static com.tcc.tela_login.model.Genders.TERROR;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Table(name = "GamerList")
@Entity
public class GameList {

    private final Collection<Game> games = new ArrayList<>();

    public Collection<Game> popularGames () {
        games.add(new Game(UUID.randomUUID(), "LEAGUE OF LEGENDS", List.of(MOBA, COMPETITIVE)));
        games.add(new Game(UUID.randomUUID(), "FORTNITE", List.of(ACTION, COMPETITIVE)));
        games.add(new Game(UUID.randomUUID(), "DOTA 2", List.of(MOBA, COMPETITIVE)));
        games.add(new Game(UUID.randomUUID(), "COUNTER-STRIKE: GLOBAL OFFENSIVE", List.of(ACTION, COMPETITIVE)));
        games.add(new Game(UUID.randomUUID(), "APEX LEGENDS", List.of(ACTION, COMPETITIVE)));
        games.add(new Game(UUID.randomUUID(), "VALORANT", List.of(ACTION, COMPETITIVE)));
        games.add(new Game(UUID.randomUUID(), "CALL OF DUTY: WARZONE", List.of(ACTION, COMPETITIVE)));
        games.add(new Game(UUID.randomUUID(), "WORLD OF WARCRAFT", List.of(RPG, ACTION, ADVENTURE)));
        games.add(new Game(UUID.randomUUID(), "OVERWATCH", List.of(ACTION, COMPETITIVE)));
        games.add(new Game(UUID.randomUUID(), "RAINBOW SIX SIEGE", List.of(ACTION, COMPETITIVE)));
        games.add(new Game(UUID.randomUUID(), "FIFA", List.of(COMPETITIVE)));
        games.add(new Game(UUID.randomUUID(), "ROCKET LEAGUE", List.of(COMPETITIVE, ACTION)));
        games.add(new Game(UUID.randomUUID(), "DESTINY 2", List.of(ACTION, ADVENTURE, RPG)));
        games.add(new Game(UUID.randomUUID(), "DIABLO IV", List.of(RPG, ACTION, ADVENTURE)));
        games.add(new Game(UUID.randomUUID(), "ESCAPE FROM TARKOV", List.of(ACTION, TERROR, COMPETITIVE)));
        games.add(new Game(UUID.randomUUID(), "PUBG", List.of(ACTION, COMPETITIVE)));
        games.add(new Game(UUID.randomUUID(), "STARCRAFT II", List.of(COMPETITIVE, STRATEGY)));
        games.add(new Game(UUID.randomUUID(), "SMITE", List.of(MOBA, COMPETITIVE)));
        games.add(new Game(UUID.randomUUID(), "TEAM FORTRESS 2", List.of(ACTION, COMPETITIVE)));
        games.add(new Game(UUID.randomUUID(), "GTA ONLINE", List.of(ACTION, ADVENTURE, COMPETITIVE)));
        games.add(new Game(UUID.randomUUID(), "PATH OF EXILE", List.of(RPG, ACTION, ADVENTURE)));
        games.add(new Game(UUID.randomUUID(), "BLACK DESERT ONLINE", List.of(RPG, ACTION, ADVENTURE)));
        games.add(new Game(UUID.randomUUID(), "MONSTER HUNTER WORLD", List.of(ACTION, RPG, ADVENTURE)));
        games.add(new Game(UUID.randomUUID(), "THE DIVISION 2", List.of(ACTION, ADVENTURE, COMPETITIVE)));
        games.add(new Game(UUID.randomUUID(), "MORTAL KOMBAT 11", List.of(ACTION, COMPETITIVE)));
        games.add(new Game(UUID.randomUUID(), "TOM CLANCY'S GHOST RECON", List.of(ACTION, ADVENTURE, COMPETITIVE)));
        games.add(new Game(UUID.randomUUID(), "HALO INFINITE", List.of(ACTION, COMPETITIVE)));
        games.add(new Game(UUID.randomUUID(), "FOR HONOR", List.of(ACTION, COMPETITIVE)));
        games.add(new Game(UUID.randomUUID(), "SEA OF THIEVES", List.of(ADVENTURE, ACTION, COMPETITIVE)));
        games.add(new Game(UUID.randomUUID(), "BRAWLHALLA", List.of(ACTION, COMPETITIVE)));
        games.add(new Game(UUID.randomUUID(), "HUNT: SHOWDOWN", List.of(ACTION, TERROR, COMPETITIVE)));
        games.add(new Game(UUID.randomUUID(), "ARCHEAGE", List.of(RPG, ACTION, ADVENTURE)));
        games.add(new Game(UUID.randomUUID(), "PALADINS", List.of(ACTION, COMPETITIVE)));

        return games;
    }
}
