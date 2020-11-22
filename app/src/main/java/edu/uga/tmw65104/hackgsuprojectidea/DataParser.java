package edu.uga.tmw65104.hackgsuprojectidea;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.gson.*;

public class DataParser {

    static LinkedList<String[]> entries;

    public static void initialize () {
        entries = new LinkedList<String[]>();
        try {
            Scanner reader = new Scanner(new File("Data.txt"));
            while (reader.hasNextLine()) {
                entries.add(reader.nextLine().split(":"));
            }
        } catch (Exception e) {
            //do nothing because this won't ever happen
        }
    }


    public static void add (String number, String name, String date) {
        entries.add(new String[]{number, name, date});
        update();
    }

    public static int findIndex (String number, String name, String date) {
        for (int i = 0; i < entries.size(); i++) {
            if (number.equals(entries.get(i)[0]) && name.equals(entries.get(i)[1]) && date.equals(entries.get(i)[2])) {
                return i;
            }
        }
        return -1;
    }

    //LISTEN HERE, IF YOU TRY TO REMOVE AN ENTRY THAT DOESN'T EXIST IN THE TREE, THINGS WILL GO VERY WRONG.
    public static void remove (String number, String name, String date) {
        entries.remove(findIndex(number, name, date));
        update();
    }

    public static String getNumber (String[] entry) {
        return entry[0];
    }

    public static String getName (String[] entry) {
        return entry[1];
    }

    public static String getDate (String[] entry) {
        return entry[2];
    }

    public static LinkedList<String[]> dateEntries (String date) {
        LinkedList<String[]> list = new LinkedList<String[]>();
        for (String[] x: entries) {
            if (getDate(x).equals(date)) {
                list.add(x);
            }
        }
        return list;
    }

    //returns an array that contains String arrays of size 2 where the first element is the name and the second element is the phone number
    public static String[] covidNumbers () {
        LinkedList<String> list = new LinkedList<>();
        for (String[] x: entries) {
            list.add(getNumber(x));
        }
        return (new LinkedHashSet<String>(list)).toArray(new String[0]);
    }

    //updates Data.txt with entries information
    public static void update () {
        try {
            //clears the file
            PrintWriter pwriter = new PrintWriter("Data.txt");
            pwriter.print("");
            pwriter.close();

            PrintStream writer = new PrintStream("Data.txt");
            for (String[] entry: entries) {
                writer.println(entry[0] + ":" + entry[1] + ":" + entry[2] + ":" + entry[3]);
            }
        } catch (Exception e) {
            //no code here because this will never happen
        }

    }
}
