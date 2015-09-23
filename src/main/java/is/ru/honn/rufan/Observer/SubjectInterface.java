package is.ru.honn.rufan.Observer;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Gudmundsdottir
 * @version 1.0 22/9/2015.
 *
 * This inteface represents a subject which observers
 * subscribe to. It notifies observers when the data it holds changes.
 */
public interface SubjectInterface {
    /**
     * Registers/subscribes an observer to the subject.
     * @param o The observer to register/subscribe to the subject.
     */
    void registerObserver(Observer o);

    /**
     * Removes/unsubscribes an observer from the subject.
     * @param o The observer to remove/unsubscribe from the subject.
     */
    void removeObserver(Observer o);

    /**
     * This function notifies each observer that is subscribed
     * of a change on the subjects data.
     */
    void notifyObservers();
}
