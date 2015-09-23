package is.ru.honn.rufan.domain;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Guðmundsdóttir
 * @date 22/9/2015.
 * @version 1.0
 */
public class Player {

    protected int playerId;
    protected int teamId;
    protected String firstName;
    protected String lastName;
    protected int height;
    protected int weight;
    protected Date birthDate;
    protected Country nationality;
    protected List<Position> positions = new ArrayList<Position>();

    public int getPlayerId() { return playerId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getHeight() { return height; }
    public int getWeight() { return weight; }
    public Date getBirthDate() { return birthDate; }
    public Country getNationality() { return nationality ; }
    public  int getTeamId() { return  teamId; }
    public List<Position> getPositions() { return positions; }

    public void setPlayerId(int playerId) { this.playerId = playerId; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setHeight(int height) { this.height = height; }

    public void setWeight(int weight) { this.weight = weight; }

    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

    public void setNationality(Country nationality) { this.nationality = nationality; }

    public void setTeamId(int teamId) { this.teamId = teamId; }

    public void setPositions(List<Position> positions) { this.positions = positions; }

    public void addPosition(Position position) {
        if(position != null){
            positions.add(position);
        }
    }
}
