import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Betty Kouadio
 *
 */

public class MorseCodeConverter
{

    private static MorseCodeTree t = new MorseCodeTree();


    public MorseCodeConverter()
    {

    }
    /**
     *
     * @param code
     * @return output
     */
    public static String convertToEnglish(String code)
    {
        String output = "";
        String[] word; // will hold each singular word from
        String[] letter; // will hold each singular word from

        // split each word  into a new array.
        word = code.split(" / ");


        for(int i = 0; i < word.length; i++)
        {
            letter = word[i].split(" "); 	// split each word  into a new array.
            for(int j = 0; j < letter.length; j++)
            {
                output += t.fetch(letter[j]);
            }

            output += " "; 	//space after each word
        }

     // take off preceding or succeeding spaces
        output = output.trim();	       
        return output;
    }


    public static String convertToEnglish(File File) throws FileNotFoundException
    {
        String output = "";
        ArrayList<String> line = new ArrayList<String>();
        String[] word;
        String[] letter;

        Scanner inputFile;
        inputFile = new Scanner(File);

        while (inputFile.hasNext()) 	// read line by line content from .txt file into an arraylist
        {
            line.add(inputFile.nextLine());
        }

        inputFile.close();

        for(int i = 0; i < line.size(); i++)
        {
            word = line.get(i).split(" / ");

            for(int j = 0; j < word.length; j++)
            {
                letter = word[j].split(" ");

                for(int k = 0; k < letter.length; k++)
                {
                    output += t.fetch(letter[k]);
                }

                output += " ";	//add a space after each word
            }
        }
        
        // take off preceding or succeeding spaces
        output = output.trim();

        return output;
    }
    public static String printTree()
    {
        ArrayList<String> treeData = new ArrayList<String>();

        treeData = t.toArrayList();

        String print = "";

        for(int i = 0; i < treeData.size(); i ++)
        {
            print += treeData.get(i) + " ";
        }

        return print;
    }

}