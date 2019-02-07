import java.util.Scanner;

public class RectangleCalculator
{
    
    private double width;
    private double height;
    public RectangleCalculator(double height, double width)
    {
        this.width = width;
        this.height = height;
    }

  
    public double getArea()
    {
        return this.width * this.height;
    }
    public double getPerimeter()
    {
        return this.width*2 + this.height * 2;
    }
    public double getDiagonalLength()
    {
        return Math.sqrt(this.width*this.width + this.height*this.height);
    }
    public String toString()
    {
        String stringHeight = Double.toString(height);
        String stringWidth = Double.toString(width);
        String stringPerimeter = Double.toString(getPerimeter());
        String stringArea = Double.toString(getArea());
        String stringDiagonalLength = Double.toString(getDiagonalLength());
        return "height: " + stringHeight + "; width: " + stringWidth + "; area: " + stringArea + "; perimeter: "+ stringPerimeter+ "; diagonal length: " + stringDiagonalLength;
    }
    
    public static void main( String [] args)
    {
      Scanner s = new Scanner(System.in);
      System.out.print ("Enter the height: ");
      double x = s.nextDouble();
      System.out.print ("Enter the width: ");
      double y = s.nextDouble();
      RectangleCalculator rect = new RectangleCalculator(x,y);
      System.out.println (rect.toString());

    }
}
