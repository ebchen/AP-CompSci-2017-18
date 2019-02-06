import java.util.ArrayList;

/**
   A question with multiple choices.
*/
public class ChoiceQuestion extends Question
{
   private ArrayList<String> choices;

   /**
      Constructs a choice question with no choices.
   */
   public ChoiceQuestion()
   {
      choices = new ArrayList<String>();
   }

   /**
    * Construct a choice question with the specified question text and
    *       no choices.
    *       
    * @param questionText specified question text
    */
   public ChoiceQuestion( String questionText)
   {
       /*
        * Explicitly call the Question class's constructor that takes
        *       a string parameter. Calling a superclass's constructor
        *       must be the first line of code in the subclass's constructor
        *       
        * If we don't explicitly call a superclass's constructor, Java
        *       will automatically call the superclass's defailt (i.e.,
        *       nop parameters) constructor.
        */
       
       super(questionText);
       
       this.choices = new ArrayList<String>();
    }
   /**
      Adds an answer choice to this question.
      @param choice the choice to add
      @param correct true if this is the correct choice, false otherwise
   */
   public void addChoice(String choice, boolean correct)
   {
      choices.add(choice);
      if (correct) 
      {
         // Convert choices.size() to string
         String choiceString = "" + choices.size();
         setAnswer(choiceString);
      }
   }
   
   public void display()
   {
      // Display the question text
      super.display();
      // Display the answer choices
      for (int i = 0; i < choices.size(); i++)
      {
         int choiceNumber = i + 1;
         System.out.println(choiceNumber + ": " + choices.get(i));     
      }
   }
}

