package algorithms;

import ImageInterpreter.Pixel;

import java.util.LinkedList;

/**
 * <h1>Fila</h1>
 * <p>Implementação de uma fila (FIFO - First In, First Out) para armazenar objetos do tipo Pixel.</p>
 *
 * <h2>Atributos</h2>
 * <ul>
 *     <li>{@code queue}: LinkedList<Pixel> - Armazena os pixels na estrutura de dados.</li>
 * </ul>
 *
 * <h2>Métodos</h2>
 * <ul>
 *     <li>{@code adicionar(Pixel p)}: Adiciona um pixel ao final da fila.</li>
 *     <li>{@code remover()}: Remove e retorna o pixel do início da fila.</li>
 *     <li>{@code estaVazia()}: Verifica se a fila está vazia.</li>
 * </ul>
 * */
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
