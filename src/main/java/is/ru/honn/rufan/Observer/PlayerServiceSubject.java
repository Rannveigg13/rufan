package is.ru.honn.rufan.Observer;

import is.ru.honn.rufan.domain.Player;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Gudmundsdottir
 * @version 1.0 22/9/2015.
 *
 * This class represents a PlayerService subject which observers
 * subscribe to. It notifies observers when a new player is added to the service.
 */
public class PlayerServiceSubject extends Subject {

    /** The newest player that has been added to the service. */
    private Player newPlayer;

    /**
     * This method gets the newest player that has
     * been added to the PlayerService. It should be called by each
     * observer so that he can see the newly updated player.
     * @return The newest player that has been added to the service.
     */
    @Override
    public Object getUpdateData(){
        return newPlayer;
    }

    /**
     * This method sets the newest player that has
     * been added to the PlayerService. It then notifies each
     * observer of a change to the subject. It should be called
     * by the PlayerService when it has added a new player.
     * @param newPlayer The new player that has been added by the service.
     */
    @Override
    public void setUpdateData(Object newPlayer){
        this.newPlayer = (Player)newPlayer;
        notifyObservers();
    }
}
