package Interface;

import java.io.Serializable;

public interface Floor extends Serializable {
    int getCountOnFloor();
    int getAreaFloor();
    int getRoomFloor();
    Space[] getArraySpace();
    Space getSpace(int index);
    void setSpace(int index, Space space);
    void addSpace(int index, Space space);
    void deleteSpace(int index);
    Space getBestSpace();
   // java.util.Iterator iterator();
}
