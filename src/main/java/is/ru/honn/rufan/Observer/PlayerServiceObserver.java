package is.ru.honn.rufan.Observer;

import is.ru.honn.rufan.domain.Player;

import java.util.logging.Logger;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Guðmundsdóttir
 * @date 22/9/2015.
 * @version 1.0
 *
 * This class represents an observer that observes a player service
 */
public class PlayerServiceObserver extends Observer {

    // The logger
    private Logger log = Logger.getLogger(Observer.class.getName());

    /***
     * The constructor for a PlayerServiceObserver.
     * @param subject The subject to observe
     */
    public PlayerServiceObserver(Subject subject){
        this.subject = subject;
        this.subject.addObserver(this);
    }

    /***
     * Logs a message for this Observer, containing the full name of the player
     * that has been added by the Subject
     */
    @Override
    public void update() {
        Player newest = (Player) subject.getUpdateData();
        logUpdateMessage(newest);
    }

    private void logUpdateMessage(Player newest){
        log.info("New player added: " + newest.getFirstName() + " " + newest.getLastName());
    }
}
