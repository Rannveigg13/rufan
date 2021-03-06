package is.ru.honn.rufan.observer;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Gudmundsdottir
 * @version 1.0 22/9/2015.
 *
 * This interface represents an observer which is subscribed to a subject.
 * It gets notified when the subject's data it's subscribed to changes.
 */
public interface ObserverInterface {
    /***
     * The function that is called to notify the observer
     * of a change on the subjects side. The implemented
     */
    void update();
}
