package com.tcc.tela_login.service.player;

import com.tcc.tela_login.controller.follower.FollowersResponse;
import com.tcc.tela_login.exeptions.game.GameAlreadyAddException;
import com.tcc.tela_login.exeptions.game.GameNotFoundException;
import com.tcc.tela_login.exeptions.player.ExistingUserNameException;
import com.tcc.tela_login.exeptions.player.NotFoundPlayer;
import com.tcc.tela_login.exeptions.player.PlayerIdNotFound;
import com.tcc.tela_login.model.game.Game;
import com.tcc.tela_login.model.player.Player;
import com.tcc.tela_login.repository.GameRepository;
import com.tcc.tela_login.repository.PlayerRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Serviço responsável pelas operações relacionadas aos jogadores.
 *
 * Esta classe permite o registro, busca, deleção e atualização de informações dos jogadores,
 * bem como a manipulação dos jogos favoritos.
 */
@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;

    /**
     * Registra um novo jogador na base de dados.
     *
     * @param player O objeto Player representando o jogador a ser registrado.
     * @throws ExistingUserNameException Se o nome de usuário já estiver em uso.
     * @return O jogador registrado.
     */
    public Player registerPlayer(Player player) throws ExistingUserNameException {
        checkUsernameAlreadyExisting(player);
        favoritingGames(player);
        return playerRepository.save(player);
    }

    /**
     * Encontra um jogador com base no nome de usuário.
     *
     * @param username O nome de usuário do jogador.
     * @return O objeto Player correspondente ao nome de usuário fornecido.
     * @throws NotFoundPlayer Se o jogador não for encontrado.
     */
    public Player findPlayerByUsername(String username) {
        return playerRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundPlayer("Nenhum jogador encontrado com esse nome"));
    }

    /**
     * Deleta um jogador da base de dados.
     *
     * @param playerId O ID do jogador a ser deletado.
     * @throws PlayerIdNotFound Se o jogador com o ID fornecido não for encontrado.
     */
    public void deletePlayer(String playerId) throws PlayerIdNotFound {
        playerRepository.findById(playerId);

        if (!playerRepository.existsById(playerId)) {
            throw new PlayerIdNotFound("Id não encontrado");
        }
        playerRepository.deleteById(playerId);
    }

    /**
     * Retorna todos os jogadores registrados.
     *
     * @return Uma coleção de objetos Player.
     */
    public Collection<Player> getPlayers() {
        return playerRepository.findAll();
    }

    /**
     * Retorna o perfil de um jogador, incluindo jogos favoritos, país e plataforma.
     *
     * @param username O nome de usuário do jogador.
     * @return Um objeto FollowersResponse contendo as informações do jogador.
     */
    public FollowersResponse getProfile(String username) {
        Player player = playerRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));

        return new FollowersResponse(
                player.getUsername(),
                player.getCountry(),
                player.getPlataformType(),
                player.getFavoriteGames());
    }

    private void checkUsernameAlreadyExisting(Player player) throws ExistingUserNameException {
        Optional<Player> playerAlreadyExist = playerRepository.findByUsername(player.getUsername());

        if (playerAlreadyExist.isPresent() && !playerAlreadyExist.get().getId().equals(player.getId())) {
            throw new ExistingUserNameException("Nome já está em uso.");
        }
    }

    private Game getGameByName(String gameName) throws GameNotFoundException {
        return gameRepository.findByName(gameName)
                .orElseThrow(() -> new GameNotFoundException("Jogo nao encontrado na base de dados do site."));
    }

    /**
     * Adiciona um novo jogo à lista de favoritos de um jogador.
     *
     * @param playerUsername O nome de usuário do jogador.
     * @param gameName O nome do jogo a ser adicionado.
     * @throws GameAlreadyAddException Se o jogo já estiver na lista de favoritos.
     */
    public void addMoreFavoritingGames(String playerUsername, String gameName) throws GameAlreadyAddException {
        var player = findPlayerByUsername(playerUsername);
        var game = getGameByName(gameName);

        if (player.getFavoriteGames().contains(game)) {
            throw new GameAlreadyAddException("Este jogo já está na sua lista de favoritos.");
        }

        player.getFavoriteGames().add(game);
        playerRepository.save(player);
    }

    private void favoritingGames(Player player) {
        if (player.getFavoriteGames() == null) {
            return;
        }

        Collection<Game> uniqueFavoriteGames = getValidUniqueFavoriteGames(player);
        player.setFavoriteGames(uniqueFavoriteGames);
    }

    private Collection<Game> getValidUniqueFavoriteGames(Player player) {
        Collection<Game> favoriteGames = new ArrayList<>();

        for (Game game : player.getFavoriteGames()) {
            Game validGame = getGameByName(game.getName());
            if (isNotDuplicate(favoriteGames, validGame)) {
                favoriteGames.add(validGame);
            }
        }
        return favoriteGames;
    }

    private boolean isNotDuplicate(Collection<Game> games, Game game) {
        return games.stream().noneMatch(g -> g.getName().equals(game.getName()));
    }

    /**
     * Atualiza as informações de um jogador, incluindo nome de usuário, email, senha e jogos favoritos.
     *
     * @param username O nome de usuário atual do jogador.
     * @param player O objeto Player com as novas informações.
     * @return O jogador atualizado.
     */
    public Player updatePlayer(String username, Player player) {
        Player exist = findPlayerByUsername(username);

        Collection<Game> validGames = player.getFavoriteGames().stream()
                .map(game -> getGameByName(game.getName()))
                .toList();

        if (!player.getUsername().equals(exist.getUsername())) {
            checkUsernameAlreadyExisting(player);
        }

        if (player.getPassword() == null) {
            player.setPassword(exist.getPassword());
        }

        Player updated = Player.builder()
                .id(exist.getId())
                .username(player.getUsername())
                .email(player.getEmail())
                .password(player.getPassword())
                .country(player.getCountry())
                .plataformType(player.getPlataformType())
                .favoriteGames(validGames)
                .build();

        return playerRepository.save(updated);
    }

    /**
     * Autentica um jogador com base no nome de usuário e senha.
     *
     * @param username O nome de usuário do jogador.
     * @param password A senha do jogador.
     * @return O jogador autenticado.
     * @throws NotFoundPlayer Se o jogador não for encontrado.
     */

    public boolean authenticate(String username, String password) {
        Optional<Player> userOptional = playerRepository.findByUsername(username);

        return userOptional.isPresent() && userOptional.get().getPassword().equals(password);
    }
}
