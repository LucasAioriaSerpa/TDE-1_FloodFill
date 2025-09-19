package utils;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <h1>LoggingManager</h1>
 * <h2>Class responsible for managing logs using Java's logging API.</h2>
 *
 * <p>This manager organizes different types of messages into separate loggers
 * and allows customization of severity levels. In addition, it provides
 * methods to log messages to the console with colors and associated
 * status codes.</p>
 *
 * <h2>Features</h2>
 * <ul>
 *   <li>Separate loggers for:
 *     <ul>
 *       <li>General messages</li>
 *       <li>Information</li>
 *       <li>Warnings</li>
 *       <li>Errors</li>
 *     </ul>
 *   </li>
 *   <li>Severity level configuration for each logger</li>
 *   <li>Methods to log colored messages to the console:
 *     <ul>
 *       <li>{@code logInfo}: informational messages (green, code 100)</li>
 *       <li>{@code logWarning}: warnings (yellow, code 303)</li>
 *       <li>{@code logError}: errors (red, code 404)</li>
 *     </ul>
 *   </li>
 *   <li>Getters and setters for logger customization</li>
 * </ul>
 *
 * <h2>Status Codes</h2>
 * <ul>
 *   <li><b>100</b>: Information</li>
 *   <li><b>200</b>: Success</li>
 *   <li><b>303</b>: Warning</li>
 *   <li><b>404</b>: Error</li>
 * </ul>
 *
 * <h2>Usage Example</h2>
 * <pre>
 * {@code LoggingManager logger = new LoggingManager();}
 * {@code logger.logInfo(
 *          "100",
 *          "Operation completed successfully."
 *      );
 * }
 * {@code logger.logWarning(
 *          "303",
 *          "Warning: Check the parameters.",
 *          throwable
 *      );
 * }
 * {@code logger.logError(
 *          "404",
 *          "Error connecting to the database.",
 *          exception
 *      );
 * }
 * </pre>
 */
public class LoggingManager {
    private Logger mainLogger;
    private Logger errorLogger;
    private Logger infoLogger;
    private Logger warningLogger;

    public LoggingManager() {
        this.mainLogger = Logger.getGlobal();
        this.infoLogger = Logger.getLogger("InfoLogger");
        this.warningLogger = Logger.getLogger("WarningLogger");
        this.errorLogger = Logger.getLogger("ErrorLogger");

        mainLogger.setLevel(Level.ALL);
        infoLogger.setLevel(Level.INFO);
        warningLogger.setLevel(Level.WARNING);
        errorLogger.setLevel(Level.SEVERE);
    }

    //? GETTERS AND SETTERS:
    public Logger getMainLogger() { return mainLogger; }
    public void setMainLogger(Logger mainLogger) { this.mainLogger = mainLogger; }

    public Logger getErrorLogger() { return errorLogger; }
    public void setErrorLogger(Logger errorLogger) { this.errorLogger = errorLogger; }

    public Logger getInfoLogger() { return infoLogger; }
    public void setInfoLogger(Logger infoLogger) { this.infoLogger = infoLogger; }

    public Logger getWarningLogger() { return warningLogger; }
    public void setWarningLogger(Logger warningLogger) { this.warningLogger = warningLogger; }

    //? METHODS:
    public void logInfo(String code, String message) {
        infoLogger.log(
                Level.INFO,
                "\u001B[32m[" + code + "] " + message + "\u001B[0m"
        ); //? Green
    }

    public void logWarning(String code, String message, Throwable throwable) {
        warningLogger.log(
                Level.WARNING,
                "\u001B[33m[" + code + "] " + message + "\u001B[0m", throwable
        ); //? Yellow
    }

    public void logError(String code, String message, Exception exception) {
        errorLogger.log(
                Level.SEVERE,
                "\u001B[31m[" + code + "] " + message + "\u001B[0m", exception
        ); //? Red
    }
}
