package AlternativeLanguageProject;
import java.util.*;
public class AnalysisFunctions {
    Map<Integer, Cell> cellMap;
    public AnalysisFunctions(Map<Integer, Cell> initialMap) {
        this.cellMap = initialMap;

    public void findMaxAverageWeight() {
        Map<String, List<Float>> weightGroupsByOem = new HashMap<>();
 for (Cell cell : cellMap.values()) {
weightGroupsByOem.computeIfAbsent(cell.getOem(), key -> new ArrayList<>()).add(cell.getBodyWeight());
 double highestAvg = 0;
 String oemWithMax = "";
 for (Map.Entry<String, List<Float>> entry : weightGroupsByOem.entrySet()) {
double avg = entry.getValue().stream().filter(Objects::nonNull).mapToDouble(Float::doubleValue).average().orElse(0);
if (avg > highestAvg) {
                highestAvg = avg;
                oemWithMax = entry.getKey();}}
        System.out.println("highest oem with average body weight: " + oemWithMax + " with an average of " + highestAvg + " grams.");}
    public void verifyAnnounceVsReleaseYears() {
        List<String> mismatchedYears = new ArrayList<>();
 for (Cell cell : cellMap.values()) {
            if (cell.getLaunchAnnounced() != null && cell.getLaunchStatus() != null &&
                !cell.getLaunchAnnounced().equals(cell.getLaunchStatus())) {
                mismatchedYears.add(cell.getOem() + " " + cell.getModel());}}
        System.out.println("Mobiles announced and released in different years: " + mismatchedYears);}
    public void countPhonesWithSingleSensor() {
        int sensorCount = 0;
        for (Cell cell : cellMap.values()) {
            if (cell.getFeaturesSensors() != null && cell.getFeaturesSensors().split(",").length == 1) {
                sensorCount++;}}
        System.out.println("Total phones one sensor: " + sensorCount);}
    public void mostLaunchesAfter1999() {
        Map<Integer, Integer> launchCountByYear = new HashMap<>();
        for (Cell cell : cellMap.values()) {
            Integer launchYear = cell.getLaunchAnnounced();
            if (launchYear != null && launchYear > 1999) {
                launchCountByYear.merge(launchYear, 1, Integer::sum);

        int yearWithMostLaunches = launchCountByYear.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse(-1);
        System.out.println("highest Years of mobile launches after 1999: " + yearWithMostLaunches);}
    public static void main(String[] args) {
        Map<Integer, Cell> cellMap = new HashMap<>();  
        AnalysisFunctions analysis = new AnalysisFunctions(cellMap);
        analysis.findMaxAverageWeight();
        analysis.verifyAnnounceVsReleaseYears();
        analysis.countPhonesWithSingleSensor();
        analysis.mostLaunchesAfter1999();}}