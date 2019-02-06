import java.util.Scanner;

/**
 * A FillInQuestion is constructed with a string that contains the answer,
 *  surrounded by '_'. For example, "The inventor of Java was _James Gosling_".
 *  The question should be displayed as :
 *  The inventor of Java was _______.
 *  
 *  The FillInQuesiton class inherits (extends) from the Question class.
 */
public class FillInQuestion extends Question
{
    /**
     * This method overrides the setText method in the Question class.
     * 
     *Sets the question text.
     *@param questionText the text of this question
     */
    public void setText(String questionText)   
    {
        Scanner parser = new Scanner(questionText);
        parser.useDelimiter("_");
        String question = parser.next();
        String answer = parser.next();
        question += "______" + parser.next();

        /*
         * The inherited instance variables are private; they cannot be
         * directly accessed. We must use mutator and accessor methods.
         */
        //this.question = question;
        //this.answer = answer;

        /*
         * Use the "super" reserved word to call the setText amnd setAnswer
         *       methods of the super class (i.e., Quesiton).
         */
        super.setText(question);
        super.setAnswer(answer);
    }
}
