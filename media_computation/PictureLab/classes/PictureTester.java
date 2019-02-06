/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
    /** Method to test zeroBlue */
    public static void testZeroBlue()
    {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }
    public static void testKeepOnlyBlue()
    {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.keepOnlyBlue();
        beach.explore();
    }

    public static void testNegate()
    {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.negate();
        beach.explore();
    }
    public static void testGrayscale()
    {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.grayscale();
        beach.explore();
    }
    
    public static void testFixUnderwater()
    {
        Picture beach = new Picture("water.jpg");
        beach.explore();
        beach.fixUnderwater();
        beach.explore();
    }
    public static void testSepia()
    {
        Picture beach = new Picture("arch.jpg");
        beach.explore();
        beach.sepia();
        beach.explore();
    }
    /** Method to test mirrorVertical */
    public static void testMirrorVertical()
    {
        Picture caterpillar = new Picture("caterpillar.jpg");
        caterpillar.explore();
        caterpillar.mirrorVertical();
        caterpillar.explore();
    }
    public static void testMakeCircles()
    {
        Picture beach = new Picture("arch.jpg");
        beach.explore();
        beach.makeCircles();
        beach.explore();
    }
    /** Method to test mirrorTemple */
    public static void testMirrorTemple()
    {
        Picture temple = new Picture("temple.jpg");
        temple.explore();
        temple.mirrorTemple();
        temple.explore();
    }

    public static void testMirrorGull()
    {
        Picture temple = new Picture("seagull.jpg");
        temple.explore();
        temple.mirrorGull();
        temple.explore();
    }
    public static void testMirrorArms()
    {
        Picture snowman = new Picture("snowman.jpg");
        snowman.explore();
        snowman.mirrorArms();
        snowman.explore();
    }
    /** Method to test the collage method */
    public static void testCollage()
    {
        Picture canvas = new Picture("640x480.jpg");
        canvas.createCollage();
        canvas.explore();
    }

    /** Method to test edgeDetection */
    public static void testEdgeDetection()
    {
        Picture swan = new Picture("swan.jpg");
        swan.edgeDetection(10);
        swan.explore();
    }

    public static void testMirrorVerticalRightToLeft()
    {
        Picture swan = new Picture("swan.jpg");
        swan.mirrorVerticalRightToLeft();
        swan.explore();
    }

    public static void testMirrorHorizontal()
    {
        Picture swan = new Picture("swan.jpg");
        swan.mirrorHorizontal();
        swan.explore();
    }
    public static void testMirrorHorizontalBotToTop()
    {
        Picture swan = new Picture("swan.jpg");
        swan.mirrorHorizontalBotToTop();
        swan.explore();
    }
    public static void testMirrorDiagonalBotToTop()
    {
        Picture swan = new Picture("arch.jpg");
        swan.mirrorDiagonalBotToTop();
        swan.explore();
    }
    
    public static void testCropAndCopy()
    {
        Picture swan = new Picture ("swan.jpg");
        Picture arch = new Picture ("arch.jpg");
        arch.cropAndCopy(swan, 10, 100, 20, 180, 30, 40);
        arch.explore();
    }
    
    public static void testScaleByHalf()
    {
        Picture arch = new Picture ("arch.jpg");
        arch.explore();
        arch.scaleByHalf().explore();
    }
    
    public static void testScaleToSize()
    {
        Picture arch = new Picture ("arch.jpg");
        arch.explore();
        arch.scaleToSize(700,100).explore();
    }
    
    public static void testMosaic()
    {
        Picture pic = new Picture("rainbowGood.jpg");
        Picture pic1 = pic.scaleToSize(1000,1000);
        Picture pic2 = new Picture("blue-rose.jpg");
        Picture end = pic1.mosaic(pic2);
        end.explore();
    }
    
    public static void testOverlay()
    {
        Picture pic1 = new Picture("eagle.jpg");
        Picture pic2 = new Picture("flag.jpg");
        
        Picture end = pic1.overlay(pic2);
        end.explore();
    }
    /** Main method for testing.  Every class can have a main
     * method in Java */
    public static void main(String[] args)
    {
        // uncomment a call here to run a test
        // and comment out the ones you don't want
        // to run
        testZeroBlue();
        //testKeepOnlyBlue();
        //testKeepOnlyRed();
        //testKeepOnlyGreen();
        //testNegate();
        //testGrayscale();
        //testFixUnderwater();
        //testMirrorVertical();
        //testMirrorTemple();
        //testMirrorArms();
        //testMirrorGull();
        //testMirrorDiagonal();
        //testCollage();
        //testCopy();
        //testEdgeDetection();
        //testEdgeDetection2();
        //testChromakey();
        //testEncodeAndDecode();
        //testGetCountRedOverValue(250);
        //testSetRedToHalfValueInTopHalf();
        //testClearBlueOverValue(200);
        //testGetAverageForColumn(0);
    }
}