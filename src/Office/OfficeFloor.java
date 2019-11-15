package Office;

import Exception.SpaceIndexOutOfBoundsException;
import Interface.Floor;
import Interface.Space;

import java.io.Serializable;
import java.util.Iterator;

public class OfficeFloor implements Floor, Serializable {

    private static class Node implements Serializable{ //вложенный класс, реализующий узел ОЦС
        private Node next;
        private Space data;

        public Node(Space data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;

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

    private void addNode(int index, Space office) {
        if (index == 0) {
            Node newNode = new Node(office, head);
            head.next = newNode;
        }
        else {
            Node host = getNode(index - 1);
            if (host.next == head) {
                Node newNode = new Node(office, head);
                host.next = newNode;
            } else {
                Node newNode = new Node(office, host.next);
                host.next = newNode;
            }
        }
    }

    private void deleteNode(int index) {
        int number = 0;
        Node host = head;
        while (number < index) {
            host = host.next;
            number++;
        }
        host.next = host.next.next;
    }

    public OfficeFloor(int countOffice) {
        head = new Node(null, null);
        head.next = head;
        for (int i = 0; i < countOffice; i++) {
            addNode(i, new Office());
        }
    }

    public OfficeFloor(Space[] offices) {
        head = new Node(null, null);
        head.next = head;
        for (int i = 0; i < offices.length; i++) {
            addNode(i, offices[i]);
        }
    }

    public int getCountOnFloor() {
        Node host = head;
        int count = 0;
        while (host.next != head) {
            count++;
            host = host.next;
        }
        return count;
    }

    public int getAreaFloor() {
        Node host = head;
        int sum = 0;
        while (host.next != head) {
            host = host.next;
            sum += host.data.getArea();
        }
        return sum;
    }

    public int getRoomFloor() {
        Node host = head;
        int sum = 0;
        while (host.next != head) {
            host = host.next;
            sum += host.data.getRoom();
        }
        return sum;
    }

    public Space[] getArraySpace() {
        Space[] arr = new Office[getCountOnFloor()];
        Node host = head.next;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = host.data;
            host = host.next;
        }
        return arr;
    }

    public Space getSpace(int index) {
        if (index < 0 || index > getCountOnFloor()) throw new SpaceIndexOutOfBoundsException();
        return getNode(index).data;
    }

    public void setSpace(int index, Space data) {
        if (index < 0 || index > getCountOnFloor()) throw new SpaceIndexOutOfBoundsException();
        getNode(index).data = data;
    }

    public void addSpace(int index, Space data) {
        if (index < 0 || index > getCountOnFloor()) throw new SpaceIndexOutOfBoundsException();
        addNode(index, data);
    }

    public void deleteSpace(int index) {
        if (index < 0 || index > getCountOnFloor()) {throw new SpaceIndexOutOfBoundsException();}
        deleteNode(index);
    }

    public Space getBestSpace() {
        Space office = head.next.data;
        for (Node host = head.next; host != head; host = host.next) {
            if (office.getArea() < host.data.getArea())
                office = host.data;
        }
        return office;
    }

    public Iterator<Space> iterator()
    {
        return new Iterator<Space>() {
            Node temp = head;
            int count = 0;
            @Override
            public boolean hasNext() {
                return count < getCountOnFloor() && temp.next != head;
            }

            @Override
            public Space next() {
                count++;
                return (temp = temp.next).data;
            }
        };
    }
}
