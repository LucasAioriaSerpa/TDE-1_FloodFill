package ImageInterpreter;

public class Pixel {
    private int[] position;
    private int[] color;
    public Pixel(int x, int y, int red, int green, int blue) {
        this.position = new int[]{x, y};
        this.color = new int[]{red, green, blue};
    }
    //? GETTERS AND SETTERS:
    public int[] getPosition() { return position; }
    public void setPosition(int[] position) { this.position = position; }
    public int[] getColor() { return color; }
    public void setColor(int[] color) { this.color = color; }
}
