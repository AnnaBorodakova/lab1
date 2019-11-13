package Office;

import Exception.InvalidRoomsCountException;
import Exception.InvalidSpaceAreaException;
import Interface.Space;

import java.io.Serializable;

public class Office implements Space, Serializable {
    private final int constArea = 250;
    private final int colRoom = 1;
    private int area;
    private int room;

    public Office()
    {
        area = constArea;
        room = colRoom;
    }

    public Office(int area)
    {
        if(area <= 0) throw new InvalidSpaceAreaException();
        this.area = area;
        room = colRoom;
    }

    public Office(int area, int room)
    {
        if (area <= 0) new InvalidSpaceAreaException();
        if (room <= 0) new InvalidRoomsCountException();
        this.area = area;
        this.room = room;
    }
    @Override
    public int getRoom()
    {
        return room;
    }
    @Override
    public void setRoom(int col)
    {
        if (col <= 0) throw new InvalidRoomsCountException();
        room = col;
    }
    @Override
    public int getArea()
    {
        return area;
    }
    @Override
    public void setArea(int ar)
    {
        if (area <= 0) throw new InvalidSpaceAreaException();
        area = ar;
    }
}
