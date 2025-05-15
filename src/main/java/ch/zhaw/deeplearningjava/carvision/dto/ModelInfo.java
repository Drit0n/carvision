package ch.zhaw.deeplearningjava.carvision.dto;

/**
 * Represents metadata for a classification model.
 *
 * @param name     The name of the model (e.g., "carclassifier-0005").
 * @param accuracy The accuracy of the model (e.g., 0.95 for 95% accuracy).
 * @param epochs   The number of training epochs used for the model.
 */
public class ModelInfo {
    private String name;
    private Double accuracy;
    private Integer epochs;

    // Constructor
    public ModelInfo(String name, Double accuracy, Integer epochs) {
        this.name = name;
        this.accuracy = accuracy;
        this.epochs = epochs;
    }

    // Getters (for JSON serialization with Spring Boot)
    public String getName() {
        return name;
    }

    public Double getAccuracy() {
        return accuracy;
    }

    public Integer getEpochs() {
        return epochs;
    }
}