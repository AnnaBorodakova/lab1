package Building;

import Exception.*;
import Interface.*;

public class PlacementExchanger {

    public static boolean checkSpace(Space object1, Space object2) {
        if (object1.getArea() == object2.getArea() && object1.getRoom() == object2.getRoom()) {
            return true;
        } else return false;
    }

    public static boolean checkFloor(Floor object1, Floor object2) {
        if (object1.getAreaFloor() == object2.getAreaFloor() && object1.getCountOnFloor() == object2.getCountOnFloor()) {
            return true;
        } else return false;
    }

    public static void exchangeFloorRooms(Floor floor1, int index1, Floor floor2, int index2) throws  InexchangeableSpacesException {
        if(index1 < 0 || index1 >= floor1.getCountOnFloor() || index2 < 0 || index2 >= floor2.getCountOnFloor()){ throw new SpaceIndexOutOfBoundsException();}
        if(!checkSpace(floor1.getSpace(index1), floor2.getSpace(index2))){throw new InexchangeableSpacesException();}
        else {
            Space temp = floor1.getSpace(index1);
            floor1.setSpace(index1, floor2.getSpace(index2));
            floor2.setSpace(index2, temp);
        }
    }

    public static void  exchangeBuildingFloors(Building building1, int index1, Building building2, int index2) throws InexchangeableFloorsException{
        if(index1 < 0 || index1 >= building1.getCountFloor() || index2 < 0 || index2 >= building2.getCountFloor()){ throw new FloorIndexOutOfBoundsException();}
        if(!checkFloor(building1.getFloor(index1),building2.getFloor(index2))){throw new InexchangeableFloorsException();}
        else {
            Floor temp = building1.getFloor(index1);
            building1.setFloor(index1, building2.getFloor(index2));
            building2.setFloor(index2, temp);
        }
    }
}
