package is.ru.honn.rufan.domain;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Guðmundsdóttir
 * @date 22/9/2015.
 * @version 1.0
 */
public class Position {
    private int positionId;
    private String name;
    private String abbreviation;
    private int sequence;

    public Position(int positionIdid, String name, String abbreviation, int sequence){
        this.positionId = positionIdid;
        this.name = name;
        this.abbreviation = abbreviation;
        this.sequence = sequence;
    }

    public  int getPositionId() { return positionId; }

    public String getName() { return name; }

    public String getAbbreviation() { return abbreviation; }

    public int getSequence() { return sequence; }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
}
