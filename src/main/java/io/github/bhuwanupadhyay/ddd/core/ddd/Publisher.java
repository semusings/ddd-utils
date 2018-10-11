package io.github.bhuwanupadhyay.ddd.core.ddd;

@FunctionalInterface
public interface Publisher {

    <T> void publish(AggregateRoot<T> aggregateRoot);
}
