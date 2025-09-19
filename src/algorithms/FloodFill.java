package algorithms;

import ImageInterpreter.ImageHandler;
import ImageInterpreter.Pixel;
import utils.LoggingManager;

import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;

public class FloodFill {
    private final DataStructure structure;
    private final LoggingManager logger = new LoggingManager();
    private int frameCounter = 0;

    public FloodFill(DataStructure structure) {
        this.structure = structure;
    }

    public int getFrameCounter() { return frameCounter; }

    public void fill(ImageHandler imgHandler, int startX, int startY, int newRed, int newGreen, int newBlue) {
        logger.logInfo("FF-100", String.format("Starting Flood Fill algorithm at (%d,%d)", startX, startY));
        BufferedImage image = imgHandler.getImage();
        int width = image.getWidth();
        int height = image.getHeight();

        // Get the original color of the starting pixel
        int targetRGB = image.getRGB(startX, startY);

        int newRGB = (255 << 24) | (newRed << 16) | (newGreen << 8) | newBlue;

        // If the original color is the same as the new color, stop
        if (targetRGB == newRGB) {
            logger.logWarning("FF-303", "Starting color is already the same as the new color, operation canceled.", null);
            return;
        }

        // Keeps track of visited pixels
        Set<String> visitedPixels = new HashSet<>();

        structure.add(new Pixel(startX, startY, newRed, newGreen, newBlue));

        int changedPixelsCount = 0;

        while (!structure.isEmpty()) {
            try {
                // Remove the next pixel
                Pixel current = structure.remove();
                int x = current.getPosition().get("X");
                int y = current.getPosition().get("Y");

                // Create a unique key for each pixel
                String key = x + "," + y;

                // Check if the pixel has not been visited, is within bounds, and its color matches the original
                if (!visitedPixels.contains(key) &&
                        x >= 0 && x < width &&
                        y >= 0 && y < height &&
                        image.getRGB(x, y) == targetRGB
                ) {
                    // Frame generator:
                    imgHandler.saveFrame(frameCounter);

                    visitedPixels.add(key);
                    image.setRGB(x, y, newRGB);
                    changedPixelsCount++;

                    // Add the 4 neighbors (up, down, left, right) to the structure so they will be analyzed later in the loop
                    structure.add(new Pixel(x + 1, y, newRed, newGreen, newBlue));
                    structure.add(new Pixel(x - 1, y, newRed, newGreen, newBlue));
                    structure.add(new Pixel(x, y + 1, newRed, newGreen, newBlue));
                    structure.add(new Pixel(x, y - 1, newRed, newGreen, newBlue));

                    // Frame counter:
                    frameCounter++;
                }
            } catch (Exception e) {
                logger.logError("FF-404", "Error processing a pixel inside the loop.", e);
            }
        }
        // Create the last frame:
        frameCounter++;
        imgHandler.saveFrame(frameCounter);

        logger.logInfo("FF-200", "Flood Fill successfully completed! Total pixels changed: " + changedPixelsCount);
    }
}
