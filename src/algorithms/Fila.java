package algorithms;

import ImageInterpreter.Pixel;

import java.util.LinkedList;

public class Fila implements EstruturaDeDados{
    private final LinkedList<Pixel> queue = new LinkedList<>();

    @Override
    public void adicionar(Pixel p) {
        queue.addLast(p);
    }

    @Override
    public Pixel remover() {
        return queue.removeFirst();
    }

    @Override
    public boolean estaVazia() {
        return queue.isEmpty();
    }
}
