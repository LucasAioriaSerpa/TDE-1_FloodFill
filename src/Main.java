
//* IMPORTS
import utils.LoggingManager;

/**
 * Main class to run the application...
 **/
public class Main {
    protected static final LoggingManager logger = new LoggingManager();
    public static void main(String[] args) {
        logger.logInfo(
                "APP-000",
                "Application running..."
        );
    }
}