package com.tcc.tela_login.model;

import jakarta.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
public class UsersList {

    private List<UserModel> users = new ArrayList<>();

    public List<UserModel> addUser(String username, String password, List<Game> favoriteGames) {
        UserModel newUSer = UserModel.builder()
            .username(username)
            .password(password)
            .favoriteGames(favoriteGames)
            .build();

        users.add(newUSer);
        return users;
    }
}
