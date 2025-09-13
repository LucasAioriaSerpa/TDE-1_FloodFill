package algorithms;

import ImageInterpreter.Pixel;

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
