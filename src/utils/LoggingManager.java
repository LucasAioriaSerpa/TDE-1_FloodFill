package utils;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <h1>LoggingManager</h1>
 * <h2>Classe responsável por gerenciar logs utilizando a API de logging do Java.</h2>
 *
 * <p>Este gerenciador organiza diferentes tipos de mensagens em loggers
 * separados e permite personalizar níveis de severidade. Além disso,
 * fornece métodos para registrar mensagens no console com cores e
 * códigos de status associados.</p>
 *
 * <h2>Funcionalidades</h2>
 * <ul>
 *   <li>Loggers separados para:
 *     <ul>
 *       <li>Mensagens gerais</li>
 *       <li>Informações</li>
 *       <li>Avisos</li>
 *       <li>Erros</li>
 *     </ul>
 *   </li>
 *   <li>Configuração de níveis de severidade para cada logger</li>
 *   <li>Métodos para registrar mensagens coloridas no console:
 *     <ul>
 *       <li>{@code logInfo}: mensagens informativas (verde, código 100)</li>
 *       <li>{@code logWarning}: avisos (amarelo, código 303)</li>
 *       <li>{@code logError}: erros (vermelho, código 404)</li>
 *     </ul>
 *   </li>
 *   <li>Getters e setters para personalização dos loggers</li>
 * </ul>
 *
 * <h2>Códigos de Status</h2>
 * <ul>
 *   <li><b>100</b>: Informações</li>
 *   <li><b>200</b>: Sucesso</li>
 *   <li><b>303</b>: Aviso</li>
 *   <li><b>404</b>: Erro</li>
 * </ul>
 *
 * <h2>Exemplo de Uso</h2>
 * <pre>
 * {@code LoggingManager logger = new LoggingManager();}
 * {@code logger.logInfo(
 *          "100",
 *          "Operação concluída com sucesso."
 *      );
 * }
 * {@code logger.logWarning(
 *          "303",
 *          "Atenção: Verifique os parâmetros.",
 *          throwable
 *      );
 * }
 * {@code logger.logError(
 * "404",
 * "Erro ao conectar ao banco de dados.",
 * exception);
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
