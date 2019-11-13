package Flat.Hotel;

import Flat.Dwelling;
import Interface.*;
public class Hotel extends Dwelling {

    public Hotel(int countFloor, int[] arrCountApFloor){
        super(countFloor,arrCountApFloor);
    }

    public Hotel(Floor[] arr)
    {
        super(arr);
    }

    public int getCountStarsAllHotel()
    {
        int countStars = 0;
        for (int i = 0; i < getCountFloor(); i++)
        {
            if(getFloor(i) instanceof HotelFloor) {
                if (((HotelFloor) getFloor(i)).getCountStars() > ((HotelFloor) getFloor(i + 1)).getCountStars())
                    countStars = ((HotelFloor) getFloor(i)).getCountStars();
            }
        }
        return countStars;
    }

    public Space getBestSpace()
    {
        double bestArea = 0;
        Space bestSpace = null;
        double[] coeff = new double[]{0.25, 0.5, 1, 1.25, 1.5};
        for(int i = 0; i < getCountFloor(); i++)
        {
            if (getFloor(i) instanceof HotelFloor)
            {
                for(int j = 0; j < getFloor(i).getCountOnFloor(); j++)
                {
                    if (bestArea < (getFloor(i).getSpace(j).getArea() *coeff[i]))
                    {
                        bestArea = getFloor(i).getSpace(j).getArea() *coeff[i];
                        bestSpace = getFloor(i).getSpace(j);
                    }
                }
            }
        }
        return bestSpace;
    }
}
