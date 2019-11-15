package Flat;
import Interface.Floor;
import Interface.Space;

import java.util.Iterator;

public class DwellingFloor implements Floor{
    Space[] masFlat;

    public DwellingFloor(int colAp) {
        masFlat = new Flat[colAp];
        for (int i = 0; i < masFlat.length; i++) {
            masFlat[i] = new Flat();
        }
    }

    public DwellingFloor(Space[] masFlat) {
        this.masFlat = masFlat;
    }

    public int getCountOnFloor() {
        return masFlat.length;
    }

    public int getAreaFloor() {
        int ar = 0;
        for (int i = 0; i < masFlat.length; i++) {
            ar += masFlat[i].getArea();
        }
        return ar;
    }

    public int getRoomFloor() {
        int r = 1;
        for (int i = 0; i < masFlat.length; i++) {
            r += masFlat[i].getRoom();
        }
        return r;
    }

    public Space[] getArraySpace() {
        return masFlat;
    }

    public Space getSpace(int i) {
        return masFlat[i];
    }

    public void setSpace(int i, Space kv) {
        masFlat[i] = kv;
    }

    public void addSpace(int index, Space newFlat) {
        Space[] arr = new Flat[masFlat.length + 1];
        for (int i = 0; i < index; i++) {
            arr[i] = masFlat[i];
        }
        arr[index] = newFlat;
        for (int i = index + 1; i < arr.length; i++) {
            arr[i] = masFlat[i-1];
        }
        masFlat = arr;
    }


    public void deleteSpace(int index) {
        Space[] arr = new Flat[getCountOnFloor() - 1];
        int k = 0;
        for (int i = 0; i < index; i++) {
                arr[i] = masFlat[i];
        }
        for (int i = index + 1; i < arr.length; i++) {
            arr[i] = masFlat[i];
        }
        masFlat = arr;
    }

    public Flat getBestSpace() {
        int maxArea = 0;
        int room = 0;
        for (int i = 0; i < masFlat.length; i++) {
            if (masFlat[i].getArea() > maxArea)
                maxArea = masFlat[i].getArea();
            room = masFlat[i].getRoom();
        }
        return new Flat(maxArea, room);
    }

    public Iterator<Space> iterator()
    {
         return new Iterator<>() {
                int count = 0;
            @Override
            public boolean hasNext() {
                return count < masFlat.length && masFlat.length != 0;
            }

            @Override
            public Space next() {
                return masFlat[count++];
            }
        };
    }
}
