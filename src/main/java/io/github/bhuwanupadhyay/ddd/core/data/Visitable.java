package io.github.bhuwanupadhyay.ddd.core.data;

public interface Visitable<T extends Visitor> {

    void accept(T visitor);
}
