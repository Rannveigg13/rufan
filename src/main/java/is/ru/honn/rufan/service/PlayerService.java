package is.ru.honn.rufan.service;

import is.ru.honn.rufan.domain.Player;

import java.util.List;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Guðmundsdóttir
 * @date 22/9/2015.
 * @version 1.0
 */
public interface PlayerService {
    Player getPlayer(int playerId);
    List<Player> getPlayers(int teamId);
    List<Player> getPlayersByTeam(String teamAbbreviation);
    int addPlayer(Player player) throws ServiceException;
}
