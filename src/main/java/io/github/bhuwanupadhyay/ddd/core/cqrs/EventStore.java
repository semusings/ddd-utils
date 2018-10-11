package io.github.bhuwanupadhyay.ddd.core.cqrs;

import io.github.bhuwanupadhyay.ddd.core.ddd.AggregateRoot;
import io.github.bhuwanupadhyay.ddd.core.ddd.DomainEvent;

import java.util.List;

public interface EventStore {

    <T> void saveEvents(AggregateRoot<T> root);

    <T> List<DomainEvent> getEvents(AggregateRoot<T> root);
}
