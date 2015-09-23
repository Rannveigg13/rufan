package is.ru.honn.rufan.domain;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Gudmundsdottir
 * @version 1.0 22/9/2015.
 */
public class Position {
    private int positionId;
    private String name;
    private String abbreviation;
    private int sequence;

    /**
     * Constructor for position class
     * @param positionIdid ID of the position
     * @param name Name of the position
     * @param abbreviation Abbreviation of the position
     * @param sequence Sequence of the position
     */
    public Position(int positionIdid, String name, String abbreviation, int sequence){
        this.positionId = positionIdid;
        this.name = name;
        this.abbreviation = abbreviation;
        this.sequence = sequence;
    }

    /**
     * Gets the ID of the position
     * @return This positions ID
     */
    public  int getPositionId() { return positionId; }

    /**
     * Gets the name of the position
     * @return This positions name
     */
    public String getName() { return name; }

    /**
     * Gets the positions abbreviation
     * @return This positions abbreviation
     */
    public String getAbbreviation() { return abbreviation; }

    /**
     * Gets the positions sequence
     * @return This positions sequence
     */
    public int getSequence() { return sequence; }

    /**
     * Sets the ID of the position
     * @param positionId ID of the position
     */
    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    /**
     * Sets the name of the position
     * @param name Name of the position
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the abbreviation of the position
     * @param abbreviation Abbreviation of the position
     */
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    /**
     * Sets the sequence of the position
     * @param sequence Sequence of the position
     */
    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
}
