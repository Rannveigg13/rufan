package is.ru.honn.rufan.service;

import is.ru.honn.rufan.domain.Player;
import is.ru.honn.rufan.observer.Subject;

import java.util.List;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Gudmundsdottir
 * @version 1.0 22/9/2015.
 *
 * This class represents a Player service
 */
public interface PlayerService {
    void addObserver();
    Subject getSubject();
    Player getPlayer(int playerId);
    List<Player> getPlayers(int teamId);
    List<Player> getPlayersByTeam(String teamAbbreviation);
    int addPlayer(Player player) throws ServiceException;
}
