package edu.uga.tmw65104.hackgsuprojectidea;
import android.content.Context;
import android.util.Log;

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


public class DataParser {

    static LinkedList<String[]> entries;
    static File f;

    //populates linkedlist entries with each entry which is of type String[4]
    public static void initialize () {
        if (entries == null) {
            entries = new LinkedList<String[]>();
            try {
                f = new File("Data.txt");
                f.setWritable(true);
                Scanner reader = new Scanner(f);
                while (reader.hasNextLine()) {
                    entries.add(reader.nextLine().split(":"));
                }
            } catch (Exception e) {
                //do nothing because this won't ever happen
            }
        }
    }


    public static void add (String number, String name, String date) {
        int originalSize = entries.size();
        for (int i = 0; i < entries.size(); i++) {
            if (date.compareTo(entries.get(i)[2]) <= 0) {
                entries.add(i, new String[]{number, name, date});
                break;
            }
        }
        if (originalSize == entries.size()) {
            entries.add(new String[]{number, name, date});
        }
        update();
    }

    //LISTEN HERE, IF YOU TRY TO REMOVE AN ENTRY THAT DOESN'T EXIST IN THE TREE, THINGS WILL GO VERY WRONG.
    public static void remove (String number, String name, String date) {
        int index = -1;
        for (int i = 0; i < entries.size(); i++) {
            if (number.equals(entries.get(i)[0]) && name.equals(entries.get(i)[1]) && date.equals(entries.get(i)[2])) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("The person being removed does not exist.");
        }
        entries.remove(index);
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

    //returns an array of distinct strings that are the phone numbers
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
            PrintWriter pwriter = new PrintWriter(f);
            pwriter.close();

            PrintStream writer = new PrintStream(f);
            for (String[] entry: entries) {
                writer.println(entry[0] + ":" + entry[1] + ":" + entry[2]);
            }
        } catch (Exception e) {
            e.printStackTrace();
            //no code here because this will never happen
        }

    }
}
