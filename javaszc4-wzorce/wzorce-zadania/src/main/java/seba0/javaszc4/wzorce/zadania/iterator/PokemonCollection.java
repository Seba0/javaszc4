package seba0.javaszc4.wzorce.zadania.iterator;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Collection of Pokemons
 *
 * @author sebastian
 */
public class PokemonCollection implements Iterable<Pokemon> {

    private final Collection<Pokemon> pokemons = new LinkedList<>();

    /**
     * Add new Pokemon
     *
     * @param pokemon Pokemon to add
     * @return true if Pokemon was added
     */
    public boolean add(Pokemon pokemon) {
        return pokemons.add(pokemon);
    }

    /**
     * Remove Pokemon
     *
     * @param pokemon Pokemon to remove
     * @return true if Pokemon was removed
     */
    public boolean remove(Pokemon pokemon) {
        return pokemons.remove(pokemon);
    }

    /**
     * Pokemon collection iterator
     *
     * @return Pokemon collection iterator
     */
    @Override
    public ArrayIterator<Pokemon> iterator() {
        return new ArrayIterator<>(pokemons);
    }

}
