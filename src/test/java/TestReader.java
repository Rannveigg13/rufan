import is.ru.honn.rufan.domain.Player;
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

public class TestReader extends TestCase {

    Logger log = Logger.getLogger(TestPlayerService.class.getName());

    @Autowired
    private ReaderFactory readerFactory;

    private AbstractReader abstractReader;


    @Before
    public void Setup()
    {
        /*abstractReader = new AbstractReader() {
            public Object parse(String content) {

            }
        };*/
    }

    @Test
    public void testReader()
    {
        Reader reader;

        // Test if faulty input returns null
        reader = readerFactory.getReader("nonExistant");
        assertNull(reader);

        // Test if factory reads xml correctly for team reader
        reader = readerFactory.getReader("teamReader");
        assertNotNull(reader);
        assertSame(reader.getClass(), TeamReader.class);

        // Test if factory reads xml correctly for player reader
        reader = readerFactory.getReader("playerReader");
        assertNotNull(reader);
        assertSame(reader.getClass(), PlayerReader.class);

        // Make a fake read handler
        ReadHandler readHandler = new ReadHandler() {
            public void read(int count, Object object) {

            }
        };

        reader.setReadHandler(readHandler);

        //Test exception if uri is wrong
        reader.setURI("http://test.jamaica/user.json");
        try {
            reader.read();
        }
        catch(Exception e){
            assertSame(ReaderFileException.class, e.getClass());
            String[] segments = e.getMessage().split(" ");
            log.info("File " + segments[0] + " not found from " + segments[1]);
        }

        //Test exception if handler is not set
        reader.setURI("http://olafurandri.com/honn/players.json");
        reader.setReadHandler(null);
        try{
            reader.read();
        }
        catch(Exception e){
            assertSame(ReaderException.class, e.getClass());
            log.info(e.getMessage());
        }


        // Check the number of lines read matches with file
        reader.setReadHandler(readHandler);
        ArrayList<Player> players = new ArrayList<Player>();
        try{
            players = (ArrayList<Player>) reader.read();
        }
        catch(Exception e){
            log.info(e.getMessage());
        }

        assertEquals(582, players.size());
    }

}
