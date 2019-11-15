package Interface;

import java.io.Serializable;
import java.util.Iterator;

public interface Floor extends Serializable, Iterable<Space>{
    int getCountOnFloor();
    int getAreaFloor();
    int getRoomFloor();
    Space[] getArraySpace();
    Space getSpace(int index);
    void setSpace(int index, Space space);
    void addSpace(int index, Space space);
    void deleteSpace(int index);
    Space getBestSpace();
    Iterator<Space> iterator();
}
