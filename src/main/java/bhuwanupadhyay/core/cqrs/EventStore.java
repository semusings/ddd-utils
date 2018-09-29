package bhuwanupadhyay.core.cqrs;

import bhuwanupadhyay.core.ddd.AggregateRoot;
import bhuwanupadhyay.core.ddd.DomainEvent;

import java.util.List;

public interface EventStore {

    <T> void saveEvents(AggregateRoot<T> root);

    <T> List<DomainEvent> getEvents(AggregateRoot<T> root);
}
