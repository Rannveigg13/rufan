package is.ru.honn.rufan.process;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Locale;
import java.util.logging.Logger;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Gudmundsdottir
 * @version 1.0 22/9/2015.
 *
 * A custom print class which handles all logging for process classes.
 */
public class ProcessMessageLogger {

    /** The logger for the printer */
    private Logger log;

    /** The message source for the printer to get messages from */
    private MessageSource msg;

    /** A custom locale for the icelandic language messages */
    private Locale localeIS;

    /** The name for the process that this printer is logging for */
    private String processName;

    /***
     * The constructor for the class.
     * Sets all member variables needed for this printer
     * @param className The name of the class to log information about
     * @param processName The name of the process to log information about
     */
    public ProcessMessageLogger(String className, String processName){
        ApplicationContext appResource = new FileSystemXmlApplicationContext("classpath:app.xml");
        localeIS = new Locale("is", "IS");
        this.processName = processName;
        this.log = Logger.getLogger(className);
        this.msg = (MessageSource) appResource.getBean("messageSource");
    }

    /**
     * This method logs info messages for the given messageId.
     * @param messageId "processbefore", "processstart" and "processreaderror"
     */
    public void logMessage(String messageId){
        boolean idMatches = ((messageId.equals("processbefore"))
                            ||(messageId.equals("processstart")));
        if(idMatches){
            log.info(msg.getMessage(messageId, new Object[]{processName}, Locale.ENGLISH));
            log.info(msg.getMessage(messageId, new Object[]{processName}, localeIS));
        }
    }

    /**
     * This method logs a severe info message for
     * a file error that was caught.
     * @param fileName The name of the file that failed reading.
     */
    public void logFileError(String fileName, String origin){
        logSevere(msg.getMessage("processreaderror", new Object[]{fileName, origin}, Locale.ENGLISH));
        logSevere(msg.getMessage("processreaderror", new Object[]{fileName, origin}, localeIS));
    }

    public void logMessage(String messageId, int size){
        if(messageId.equals("processstartdone") ){
            log.info(msg.getMessage(messageId, new Object[]{size}, Locale.ENGLISH));
            log.info(msg.getMessage(messageId, new Object[]{size}, localeIS));
        }
    }

    public void logSevere(String message){
        log.severe(message);
    }
}
