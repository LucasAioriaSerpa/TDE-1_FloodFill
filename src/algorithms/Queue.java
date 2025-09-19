package algorithms;

import ImageInterpreter.Pixel;
import utils.LoggingManager;

import java.util.LinkedList;

/**
 * <h1>Queue</h1>
 * <p>Implementation of a queue (FIFO - First In, First Out) to store Pixel objects.</p>
 *
 * <h2>Attributes</h2>
 * <ul>
 *     <li>{@code queue}: LinkedList<Pixel> - Stores the pixels in the data structure.</li>
 * </ul>
 *
 * <h2>Methods</h2>
 * <ul>
 *     <li>{@code add(Pixel p)}: Adds a pixel to the end of the queue.</li>
 *     <li>{@code remove()}: Removes and returns the pixel at the front of the queue.</li>
 *     <li>{@code isEmpty()}: Checks if the queue is empty.</li>
 * </ul>
 */
public class Queue implements DataStructure {
    private final LoggingManager logger = new LoggingManager();
    private final LinkedList<Pixel> queue = new LinkedList<>();

    @Override
    public void add(Pixel p) {
        queue.addLast(p);
    }

    @Override
    public Pixel remove() {
        if (isEmpty()) {
            logger.logError("QUE-404", "Attempted to remove an element from an empty structure.",
                    new java.util.NoSuchElementException());
            throw new java.util.NoSuchElementException("Cannot remove, the data structure is empty.");
        }
        return queue.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
