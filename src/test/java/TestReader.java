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

/**
 * Created by Hrafnkell on 23/9/2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-test-stub.xml")

public class TestReader extends TestCase {

    private Reader playerReader;
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

        // Getting a reader from a reader factory
        /*ReaderFactory readerFactory = new ReaderFactory();
        playerReader = readerFactory.getReader("playerReader");
        playerReader.setReadHandler(this);
        playerReader.setURI(getProcessContext().getImportURL());*/


    }

}
