package ch.zhaw.deeplearningjava.carvision;

import ai.djl.Model;
import ai.djl.ModelException;
import ai.djl.inference.Predictor;
import ai.djl.modality.Classifications;
import ai.djl.modality.cv.Image;
import ai.djl.modality.cv.ImageFactory;
import ai.djl.modality.cv.transform.Resize;
import ai.djl.modality.cv.transform.ToTensor;
import ai.djl.modality.cv.translator.ImageClassificationTranslator;
import ai.djl.translate.TranslateException;
import ai.djl.translate.Translator;
import ch.zhaw.deeplearningjava.carvision.dto.LabelInfo;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.imageio.ImageIO;

/**
 * Handles car type classification using DJL (Deep Java Library).
 */
public class Inference {

    private static final Path MODEL_DIR = Paths.get("models");
    private Predictor<Image, Classifications> predictor;

    public Inference() {
        try {
            Model model = Models.getModel();
            model.load(MODEL_DIR, Models.MODEL_NAME);

            Translator<Image, Classifications> translator = ImageClassificationTranslator.builder()
                    .addTransform(new Resize(Models.IMAGE_WIDTH, Models.IMAGE_HEIGHT))
                    .addTransform(new ToTensor())
                    .optApplySoftmax(true)
                    .build();
            predictor = model.newPredictor(translator);

        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException("Failed to initialize the model.", e);
        }
    }

    public Classifications predict(byte[] imageData) throws ModelException, TranslateException, IOException {
        InputStream is = new ByteArrayInputStream(imageData);
        BufferedImage bi = ImageIO.read(is);
        Image img = ImageFactory.getInstance().fromImage(bi);

        return this.predictor.predict(img);
    }

    public List<String> availableModels() {
        try (Stream<Path> files = Files.list(MODEL_DIR)) {
            return files
                    .filter(p -> p.toString().endsWith(".params"))
                    .map(p -> p.getFileName().toString().replaceFirst("\\.params$", ""))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Error reading available models.", e);
        }
    }

    public List<LabelInfo> getLabelInfos() {
        Path synset = MODEL_DIR.resolve("synset.txt");
        try {
            return Files.readAllLines(synset).stream()
                    .map(label -> new LabelInfo(label, ""))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Error loading labels.", e);
        }
    }
}