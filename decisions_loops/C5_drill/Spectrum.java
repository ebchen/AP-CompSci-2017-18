import java.util.Scanner;
public class Spectrum
{
    public static String whichSpectrum(double wavelength)
    {
       if (wavelength > 1e-1)
       {
           return "Radio Waves; wavelength(m): >10^-1; frequency(hz): <3x10^9";
       }
       else if (wavelength >= 1e-3)
       {
           return "Microwaves; wavelength(m): 10^-3 to 10^-1; frequency(hz): 3x10^9 to 3x10^11";
       }
       else if (wavelength >= 7*1e-7)
       {
           return "Infrared; wavelength(m): 7x10^-7 to 10^-3; frequency(hz): 3x10^11 to 4x10^14";
       }
       else if (wavelength >= 4*1e-7)
       {
           return "Visible Light; wavelength(m): 4x10^-7 to 7*10^-7; frequency(hz): 4x10^14 to 7.5x10^14";
       }
       else if (wavelength >= 1e-8)
       {
           return "Ultraviolet; wavelength(m): 10^-8 to 4*10^-7; frequency(hz): 7.5x10^14 to 3x10^16";
       }
       else if (wavelength >= 1e-11)
       {
           return "X-rays; wavelength(m): 10^-11 to 10^-8; frequency(hz): 3x10^16 to 3x10^19";
       }
       else 
       {
           return "Gamma rays; wavelength(m): <10^-11; frequency(hz): >3x10^19";
       }
    }
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        double wavelength = scan.nextDouble();
        System.out.println("Type of wave: " + whichSpectrum(wavelength));
    }
}