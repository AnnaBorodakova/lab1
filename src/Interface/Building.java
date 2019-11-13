package Interface;

import Interface.Floor;
import java.io.Serializable;

public interface Building  extends Serializable {
    int getCountFloor();
    int getCountAllBuilding();
    int getCountAreaBuilding();
    int getCountRoomBuilding();
    Floor[] getArrayFloor();
    Floor getFloor(int index);
    void setFloor(int index, Floor floor);
    Space getSpaceBuilding(int index);
    void setSpaceBuilding(int index, Space space);
    void addSpaceBuilding(int index, Space space);
    Space getBestSpace();
    void sort();
   // java.util.Iterator iterator();
}
