
public class RectangleTester
{
    public static void main(String [] args)
    {
        BetterRectangle rect = new BetterRectangle (10,10,100,90);
        System.out.println("Perimeter: " + rect.getPerimeter());
        System.out.println("Area: " + rect.getArea());
    }
}
