import is.ru.honn.rufan.domain.Player;
import is.ru.honn.rufan.domain.Team;
import is.ru.honn.rufan.service.PlayerService;
import is.ru.honn.rufan.service.ServiceException;
import is.ru.honn.rufan.service.TeamService;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Hrafnkell on 23/9/2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-test-stub.xml")

public class TestTeamService extends TestCase {

    @Autowired
    private TeamService teamService;

    @Before
    public void Setup()
    {
    }

    @Test
    public void testTeam()
    {
        Team team0 = new Team(0, "LOL", "Lollerpool");
        teamService.addTeam(1337, team0);

        // Adding team and checking if it was added
        Team testIfExists = teamService.getTeamByAbbreviation("LOL");
        assertEquals(team0, testIfExists);

        // Add team that fails
        Team team1 = new Team(1, "FAIL", null);
        try{
            teamService.addTeam(1337, team1);
        }
        catch(Exception e){
            assertSame(ServiceException.class, e.getClass());
        }

        // Add team that does not have leagueId
        Team team2 = new Team(2, "LEET", "Elites");
        try{
            teamService.addTeam(null, team2);
        }
        catch(Exception e){
            assertSame(ServiceException.class, e.getClass());
        }

        // Get team that does not exist
        Team nonExistingTeam = teamService.getTeamByAbbreviation("NULL");
        assertEquals(null, nonExistingTeam);
    }

}
