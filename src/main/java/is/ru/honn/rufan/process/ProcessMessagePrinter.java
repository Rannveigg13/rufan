package is.ru.honn.rufan.process;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Locale;
import java.util.logging.Logger;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Guðmundsdóttir
 * @date 22/9/2015.
 * @version 1.0
 *
 * A custom print class which handles all logging for process classes
 */
public class ProcessMessagePrinter {
    private Logger log;
    private MessageSource msg;
    private Locale localeIS;
    private String processName;

    /***
     * The constructor for the class.
     * @param className The name of the class to log information about
     */
    public ProcessMessagePrinter(String className, String processName){
        ApplicationContext appResource = new FileSystemXmlApplicationContext("classpath:app.xml");
        localeIS = new Locale("is", "IS");
        this.processName = processName;
        this.log = Logger.getLogger(className);
        this.msg = (MessageSource) appResource.getBean("messageSource");
    }

    public void printMessage(String messageId){
        boolean idMatches = ((messageId.equals("processbefore"))
                            ||(messageId.equals("processstart"))
                            ||(messageId.equals("processreaderror")));
        if(idMatches){
            log.info(msg.getMessage(messageId, new Object[]{processName}, Locale.ENGLISH));
            log.info(msg.getMessage(messageId, new Object[]{processName}, localeIS));
        }
    }

    public void printMessage(String messageId, int size){
        if(messageId.equals("processstartdone") ){
            log.info(msg.getMessage(messageId, new Object[]{size}, Locale.ENGLISH));
            log.info(msg.getMessage(messageId, new Object[]{size}, localeIS));
        }
    }

    public void logSevere(String message){
        log.severe(message);
    }
}
