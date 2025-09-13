package algorithms;

import ImageInterpreter.Pixel;

public interface EstruturaDeDados {
    void adicionar(Pixel p);
    Pixel remover();
    boolean estaVazia();
}
