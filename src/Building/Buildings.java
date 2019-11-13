package Building;

import Interface.*;
import Office.*;

import java.io.*;

public class Buildings {

    public static void outputBuilding (Building building, OutputStream out) throws IOException
    {
        DataOutputStream stream = new DataOutputStream(out);
        stream.writeInt(building.getCountFloor());
        for(int i = 0; i < building.getCountFloor(); i++)
        {
            stream.writeInt(building.getFloor(i).getCountOnFloor());
            for(int j = 0; j < building.getFloor(i).getCountOnFloor(); j++)
            {
                stream.writeInt(building.getFloor(i).getSpace(j).getArea());
                stream.writeInt(building.getFloor(i).getSpace(j).getRoom());
            }
        }
        stream.close();
    }
    //чтения данных о здании из байтового потока
    public static Building inputBuilding (InputStream in) throws IOException{
        DataInputStream stream = new DataInputStream(in);
        int count = stream.readInt();//считываем количество этажей в здании
        Floor[] array = new Floor[count];
        for (int i = 0; i < array.length; i++)
        {
           int countSpace = stream.readInt();//считываем количество квартир на этаже
            Space[] spaces = new Space[countSpace];
            for (int j = 0; j < countSpace; j++)
            {
                spaces[j] = new Office(stream.readInt(),stream.readInt());
            }
            array[i] = new OfficeFloor(spaces);
        }
        stream.close();
        return new OfficeBuilding(array);
    }

    public static void writeBuilding (Building building, Writer out) throws IOException
    {
        PrintWriter stream = new PrintWriter(out);
        stream.println(building.getCountFloor());
        for(int i = 0; i < building.getCountFloor(); i++)
        {
            stream.println(building.getFloor(i).getCountOnFloor());
            for(int j = 0; j < building.getFloor(i).getCountOnFloor(); j++)
            {
                stream.println(building.getFloor(i).getSpace(j).getArea());
                stream.println(building.getFloor(i).getSpace(j).getRoom());
            }
        }
        stream.flush();
    }

    public static Building readBuilding (Reader in) throws IOException
    {
        StreamTokenizer token = new StreamTokenizer(in);
        token.nextToken();
        int count = (int)token.nval;//считываем количество этажей в здании
        Floor[] array = new Floor[count];
        for (int i = 0; i < array.length; i++)
        {
            token.nextToken();
            int countSpace = (int)token.nval;//считываем количество квартир на этаже
            Space[] spaces = new Space[countSpace];
            for (int j = 0; j < countSpace; j++)
            {
                token.nextToken();
                int area = (int)token.nval;
                token.nextToken();
                int room = (int)token.nval;
                spaces[j] = new Office(area,room);
            }
            array[i] = new OfficeFloor(spaces);
        }
        return new OfficeBuilding(array);
    }

    public static void serilizeBuild(Building building, OutputStream out) throws IOException
    {
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(building);
    }

    public static Building deserilizeBuild(InputStream in) throws IOException, ClassNotFoundException
    {
        ObjectInputStream ois = new ObjectInputStream(in);
       return (Building) ois.readObject();
    }
}

