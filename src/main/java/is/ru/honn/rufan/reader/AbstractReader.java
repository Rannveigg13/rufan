package is.ru.honn.rufan.reader;

import org.json.simple.JSONObject;

import javax.ws.rs.ProcessingException;
import java.net.URI;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Gudmundsdottir
 * @version 1.0 22/9/2015.
 */
abstract public class AbstractReader implements Reader {

    ReadHandler readHandler;
    private String uri;

    public Object read() throws ReaderException{

        if(readHandler == null){
            throw new ReaderException("readHandler must be set");
        }

        String json = "";
        try{
            json = new ClientRequest().getRequest(uri);
        }
        catch(ProcessingException e){
            String[] segments = uri.split("/");
            String fileName = segments[segments.length-1];
            String origin = "http://";
            for(int i = 2; i < segments.length-1; i++){
                origin += segments[i] + "/";
            }
            throw new ReaderFileException(fileName + " " + origin);
        }

        return parse(json);
    }

    public void setURI(String URI){
        this.uri = URI;
    }

    public void setReadHandler(ReadHandler _readHandler){
        this.readHandler = _readHandler;
    }

    protected int getInt(JSONObject jParent, String name)
    {
        if(jParent == null)
            return 0;
        Long value = (Long)jParent.get(name);
        if(value == null)
            return 0;
        return value.intValue();
    }

    protected Date newDate(int year, int month, int date)
    {
        Calendar cal = new GregorianCalendar();
        cal.set(year, month, date);
        return cal.getTime();
    }

    // Format example 2015-08-21T16:19:30.6967613Z
    protected Date convertDate(String strDate)
    {
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd'T'HH:mm:ss", Locale.ENGLISH);
        Date date = null;

        try
        {
            date = format.parse(strDate);
        }
        catch (ParseException e)
        {
            System.out.println("FAIL");
        }
        return date;
    }
}
