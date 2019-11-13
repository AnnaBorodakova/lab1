package Flat.Hotel;
import Interface.Space;
import Flat.DwellingFloor;

public class HotelFloor extends DwellingFloor {
    private int stars;
    private static final int STARCONST = 1;

    public HotelFloor(int countSpace)
    {
        super(countSpace);
        stars = STARCONST;
    }

    public HotelFloor(Space[] arr)
    {
        super(arr);
        stars = STARCONST;
    }

    public int getCountStars()
    {
        return stars;
    }

    public void setCountStars(int stars)
    {
        this.stars = stars;
    }
}
