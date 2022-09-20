import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;

import java.util.Calendar;
import java.util.Scanner;
import java.util.ArrayList;

public class PersonGenerator
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Boolean moreUsers = true;
        String ID = "" ;
        String firstName = "";
        String lastName = "";
        String title = "";
        int yearOfBirth = 0;
        ArrayList<String> users = new ArrayList<String>();
        moreUsers = SafeInput.getYNConfirm(in, "Do you have a person to add to the list?");
        while(moreUsers == true)
        {
            ID = genIDNum();
            firstName = SafeInput.getNonZeroLenString(in, "What is the user's first name?");
            lastName = SafeInput.getNonZeroLenString(in, "What is the user's last name?");
            title = SafeInput.getNonZeroLenString(in, "What is the user's title?");
            yearOfBirth = SafeInput.getRangedInt(in, "What is the user's year of birth?", 1940, 2000);
            users.add(ID + ", " + firstName + ", " + lastName + ", " + title + ", " + yearOfBirth);
            moreUsers = SafeInput.getYNConfirm(in, "Do you have another person to add to the list?");
            PersonGenerator person = new PersonGenerator(ID, firstName, lastName, title, yearOfBirth);
            System.out.print(person);
        }
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\PersonTestData.txt");
        try
        {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
            Files.write(file, users);
            writer.newLine();
            writer.close();
            System.out.print("New user(s) added successfully");
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    private String IDNum;
    private String firstName;
    private String lastName;
    private String title;
    private int yearOfBirth;
    private static int startSeed = 1;

    public static int getStartSeed()
    {
        return startSeed;
    }

    public static void setStartSeed(int startSeed)
    {
        PersonGenerator.startSeed = startSeed;
    }

    public PersonGenerator(String IDNum, String firstName, String lastName, String title, int yearOfBirth)
    {
        this.IDNum = IDNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.yearOfBirth = yearOfBirth;
    }

    public PersonGenerator(String firstName, String lastName, String title, int yearOfBirth)
    {
        this.IDNum = this.genIDNum();
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.yearOfBirth = yearOfBirth;
    }

    public String getIDNum()
    {
        return IDNum;
    }

    private static String genIDNum()
    {
        String newID = "" + startSeed;
        while(newID.length() < 6)
        {
            newID = "0" + newID;
        }
        startSeed++;

        return newID;
    }

    public void setIDNum(String IDNum)
    {
        this.IDNum = IDNum;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getYearOfBirth()
    {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth)
    {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString()
    {
        return "PersonGenerator{" +
                "IDNum='" + IDNum + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", yearOfBirth='" + yearOfBirth + '\'' +
                '}';
    }

    public String fullName()
    {
        String fullName = this.firstName + " " + this.lastName;
        return fullName;
    }

    public String formalName()
    {
        String formalName = this.title + " " + this.firstName + " " + this.lastName;
        return formalName;
    }

    public String ageCurrent()
    {
        String ageNow = "";
        Calendar calendar = Calendar.getInstance();
        int math = this.yearOfBirth - calendar.get(Calendar.YEAR);
        ageNow = String.valueOf(math);
        return ageNow;
    }

    public String getAge(int pastYear)
    {
        String ageThen = "";
        int math = this.yearOfBirth - pastYear;
        ageThen = String.valueOf(math);
        return ageThen;
    }
}