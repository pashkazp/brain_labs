package ua.zp.brain.labs.oop.basics.lab20;

/**
 * Interface that specifies ability of store some data
 *
 * @param <S>
 */
public interface Storeable<S> {
    S read();

    void write(S data);

    Type getType();
}
