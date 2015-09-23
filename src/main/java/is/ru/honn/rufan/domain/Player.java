package is.ru.honn.rufan.domain;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Gudmundsdottir
 * @version 1.0 22/9/2015.
 */
public class Player {

    protected int playerId;
    protected Integer teamId;
    protected String firstName;
    protected String lastName;
    protected int height;
    protected int weight;
    protected Date birthDate;
    protected Country nationality;
    protected List<Position> positions = new ArrayList<Position>();

    public Player(){}

    public Player(int playerId, Integer teamId, String firstName, String lastName){
        this.teamId = teamId;
        this.playerId = playerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    /**
     * Gets the player ID
     * @return This player's ID
     */
    public int getPlayerId() { return playerId; }

    /**
     * Gets the players first name
     * @return This players first name
     */
    public String getFirstName() { return firstName; }

    /**
     * Gets the players last name
     * @return This players last name
     */
    public String getLastName() { return lastName; }

    /**
     * Gets the players height
     * @return This players height
     */
    public int getHeight() { return height; }

    /**
     * Gets the players weight
     * @return This players weight
     */
    public int getWeight() { return weight; }

    /**
     * Gets the players birthdate
     * @return This players birthdate
     */
    public Date getBirthDate() { return birthDate; }

    /**
     * Gets the players nationality
     * @return This players nationality
     */
    public Country getNationality() { return nationality ; }

    /**
     * Gets the players team ID
     * @return This players team ID
     */
    public Integer getTeamId() { return  teamId; }

    /**
     * Gets the players position
     * @return This players position
     */
    public List<Position> getPositions() { return positions; }

    /**
     * Sets the players ID
     * @param playerId ID of the player
     */
    public void setPlayerId(int playerId) { this.playerId = playerId; }

    /**
     * Sets the players first name
     * @param firstName First name of the player
     */
    public void setFirstName(String firstName) { this.firstName = firstName; }

    /**
     * Sets the players last name
     * @param lastName Last name of the player
     */
    public void setLastName(String lastName) { this.lastName = lastName; }

    /**
     * Sets the players height
     * @param height Height of the player
     */
    public void setHeight(int height) { this.height = height; }

    /**
     * Sets the players weight
     * @param weight Weight of the player
     */
    public void setWeight(int weight) { this.weight = weight; }

    /**
     * Sets the players birthdate
     * @param birthDate Birthdate of the player
     */
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

    /**
     * Sets the players nationality
     * @param nationality Nationality of the player
     */
    public void setNationality(Country nationality) { this.nationality = nationality; }

    /**
     * Sets the players team ID
     * @param teamId ID of the players team
     */
    public void setTeamId(int teamId) { this.teamId = teamId; }

    /**
     * Sets the players positions
     * @param positions Positions of the player
     */
    public void setPositions(List<Position> positions) { this.positions = positions; }

    /**
     * Adds a player's position to a list of positions
     * @param position The player's position to be added
     */
    public void addPosition(Position position) {
        if(position != null){
            positions.add(position);
        }
    }
}
