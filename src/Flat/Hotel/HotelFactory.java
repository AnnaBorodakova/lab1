package Flat.Hotel;

import Flat.Flat;
import Interface.*;

public class HotelFactory implements BuildingFactory {

    public Space createSpace(int area) {
        return new Flat(area);
    }

    public Space createSpace(int roomsCount, int area) {
        return new Flat(area, roomsCount);
    }

    public Floor createFloor(int spacesCount) {
        return new HotelFloor(spacesCount);
    }

    public Floor createFloor(Space[] spaces) {
        return new HotelFloor(spaces);
    }

    public Building createBuilding(int floorsCount, int[] spacesCounts) {
        return new Hotel(floorsCount, spacesCounts);
    }

    public Building createBuilding(Floor[] floors) {
        return new Hotel(floors);
    }
}
