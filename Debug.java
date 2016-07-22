/*  Class : Debug,
    Date : 29/02/2016,
    Author : Christopher Cullen,
    Description : output debug messages to a File.      */
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Debug
{
    //  Overload the method
    public static void log(String funcName, int lineNumber, String msg){
        PrintToFile("[Debug] " + funcName + " Function, Line Number: " + lineNumber + " - " + msg);
    }
    public static void log(String funcName, String msg){
        PrintToFile("[Debug] " + funcName + " Function - " + msg);
    }
    public static void log(String funcName, int lineNumber){
        PrintToFile("[Debug] " + funcName + " Function, Line Number: " + lineNumber);
    }
    public static void log(String msg){
        PrintToFile("[Debug] " + msg);
    }
    public static void log(int lineNumber){
        PrintToFile("[Debug] Line Number: " + lineNumber);
    }

    public static void PrintToFile(String msg){
        try{   
            //  Get the Date and Time
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss dd-mm-yyyy");
            String time = simpleDateFormat.format(calendar.getTime());

            //  Create a folder
            File folder = new File("Debug Logs");
            folder.mkdir();

            //  Setup the file name and path
            String fileName = "Logs";
            String filePath = "C://" + folder +"/" + fileName;

            //  Check to see if the file exists
            File file = new File(filePath + ".txt");
            if(!file.exists())
                file.createNewFile();

            //  Convenience class for writing character files.
            FileWriter fileWriter = new FileWriter(file, true);
            
            //  Writes text to a character-output stream, buffering characters so as to provide for the efficient writing of single characters, arrays, and strings. 
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            
            //  Prints formatted representations of objects to a text-output stream. 
            PrintWriter printWriter = new PrintWriter(bufferWriter);

            //  Print it to the log
            printWriter.println("[" + time + "]" + msg);
            printWriter.close();
        }
        catch(IOException ioe){
           System.out.println(ioe.getMessage());
           //ioe.printStackTrace();


        }
    }
}