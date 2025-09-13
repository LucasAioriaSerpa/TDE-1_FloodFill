package ImageInterpreter;

import utils.LoggingManager;

import java.util.HashMap;

/**
 * <h1>Píxel</h1>
 * <p>Armazena informações importante de um pixel, utilizando hashMap para armazenar posição e cor.</p>
 *
 * <h2>Atributos</h2>
 * <ul>
 *     <li>{@code position}: HashMap<String, Integer> - Armazena as coordenadas X e Y do pixel.</li>
 *     <li>{@code color}: HashMap<String, Integer> - Armazena os valores de cor RGB do pixel.</li>
 * </ul>
 * <h2>Métodos</h2>
 * <ul>
 *     <li>{@code Construtor}: Inicializa um pixel com posição e cor fornecidas.</li>
 *     <li>{@code Getters e Setters}: Métodos para acessar e modificar os atributos position e color.</li>
 * </ul>
 * */
public class Pixel {
    private HashMap<String, Integer> position;
    private HashMap<String, Integer> color;
    public Pixel(int x, int y, int red, int green, int blue) {
        LoggingManager loggingManager = new LoggingManager();
        loggingManager.logInfo(
                "PIX-000",
                String.format(
                        "Creating pixel at position (%d, %d) with color (R:%d, G:%d, B:%d).",
                        x, y, red, green, blue
                )
        );
        this.position = new HashMap<String, Integer>();
        this.color = new HashMap<String, Integer>();
        this.position.put("X", x);
        this.position.put("Y", y);
        this.color.put("R", red);
        this.color.put("G", green);
        this.color.put("B", blue);

    }
    //? GETTERS AND SETTERS:
    public HashMap<String, Integer> getPosition() { return position; }
    public void setPosition(HashMap<String, Integer> position) { this.position = position; }
    public HashMap<String, Integer> getColor() { return color; }
    public void setColor(HashMap<String, Integer> color) { this.color = color; }
}
