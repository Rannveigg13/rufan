package is.ru.honn.rufan.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Guðmundsdóttir
 * @date 22/9/2015.
 * @version 1.0
 *
 * This abstract class represents a subject which observers
 * subscribe to. It notifies observers when the data it holds changes.
 */
public abstract class Subject {

    /**
     * A list of observers that are subscribed to the subject
     */
    protected List<Observer> observers = new ArrayList<Observer>();

    /**
     * Adds or subscribes an observer to the subject
     * @param obs The observer to add/subscribe to the subject
     */
    public void addObserver(Observer obs){
        observers.add(obs);
    }

    /**
     * This function should provide the observer with the
     * new data that has been added by the subject
     * @return The updated data that the subject has to provide to his observers
     */
    public abstract Object getUpdateData();

    /**
     * This function should be called by the service that the subject
     * is portraying. This will provide the updated data to the subject.
     * The implemented function should call the "notifyAllObservers()" function
     * after the data has been updated
     * @param o The updated object
     */
    public abstract void setUpdateData(Object o);

    /**
     * This function notifies each observer that is subscribed
     * to this subject
     */
    public void notifyAllObservers(){
        for(Observer o : observers){
            o.update();
        }
    }
}
