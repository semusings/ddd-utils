package bhuwanupadhyay.core.railway;

import bhuwanupadhyay.core.railway.message.MessageRuntimeException;
import org.junit.Test;

import static bhuwanupadhyay.core.railway.message.Message.withError;

public class FailureUnitTest {

    @Test(expected = MessageRuntimeException.class)
    public void onFailureThrow() {
        Result.with(null, withError("NotNull"))
                .onFailureThrow(MessageRuntimeException::new);
    }
}