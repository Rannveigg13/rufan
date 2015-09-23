package is.ru.honn.rufan.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Gudmundsdottir
 * @version 1.0 22/9/2015.
 *
 * This abstract class represents a subject which observers
 * subscribe to. It notifies observers when the data it holds changes.
 */
public abstract class Subject implements SubjectInterface {

    /**
     * A list of observers that are subscribed to the subject.
     */
    protected List<Observer> observers = new ArrayList<Observer>();

    /**
     * Registers/subscribes an observer to the subject.
     * @param obs The observer to register/subscribe to the subject.
     */
    public void registerObserver(Observer obs){
        observers.add(obs);
    }

    /**
     * Removes/unsubscribes an observer from the subject.
     * @param obs The observer to remove/unsubscribe from the subject.
     */
    public void removeObserver(Observer obs){
        observers.remove(obs);
    }

    /**
     * This function should provide the observer with the
     * new data that has been added by the subject.
     * @return The updated data that the subject has to provide to his observers.
     */
    public abstract Object getUpdateData();

    /**
     * This function should be called by the service that the subject
     * is portraying. This will provide the updated data to the subject.
     * The "notifyObservers()" function should be called by this function
     * when it is being implemented, after the data has been updated.
     * @param o The updated object.
     */
    public abstract void setUpdateData(Object o);

    /**
     * This function notifies each observer that is subscribed
     * of a change on the subjects data.
     */
    public void notifyObservers(){
        for(Observer o : observers){
            o.update();
        }
    }
}
