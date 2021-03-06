package is.ru.honn.rufan.service;

import is.ru.honn.rufan.observer.Observer;
import is.ru.honn.rufan.observer.PlayerServiceObserver;
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
    private Logger log = Logger.getLogger(PlayerServiceStub.class.getName());
    private List<Player> players = new ArrayList<Player>();
    private TeamServiceStub tss = new TeamServiceStub();
    private Subject subject = new PlayerServiceSubject();
    private Observer observer;

    /**
     * Adds an observer to the subject
     */
    public void addObserver(){
        observer = new PlayerServiceObserver(subject);
    }

    /**
     * This method allows tests to get the subject
     * @return This services subject
     */
    public Subject getSubject(){ return this.subject; }

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

        String err = "";
        boolean error = false;
        if(player == null){
            err = "Player cannot be null";
            error = true;
        }
        else if(player.getFirstName() == null){
            player.setFirstName("");
        }
        else if(player.getLastName() == null){
            err = "Player " + String.valueOf(player.getPlayerId()) + " lastName cannot be null";
            error = true;
        }
        else if(player.getTeamId() == null ){
            err = "Player " + String.valueOf(player.getPlayerId()) +  " teamId cannot be null";
            error = true;
        }

        if(error){
            log.severe(err);
            throw new ServiceException(err);
        }


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
