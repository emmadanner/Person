import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.ArrayList;

public class PersonReader
{
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        chooser.setCurrentDirectory(target.toFile());
        try
        {
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                target = chooser.getSelectedFile().toPath();
                BufferedReader inFile = new BufferedReader(new FileReader(target.toFile()));
                String line = inFile.readLine();
                System.out.println("ID#           Firstname   Lastname     Title        YOB");
                System.out.println("=======================================================");
                while ((line = inFile.readLine()) != null)
                {
                    ArrayList<String> users = new ArrayList(Arrays.asList(line.split(",[ ]*")));
                    int spacingSeparation = 3;
                    int longest = "          ".length();
                    int spacing = longest + spacingSeparation;
                    System.out.print(String.format("%-" + spacing + "s%-" + spacing + "s%-" + spacing + "s%-" + spacing + "s%-" + spacing + "s\n", users.get(0), users.get(1), users.get(2), users.get(3), users.get(4)));
                }
                inFile.close();
            }
            else
            {
                System.out.println("You must select a file.  The program will now close.");
                System.exit(0);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found error");
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
