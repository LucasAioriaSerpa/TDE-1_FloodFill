package algorithms;

import ImageInterpreter.Pixel;

/**
 * <h1>EstruturaDeDados</h1>
 * <p>Interface que define os métodos essenciais para estruturas de dados que armazenam objetos do tipo Pixel.</p>
 *
 * <h2>Métodos</h2>
 * <ul>
 *     <li>{@code adicionar(Pixel p)}: Adiciona um pixel à estrutura de dados.</li>
 *     <li>{@code remover()}: Remove e retorna um pixel da estrutura de dados.</li>
 *     <li>{@code estaVazia()}: Verifica se a estrutura de dados está vazia.</li>
 * </ul>
 * */
public interface EstruturaDeDados {
    void adicionar(Pixel p);
    Pixel remover();
    boolean estaVazia();
}
