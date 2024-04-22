package AlternativeLanguageProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
public class Test {
    private static final String CSV_FILE = "AlternativeLanguageProject/cells.csv"; 
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(CSV_FILE))){
            String currentLine;
            int rowCount = 0;
            Random randomGenerator = new Random();
            int[] selectedRows = {randomGenerator.nextInt(1000) + 1, randomGenerator.nextInt(1000) + 1, randomGenerator.nextInt(1000) + 1};
            int processedRow = 0;
            if ((currentLine = bufferedReader.readLine()) == null) {
                System.out.println(" CSV is empty.");
                return;}
            while ((currentLine = bufferedReader.readLine()) != null) {
                currentLine = modifyCommasWithinQuotes(currentLine);
                rowCount++;
                for (int testRow : selectedRows) {
              if (processedRow == testRow) {
                  String[] dataEntries = currentLine.split(",");
                  if (dataEntries.length >= 12) {
                            Cell testCell = new Cell(
                dataEntries[0], dataEntries[1], dataEntries[2], dataEntries[3],
                dataEntries[4], dataEntries[5], dataEntries[6], dataEntries[7],
                  dataEntries[8], dataEntries[9], dataEntries[10], dataEntries[11]);
              System.out.println("Testing Row " + testRow + ": " + testCell);
                System.out.println("Actual Row " + testRow + " Data: " + currentLine);}}}
                processedRow++;}
            if (rowCount > 0) {
                System.out.println("Read succesfuly" + rowCount + " rows processed.");
            } else {
                System.out.println("No rows found");
            }
        } catch (IOException ex) {
            ex.printStackTrace();}}
    private static String modifyCommasWithinQuotes(String input) {
        boolean withinQuotes = false;
        char[] characters = input.toCharArray();
        for (int index = 0; index < characters.length; index++) {
            if (characters[index] == '\"') {
                withinQuotes = !withinQuotes;
            } else if (characters[index] == ',' && withinQuotes) {
                characters[index] = '\u0007';}}
        return new String(characters);}}
