package ch.zhaw.deeplearningjava.carvision.dto;

/**
 * Represents the result of a car type classification.
 * This DTO is immutable and validates inputs in the constructor.
 *
 * @param className   The technical name of the car type label (e.g., "SUV").
 * @param probability The probability for this label (0.0 to 1.0).
 */
public class ClassificationResult {
    private String className;
    private double probability;

    public ClassificationResult() {
    }

    public ClassificationResult(String className, double probability) {
        this.className = className;
        this.probability = probability;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }
}