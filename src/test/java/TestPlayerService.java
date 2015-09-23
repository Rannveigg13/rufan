import is.ru.honn.rufan.domain.Player;
import is.ru.honn.rufan.service.PlayerService;
import is.ru.honn.rufan.service.ServiceException;
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

public class TestPlayerService extends TestCase {

    @Autowired
    private PlayerService playerService;

    @Before
    public void Setup()
    {
    }

    @Test
    public void testPlayer()
    {
        // Add player, first name, last name and teamid are required
        Player player0 = new Player(42, 0, "messi", "Messi");
        Player player1 = new Player(13, 1, "ronaldo", "Ronaldo");

        playerService.addPlayer(player0);
        int pos = playerService.addPlayer(player1);

        // Test if player 1 is the second entry in the players
        // list of the service
        assertEquals(2, pos+1);

        // Test if player1 exists
        Player testExistingPlayer = playerService.getPlayer(13);
        assertEquals(player1, testExistingPlayer);

        // Add player that fails
        Player player2 = new Player(5, null, "gunnar", "atlason");
        try{
            playerService.addPlayer(player2);
        }
        catch (Exception e){
            assertSame(ServiceException.class, e.getClass());
        }

        // Get player that exists
        Player playerNew = playerService.getPlayer(13);
        assertSame(playerNew, player1);

        // Get player that doesn't exist returns null
        Player playerFail = playerService.getPlayer(80085);
        assertSame(null, playerFail);

        // Test if adding an already existing player fails
        try
        {
            playerService.addPlayer(player1);
        }
        catch (Exception e)
        {
            assertSame(ServiceException.class, e.getClass());
        }
    }

}
