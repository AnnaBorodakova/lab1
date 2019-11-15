package Office;

import Interface.*;

public class OfficeFactory implements BuildingFactory {
    public Space createSpace(int area){
        return new Office(area);
    }
    public Space createSpace(int roomsCount, int area){
        return new Office(area, roomsCount);
    }
    public Floor createFloor(int spacesCount)
    {
        return new OfficeFloor(spacesCount);
    }
    public Floor createFloor(Space[] spaces){
        return new OfficeFloor(spaces);
    }
    public Building createBuilding(int floorsCount, int[] spacesCounts){
        return new OfficeBuilding(floorsCount,spacesCounts);
    }
    public Building createBuilding(Floor[] floors){
        return new OfficeBuilding(floors);
    }
}
