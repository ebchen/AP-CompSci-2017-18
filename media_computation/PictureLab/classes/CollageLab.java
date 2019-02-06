
/**
 * My collage lab.
 *
 * @author ebchen
 * @version 16 January 2018
 */
public class CollageLab
{
   public static void snapHotdog()
   {
       Picture original = new Picture("hotdog.jpg");
       Picture source = original.scaleToSize(500,500);
       //Picture source = oldSource.scaleToSize(550, 366);
       Picture picture2 = new Picture(source);
       Picture picture3 = new Picture(source);
       Picture picture4 = new Picture(source);
       Picture picture5 = new Picture(source);
       Picture picture6 = new Picture(source);
       
       Pixel[][] pixelSource = source.getPixels2D();
       int height = pixelSource.length;
       int width = pixelSource[0].length;
       Picture canvas = new Picture(height * 2, width * 3);
       canvas.cropAndCopy(source, 0, height - 1, 0, width - 1, 0, 0);
       
       Picture fill = new Picture("snap.jpg");
       Picture picture2mod = picture2.mosaic(fill);
       canvas.cropAndCopy(picture2mod, 0, height - 1, 0, width - 1, height, width);
       picture3.edgeDetection(10);
       canvas.cropAndCopy(picture3, 0, height - 1, 0, width - 1, 0, width);
       picture4.mirrorVerticalRightToLeft();
       canvas.cropAndCopy(picture4, 0, height - 1, 0, width - 1, height, 0);
       picture5.negate();
       canvas.cropAndCopy(picture5, 0, height - 1, 0, width - 1, 0, width*2);
       Picture picX = new Picture("chicago.jpg");
       picture6 = picture6.overlay(picX);
       canvas.cropAndCopy(picture6, 0, height - 1, 0, width - 1, height, width*2);
       canvas.explore();
       canvas.write("EricChen.jpg");
    }
    
   public static void lake()
   {
       Picture original = new Picture("lake.jpg");
       Picture source = original.scaleToSize(500,500);
       //Picture source = oldSource.scaleToSize(550, 366);
       Picture picture2 = new Picture(source);
       Picture picture3 = new Picture(source);
       Picture picture4 = new Picture(source);
       Pixel[][] pixelSource = source.getPixels2D();
       int height = pixelSource.length;
       int width = pixelSource[0].length;
       Picture canvas = new Picture(height * 2, width * 2);
       canvas.cropAndCopy(source, 0, height - 1, 0, width - 1, 0, 0);
       
       picture2.makeCircles();
       canvas.cropAndCopy(picture2, 0, height - 1, 0, width - 1, height, width);
       picture3.negate();
       canvas.cropAndCopy(picture3, 0, height - 1, 0, width - 1, 0, width);
       picture4.mirrorHorizontal();
       canvas.cropAndCopy(picture4, 0, height - 1, 0, width - 1, height, 0);
       canvas.explore();
       canvas.write("lakeCollage.jpg");
    }
    
    public static void eagle()
   {
       Picture original = new Picture("eagle.jpg");
       Picture source = original.scaleToSize(500,500);
       //Picture source = oldSource.scaleToSize(550, 366);
       Picture picture2 = new Picture(source);
       Picture picture3 = new Picture(source);
       Picture picture4 = new Picture(source);
       Pixel[][] pixelSource = source.getPixels2D();
       int height = pixelSource.length;
       int width = pixelSource[0].length;
       Picture canvas = new Picture(height * 2, width * 2);
       canvas.cropAndCopy(source, 0, height - 1, 0, width - 1, 0, 0);
       
       Picture picX = new Picture("shield.jpg");
       picture2 = picture2.mosaic(picX);
       canvas.cropAndCopy(picture2, 0, height - 1, 0, width - 1, height, width);
       Picture flag = new Picture("flag.jpg");
       picture3 = picture3.overlay(flag);
       canvas.cropAndCopy(picture3, 0, height - 1, 0, width - 1, 0, width);
       picture4.mirrorDiagonalTopToBot();
       
       canvas.cropAndCopy(picture4, 0, height - 1, 0, width - 1, height, 0);
       canvas.explore();
       canvas.write("eagleCollage.jpg");
    }
   public static void main(String [] args)
   {
       snapHotdog();
    }
}
