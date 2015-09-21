package is.ru.honn.rufan.service;

/**
 * Created by Notandi on 21-Sep-15.
 */
public class ServiceException extends RuntimeException
{
    public ServiceException(){super();}

    public ServiceException(String message) {super(message);}

    public ServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
