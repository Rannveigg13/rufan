package is.ru.honn.rufan.reader;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Gudmundsdottir
 * @version 1.0 22/9/2015.
 */
public interface Reader {
    Object read() throws ReaderException;
    Object parse(String content);
    void setURI(String URI);
    void setReadHandler(ReadHandler readerHandler);
}
