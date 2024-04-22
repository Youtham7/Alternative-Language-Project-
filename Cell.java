package AlternativeLanguageProject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Cell {
    private String oem;
    private String model;
    private Integer launchAnnounced;
    private String launchStatus;
    private String bodyDimensions;
    private Float bodyWeight;
    private String bodySim;
    private String displayType;
    private Float displaySize;
    private String displayResolution;
    private String featuresSensors;
    private String platformOs;
    public Cell(String oem, String model, String launchAnnounced, String launchStatus, 
                String bodyDimensions, String bodyWeight, String bodySim, 
                String displayType, String displaySize, String displayResolution,
                String featuresSensors, String platformOs) {
        this.oem = oem;
        this.oem = validateString(oem);
        this.model = validateString(model);
        this.launchAnnounced = extractYear(launchAnnounced);
        this.launchStatus = validateLaunchStatus(launchStatus);
        this.bodyDimensions = validateString(bodyDimensions);
        this.bodyWeight = extractWeight(bodyWeight);
        this.bodySim = validateString(bodySim);
        this.displayType = validateString(displayType);
        this.displaySize = extractSize(displaySize);
        this.displayResolution = validateString(displayResolution);
        this.featuresSensors = validateString(featuresSensors);
        this.platformOs = extractOs(platformOs);
    }    public String getOem() {
        return oem;}
    public void setOem(String oem) {
        this.oem = validateString(oem);
    }
    public String getModel() {
        return model;}
    public void setModel(String model) {
        this.model = validateString(model);}
    public Integer getLaunchAnnounced() {
        return launchAnnounced; }
    public void setLaunchAnnounced(String launchAnnounced) {
        this.launchAnnounced = extractYear(launchAnnounced);
    }
    public String getLaunchStatus() {
        return launchStatus;}
    public void setLaunchStatus(String launchStatus) {
        this.launchStatus = validateLaunchStatus(launchStatus);
    }
    public String getBodyDimensions() {
        return bodyDimensions;}
    public void setBodyDimensions(String bodyDimensions) {
        this.bodyDimensions = validateString(bodyDimensions);
    }
    public Float getBodyWeight() {
        return bodyWeight;}
    public void setBodyWeight(String bodyWeight) {
        this.bodyWeight = extractWeight(bodyWeight);
    }
    public String getBodySim() {
        return bodySim;
    }
    public void setBodySim(String bodySim) {
    this.bodySim = validateString(bodySim);}
    public String getDisplayType() {
        return displayType;
    }
    public void setDisplayType(String displayType) {
        this.displayType = validateString(displayType);}
    public Float getDisplaySize() {
        return displaySize;
    }
    public void setDisplaySize(String displaySize) {
        this.displaySize = extractSize(displaySize);}
    public String getDisplayResolution() {
        return displayResolution;}

    public void setDisplayResolution(String displayResolution) {
        this.displayResolution = validateString(displayResolution);}
    public String getFeaturesSensors() {
        return featuresSensors;}

    public void setFeaturesSensors(String featuresSensors) {
        this.featuresSensors = validateString(featuresSensors);}
    public String getPlatformOs() {
        return platformOs;}

    public void setPlatformOs(String platformOs) {
        this.platformOs = extractOs(platformOs);}    
    private String validateString(String text) {
        if (text == null || text.trim().isEmpty() || text.equals("-")) {
            return null;}
        return text;}
    private String validateLaunchStatus(String text) {
        if (text == null || text.trim().isEmpty() || text.equals("-")) {
            return null;
        }
        if (text.matches("not availabe")) {
            return text;}
        return extractYear(text) != null ? String.valueOf(extractYear(text)) : null;}
    private Integer extractYear(String text) {
        Pattern p = Pattern.compile("\\b\\d{4}\\b");
        Matcher m = p.matcher(text);
        if (m.find()) {
            return Integer.parseInt(m.group());
        }
        return null;}
    private Float extractWeight(String text) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(text);
        if (m.find()) {
            return Float.parseFloat(m.group());}
        return null;}
    private Float extractSize(String text) {
        Pattern p = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher m = p.matcher(text);
        if (m.find()) {
            return Float.parseFloat(m.group()); }
        return null;}
    private String extractOs(String text) {
        if (text != null && !text.equals("-")) {
            return text.split(",")[0];}
        return null;}
package AlternativeLanguageProject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Cell {
    private String manufacturer;
    private String modelName;
    private Integer announcedYear;
    private String status;
    private String dimensions;
    private Float weight;
    private String simConfiguration;
    private String displayType;
    private Float displayDiagonal;
    private String resolution;
    private String sensorDetails;
    private String operatingSystem;
    public Cell(String manufacturer, String modelName, String announced, String status,
                String dimensions, String weight, String sim, String displayType, 
                String displaySize, String resolution, String sensors, String os) {
        this.manufacturer = manufacturer;
        this.modelName = cleanInput(modelName);
        this.announcedYear = parseYear(announced);
        this.status = checkStatus(status);
        this.dimensions = cleanInput(dimensions);
        this.weight = parseWeight(weight);
        this.simConfiguration = cleanInput(sim);
        this.displayType = cleanInput(displayType);
        this.displayDiagonal = parseSize(displaySize);
        this.resolution = cleanInput(resolution);
        this.sensorDetails = cleanInput(sensors);
        this.operatingSystem = parseOs(os);}
    public String getManufacturer() {
        return manufacturer;
    } public void setManufacturer(String manufacturer) {
        this.manufacturer = cleanInput(manufacturer);
    } public String getModelName() {
        return modelName;
    }public void setModelName(String modelName) {
        this.modelName = cleanInput(modelName);
    }public Integer getAnnouncedYear() {
        return announcedYear;
    }public void setAnnouncedYear(String announced) {
        this.announcedYear = parseYear(announced);
    } public String getStatus() {
        return status;
    } public void setStatus(String status) {
        this.status = checkStatus(status);
    } public String getDimensions() {
        return dimensions;
    } public void setDimensions(String dimensions) {
        this.dimensions = cleanInput(dimensions);
    }public Float getWeight() {
        return weight;
    }public void setWeight(String weight) {
        this.weight = parseWeight(weight);
    }public String getSimConfiguration() {
        return simConfiguration;
    }public void setSimConfiguration(String sim) {
        this.simConfiguration = cleanInput(sim);
    } public String getDisplayType() {
        return displayType;
    }public void setDisplayType(String displayType) {
        this.displayType = cleanInput(displayType);
    }public Float getDisplayDiagonal() {
        return displayDiagonal;}
    public void setDisplayDiagonal(String displaySize) {
        this.displayDiagonal = parseSize(displaySize);}
    public String getResolution() {
        return resolution;}
    public void setResolution(String resolution) {
        this.resolution = cleanInput(resolution);}
    public String getSensorDetails() {
        return sensorDetails;}
    public void setSensorDetails(String sensors) {
        this.sensorDetails = cleanInput(sensors);}
    public String getOperatingSystem() {
        return operatingSystem;}
    public void setOperatingSystem(String os) {
        this.operatingSystem = parseOs(os);}
        private String cleanInput(String text) {
        if (text == null || text.trim().isEmpty() || text.equals("-")) {
            return null;}
        return text;}
    private String checkStatus(String text) {
        if (text == null || text.trim().isEmpty() || text.equals("-")) {
            return null;
        }
        if (text.matches("not availabe")) {
            return text; }
        return parseYear(text) != null ? String.valueOf(parseYear(text)) : null;}
    private Integer parseYear(String text) {
        Pattern yearPattern = Pattern.compile("\\b\\d{4}\\b");
        Matcher yearMatcher = yearPattern.matcher(text);
        if (yearMatcher.find()) {
            return Integer.parseInt(yearMatcher.group());}
        return null;}
    private Float parseWeight(String text) {
        Pattern weightPattern = Pattern.compile("\\d+");
        Matcher weightMatcher = weightPattern.matcher(text);
        if (weightMatcher.find()) {
            return Float.parseFloat(weightMatcher.group());
        }   return null;
    }
    private Float parseSize(String text) {
        Pattern sizePattern = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher sizeMatcher = sizePattern.matcher(text);
        if (sizeMatcher.find()) {
            return Float.parseFloat(sizeMatcher.group());}
        return null;}
    private String parseOs(String text) {
        if (text != null && !text.equals("-")) {
            return text.split(",")[0];
        }
        return null;}
    @Override
    public String toString() {
        return "Cell{" +
            "manufacturer='" + manufacturer + '\'' +
            ", modelName='" + modelName + '\'' +
            ", announcedYear=" + announcedYear +
            ", status='" + status + '\'' +
            ", dimensions='" + dimensions + '\'' +
            ", weight=" + weight +
            ", simConfiguration='" + simConfiguration + '\'' +
            ", displayType='" + displayType + '\'' +
            ", displayDiagonal=" + displayDiagonal +
            ", resolution='" + resolution + '\'' +
            ", sensorDetails='" + sensorDetails + '\'' +
            ", operatingSystem='" + operatingSystem + '\'' +
            '}';}}
    @Override
    public String toString() {
        return "Cell{" +
            "oem='" + oem + '\'' +
            ", model='" + model + '\'' +
            ", launchAnnounced=" + launchAnnounced +
            ", launchStatus='" + launchStatus + '\'' +
            ", bodyDimensions='" + bodyDimensions + '\'' +
            ", bodyWeight=" + bodyWeight +
            ", bodySim='" + bodySim + '\'' +
            ", displayType='" + displayType + '\'' +
            ", displaySize=" + displaySize +
            ", displayResolution='" + displayResolution + '\'' +
            ", featuresSensors='" + featuresSensors + '\'' +
            ", platformOs='" + platformOs + '\'' +
            '}';}}