import java.util.Objects;
/**
   A labeled point has x- and y-coordinates and a string label.
*/
public class LabeledPoint
{
   private int x;
   private int y;
   private String label;

   /**
      Constructs a labeled point.
      @param x the x-coordinate
      @param y the y-coordinate
      @param label the string label for the point.
   */
   public LabeledPoint(int x, int y, String label)
   {
      this.x = x;
      this.y = y;
      this.label = label;
   }

   /**
      Returns the hashcode for this object.
      @return the hashcode
   */
   public int hashCode()
   {
      int hC1 = label.hashCode();
      String h

   }

   /*
      Two labeled points considered the same when they
      have the same location and label.
      @param o the object to compare this to.
   */
   public boolean equals(Object o)
   {
      // Complete this method
      // See Section 9.5.2
      . . .


   }

   /**
      @return the label
   */
   public String getLabel()
   {
      . . .
   }

   /**
      @return the x-coordinate
   */
   public int getX()
   {
      . . .
   }

   /**
      @return the y-coordinate
   */
   public int getY()
   {
      . . .
   }

   @Override
   public String toString()
   {
      . . .
   }
}
