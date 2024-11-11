package com.tcc.tela_login.model;

import jakarta.persistence.Entity;
import java.util.Collection;
import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
public class UsersList {

    private Collection<UserModel> users;

    /**
     * Metodo com a funcionalidade de cadastrar um novo usuario no banco de dados do sistema.
     */
    public Collection<UserModel> register(String email,String username, String password, Collection<Game> favoriteGames) {
        UserModel newUSer = UserModel.builder()
            .email(email)
            .username(username)
            .password(password)
            .favoriteGames(favoriteGames)
            .build();

        users.add(newUSer);
        return users;
    }
}
