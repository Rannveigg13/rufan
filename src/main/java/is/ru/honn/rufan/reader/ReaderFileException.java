package is.ru.honn.rufan.reader;

/**
 * Created by Hrafnkell on 23/9/2015.
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
