package is.ru.honn.rufan.service;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Guðmundsdóttir
 * @date 22/9/2015.
 * @version 1.0
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
