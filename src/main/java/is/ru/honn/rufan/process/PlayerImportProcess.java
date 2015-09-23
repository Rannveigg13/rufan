package is.ru.honn.rufan.process;

import is.ru.honn.rufan.domain.Player;
import is.ru.honn.rufan.reader.*;
import is.ru.honn.rufan.service.PlayerService;
import is.ru.honn.rufan.service.PlayerServiceStub;
import is.ruframework.process.RuAbstractProcess;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import java.util.ArrayList;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Guðmundsdóttir
 * @date 22/9/2015.
 * @version 1.0
 */
public class PlayerImportProcess extends RuAbstractProcess implements ReadHandler
{
    protected Reader playerReader;
    protected PlayerService playerService;
    protected ReaderFactory readerFactory;
    protected int count;
    private ArrayList<Player> players;
    private ProcessMessagePrinter printer;

    public void read(int count, Object object) {
        this.count = count;
        playerService.addPlayer((Player) object);
    }

    @Override
    public void startProcess() {
        printer.printMessage("processstart");
        try{
            players = ((ArrayList<Player>) playerReader.read());
        }
        catch(ReaderException e){
            printer.printMessage("processreaderror");
            printer.logSevere("playerReader read error");
            printer.logSevere(e.getMessage());
        }
    }

    @Override
    public void beforeProcess() {
        // Getting playerService
        ApplicationContext serviceResource = new FileSystemXmlApplicationContext("classpath:service.xml");
        playerService = (PlayerServiceStub) serviceResource.getBean("playerService");

        // Getting a reader from a readerfactory
        readerFactory = new ReaderFactory();
        playerReader = readerFactory.getReader("playerReader");
        playerReader.setReadHandler(this);
        playerReader.setURI(getProcessContext().getImportURL());

        printer = new ProcessMessagePrinter(this.getClass().getName(), getProcessContext().getProcessName());
        printer.printMessage("processbefore");
    }

    @Override
    public void afterProcess() {
        printer.printMessage("processstartdone", players.size());
    }
}
