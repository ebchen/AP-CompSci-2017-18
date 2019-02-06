import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments 
     */
    public Picture ()
    {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor 
         */
        super();  
    }

    /**
     * Constructor that takes a file name and creates the picture 
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName)
    {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     * @param height the height of the desired picture
     * @param width the width of the desired picture
     */
    public Picture(int height, int width)
    {
        // let the parent class handle this width and height
        super(width,height);
    }

    /**
     * Constructor that takes a picture and creates a 
     * copy of that picture
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture)
    {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image)
    {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////

    /**
     * Method to return a string with information about this picture.
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString()
    {
        String output = "Picture, filename " + getFileName() + 
            " height " + getHeight() 
            + " width " + getWidth();
        return output;

    }

    /** Method to set the blue to 0 */
    public void zeroBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setBlue(0);
            }
        }
    }

    public void keepOnlyBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setRed(0);
                pixelObj.setGreen(0);
            }
        }
    }

    public void negate()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setRed(255-pixelObj.getRed());
                pixelObj.setGreen(255-pixelObj.getGreen());
                pixelObj.setBlue(255-pixelObj.getBlue());
            }
        }
    }

    public void grayscale()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                int average = (pixelObj.getRed()+pixelObj.getBlue()+pixelObj.getGreen())/3;
                pixelObj.setRed(average);
                pixelObj.setGreen(average);
                pixelObj.setBlue(average);
            }
        }
    }

    public void fixUnderwater()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                if (pixelObj.getRed() > 30)
                {

                    pixelObj.setRed(pixelObj.getRed()+100);
                }
                if (pixelObj.getBlue()<155)
                {
                    pixelObj.setBlue(pixelObj.getBlue()/2);
                }
            }
        }
    }

    /** Method that mirrors the picture around a 
     * vertical mirror in the center of the picture
     * from left to right */
    public void mirrorVertical()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        } 
    }

    public void mirrorVerticalRightToLeft()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                leftPixel.setColor(rightPixel.getColor());
            }
        }
    }

    public void mirrorHorizontal()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int width = pixels[0].length;
        int height = pixels.length;
        for (int row = 0; row < pixels.length/2; row++)
        {
            for (int col = 0; col < width; col++)
            {
                topPixel = pixels[row][col];
                bottomPixel = pixels[height - 1 - row][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }

    public void mirrorHorizontalBotToTop()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int width = pixels[0].length;
        int height = pixels.length;
        for (int row = 0; row < pixels.length/2; row++)
        {
            for (int col = 0; col < width; col++)
            {
                topPixel = pixels[row][col];
                bottomPixel = pixels[height - 1 - row][col];
                topPixel.setColor(bottomPixel.getColor());
            }
        }
    }

    public void mirrorDiagonalBotToTop()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel bottomLeftPixel = null;
        Pixel topRightPixel = null;
        int width = pixels[0].length;
        int height = pixels.length;
        int min;
        if (width< height ) min = width;
        else min = height;

        for (int col = 0; col < min; col++)
        {
            for (int row = col; row < min; row++)
            {
                bottomLeftPixel = pixels[row][col];
                topRightPixel = pixels[col][row];
                topRightPixel.setColor(bottomLeftPixel.getColor());
            }
        }
    }

    public void mirrorDiagonalTopToBot()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel bottomLeftPixel = null;
        Pixel topRightPixel = null;
        int width = pixels[0].length;
        int height = pixels.length;
        int min;
        if (width< height ) min = width;
        else min = height;

        for (int col = 0; col < min; col++)
        {
            for (int row = col; row < min; row++)
            {
                bottomLeftPixel = pixels[row][col];
                topRightPixel = pixels[col][row];
                bottomLeftPixel.setColor(topRightPixel.getColor());
            }
        }
    }
    
    /** Mirror just part of a picture of a temple */
    public void mirrorTemple()
    {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 27; row < 97; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 13; col < mirrorPoint; col++)
            {

                leftPixel = pixels[row][col];      
                rightPixel = pixels[row]                       
                [mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
                count++;
            }
        }

        System.out.println("Count: " + count);
    }

    public void mirrorGull()
    {
        int mirrorPoint = 346;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 231; row < 327; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 233; col < mirrorPoint; col++)
            {

                leftPixel = pixels[row][col];      
                rightPixel = pixels[row]                       
                [mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
                count++;
            }
        }

        System.out.println("Count: " + count);
    }

    public void mirrorArms()
    {
        int mirrorPoint = 190;
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 156; row < mirrorPoint; row++)
        {
            for (int col = 96; col < 170; col++)
            {
                topPixel = pixels[row][col];      
                bottomPixel = pixels[mirrorPoint + mirrorPoint-row][col];
                bottomPixel.setColor(topPixel.getColor());
                count++;
            }
        }

        for (int row = 168; row < mirrorPoint; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 238; col < 295; col++)
            {

                topPixel = pixels[row][col];      
                bottomPixel = pixels[mirrorPoint * 2 - row][col];
                bottomPixel.setColor(topPixel.getColor());
                count++;
            }
        }
    }

    /** copy from the passed fromPic to the
     * specified startRow and startCol in the
     * current picture
     * @param fromPic the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
    public void copy(Picture fromPic, 
    int startRow, int startCol)
    {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = 0, toRow = startRow; 
        fromRow < fromPixels.length &&
        toRow < toPixels.length; 
        fromRow++, toRow++)
        {
            for (int fromCol = 0, toCol = startCol; 
            fromCol < fromPixels[0].length &&
            toCol < toPixels[0].length;  
            fromCol++, toCol++)
            {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }   
    }

    /** Method to create a collage of several pictures */
    public void createCollage()
    {
        Picture flower1 = new Picture("flower1.jpg");
        Picture flower2 = new Picture("flower2.jpg");
        this.copy(flower1,0,0);
        this.copy(flower2,100,0);
        this.copy(flower1,200,0);
        Picture flowerNoBlue = new Picture(flower2);
        flowerNoBlue.zeroBlue();
        this.copy(flowerNoBlue,300,0);
        this.copy(flower1,400,0);
        this.copy(flower2,500,0);
        this.mirrorVertical();
        this.write("collage.jpg");
    }

    /** Method to show large changes in color 
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection(int edgeDist)
    {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; 
            col < pixels[0].length-1; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col+1];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) > 
                edgeDist)
                    leftPixel.setColor(Color.BLACK);
                else
                    leftPixel.setColor(Color.WHITE);
            }
        }
    }

    void cropAndCopy( Picture sourcePicture, int startSourceRow, int endSourceRow, int startSourceCol, int endSourceCol,
    int startDestRow, int startDestCol )
    {
        Pixel sourcePixel = null;
        Pixel replacedPixel = null;
        Pixel[][] sourcePixels = sourcePicture.getPixels2D();
        Pixel[][] replacedPixels = this.getPixels2D();
        int rowDiff = startDestRow - startSourceRow;
        int colDiff = startDestCol - 
            startSourceCol;
        int height = endSourceRow - startSourceRow;
        int width = endSourceCol - startSourceCol;
        for (int destRow = startDestRow; destRow < startDestRow + height; destRow++)
        {
            for (int destColumn = startDestCol; destColumn < startDestCol + width; destColumn++)
            {
                replacedPixels[destRow][destColumn].setColor(sourcePixels[destRow - rowDiff][destColumn-colDiff].getColor());

            }
        }

    }

    Picture scaleByHalf()
    {
        Pixel[][] pixels = this.getPixels2D();
        int height = pixels.length;
        int width = pixels[0].length;
        Picture smallPicture = new Picture(height/2, width/2);
        Pixel[][] halfSize = smallPicture.getPixels2D();
        for (int row = 0; row < halfSize.length; row++)
        {
            for (int col = 0; col < halfSize[0].length; col ++)
            {
                halfSize[row][col].setColor(pixels[row*2][col*2].getColor());
            }
        }
        return smallPicture;
    }

    Picture scaleToSize(int height, int width)
    {
        Pixel[][] pixels = this.getPixels2D();
        int ogHeight = pixels.length;
        int ogWidth = pixels[0].length;
        double heightScale = (double)height/ogHeight;
        double widthScale = (double)width/ogWidth;

        Picture smallPicture = new Picture(height, width);
        Pixel[][] smallSize = smallPicture.getPixels2D();
        for (int row = 0; row < smallSize.length; row++)
        {
            for (int col = 0; col < smallSize[0].length; col ++)
            {

                smallSize[row][col].setColor(pixels[(int)(row/heightScale)][(int)(col/widthScale)].getColor());
            }
        }
        return smallPicture;
    }

    Picture mosaic(Picture block)
    {
        int bigSize = 500;
        int smallSize = 10;
        Picture mosaic = this.scaleToSize(bigSize,bigSize);
        Pixel[][] pixels = mosaic.getPixels2D();
        Picture b  = block.scaleToSize(smallSize,smallSize);
        Pixel[][] bs = b.getPixels2D();

        for (int i = 0; i < bigSize; i+=smallSize)
        {
            for (int j = 0; j < bigSize; j+=smallSize)
            {

                float[]a = new float[3];
                float hueSum = 0;
                float[] list = new float[3];
                for (int k = 0; k < smallSize; k++)
                {
                    for (int l = 0; l < smallSize; l++)
                    {
                        if (i+k < bigSize && j+l < bigSize)
                        {
                            Color color = pixels[i+k][j+l].getColor();
                            list = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), list);
                            hueSum += list[0];
                        }
                    }
                }
                float hue = hueSum/(smallSize*smallSize);

                for (int k = 0; k < smallSize; k++)
                {
                    for (int l = 0; l < smallSize; l++)
                    {
                        if (i+k < bigSize && j+l < bigSize)
                        {
                            Color bsColor = bs[k][l].getColor();
                            float[] hsbList = new float[3];
                            hsbList = Color.RGBtoHSB(bsColor.getRed(), bsColor.getGreen(), bsColor.getBlue(), hsbList);

                            pixels[i+k][j+l].setColor(Color.getHSBColor(hue, hsbList[1], hsbList[2]));
                        }
                    }
                }
            }
        }
        return mosaic;
    }

    public void sepia()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                if (pixelObj.getRed() < 60)
                {
                    pixelObj.setRed((int)((double)pixelObj.getRed()*.9));
                    pixelObj.setGreen((int)((double)pixelObj.getGreen()*.9));
                    pixelObj.setBlue((int)((double)pixelObj.getBlue()*.9));
                }
                else if (pixelObj.getRed()<190)
                {
                    pixelObj.setBlue((int)((double)pixelObj.getBlue()*.8));
                }
                else
                {
                    pixelObj.setBlue((int)((double)pixelObj.getBlue()*.9));
                }
            }
        }
    }

    public void makeCircles()
    {

        Pixel[][]pixels = this.getPixels2D();
        int height = pixels.length;
        int width = pixels[0].length;
        int blockSide = 5;
        for (int i = 0; i < height; i+=blockSide)
        {
            for (int j = 0; j < width; j+=blockSide)
            {
                double radius = (double)(blockSide-1)/2;
                for (int k = 0; k < blockSide; k++)
                {
                    for (int l = 0; l < blockSide; l++)
                    {
                        double centerX = (double)blockSide/2;
                        double centerY = (double)blockSide/2;
                        double diffX = centerX - l;
                        double diffY = centerY - k;
                        double distance = Math.sqrt(diffX * diffX + diffY*diffY);

                        if (distance > radius)
                        //if (!((k>=1 && k <=blockSide-2 )&&(l>=1 && l<=blockSide-2)))
                        {
                            if (i+k < height && j+l < width)
                                pixels[i+k][j+l].setColor(new Color(255,255,255));
                        }

                    }
                }

            }
        }
    }

    public Picture overlay( Picture over)
    {

        int bigSize = 500;
        Picture bottom = this.scaleToSize(bigSize,bigSize);
        Picture top = over.scaleToSize(bigSize,bigSize);
        Pixel[][] pixels1 = bottom.getPixels2D();
        Pixel[][] pixels2 = top.getPixels2D();

        for (int i = 0; i < 500; i ++)
        {
            for (int j = 0; j < 500; j++)
            {
                
                if ( i%2 == 0 && j%2 != 0)
                {
                    pixels1[i][j].setColor(pixels2[i][j].getColor());
                }
                else if (i %2 != 0 && j%2 == 0)
                {
                    pixels1[i][j].setColor(pixels2[i][j].getColor());
                }
                else 
                {
                   
                    
                    Color color = pixels1[i][j].getColor();
                    color = new Color (color.getRed(), color.getGreen(), color.getBlue(), 100);
                    pixels1[i][j].setColor(color);
                }
            }

        }
        return bottom;
    }

    /* Main method for testing - each class in Java can have a main 
     * method 
     */
    public static void main(String[] args) 
    {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }

} // this } is the end of class Picture, put all new methods before this
