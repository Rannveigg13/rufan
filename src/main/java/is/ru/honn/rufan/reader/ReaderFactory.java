package is.ru.honn.rufan.reader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Gudmundsdottir
 * @version 1.0 22/9/2015.
 *
 * This class represents the Reader Factory
 */
public class ReaderFactory {
    /***
     * Gets the appropriate reader associated with the given input
     * @param reader The type of reader to get
     * @return A reader class of the type asked for
     */
    public Reader getReader(String reader){
        ApplicationContext misterBean = new FileSystemXmlApplicationContext("classpath:reader.xml");
        if(reader.equals("playerReader")) {return (PlayerReader) misterBean.getBean(reader);}
        if(reader.equals("teamReader")){return (TeamReader) misterBean.getBean(reader);}
        return null;
    }
}
