package Interface;

import java.io.Serializable;

public interface Space extends Serializable {
    int getRoom();
    void setRoom(int value);
    int getArea();
    void setArea(int value);
}
