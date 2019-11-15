package Office;

import Exception.FloorIndexOutOfBoundsException;
import Exception.SpaceIndexOutOfBoundsException;
import Interface.*;

import java.io.Serializable;
import java.util.Iterator;

public class OfficeBuilding implements Building, Serializable {

    private static class Node implements Serializable{
        private Floor data;
        private Node next;
        private Node prev;

        public Node(Floor data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node head;

    private void addNode(int index, Floor floor) {
        if (index == 0) {
            Node newNode = new Node(floor, head, head);
            head.next = newNode;
            head.prev = newNode;
        } else {
            Node host = getNode(index - 1);
            if (host.next == head) {
                Node newNode = new Node(floor, head, host);
                host.next = newNode;
                head.prev = newNode;
            } else {
                Node newNode = new Node(floor, host.next, host);
                host.next.prev = newNode;
                host.next = newNode;
            }
        }
    }

    private Node getNode(int index) {
        if (index == 0) {
            return head.next;
        } else {
            Node host = head.next;
            int i = 0;
            while (index != i) {
                host = host.next;
                i++;
            }
            return host;
        }
    }

    public void delNode(int index) {
        if (getCountAllBuilding() == 0) throw new FloorIndexOutOfBoundsException();
        int number = 0;
        Node host = head;
        while (number < index) {
            host = host.next;
            number++;
        }
        host.next = host.next.next;
        host.next.prev = host;
    }

    public OfficeBuilding(int countFloor, int countOfficeFloor[]) {
        head = new Node(null, null, null);
        head.next = head;
        head.prev = head;
        OfficeFloor[] arr = new OfficeFloor[countFloor];
        for (int i = 0; i < countOfficeFloor.length; i++) {
            arr[i] = new OfficeFloor(countOfficeFloor[i]);
            addNode(i, arr[i]);
        }
    }

    public OfficeBuilding(Floor[] floors) {
        head = new Node(null, null, null);
        head.next = head;
        head.prev = head;
        for (int i = 0; i < floors.length; i++) {
            addNode(i, floors[i]);
        }
    }

    public int getCountFloor() {
        Node host = head;
        int count = 0;
        while (host.next != head) {
            count++;
            host = host.next;
        }
        return count;
    }

    public int getCountAllBuilding() {
        Node host = head;
        int count = 0;
        while (host.next != head) {
            host = host.next;
            count += host.data.getCountOnFloor();
        }
        return count;
    }

    public int getCountAreaBuilding() {
        Node host = head;
        int count = 0;
        while (host.next != head) {
            host = host.next;
            count += host.data.getAreaFloor();
        }
        return count;
    }

    public int getCountRoomBuilding() {
        Node host = head;
        int count = 0;
        while (host.next != head) {
            host = host.next;
            count += host.data.getRoomFloor();
        }
        return count;
    }

    public Floor[] getArrayFloor() {
        Floor[] arr = new OfficeFloor[getCountFloor()];
        Node host = head.next;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = host.data;
            host = host.next;
        }
        return arr;
    }

    public Floor getFloor(int index) {
        if (index < 0 || index >= getCountFloor()) {
            throw new FloorIndexOutOfBoundsException();
        }
        return getNode(index).data;
    }

    public void setFloor(int index, Floor floor) {
        if (index < 0 || index >= getCountFloor()) {
            throw new FloorIndexOutOfBoundsException();
        }
        getNode(index).data = floor;
    }

    public Space getSpaceBuilding(int index) {
        if (index < 0 || index >= getCountAllBuilding()) throw new SpaceIndexOutOfBoundsException();
        Node host = head.next;
        while (index - host.data.getCountOnFloor() >= 0) {
            index -= host.data.getCountOnFloor();
            host = host.next;
        }
        return host.data.getSpace(index);
    }

    public void setSpaceBuilding(int index, Space office) {
        if (index < 0 || index >= getCountAllBuilding()) throw new SpaceIndexOutOfBoundsException();
        Node host = head.next;
        while (index - host.data.getCountOnFloor() >= 0) {
            index -= host.data.getCountOnFloor();
            host = host.next;
        }
        host.data.setSpace(index, office);
    }

    public void addSpaceBuilding(int index, Space office) {
        if (index < 0 || index >= getCountAllBuilding() + 1) throw new SpaceIndexOutOfBoundsException();
        Node host = head.next;
        while (index - host.data.getCountOnFloor() > 0) {
            index -= host.data.getCountOnFloor();
            host = host.next;
        }
        host.data.addSpace(index, office);
    }

    public void delSpaceBuilding(int index) {
        if (index < 0 || index >= getCountAllBuilding()) throw new SpaceIndexOutOfBoundsException();
        Node host = head.next;
        while (index - host.data.getCountOnFloor() >= 0) {
            index -= host.data.getCountOnFloor();
            host = host.next;
        }
        host.data.deleteSpace(index);
    }

    public Space getBestSpace() {
        Space office = head.next.data.getBestSpace();
        Node host = head.next;
        while(host.next != head) {
            if (office.getArea() < host.next.data.getBestSpace().getArea())
                office = host.next.data.getBestSpace();
            host = host.next;
        }
        return office;
    }

    public void sort() {
        Space[] arr = new Office[getCountAllBuilding()];
        int index = 0;
        Node host = head.next;
        while (host != head) {
            int i = host.data.getCountOnFloor();
            int k = 0;
            while (i > 0) {
                arr[index] = host.data.getSpace(k);
                k++;
                i--;
                index++;
            }
            host = host.next;
        }
        Space temp = null;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j].getArea() < arr[j + 1].getArea()) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].getArea());
        }
    }

    public Iterator<Floor> iterator()
    {
        return new Iterator<Floor>() {
            Node temp = head;
            int count = 0;
            @Override
            public boolean hasNext() {
                return count < getCountFloor() && temp.next != head;
            }

            @Override
            public Floor next() {
                count++;
                return (temp = temp.next).data;
            }
        };
    }
}
