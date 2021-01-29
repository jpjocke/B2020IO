package org.ben.util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {

    public static List<String> readFileAsStringsPerLine(String file) {
        List<String> items = new ArrayList<>();
        BufferedReader br = null;
        try {
            br  = new BufferedReader(new FileReader(file));
            String line = br.readLine();

            while (line != null) {
                items.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return items;
    }

    public static void printToFile(String fileName, List<? extends Printable> list) {
        try {
            PrintWriter writer = new PrintWriter("./out/" + fileName, "UTF-8");
            list.forEach(item -> writer.println(item.toPrint()));
            writer.close();
        } catch (IOException e) {
            System.out.println("Failed to write to file " + fileName);
            e.printStackTrace();
        }
    }
}