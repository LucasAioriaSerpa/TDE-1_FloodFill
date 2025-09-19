package algorithms;

import ImageInterpreter.Pixel;

/**
 * <h1>DataStructure</h1>
 * <p>Interface that defines the essential methods for data structures that store Pixel objects.</p>
 *
 * <h2>Methods</h2>
 * <ul>
 *     <li>{@code add(Pixel p)}: Adds a pixel to the data structure.</li>
 *     <li>{@code remove()}: Removes and returns a pixel from the data structure.</li>
 *     <li>{@code isEmpty()}: Checks if the data structure is empty.</li>
 * </ul>
 */
public interface DataStructure {
    void add(Pixel p);
    Pixel remove();
    boolean isEmpty();
}
