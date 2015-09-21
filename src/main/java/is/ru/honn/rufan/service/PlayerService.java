package is.ru.honn.rufan.service;

import is.ru.honn.rufan.domain.Player;

import java.util.List;

/**
 * Created by Notandi on 21-Sep-15.
 */
public interface PlayerService {
    Player getPlayer(int playerId);
    List<Player> getPlayers(int teamId);
    List<Player> getPlayersByTeam(String teamAbbreviation);
    int addPlayer(Player player) throws ServiceException;

}
