package is.ru.honn.rufan.Observer;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Gudmundsdottir
 * @version 1.0 22/9/2015.
 *
 * This abstract class represents an observer which is subscribed
 * to a subject
 */
public abstract class Observer implements ObserverInterface {
    /***
     * The subject that the observer is subscribed to
     */
    protected Subject subject;

    /***
     * The function that is called to notify the observer
     * of a change on the subjects side. The implemented
     * function should display some kind of update message.
     */
    public abstract void update();
}
