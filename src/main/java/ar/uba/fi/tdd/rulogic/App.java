package ar.uba.fi.tdd.rulogic;

import ar.uba.fi.tdd.rulogic.model.Exceptions.InvalidDatabaseException;
import ar.uba.fi.tdd.rulogic.model.Exceptions.InvalidQuestionException;
import ar.uba.fi.tdd.rulogic.model.Interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Console application.
 *
 */
public class App
{
	public static void main(String[] args) throws IOException, InvalidDatabaseException, InvalidQuestionException {
		System.out.println("I shall answer all your questions!");
        System.out.println("Enter the path to the DataBase:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Interpreter i;
        try {
            String path = br.readLine();
             i = new Interpreter(path);
        } catch (IOException e) {
                System.out.println("The path is wrong");
                System.out.println(e.getMessage());
                return;
        } catch (InvalidDatabaseException e) {
                System.out.println("The Database is malformed");
                System.out.println(e.getMessage());
                return;
        }


        System.out.println("Enter your question below (!q to exit)");

        String question = br.readLine();
        while (!question.equals("!q")) {
            try {
                System.out.println(i.answer(question));
            } catch (InvalidQuestionException e){
                System.out.println("Invalid Question: " + e.getMessage());
            }
            question = br.readLine();
        }
        System.out.println("Bye!");
    }
}
