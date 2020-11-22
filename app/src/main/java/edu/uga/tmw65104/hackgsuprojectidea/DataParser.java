package edu.uga.tmw65104.hackgsuprojectidea;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;
import com.google.gson.*;

public class DataParser {

    static LinkedList<String> entries;

    public static void initialize () {
        entries = new LinkedList<String>();
        try {
            Scanner reader = new Scanner(new File("Data.txt"));
            while (reader.hasNextLine()) {
                entries.add(reader.nextLine());
            }
        } catch (Exception e) {
            //do nothing because this won't ever happen
        }
    }



    public static void add (String number, String name, int date, int time) {
        entries.add(number + ":" + name + ":" + date + ":" + time + ":");
        update();
    }

    public static void remove (String number, String name, int date, int time) {
        entries.remove(number + ":" + name + ":" + date + ":" + time + ":");
        update();
    }

    public static void edit () {

    }

    //updates Data.txt with entries information
    public static void update () {
        try {
            //clears the file
            PrintWriter pwriter = new PrintWriter("Data.txt");
            pwriter.print("");
            pwriter.close();

            PrintStream writer = new PrintStream("Data.txt");
            for (String entry: entries) {
                writer.println(entry);
            }
        } catch (Exception e) {
            //no code here because this will never happen
        }

    }
}
