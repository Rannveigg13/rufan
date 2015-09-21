package is.ru.honn.rufan.service;

import is.ru.honn.rufan.domain.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Notandi on 21-Sep-15.
 */
public class PlayerServiceStub implements PlayerService
{

    Logger log = Logger.getLogger(PlayerServiceStub.class.getName());
    private List<Player> players = new ArrayList<Player>();

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



    public List<Player> getPlayersByTeam(String teamAbbreviation){

        for(Player p : players){

            if(p.get == teamAbbreviation){
                teamAbbPlayers.add(p);
            }
        }
        return teamPlayers;
    }

    /***
     * Adds the given player to the players list if the player is valid and doesn't already exist
     * @param player The player to add
     * @return The index of the player in the players list
     * @throws ServiceException
     */
    public int addPlayer(Player player) throws ServiceException{

        if(player == null) throw new ServiceException("Player is not assigned");
        if(player.getPlayerId() < 0) throw new ServiceException("Player id cannot be below zero");
        if(player.getTeamId() < 0) throw new ServiceException("Player " + String.valueOf(player.getPlayerId()) +  " team id cannot be below zero");
        if(player.getBirthDate() == null) throw new ServiceException("Player " + String.valueOf(player.getPlayerId()) +  " birth date is not assigned.");
        if(player.getFirstName() == null) throw new ServiceException("Player " + String.valueOf(player.getPlayerId()) +  " first name is not assigned.");
        if(player.getLastName() == null) throw new ServiceException("Player " + String.valueOf(player.getPlayerId()) + " last name is not assigned.");
        if(player.getHeight() <= 0) throw new ServiceException("Player " + String.valueOf(player.getPlayerId()) +  " height cannot be zero or below.");
        if(player.getNationality() == null) throw new ServiceException("Player " + String.valueOf(player.getPlayerId()) +  " Country is not assigned.");
        if(player.getPositions() == null) throw new ServiceException("Player " + String.valueOf(player.getPlayerId()) +  " List<Position> is not assigned.");
        if(player.getWeight() <= 0) throw new ServiceException("Player " + String.valueOf(player.getPlayerId()) +  " weight cannot be zero or below.");

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
        return players.size()-1;
    }

}
