package tests;

//* IMPORTS
import algorithms.DataStructure;
import algorithms.FloodFill;
import algorithms.Stack;
import utils.LoggingManager;
import ImageInterpreter.ImageHandler;
import viewer.Window;

//* JAVA IMPORTS
import java.util.Scanner;

public class TestMain {
    private static final LoggingManager logger = new LoggingManager();
    private static final Scanner scanner = new Scanner(System.in);

    // Load and display image information
    public static void loadImagePixels() {
        try {
            ImageHandler img = new ImageHandler("Sprite-0001.png");
            logger.logInfo(
                    "APP_TEST-200",
                    String.format(
                            "Image loaded successfully with dimensions: %dx%d and total pixels: %d",
                            img.getImage().getWidth(),
                            img.getImage().getHeight(),
                            img.getImage().getWidth() * img.getImage().getHeight()
                    )
            );
        } catch (Exception e) {
            logger.logError(
                    "APP_TEST-404",
                    "Failed to load image: " + e.getMessage(), e
            );
        }
    }

    // Open a window and show the image
    public static void displayImage() {
        try {
            new Window(
                    "Image Viewer",
                    800,
                    600,
                    new ImageHandler("Sprite-0001.png"),
                    1502,
                    50
            );
            logger.logInfo(
                    "APP_TEST-200",
                    "Window visualization executed successfully!"
            );
        } catch (Exception e) {
            logger.logError(
                    "APP_TEST-404",
                    "Failed to display window: " + e.getMessage(), e
            );
        }
    }

    // Apply FloodFill algorithm and save frames
    public static void generateFrames() {
        try {
            ImageHandler img = new ImageHandler("Sprite-0001.png");
            DataStructure structure = new Stack();
            FloodFill floodFill = new FloodFill(structure);

            // Example: fill starting from point (50, 15) with blue
            int x = 50, y = 15;
            int red = 0, green = 0, blue = 255;

            floodFill.fill(img, x, y, red, green, blue);

            logger.logInfo(
                    "APP_TEST-200",
                    "Frames created successfully!"
            );
        } catch (Exception e) {
            logger.logError(
                    "APP_TEST-404",
                    "Failed to create frames: " + e.getMessage(), e
            );
        }
    }

    public static void main(String[] args) {
        logger.logInfo("APP_TEST-000", "Application TEST running...");
        logger.logInfo("APP_TEST-001", "Choose a test to run:");
        System.out.println("1 - Load image pixels");
        System.out.println("2 - Display image in window");
        System.out.println("3 - Generate frames with FloodFill");
        System.out.print("→ ");

        String option = scanner.nextLine();
        switch (option) {
            case "1" -> loadImagePixels();
            case "2" -> displayImage();
            case "3" -> generateFrames();
            default -> System.out.println("Invalid test choice.");
        }

        scanner.close();
    }
}
