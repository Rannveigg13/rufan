package is.ru.honn.rufan.reader;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Gudmundsdottir
 * @version 1.0 22/9/2015.
 */
public class ReaderFileException extends ReaderException {

    public ReaderFileException()
    {
        super();
    }

    public ReaderFileException(String message)
    {
        super(message);
    }

    public ReaderFileException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
