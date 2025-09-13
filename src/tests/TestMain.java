package tests;

//* IMPORTS
import utils.LoggingManager;
import ImageInterpreter.ImagemHandler;

//* JAVA IMPORTS
import java.util.Scanner;

public class TestMain {
    protected static final LoggingManager logger = new LoggingManager();
    protected static Scanner choice = new Scanner(System.in);
    public static void loadingImagePixels() {
        try {
            ImagemHandler img = new ImagemHandler("assets/Sprite-0001.png");
            logger.logInfo(
                    "APP_TEST-200",
                    String.format(
                            "\n\nImage loaded successfully with dimensions: %dx%d and total pixels: %d",
                            img.getImage().getWidth(),
                            img.getImage().getHeight(),
                            img.getImage().getWidth() * img.getImage().getHeight()
                    )
            );
        } catch (Exception e) {
            logger.logError(
                    "APP_TEST-201",
                    "Error loading image: " + e.getMessage(), e
            );
        }
    }
    public static void
    public static void main(String[] args) {
        logger.logInfo(
                "APP_TEST-000",
                "Application TEST running..."
        );
        logger.logInfo(
                "APP_TEST-001",
                "choose a test to run:"
        );
        System.out.print("→ ");
        switch (choice.nextLine()) {
            case "1" -> loadingImagePixels();
            case "2" -> {}
            default -> System.out.println("Invalid test choice.");
        }
    }
}
