package bhuwanupadhyay.core.railway;

import bhuwanupadhyay.core.railway.message.Message;
import bhuwanupadhyay.core.railway.message.MessageRuntimeException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static bhuwanupadhyay.core.railway.message.Message.withError;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.junit.Assert.*;

public class FailureUnitTest {

    @Test(expected = MessageRuntimeException.class)
    public void onFailureThrow() {
        Result.with(null, withError("NotNull"))
                .onFailureThrow(MessageRuntimeException::new);
    }

    @Test
    public void onEnsureAll_Succeed() {
        List<Ensure<Person, Message>> ensures = new ArrayList<>();
        ensures.add(new Ensure<>(person -> isNotBlank(person.getName()), withError("person.name.should.not.be.blank")));
        ensures.add(new Ensure<>(person -> isNotBlank(person.getEmail()), withError("person.email.should.not.be.blank")));
        ensures.add(new Ensure<>(person -> person.getEmail().contains("@"), withError("person.email.should.have_@")));
        Person person = new Person();
        person.setName("Bhuwan Upadhyay");
        person.setEmail("email@email.com");
        Result<Person, List<Message>> result =
                Result.with(person, withError("person.should.not.null"))
                        .ensureAll(ensures);
        assertTrue(result.isSuccess());
        assertFalse(result.isFailure());
    }

    @Test
    public void onEnsureAll_Failed() {
        List<Ensure<Person, Message>> ensures = new ArrayList<>();
        ensures.add(new Ensure<>(person -> isNotBlank(person.getName()), withError("person.name.should.not.be.blank")));
        ensures.add(new Ensure<>(person -> isNotBlank(person.getEmail()), withError("person.email.should.not.be.blank")));
        ensures.add(new Ensure<>(person -> person.getEmail().contains("@"), withError("person.email.should.have_@")));
        Person person = new Person();
        person.setName("");
        person.setEmail("email");
        Result<Person, List<Message>> result =
                Result.with(person, withError("person.should.not.null"))
                        .ensureAll(ensures);
        assertFalse(result.isSuccess());
        assertTrue(result.isFailure());
        List<Message> messages = result.getError();
        assertEquals("person.name.should.not.be.blank", messages.get(0).getText());
        assertEquals("person.email.should.have_@", messages.get(1).getText());
    }

}




