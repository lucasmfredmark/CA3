/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpErrors;

/**
 *
 * @author Låne PC
 */
public class PokemonNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>PokemonNotFoundException</code> without
     * detail message.
     */
    public PokemonNotFoundException() {
    }

    /**
     * Constructs an instance of <code>PokemonNotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PokemonNotFoundException(String msg) {
        super(msg);
    }
}
