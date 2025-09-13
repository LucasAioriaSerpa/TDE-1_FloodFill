package algorithms;

import ImageInterpreter.Pixel;

import java.util.LinkedList;

public class Pilha implements EstruturaDeDados{
    private final LinkedList<Pixel> stack = new LinkedList<>();

    @Override
    public void adicionar(Pixel p){
        stack.addFirst(p);
    }

    @Override
    public Pixel remover() {
        return stack.removeFirst();
    }

    @Override
    public boolean estaVazia(){
        return stack.isEmpty();
    }
}
