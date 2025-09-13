package algorithms;

import java.util.LinkedList;

public class Fila implements EstruturaDeDados{
    private final LinkedList<Pixel> queue = new LinkedList<>();

    @Override
    public void adicionar(Pixel p) {
        queue.addLast(p);
    }

    @Override
    public boolean estaVazia() {
        return queue.isEmpty();
    }
}
