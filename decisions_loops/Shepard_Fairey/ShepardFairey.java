import java.awt.Color;

/**
 * Transforms a picture by applying a Shepard Fairey-inspired effect.
 *
 * @author (your name)
 * @version (a version number or a date)
 * 
 * I wrote 4 transform methods, one for each of the 4 palettes I have.
 * The one transform method I am using is transform2
 */
public class ShepardFairey
{
    private Picture picture;
    private int maxGray;
    private int minGray;
    private int range;
    private int quads;
    /*
     * Shephard palette
     */
    private static final Color OFF_WHITE = new Color( 248, 229, 175 );
    private static final Color LIGHT_BLUE = new Color( 121, 149, 159 );
    private static final Color RED = new Color( 198, 50, 45 );
    private static final Color DARK_BLUE = new Color( 16, 48, 77 );
    
    /*
     * Custom palette1
     */
    private static final Color NEON_YELLOW = new Color( 255, 255, 37 );
    private static final Color NEON_CYAN = new Color( 37, 255, 247 );
    private static final Color NEON_ORANGE = new Color( 255, 134, 37 );
    private static final Color NEON_VIOLET = new Color( 182, 48, 255 );
    
    
    
    public ShepardFairey( Picture newPicture )
    {
        this.picture = newPicture;
    }

    
    
    public void getMaxGray()
    {
        int max = -1;

        for (int i = 0; i < this.picture.getHeight(); i++)
        {
            for (int j = 0; j < this.picture.getWidth(); j++)
            {
                Pixel pixel = this.picture.getPixel( j, i );
                Color color = pixel.getColor();
                if (color.getRed() > max)
                {
                    max = pixel.getRed();
                }
            }
        }
        this.maxGray = max;
    }
    
    public void getMinGray()
    {
        int min = 256;
        for (int i = 0; i < this.picture.getHeight(); i++)
        {
            for (int j = 0; j < this.picture.getWidth(); j++)
            {
                Pixel pixel = this.picture.getPixel( j, i );
                Color color = pixel.getColor();
                if (color.getRed() < min)
                {
                    min = pixel.getRed();
                }
            }
        }
        this.minGray = min;
    }
    
    public void setRange()
    {
        getMaxGray();
        getMinGray();
        this.range = this.maxGray - this.minGray;
        this.quads = range/4;
    }
    
    public void changePixelColor(int x, int y)
    {
        
        Pixel pixel = this.picture.getPixel( x, y );
        Color color = pixel.getColor();
        if ( color.getRed() < minGray + quads)
        {
            pixel.setColor(NEON_VIOLET);
        }
        else if ( color.getRed() < minGray + quads*2)
        {
            pixel.setColor(NEON_ORANGE);
        }
        else if ( color.getRed() < minGray + quads*3)
        {
            pixel.setColor(NEON_CYAN);
        }
        else 
        {
            pixel.setColor(NEON_YELLOW);
        }
    }
    
    /**
     * Transforms the picture by applying a Shepard Fairey-inspired effect.
     *  uses custom palette1
     */
    public void transform()
    {
        ColorManipulator man = new ColorManipulator(this.picture);
        man.grayscale();
        setRange();
        
        for (int i =1; i < this.picture.getHeight(); i++)
        {
            for (int j = 1; j < this.picture.getWidth(); j++)
            {
                changePixelColor(j,i);
            }
        }

    }

    
    
    public static void main(String args[])
    {
        // create a new picture object based on the original selfie
        Picture selfiePortrait = new Picture ("selfiePortrait.jpg" );
        Picture selfieLandscape = new Picture ("selfieLandscape.jpg" );

        // create a ShepardFairey object to transform the selfie picture
        ShepardFairey faireyPortrait = new ShepardFairey( selfiePortrait );
        ShepardFairey faireyLandscape = new ShepardFairey( selfieLandscape );

        // display the original selfie picture
        selfiePortrait.explore();
        selfieLandscape.explore();

        // transform the selfie picture by applying a Shepard Fairey-inspired effect
       
        //  uses the custom palette1
        faireyPortrait.transform();
        faireyLandscape.transform();

     
        // save the transformed selfie picture

        /* This code doesn't work for some students for unknown reasons.
         * You may need to specify an absolute path. For example:
         *  finalPic.write("C:\\Users\\gschmit\\Desktop\\GitHub\\unit6MediaComp\\images\\Schmit.jpg");
         */
        
        selfiePortrait.write("/Users/ebchen/GitHub/decisions-loops-ebchen/Shepard Fairey/EricChenPortrait.jpg" );
        selfieLandscape.write("/Users/ebchen/GitHub/decisions-loops-ebchen/Shepard Fairey/EricChenLandscape.jpg" );
        
        // display the transformed selfie picture 
        selfiePortrait.explore();
        selfieLandscape.explore();
    }
}