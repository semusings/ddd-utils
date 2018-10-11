package io.github.bhuwanupadhyay.ddd.railway.message;

public class MessageRuntimeException extends RuntimeException {

    public MessageRuntimeException(Message message) {
        super(message.getText());
    }
}
