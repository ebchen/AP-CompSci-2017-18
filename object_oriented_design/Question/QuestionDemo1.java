import java.util.Scanner;

/**
   This program shows a simple quiz with one question.
*/
public class QuestionDemo1
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);

      ChoiceQuestion cq = new ChoiceQuestion( "Who was the inventor of Java?");
      cq.addChoice("James Gosling", true);
      cq.addChoice("Alan Kay", false);
      
      Question q = cq;
      q.display();
      System.out.print("Your answer: ");
      String response = in.nextLine();
      System.out.println(q.checkAnswer(response));
   }
}

