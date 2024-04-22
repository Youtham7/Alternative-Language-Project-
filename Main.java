package AlternativeLanguageProject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class Main {
    public static void main(String[] args) {
        String filePath = "AlternativeLanguageProject/cells.csv"; 
        Map<Integer, Cell> phoneMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            int idCounter = 1; 
            reader.readLine();
            while ((currentLine = reader.readLine()) != null) {
                String adjustedLine = handleCommasWithinQuotes(currentLine);
                String[] dataFields = adjustedLine.split(",");
                for (int i = 0; i < dataFields.length; i++) {
                    dataFields[i] = dataFields[i].replace('\u0007', ',');}
                dataFields = Arrays.copyOf(dataFields, 12);
                Arrays.fill(dataFields, dataFields.length, 12, "-");
                Cell newCell = new Cell(
                    dataFields[0], dataFields[1], dataFields[2], dataFields[3],
                    dataFields[4], dataFields[5], dataFields[6], dataFields[7],
                    dataFields[8], dataFields[9], dataFields[10], dataFields[11]
                );
                phoneMap.put(idCounter++, newCell);
            }} catch (IOException ex) {
            ex.printStackTrace();}
        phoneMap.forEach((key, cell) -> System.out.println("Record ID " + key + ": " + cell));
        AnalysisFunctions analytics = new AnalysisFunctions(phoneMap);
        analytics.highestAverageWeight();
        analytics.checkAnnounceAndReleaseYears();
        analytics.countSingleFeatureSensors();
        analytics.mostPhonesLaunchedPost1999();}
    private static String handleCommasWithinQuotes(String input) {
        boolean isInsideQuotes = false;
        char[] characters = input.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == '\"') {
                isInsideQuotes = !isInsideQuotes; 
            } else if (characters[i] == ',' && isInsideQuotes) {
                characters[i] = '\u0007';}}
        return new String(characters);}}
