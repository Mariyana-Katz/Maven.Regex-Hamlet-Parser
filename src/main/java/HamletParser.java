import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public void changeAllStringOccurrences(String target, String replaceWith) {
        Pattern pattern = Pattern.compile(target, Pattern.LITERAL | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher matcher = pattern.matcher(this.hamletData);
        this.hamletData = matcher.replaceAll(replaceWith);
        storeInFile(this.hamletData);
    }

    public void storeInFile(String output){
        try{
            PrintWriter fileOut = new PrintWriter("output.txt");
            fileOut.println(output);
            fileOut.close();

        } catch(IOException e) {
            //Display on the console if there is a problem writing to a file.
            System.out.println("There is a problem with the writing " + e.getMessage());
        }
    }

}
