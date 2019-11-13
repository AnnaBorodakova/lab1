package Building;

import Office.*;
import Flat.*;
import Interface.*;
import Exception.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InexchangeableFloorsException, InexchangeableSpacesException {
        // write your code here
        Office f1 = new Office();
        Office f2 = new Office(45);
        Office f3 = new Office(80, 3);
        Office f4 = new Office(400, 3);
        OfficeFloor df1 = new OfficeFloor(5);
        OfficeFloor df2 = new OfficeFloor(new Office[]{f1, f2, f3, f4});
        OfficeBuilding ob1 = new OfficeBuilding(new OfficeFloor[]{df1, df2});


        //методы 4 лабораторной
        /*
        PlacementExchanger.exchangeFloorRooms(df1,0,df2, 0);

        Buildings.outputBuilding(ob1, new FileOutputStream("1"));
        Building officeBuilding = Buildings.inputBuilding(new FileInputStream("1"));
        System.out.println(officeBuilding.getCountFloor());
        System.out.println(officeBuilding.getCountAllBuilding());
        System.out.println(officeBuilding.getCountRoomBuilding());
        System.out.println(officeBuilding.getBestSpace().getArea());

        Buildings.writeBuilding(ob1, new FileWriter("1"));
        Building officeBuilding1 = Buildings.readBuilding(new FileReader("1"));
        System.out.println(officeBuilding1.getCountFloor());
        System.out.println(officeBuilding1.getCountAllBuilding());
        System.out.println(officeBuilding1.getCountRoomBuilding());
        System.out.println(officeBuilding1.getBestSpace().getArea());

        Building officeBuilding2 = Buildings.readBuilding(new InputStreamReader(System.in));
        Buildings.writeBuilding(officeBuilding2, new OutputStreamWriter(System.out));
        System.out.println(officeBuilding2.getCountFloor());
        System.out.println(officeBuilding2.getCountAllBuilding());
        System.out.println(officeBuilding2.getCountRoomBuilding());
        System.out.println(officeBuilding2.getBestSpace().getArea());

        Buildings.serilizeBuild(ob1, new FileOutputStream("2"));
        Building officeBuilding3 = Buildings.deserilizeBuild(new FileInputStream("2"));
        System.out.println(officeBuilding3.getCountFloor());
        System.out.println(officeBuilding3.getCountAllBuilding());
        System.out.println(officeBuilding3.getCountRoomBuilding());
        System.out.println(officeBuilding3.getBestSpace().getArea());*/
        //методы 3 лабораторной работы
        /* System.out.println(df2.getAreaFloor());
        System.out.println(df2.getCountOnFloor());
        System.out.println(df2.getRoomFloor());
        System.out.println(df2.getSpace(1).getArea());
        System.out.println(df2.getBestSpace().getArea());
        System.out.println("Отсортированный по убыванию массив:");
        ob1.sort();
        System.out.println("Количество квартир в здании: " + ob2.getCountAllBuilding());
        System.out.println(ob2.getCountAreaBuilding());
        ob1.setSpaceBuilding(7, new Office(88, 3));
        ob1.addSpaceBuilding(9, new Flat(33, 3)); //добавление квартиры в список офисов
        ob1.delSpaceBuilding(5);
        System.out.println(ob1.getSpaceBuilding(6).getArea());
        System.out.println(ob1.getSpaceBuilding(8).getArea());
        System.out.println(ob1.getBestSpace().getArea());*/
        //методы 2 лабораторной работы
        /*Flat f1 = new Flat();
        Flat f2 = new Flat(45);
        Flat f3 = new Flat(80, 3);
        Flat f4 = new Flat(75, 3);
        /*DwellingFloor df1 = new DwellingFloor(new Flat[]{f1, f2, f3});
        DwellingFloor df2 = new DwellingFloor(new Flat[]{f4, f5});
        DwellingFloor df3 = new DwellingFloor(new Flat[]{f6, f7});
        Dwelling d = new Dwelling(new DwellingFloor[]{df1, df2, df3});
        System.out.println("Общая площадь квартир на этаже 1: " + df1.getFullArea());
        System.out.println("Общее количество комнат на этаже 1: " + df1.getColRoom());
        d.deleteFlatBuild(6);
        System.out.println("Квартира на этаже с максимальной площадью на 1 этаже: " + df1.getBestSpace().getArea() + " комнаты - " + df1.getBestSpace().getRoom());
        System.out.println("Квартира на этаже с максимальной площадью в доме: " + d.getBestSpace().getArea() + " комнаты - " + d.getBestSpace().getRoom());
        System.out.println("Получение квартиры под номером 4 : " + d.getFlatBuild(4).getArea() + " комнаты - " + d.getFlatBuild(4).getRoom());
        df2.addFlat(1, new Flat(58, 5));
        System.out.println("Получение квартиры под номером 2 на втором этаже : " + df2.getFlat(1).getArea() + " комнаты - " + df2.getFlat(1).getRoom());
        d.addFlat(6, new Flat(100, 3));
        System.out.println("Получение квартиры под номером 8 : " + d.getFlatBuild(6).getArea() + " комнаты - " + d.getFlatBuild(6).getRoom());
        d.setFlatBuild(4, new Flat());
        System.out.println("Получение изменённой квартиры под номером 4 : " + d.getFlatBuild(4).getArea() + " комнаты - " + d.getFlatBuild(4).getRoom());

        System.out.println("Сортировка массива по убыванию:");
        d.sort();*/
    }
}
