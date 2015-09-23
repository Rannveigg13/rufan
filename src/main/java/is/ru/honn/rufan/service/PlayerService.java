package is.ru.honn.rufan.service;

import is.ru.honn.rufan.domain.Player;

import java.util.List;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Gudmundsdottir
 * @version 1.0 22/9/2015.
 */
public interface PlayerService {
    void addObserver();
    Player getPlayer(int playerId);
    List<Player> getPlayers(int teamId);
    List<Player> getPlayersByTeam(String teamAbbreviation);
    int addPlayer(Player player) throws ServiceException;
}
