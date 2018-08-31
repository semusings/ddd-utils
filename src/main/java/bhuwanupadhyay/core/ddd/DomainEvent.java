package bhuwanupadhyay.core.ddd;

import java.util.UUID;

public abstract class DomainEvent {

    private String eventId = UUID.randomUUID().toString();

    private String eventClassType = getClass().getName();

    public String getEventId() {
        return eventId;
    }

    public String getEventClassType() {
        return eventClassType;
    }

}
