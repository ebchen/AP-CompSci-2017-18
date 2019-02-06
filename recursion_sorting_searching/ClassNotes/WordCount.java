import java.util.Scanner;
import java.io.File;
import java.io.*;
import java.util.*;

public class WordCount
{
    public static void main(String []args) throws IOException
    {
        Scanner s = new Scanner (System.in);
        System.out.println("File name: ");
        String fileName = s.next();

        File in = new File(fileName);
        System.out.println(in);
        Scanner input = new Scanner(in);

        int wordCounter = 0;
        int charCounterNoWhiteSpace = 0;
        int charCounterWithWhiteSpace = 0;
        int lineCounter = 0;
        
        while (input.hasNextLine())
        {
            String line = input.nextLine();
            System.out.println(line);
            lineCounter++;
            charCounterWithWhiteSpace += line.length();
            for(int i=0;i<line.length();i++)
            { 
                if(line.charAt(i)!=' ' && line.charAt(i)!='\n')
                    charCounterNoWhiteSpace ++;
            }
            wordCounter+= new StringTokenizer(line, " ,").countTokens();

        }

        System.out.println("Word Count: " + wordCounter);
        System.out.println("Character Count (no white space): " + charCounterNoWhiteSpace);
        System.out.println("Character Count (w/ white space): " + charCounterWithWhiteSpace);
        System.out.println("Line Count: " + lineCounter);

    }
}
