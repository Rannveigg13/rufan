package is.ru.honn.rufan.process;

import is.ru.honn.rufan.domain.League;
import is.ru.honn.rufan.domain.Team;
import is.ru.honn.rufan.reader.*;
import is.ru.honn.rufan.service.TeamService;
import is.ru.honn.rufan.service.TeamServiceStub;
import is.ruframework.process.RuAbstractProcess;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import java.util.ArrayList;


/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Guðmundsdóttir
 * @date 22/9/2015.
 * @version 1.0
 */
public class TeamImportProcess extends RuAbstractProcess implements ReadHandler
{
    protected int count;
    protected League league;
    protected Reader teamReader;
    protected TeamService teamService;
    protected ReaderFactory readerFactory;
    private ProcessMessagePrinter printer;

    public void read(int count, Object object) {
        this.count = count;
        teamService.addTeam(league.getLeagueId(), (Team) object);
    }

    @Override
    public void startProcess() {
        printer.printMessage("processstart");
        try{
            league = (League) teamReader.read();
        }
        catch(ReaderException e){
            printer.logSevere("teamReader read error");
            printer.logSevere(e.getMessage());
        }
    }

    @Override
    public void beforeProcess() {
        // Getting teamService
        ApplicationContext serviceResource = new FileSystemXmlApplicationContext("classpath:service.xml");
        teamService = (TeamServiceStub) serviceResource.getBean("teamService");

        // Getting a reader from a readerfactory
        readerFactory = new ReaderFactory();
        teamReader = readerFactory.getReader("teamReader");
        teamReader.setReadHandler(this);
        teamReader.setURI(getProcessContext().getImportURL());

        printer = new ProcessMessagePrinter(this.getClass().getName(), getProcessContext().getProcessName());
        printer.printMessage("processbefore");
    }

    @Override
    public void afterProcess() {

        printer.printMessage("processstartdone", count);

        ArrayList<Team> teams = (ArrayList<Team>) teamService.getTeams(league.getLeagueId());
        for(Team t : teams){
            System.out.println("Team: " + t.getDisplayName() + ", Abbr: " + t.getAbbreviation());
        }
    }


}
