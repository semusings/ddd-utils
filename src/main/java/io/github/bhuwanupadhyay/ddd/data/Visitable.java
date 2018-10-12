package io.github.bhuwanupadhyay.ddd.data;

public interface Visitable<T extends Visitor> {

    void accept(T visitor);
}
