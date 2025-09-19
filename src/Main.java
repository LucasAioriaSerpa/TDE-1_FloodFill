import ImageInterpreter.ImageHandler;
import algorithms.DataStructure;
import algorithms.FloodFill;
import algorithms.Stack;
import utils.LoggingManager;
import viewer.Window;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static LoggingManager logger = new LoggingManager();
    public static void main(String[] args) {
        try {
            logger.logInfo(
                    "MAIN-100",
                    "STARTING FRAMES CREATION"
            );
            ImageHandler imageHandler = new ImageHandler("Sprite-0001.png");
            DataStructure dataStructure = new Stack();
            FloodFill floodFill = new FloodFill(dataStructure);
            HashMap<String, Integer> pointer = new HashMap<>();
            pointer.put("x", 50);
            pointer.put("y", 15);
            pointer.put("red", 5);
            pointer.put("green", 5);
            pointer.put("blue", 5);
            floodFill.fill(imageHandler, pointer.get("x"), pointer.get("y"), pointer.get("red"), pointer.get("green"), pointer.get("blue"));
            Window window = new Window(
                    "FloodFill in practice!",
                    800,
                    600,
                    imageHandler,
                    floodFill.getFrameCounter(),
                    20
            );
            logger.logInfo(
                    "MAIN-200",
                    "FloodFill example run successfully!"
            );
        } catch (IllegalArgumentException e) {
            logger.logError("MAIN-404", "Invalid parameters passed to the FloodFill algorithm.", e);
        } catch (IndexOutOfBoundsException e) {
            logger.logError("MAIN-404", "Starting coordinates out of image bounds.", e);
        } catch (IOException e) {
            logger.logError("MAIN-404", "Error loading or saving the image!", e);
        } catch (Exception e) {
            logger.logError("MAIN-404", "Unexpected error during execution.", e);
        }
    }
    public static void creationFrames() {
        try {
            // Initialize the image
            String imagePath = "Sprite-0001.png";
            logger.logInfo("MAIN-100","Loading Image: " + imagePath);

            ImageHandler image = new ImageHandler(imagePath);

            // Choose the data structure (Stack or Queue)
            DataStructure structure = new Stack();
            logger.logInfo("MAIN-100","Chosen structure: " + structure.getClass().getSimpleName());

            // Initialize the algorithm
            FloodFill floodFill = new FloodFill(structure);

            // Define the starting pixel and new color
            int startX = 50;
            int startY = 15;
            int newRed = 255;
            int newGreen = 0;
            int newBlue = 0;
            logger.logInfo("MAIN-100",
                    String.format("Applying FloodFill at (%d, %d) with RGB color(%d,%d,%d)",
                            startX, startY, newRed, newGreen, newBlue)
            );

            floodFill.fill(image, startX, startY, newRed, newGreen, newBlue);
            logger.logInfo("MAIN-200","FloodFill algorithm completed successfully!");

            // Create the output folder if it does not exist and save the image
            String outputFolder = "../TDE-1_FloodFill/output";
            File outputDir = new File(outputFolder);
            if (!outputDir.exists()) {
                outputDir.mkdirs();
            }

            String outputFileName = "Sprite-0001_floodfill.png";
            String fullOutputPath = outputDir.getAbsolutePath() + "/" + outputFileName;

            ImageIO.write(image.getImage(), "png", new File(fullOutputPath));
            logger.logInfo("MAIN-200", "Image saved at: " + fullOutputPath);

        } catch (IllegalArgumentException e) {
            logger.logError("MAIN-404", "Invalid parameters passed to the FloodFill algorithm.", e);
        } catch (IndexOutOfBoundsException e) {
            logger.logError("MAIN-404", "Starting coordinates out of image bounds.", e);
        } catch (IOException e) {
            logger.logError("MAIN-404", "Error loading or saving the image!", e);
        } catch (Exception e) {
            logger.logError("MAIN-404", "Unexpected error during execution.", e);
        }
    }
}
