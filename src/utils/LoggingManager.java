package utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingManager {
    private Logger mainLogger;
    private Logger errorLogger;
    private Logger infoLogger;
    private Logger warningLogger;
    public LoggingManager() {
        this.mainLogger = Logger.getGlobal();
        this.infoLogger = Logger.getLogger("infoLogger");
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
        ); //? Verde
    }

    public void logWarning(String code, String message, Throwable throwable) {
        warningLogger.log(
                Level.WARNING,
                "\u001B[33m[" + code + "] " + message + "\u001B[0m", throwable
        ); //? Amarelo
    }

    public void logError(String code, String message, Exception exception) {
        errorLogger.log(
                Level.SEVERE,
                "\u001B[31m[" + code + "] " + message + "\u001B[0m", exception
        ); //? Vermelho
    }
}
