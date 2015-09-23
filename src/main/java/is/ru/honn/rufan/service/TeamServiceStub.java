package is.ru.honn.rufan.service;

import is.ru.honn.rufan.domain.League;
import is.ru.honn.rufan.domain.Team;

import java.util.*;
import java.util.logging.Logger;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Guðmundsdóttir
 * @date 22/9/2015.
 * @version 1.0
 */
public class TeamServiceStub implements TeamService
{
    Logger log = Logger.getLogger(TeamServiceStub.class.getName());
    private static Map<Integer, ArrayList<Team>> leagueTeamRelation = new HashMap<Integer, ArrayList<Team>>();
    private static List<League> leagues = new ArrayList<League>();

    /***
     * Makes a relation between the given team and the league with the given league ID.
     * @param leagueId The league ID of the league to add the team to
     * @param team The team to add to the league with the given league ID
     * @return The index of the added team in the list of teams in the league with the league ID
     * @throws ServiceException if the given values do not exist or are null
     */
    public int addTeam(int leagueId, Team team) throws ServiceException{

        // Dummy data
        if(leagueTeamRelation.isEmpty()) leagueTeamRelation.put(39,new ArrayList<Team>());

        // Error checking the team and league id
        if(team == null){
            String msg = "Team is not assigned.";
            log.info(msg);
            throw new ServiceException(msg);
        }
        if(!leagueTeamRelation.containsKey(leagueId)){
            String msg = "League ID: '" + leagueId + "' does not exist.";
            log.info(msg);
            throw new ServiceException(msg);
        }

        ArrayList<Team> teams = leagueTeamRelation.get(leagueId);

        for(Team t : teams)
        {
            if (t.getTeamId() == team.getTeamId())
            {
                String msg = "Team: '" + team.getDisplayName() + "' already exists.";
                log.info(msg);
                throw new ServiceException(msg);
            }
        }

        teams.add(team);

        log.info("New team '" + team.getDisplayName() + "' added to league " + leagueId + ".");
        return teams.size()-1;
    }

    /***
     * Finds and returns a list of teams assigned with the given league ID.
     * If the leagueId does not exist, returns an empty list
     * @param leagueId The league ID of the league to get the teams from
     * @return A list of teams in the league with the given league ID
     */
    public List<Team> getTeams(int leagueId){
        if(leagueTeamRelation.containsKey(leagueId)){
            return leagueTeamRelation.get(leagueId);
        }
        List<Team> teams = new ArrayList<Team>();
        return teams;
    }

    /***
     * Finds and returns the team with the given abbreviation.
     * If there is no team with the given abbreviation, it returns null.
     * @param abbreviation The abbreviation for the team to get
     * @return The team with the given abbreviation, if no team is found; returns null.
     */
    public Team getTeamByAbbreviation(String abbreviation){
        Collection<ArrayList<Team>> collection = leagueTeamRelation.values();
        for(ArrayList<Team> at : collection){
            for(Team t : at){
                if(t.getAbbreviation().equals(abbreviation)){
                    return t;
                }
            }
        }
        return null;
    }
}

