package io.github.bhuwanupadhyay.ddd.core.railway.message;

public class MessageRuntimeException extends RuntimeException {

    public MessageRuntimeException(Message message) {
        super(message.getText());
    }
}
