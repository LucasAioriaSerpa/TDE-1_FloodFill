package ImageInterpreter;

import utils.LoggingManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * <h1>ImageHandler</h1>
 * <p>Class responsible for loading an image from a file path, extracting its pixels, and storing relevant information.</p>
 *
 * <h2>Attributes</h2>
 * <ul>
 *     <li>{@code filePath}: String - Stores the image file path.</li>
 *     <li>{@code image}: BufferedImage - Stores the loaded image.</li>
 *     <li>{@code dimensions}: HashMap<String, Integer> - Stores the image dimensions (width, height, and total pixels).</li>
 *     <li>{@code pixels}: ArrayList<Pixel> - Stores the extracted pixels from the image.</li>
 * </ul>
 *
 * <h2>Methods</h2>
 * <ul>
 *     <li>{@code getPixelsFromImage()}: Extracts pixels from the image and stores them in a list.</li>
 * </ul>
 */
public class ImageHandler {
    private final LoggingManager logger = new LoggingManager();
    private final String folderPath = "assets/";
    private final String folderPathCopy = "assets/copies/";
    private String filePath;
    private String fileCopyPath;
    private File fileImage;
    private File fileImageCopy;
    private BufferedImage image;
    private BufferedImage imageCopy;
    private final HashMap<String, Integer> dimensions;
    private ArrayList<Pixel> pixels;

    public ImageHandler(String file) throws IOException {
        logger.logInfo(
                "IMG-000",
                String.format("Loading image from folderPath: %s", file)
        );
        this.filePath = folderPath + file;
        this.fileCopyPath = folderPathCopy + file.replace(".png", "") + "Copy.png";
        this.fileImage = new File(this.filePath);
        this.image = ImageIO.read(fileImage);
        this.dimensions = new HashMap<>();
        this.dimensions.put("X", image.getWidth());
        this.dimensions.put("Y", image.getHeight());
        this.dimensions.put("totalPixels", image.getWidth() * image.getHeight());
        this.pixels = getPixelsFromImage();
        this.imageCopy = new BufferedImage(dimensions.get("X"), dimensions.get("Y"), BufferedImage.TYPE_INT_RGB);
        this.fileImageCopy = copyImage();
    }

    // GETTERS AND SETTERS:
    public String getFilePath() { return filePath; }
    public String setFilePath(String filePath) throws IOException {
        String file = this.filePath.replace(folderPath, "");
        fileCopyPath = folderPathCopy + file.replace(".png", "") + "Copy.png";
        fileImage = new File(this.filePath);
        image = ImageIO.read(fileImage);
        dimensions.replace("X", image.getWidth());
        dimensions.replace("Y", image.getHeight());
        dimensions.replace("totalPixels", image.getWidth() * image.getHeight());
        pixels = getPixelsFromImage();
        imageCopy = new BufferedImage(dimensions.get("X"), dimensions.get("Y"), BufferedImage.TYPE_INT_RGB);
        fileImageCopy = copyImage();
        return this.filePath = filePath;
    }
    public String getFileCopyPath() { return fileCopyPath; }
    public BufferedImage getImage() { return image; }
    public HashMap<String, Integer> getDimensions() { return dimensions; }
    public ArrayList<Pixel> getPixels() { return pixels; }

    // METHODS:
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
                            String.format("Pixel at position (%d, %d) with color (R:%d, G:%d, B:%d) extracted successfully.", X, Y, RED, GREEN, BLUE)
                    );
                }
            }
        } catch (Exception exception) {
            logger.logError("IMG-404", "Error while extracting pixels from image.", exception);
            throw new RuntimeException(exception);
        } finally {
            logger.logInfo("IMG-200", String.format("All %d pixels extracted successfully.", dimensions.get("totalPixels")));
        }
        return pixels;
    }

    public File copyImage() {
        try {
            Graphics G2D = imageCopy.createGraphics();
            G2D.drawImage(imageCopy, 0, 0, null);
            G2D.dispose();
            ImageIO.write(imageCopy, "png", new File(fileCopyPath));
            logger.logInfo(
                    "IMG-200",
                    "Image copied successfully"
            );
            return new File(fileCopyPath);
        } catch (IOException e) {
            logger.logError("IMG-404", "Error while copying image.", e);
            throw new RuntimeException(e);
        }
    }

    public void saveFrame(int frame) {
        try {
            File folder = new File("assets/copies/");
            if (!folder.exists()) { folder.mkdir(); }
            String frameFile = String.format(fileCopyPath.replace(".png", "") + "_%02d.png", frame);
            ImageIO.write(getImage(), "png", new File(frameFile));
            logger.logInfo(
                    "IMG-200",
                    String.format("Frame %02d saved", frame)
            );
        } catch (IOException e) {
            logger.logError(
                    "IMG-404",
                    "Error while saving image.", e);
            throw new RuntimeException(e);
        }
    }
}
