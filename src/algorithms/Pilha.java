package algorithms;

import ImageInterpreter.Pixel;
import utils.LoggingManager;

import java.util.LinkedList;

/**
 * <h1>Pilha</h1>
 * <p>Implementação de uma pilha (LIFO - Last In, First Out) para armazenar objetos do tipo Pixel.</p>
 *
 * <h2>Atributos</h2>
 * <ul>
 *     <li>{@code stack}: LinkedList<Pixel> - Armazena os pixels na estrutura de dados.</li>
 * </ul>
 *
 * <h2>Métodos</h2>
 * <ul>
 *     <li>{@code adicionar(Pixel p)}: Adiciona um pixel ao topo da pilha.</li>
 *     <li>{@code remover()}: Remove e retorna o pixel do topo da pilha.</li>
 *     <li>{@code estaVazia()}: Verifica se a pilha está vazia.</li>
 * </ul>
 * */
public class Pilha implements EstruturaDeDados{
    private final LoggingManager logger = new LoggingManager();
    private final LinkedList<Pixel> stack = new LinkedList<>();

    @Override
    public void adicionar(Pixel p){
        stack.addFirst(p);
    }

    @Override
    public Pixel remover() {
        if (estaVazia()) {
            logger.logError("PLH-404", "Tentativa de remover elemento de uma estrutura vazia.",
                    new java.util.NoSuchElementException());
            throw new java.util.NoSuchElementException("Não é possível remover, a estrutura de dados está vazia.");
        }
        return stack.removeFirst();
    }

    @Override
    public boolean estaVazia(){
        return stack.isEmpty();
    }
}
