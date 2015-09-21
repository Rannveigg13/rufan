package is.ru.honn.rufan.service;

import is.ru.honn.rufan.domain.League;
import is.ru.honn.rufan.domain.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Notandi on 21-Sep-15.
 */
public class TeamServiceStub implements TeamService
{
    Logger log = Logger.getLogger(TeamServiceStub.class.getName());
    private List<League> leagues = new ArrayList<League>();

    public int addTeam(int leagueId, Team team) throws ServiceException{
        if(team == null) throw new ServiceException("Team is not assigned");
        if(team.getTeamId() < 0) throw new ServiceException("Team id cannot be below zero");
        if(team.getAbbreviation() == null) throw new ServiceException("Team " + String.valueOf(team.getTeamId()) +  " abbreviation is not assigned.");
        if(team.getDisplayName() == null) throw new ServiceException("Team " + String.valueOf(team.getTeamId()) +  " display name is not assigned.");
        if(team.getLocation() == null) throw new ServiceException("Team " + String.valueOf(team.getTeamId()) +  " location is not assigned.");
        if(team.getVenue() == null) throw new ServiceException("Team " + String.valueOf(team.getTeamId()) +  " Venue is not assigned.");



        for( p: players)
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

    public List<Team> getTeams(int leagueId){

    }
}

