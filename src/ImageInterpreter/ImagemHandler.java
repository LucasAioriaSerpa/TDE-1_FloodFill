package ImageInterpreter;

import utils.LoggingManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ImagemHandler {
    private final LoggingManager logger = new LoggingManager();
    private String filePath;
    private BufferedImage image;
    private ArrayList<Pixel> pixels;
    public ImagemHandler(String filePath) throws IOException {
        this.filePath = filePath;
        File fileImage = new File(filePath);
        this.image = ImageIO.read(fileImage);
        this.pixels = getPixels();
    }
    //? GETTERS AND SETTERS:
    public String getFilePath() { return filePath; }
    public String setFilePath(String filePath) { return this.filePath = filePath; }
    public BufferedImage getImage() { return image; }
    public void setImage(BufferedImage image) { this.image = image; }

    //? METHODS:
    private ArrayList<Pixel> getPixels() {
        ArrayList<Pixel> pixels = new ArrayList<>();
        try {
            for (int Y = 0; Y < image.getHeight(); Y++) {
                for (int X = 0; X < image.getWidth(); X++) {
                    int RGB = image.getRGB(X, Y);
                    int RED = (RGB >> 16) & 0xFF;
                    int GREEN = (RGB >> 8) & 0xFF;
                    int BLUE = RGB & 0xFF;
                    Pixel pixel = new Pixel(X, Y, RED, GREEN, BLUE);
                    pixels.add(pixel);
                    logger.logInfo(
                            "IMG-000",
                            String.format(
                                    "Pixel at position (%d, %d) with color (R:%d, G:%d, B:%d) extracted successfully.",
                                    X, Y, RED, GREEN, BLUE
                            )
                    );
                }
            }
        } catch (Exception exception) {
            logger.logError(
                    "IMG-001",
                    "Error while extracting pixels from image.",
                    exception
            );
            throw new RuntimeException(exception);
        }
        return pixels;
    }
}
