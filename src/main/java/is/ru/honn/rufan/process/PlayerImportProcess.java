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
 * @author Rannveig Gudmundsdottir
 * @version 1.0 22/9/2015.
 *
 * This class represents a process which imports Player
 * objects and logs them.
 */
public class PlayerImportProcess extends RuAbstractProcess implements ReadHandler
{
    /** The reader for this process */
    private Reader playerReader;

    /** The player service for this process */
    private PlayerService playerService;

    /** The array list of players for this process */
    private ArrayList<Player> players;

    /** The printer for this process. Handles all logging */
    private ProcessMessageLogger logger;

    /**
     * This method adds a single player to the player service.
     * @param count The number of the player.
     * @param object The object that has to be read.
     */
    public void read(int count, Object object) {
        playerService.addPlayer((Player) object);
    }

    /**
     * This method calls the player reader to make it read
     * all of the players to be added to the player service
     */
    @Override
    public void startProcess() {

        // Log information about that the process has started
        logger.logMessage("processstart");

        try{
            // Read all players and store them in an array list
            players = ((ArrayList<Player>) playerReader.read());
        }
        catch(ReaderFileException e){
            // If a reader file exception is caught, display an
            // error message with the file name and origin of the file
            // which are split by whitespace in the message
            String[] segments = e.getMessage().split(" ");
            logger.logFileError(segments[0], segments[1]);
        }
        catch(ReaderException e){
            // If a reader exception is caught, display an error message
            logger.logSevere(e.getMessage());
        }

    }

    /**
     * This method sets up all member variables needed
     * for the process.
     */
    @Override
    public void beforeProcess() {

        // Getting playerService
        ApplicationContext serviceResource = new FileSystemXmlApplicationContext("classpath:service.xml");
        playerService = (PlayerServiceStub) serviceResource.getBean("playerService");

        // Getting a reader from a reader factory
        ReaderFactory readerFactory = new ReaderFactory();
        playerReader = readerFactory.getReader("playerReader");
        playerReader.setReadHandler(this);
        playerReader.setURI(getProcessContext().getImportURL());

        // Log information about the process
        logger = new ProcessMessageLogger(this.getClass().getName(), getProcessContext().getProcessName());
        logger.logMessage("processbefore");
    }

    /**
     * This method calls the printer to log information
     * about the number of players successfully read.
     */
    @Override
    public void afterProcess() {
        if(players != null){
            logger.logMessage("processstartdone", players.size());
        }
    }
}
