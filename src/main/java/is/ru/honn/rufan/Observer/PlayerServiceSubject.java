package is.ru.honn.rufan.Observer;

import is.ru.honn.rufan.domain.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hrafnkell Baldursson
 * @author Rannveig Guðmundsdóttir
 * @date 22/9/2015.
 * @version 1.0
 *
 *
 */
public class PlayerServiceSubject extends Subject {

    private Player newPlayer;

    @Override
    public Object getUpdateData(){
        return newPlayer;
    }

    @Override
    public void setUpdateData(Object newPlayer){
        this.newPlayer = (Player)newPlayer;
        notifyAllObservers();
    }
}
