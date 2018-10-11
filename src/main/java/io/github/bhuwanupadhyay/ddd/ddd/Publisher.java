package io.github.bhuwanupadhyay.ddd.ddd;

@FunctionalInterface
public interface Publisher {

    <T> void publish(AggregateRoot<T> aggregateRoot);
}
