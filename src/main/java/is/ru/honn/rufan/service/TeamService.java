package is.ru.honn.rufan.service;

import is.ru.honn.rufan.domain.Team;

import java.util.List;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Gudmundsdottir
 * @version 1.0 22/9/2015.
 *
 * This class represents an interface for Team Service
 */
public interface TeamService
{
    int addTeam(Integer leagueId, Team team) throws ServiceException;
    List<Team> getTeams(int leagueId);
    Team getTeamByAbbreviation(String abbreviation);
}

