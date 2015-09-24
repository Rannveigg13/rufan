import is.ru.honn.rufan.domain.Player;
import is.ru.honn.rufan.observer.Observer;
import is.ru.honn.rufan.observer.PlayerServiceObserver;
import is.ru.honn.rufan.observer.PlayerServiceSubject;
import is.ru.honn.rufan.reader.*;
import is.ru.honn.rufan.service.PlayerService;
import is.ru.honn.rufan.service.ServiceException;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Created by Hrafnkell on 23/9/2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-test-stub.xml")

public class TestObserver extends TestCase {

    Logger log = Logger.getLogger(TestPlayerService.class.getName());

    @Autowired
    private PlayerService playerService;
    @Autowired
    private PlayerServiceObserver observer;



    @Before
    public void Setup()
    {
    }

    @Test
    public void testObserver()
    {
       PlayerServiceSubject subject = (PlayerServiceSubject) playerService.getSubject();
        playerService.addObserver();

        ArrayList<Observer> observers = (ArrayList<Observer>)subject.getObservers();
        assertEquals(1, observers.size());

        // Add player, first name, last name and teamid are required
        Player player0 = new Player(333, 0, "333", "three");
        Player player1 = new Player(444, 1, "444", "four");

        playerService.addPlayer(player0);
        assertSame(subject.getUpdateData(), player0);

        playerService.addPlayer(player1);
        assertSame(subject.getUpdateData(), player1);

    }

}
