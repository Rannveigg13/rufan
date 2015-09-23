package is.ru.honn.rufan.Observer;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Guðmundsdóttir
 * @date 22/9/2015.
 * @version 1.0
 *
 * This abstract class represents an observer which is subscribed
 * to a subject
 */
public abstract  class Observer {
    /***
     * The subject that the observer is subscribed to
     */
    protected Subject subject;

    /***
     * The function that is called to notify the observer
     * of a change on the subjects side
     */
    public abstract void update();
}
