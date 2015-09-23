package is.ru.honn.rufan.observer;

import is.ru.honn.rufan.domain.Player;

import java.util.logging.Logger;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Gudmundsdottir
 * @version 1.0 22/9/2015.
 *
 * This class represents a PlayerService observer that observes
 * a PlayerService subject.
 */
public class PlayerServiceObserver extends Observer {

    /** The logger that logs changes for this observer. */
    private Logger log = Logger.getLogger(Observer.class.getName());

    public PlayerServiceObserver(){}

    /**
     * The constructor for a PlayerServiceObserver.
     * @param subject The subject to observe.
     */
    public PlayerServiceObserver(Subject subject){
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    /**
     * This method notifies this observer that a new player
     * has been added to the subject.
     */
    @Override
    public void update() {
        Player newest = (Player) subject.getUpdateData();
        logUpdateMessage(newest);
    }

    /**
     * Logs a message for this PlayerService observer,
     * containing the full name of the player that has been
     * added to the PlayerService subject.
     */
    private void logUpdateMessage(Player newest){
        log.info("New player added to PlayerService subject: " + newest.getFirstName() + " " + newest.getLastName());
    }
}
