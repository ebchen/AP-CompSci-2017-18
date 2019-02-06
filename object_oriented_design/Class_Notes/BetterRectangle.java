import java.awt.Rectangle;

public class BetterRectangle extends Rectangle
{
    
    public BetterRectangle(int x, int y, int height, int width)
    {
       super.setLocation(x,y);
       super.setSize(height, width);
    }
    
    public int getPerimeter()
    {
       int width = (int)(getWidth());
       int height = (int)(getHeight());
       return 2*height + 2*width;
    }
    
    public int getArea()
    {
        int width = (int)(getWidth());
       int height = (int)(getHeight());
       return height*width;
    }

}
