package is.ru.honn.rufan.reader;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Guðmundsdóttir
 * @date 22/9/2015.
 * @version 1.0
 */
public interface Reader {
    Object read() throws ReaderException;
    Object parse(String content);
    void setURI(String URI);
    void setReadHandler(ReadHandler readerHandler);
}
