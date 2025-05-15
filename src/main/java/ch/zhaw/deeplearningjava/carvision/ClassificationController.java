package ch.zhaw.deeplearningjava.carvision;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ch.zhaw.deeplearningjava.carvision.dto.LabelInfo;
import ch.zhaw.deeplearningjava.carvision.dto.ModelInfo;
import ch.zhaw.deeplearningjava.carvision.dto.ClassificationResult;

/**
 * REST Controller for car type classification:
 * - Health check
 * - Fetch available models and labels
 * - Image upload and classification
 */
@RestController
public class ClassificationController {

    private final Inference inference = new Inference();

    /**
     * Returns metadata for all available labels (name + description).
     *
     * @return List of LabelInfo DTOs
     */
    @GetMapping("/labels")
    public List<LabelInfo> getLabels() {
        return inference.getLabelInfos();
    }

    /**
     * Simple health check.
     *
     * @return Status, version, and server timestamp
     */
    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of(
                "status", "UP",
                "version", "1.0.0",
                "timestamp", Instant.now().toString()
        );
    }

    /**
     * Returns a list of available models with metadata.
     *
     * @return List of ModelInfo objects representing available models
     */
    @GetMapping("/models")
    public List<ModelInfo> listModels() {
        return inference.availableModels().stream()
                .map(name -> {
                    return switch (name) {
                        case "vehicleclassifier-0010.params" -> new ModelInfo(name, 0.95, 10);
                        default -> new ModelInfo(name, null, null); // Default fallback
                    };
                })
                .collect(Collectors.toList());
    }

    /**
     * Accepts an image, performs classification, and returns a sorted list of results.
     *
     * @param image MultipartFile containing the image (JPG/PNG, etc.)
     * @return List of ClassificationResult, sorted by probability in descending order
     */
    @PostMapping(path = "/api/detect", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClassificationResult> predict(@RequestParam("image") MultipartFile image) throws Exception {
        if (image == null || image.isEmpty()) {
            throw new IllegalArgumentException("No image provided.");
        }

        System.out.println("[INFO] Received image: " + image.getOriginalFilename() +
                " (" + image.getSize() + " Bytes)");

        return inference.predict(image.getBytes())
                .items().stream()
                .map(item -> new ClassificationResult(item.getClassName(), item.getProbability()))
                .sorted((a, b) -> Double.compare(b.getProbability(), a.getProbability()))
                .collect(Collectors.toList());
    }
}