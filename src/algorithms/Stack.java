package algorithms;

import ImageInterpreter.Pixel;
import utils.LoggingManager;

import java.util.LinkedList;

/**
 * <h1>Stack</h1>
 * <p>Implementation of a stack (LIFO - Last In, First Out) to store Pixel objects.</p>
 *
 * <h2>Attributes</h2>
 * <ul>
 *     <li>{@code stack}: LinkedList<Pixel> - Stores the pixels in the data structure.</li>
 * </ul>
 *
 * <h2>Methods</h2>
 * <ul>
 *     <li>{@code add(Pixel p)}: Adds a pixel to the top of the stack.</li>
 *     <li>{@code remove()}: Removes and returns the pixel from the top of the stack.</li>
 *     <li>{@code isEmpty()}: Checks if the stack is empty.</li>
 * </ul>
 */
public class Stack implements DataStructure {
    private final LoggingManager logger = new LoggingManager();
    private final LinkedList<Pixel> stack = new LinkedList<>();

    @Override
    public void add(Pixel p){
        stack.addFirst(p);
    }

    @Override
    public Pixel remove() {
        if (isEmpty()) {
            logger.logError("STK-404", "Attempted to remove an element from an empty structure.",
                    new java.util.NoSuchElementException());
            throw new java.util.NoSuchElementException("Cannot remove, the data structure is empty.");
        }
        return stack.removeFirst();
    }

    @Override
    public boolean isEmpty(){
        return stack.isEmpty();
    }
}
