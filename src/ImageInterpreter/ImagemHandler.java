package ImageInterpreter;

import utils.LoggingManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * <h1>ImagemHandler</h1>
 * <p>Classe responsável por carregar uma imagem a partir de um caminho de arquivo, extrair seus pixels e armazenar informações relevantes.</p>
 *
 * <h2>Atributos</h2>
 * <ul>
 *     <li>{@code filePath}: String - Armazena o caminho do arquivo da imagem.</li>
 *     <li>{@code image}: BufferedImage - Armazena a imagem carregada.</li>
 *     <li>{@code dimensions}: HashMap<String, Integer> - Armazena as dimensões da imagem (largura, altura e total de pixels).</li>
 *     <li>{@code pixels}: ArrayList<Pixel> - Armazena os pixels extraídos da imagem.</li>
 * </ul>
 *
 * <h2>Métodos</h2>
 * <ul>
 *     <li>{@code getPixelsFromImage()}: Extrai os pixels da imagem e os armazena em uma lista.</li>
 * </ul>
 * */
public class ImagemHandler {
    private final LoggingManager logger = new LoggingManager();
    private String filePath;
    private BufferedImage image;
    private final HashMap<String, Integer> dimensions;
    private final ArrayList<Pixel> pixels;
    public ImagemHandler(String filePath) throws IOException {
        logger.logInfo(
                "IMG-000",
                String.format("Loading image from path: %s", filePath)
        );
        this.filePath = filePath;
        File fileImage = new File(filePath);
        this.image = ImageIO.read(fileImage);
        this.dimensions = new HashMap<>();
        this.dimensions.put("X", image.getWidth());
        this.dimensions.put("Y", image.getHeight());
        this.dimensions.put("totalPixels", image.getWidth() * image.getHeight());
        this.pixels = getPixelsFromImage();
    }
    //? GETTERS AND SETTERS:
    public String                   getFilePath() { return filePath; }
    public String                   setFilePath(String filePath) { return this.filePath = filePath; }
    public BufferedImage            getImage() { return image; }
    public void                     setImage(BufferedImage image) { this.image = image; }
    public HashMap<String, Integer> getDimensions() { return dimensions; }
    public ArrayList<Pixel>         getPixels() { return pixels; }

    //? METHODS:
    private ArrayList<Pixel> getPixelsFromImage() {
        ArrayList<Pixel> pixels = new ArrayList<>();
        try {
            for (int Y = 0; Y < dimensions.get("Y"); Y++) {
                for (int X = 0; X < dimensions.get("X"); X++) {
                    int RGB = image.getRGB(X, Y);
                    int RED = (RGB >> 16) & 0xFF;
                    int GREEN = (RGB >> 8) & 0xFF;
                    int BLUE = RGB & 0xFF;
                    Pixel pixel = new Pixel(X, Y, RED, GREEN, BLUE);
                    pixels.add(pixel);
                    logger.logInfo("IMG-100",
                            String.format("Pixel at position (%d, %d) with color (R:%d, G:%d, B:%d) extracted successfully.",X, Y, RED, GREEN, BLUE)
                    );
                }
            }
        } catch (Exception exception) {
            logger.logError("IMG-404", "Error while extracting pixels from image.", exception);
            throw new RuntimeException(exception);
        } finally {logger.logInfo("IMG-200", String.format("All %d pixels extracted successfully.", dimensions.get("totalPixels")));}
        return pixels;
    }
}
