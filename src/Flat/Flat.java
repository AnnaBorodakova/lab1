package Flat;

import Interface.Space;

public class Flat implements Space {
    private final int constArea = 50;
    private final int colRoom = 2;
    private int area;
    private int room;

    public Flat() {
        area = constArea;
        room = colRoom;
    }

    public Flat(int area) {
        this.area = area;
        room = colRoom;
    }

    public Flat(int area, int room) {
        this.area = area;
        this.room = room;
    }

    @Override
    public int getRoom() {
        return room;
    }

    @Override
    public void setRoom(int value) {
        room = value;
    }
    @Override
    public int getArea() {
        return area;
    }
    @Override
    public void setArea(int value) {
        area = value;
    }
}
