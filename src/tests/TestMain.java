package tests;

//* IMPORTS
import algorithms.EstruturaDeDados;
import algorithms.FloodFill;
import algorithms.Pilha;
import algorithms.Fila;
import utils.LoggingManager;
import ImageInterpreter.ImagemHandler;
import viewer.Window;

//* JAVA IMPORTS
import java.util.HashMap;
import java.util.Scanner;

public class TestMain {
    protected static final LoggingManager logger = new LoggingManager();
    protected static Scanner choice = new Scanner(System.in);
    public static void loadingImagePixels() {
        try {
            ImagemHandler img = new ImagemHandler("Sprite-0001.png");
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
                    "APP_TEST-404",
                    "Error loading image: " + e.getMessage(), e
            );
        }
    }
    public static void viewImage() {
        try {
            new Window(
                    "test",
                    800,
                    600,
                    new ImagemHandler(
                            "Sprite-0001.png"
                    ),
                    1502,
                    50
            );
            logger.logInfo(
                    "APP-TEST-200",
                    "Visualização da janela foi feita com sucesso!"
            );
        } catch (Exception e) {
            logger.logError(
                    "APP-TEST-404",
                    "Falha em mostrar a tela: " + e.getMessage(), e
            );
        }
    }
    public static void createFrames() {
        try {
            ImagemHandler img = new ImagemHandler("Sprite-0001.png");
            EstruturaDeDados estrutura = new Pilha();
            FloodFill floodFill = new FloodFill(estrutura);
            HashMap<String, Integer> point = new HashMap<>();
            point.put("X", 50);
            point.put("Y", 15);
            point.put("RED", 0);
            point.put("GREEN", 0);
            point.put("BLUE", 255);
            floodFill.colorir(img, point.get("X"), point.get("Y"), point.get("RED"), point.get("GREEN"), point.get("BLUE"));
            logger.logInfo(
                    "APP-TEST-200",
                    "Criação dos frames feita com sucesso!"
            );
        } catch (Exception e) {
            logger.logError(
                    "APP-TEST-404",
                    "Falha em criar os frames: " + e.getMessage(),e
            );
        }
    }
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
            case "2" -> viewImage();
            case "3" -> createFrames();
            default -> System.out.println("Invalid test choice.");
        }
    }
}
