package io.github.bhuwanupadhyay.cqrs;

import io.github.bhuwanupadhyay.ddd.AggregateRoot;
import io.github.bhuwanupadhyay.ddd.DomainEvent;

import java.util.List;

public interface EventStore {

    <T> void saveEvents(AggregateRoot<T> root);

    <T> List<DomainEvent> getEvents(AggregateRoot<T> root);
}
