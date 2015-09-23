package is.ru.honn.rufan.service;

import is.ru.honn.rufan.observer.PlayerServiceSubject;
import is.ru.honn.rufan.observer.Subject;
import is.ru.honn.rufan.domain.Player;
import is.ru.honn.rufan.domain.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Gudmundsdottir
 * @version 1.0 22/9/2015.
 */
public class PlayerServiceStub implements PlayerService
{
    Logger log = Logger.getLogger(PlayerServiceStub.class.getName());
    private List<Player> players = new ArrayList<Player>();
    TeamServiceStub tss = new TeamServiceStub();
    Subject subject = new PlayerServiceSubject();

    /***
     * Finds and returns the player with the given player ID,
     * if the player doesn't exist; null is returned
     * @param playerId The player ID of the player to return
     * @return The player with the given player ID, null if the player doesn't exist
     */
    public Player getPlayer(int playerId){
        for(Player p : players){
            if(p.getPlayerId() == playerId){
                return p;
            }
        }
        return null;
    }

    /***
     * Gets players that are assigned with the given team ID and returns a list of them
     * @param teamId The team ID of the list of players to return
     * @return A list of players assigned with the given team ID
     */
    public List<Player> getPlayers(int teamId){
        List<Player> teamPlayers = new ArrayList<Player>();
        for(Player p : players){
            if(p.getTeamId() == teamId){
                teamPlayers.add(p);
            }
        }
        return teamPlayers;
    }


    /***
     * Finds and returns a list of players associated with the given team abbreviation
     * @param teamAbbreviation The team abbreviation to filter players with
     * @return A list of players associated with the given team abbreviation
     */
    public List<Player> getPlayersByTeam(String teamAbbreviation){
        Team team = tss.getTeamByAbbreviation(teamAbbreviation);
        List<Player> result = new ArrayList<Player>();
        for(Player p : players){
            if(p.getTeamId() == team.getTeamId()){
                result.add(p);
            }
        }
        return result;
    }

    /***
     * Adds the given player to the players list if the player is valid and doesn't already exist
     * @param player The player to add
     * @return The index of the player in the players list
     * @throws ServiceException
     */
    public int addPlayer(Player player) throws ServiceException{

        if(player == null) throw new ServiceException("Player is not assigned");
        if(player.getFirstName() == null) player.setFirstName("");
        if((Integer)player.getPlayerId() == null) throw new ServiceException("Player " + player.getFirstName() + " " + player.getLastName() + " playerId cannot be null");
        if((Integer)player.getTeamId() == null ) throw new ServiceException("Player " + String.valueOf(player.getPlayerId()) +  " teamId cannot be null");


        for(Player p: players)
        {
            if (p.getPlayerId() == player.getPlayerId())
            {
                String msg = "Player: '" + player.getFirstName() + " " + player.getLastName() + "' already exists.";
                log.info(msg);
                throw new ServiceException(msg);
            }
        }

        players.add(player);
        log.info("New player '" + player.getFirstName() + " " + player.getLastName() + "' added");

        // Notify all observers
        subject.setUpdateData(player);

        return players.size()-1;
    }
}
