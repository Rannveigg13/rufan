package is.ru.honn.rufan.service;

import is.ru.honn.rufan.domain.Team;

import java.util.List;

/**
 * Created by Notandi on 21-Sep-15.
 */
public interface TeamService
{
    int addTeam(int leagueId, Team team) throws ServiceException;
    List<Team> getTeams(int leagueId);
    Team getTeamByAbbreviation(String abbreviation);
}

