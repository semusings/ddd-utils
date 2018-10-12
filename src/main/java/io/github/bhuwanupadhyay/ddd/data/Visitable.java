package io.github.bhuwanupadhyay.ddd.data;

public interface Visitable<T extends Visitor> {

    T accept(T visitor);
}
