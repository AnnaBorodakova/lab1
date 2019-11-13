package Flat;

import Interface.*;

public class Dwelling implements Building{
    Floor[] masFloor; //массив этажей

    public Dwelling(int colFloor, int[] masColApFloor) {
        for(int i = 0; i < masFloor.length; i++)
        {
            masFloor[i] = new DwellingFloor(masColApFloor[i]);
        }
    }

    public Dwelling(Floor[] masFloor) {
        this.masFloor = masFloor;
    }

    public int getCountFloor() {
        return masFloor.length;
    }

    public int getCountAllBuilding() {
        int count = 0;
        for (int i = 0; i < getCountFloor(); i++) {
            count += masFloor[i].getCountOnFloor();
        }
        return count;
    }

    public int getCountAreaBuilding() {
        int area = 0;
        for (int i = 0; i < getCountFloor(); i++) {
            area += masFloor[i].getAreaFloor();
        }
        return area;
    }

    public int getCountRoomBuilding() {
        int room = 0;
        for (int i = 0; i < getCountFloor(); i++) {
            room += masFloor[i].getRoomFloor();
        }
        return room;
    }

    public Floor[] getArrayFloor() {
        return masFloor;
    }

    public Floor getFloor(int i) {
        return masFloor[i];
    }

    public void setFloor(int i, Floor floor) {
        masFloor[i] = floor;
    }

    public Space getSpaceBuilding(int index) {
        int numberFlat = index;
        int i = 0;
        while (numberFlat - masFloor[i].getCountOnFloor() >= 0) {
            numberFlat -= masFloor[i].getCountOnFloor();
            i++;
        }
        return masFloor[i].getSpace(numberFlat);
    }

    public void setSpaceBuilding(int index, Space kv) {
        int numberFlat = index;
        int i = 0;
        while (numberFlat - masFloor[i].getCountOnFloor() >= 0) {
            numberFlat -= masFloor[i].getCountOnFloor();
            i++;
        }
        masFloor[i].setSpace(numberFlat, new Flat());
    }

    public void addSpaceBuilding(int index, Space newFlat) {
        int numberFlat = index;
        int i = 0;
        while (numberFlat - masFloor[i].getCountOnFloor() > 0) {
            numberFlat -= masFloor[i].getCountOnFloor();
            i++;
        }
        masFloor[i].addSpace(numberFlat, newFlat);
    }

    public void delSpaceBuilding(int index) {
        int numberFlat = 0;
        for(int i =0; i < masFloor.length; i++)
           for(int j = 0; j<masFloor[i].getCountOnFloor();j++)
           {
               if(numberFlat == index) {
                   masFloor[i].deleteSpace(j);
                   return;
               }
               numberFlat++;
           }

    }

    public Space getBestSpace() {
        int maxArea = 0;
        int room = 0;
        Space flat;
        for (int i = 0; i < masFloor.length; i++) {
            flat = masFloor[i].getBestSpace();
            if (flat.getArea() > maxArea) {
                maxArea = flat.getArea();
                room = flat.getRoom();
            }
        }
        return new Flat(maxArea, room);
    }
    public void Print(Space[] arr)
    {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].getArea());
        }
    }
    public void sort() {
        int index = 0;
        Space[] arr = new Flat[getCountAllBuilding()];
        for (int i = 0; i < masFloor.length; i++) {
            for (int j = 0; j < masFloor[i].getCountOnFloor(); j++) {
                arr[index] = masFloor[i].getSpace(j);
                index++;
            }
        }
        Space temp = null;
        int isSorted = 0;
        while(isSorted < arr.length) {
            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i].getArea() > arr[i + 1].getArea()) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isSorted++;
                }
            }
        }
        Print(arr);
    }
}

