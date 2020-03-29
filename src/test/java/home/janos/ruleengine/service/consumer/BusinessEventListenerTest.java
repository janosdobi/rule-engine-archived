package home.janos.ruleengine.service.consumer;

import home.janos.ruleengine.model.context.ExecutionContext;
import home.janos.ruleengine.model.event.BusinessEvent;
import home.janos.ruleengine.model.event.SimpleBusinessEvent;
import home.janos.ruleengine.service.handler.BusinessEventHandler;
import home.janos.ruleengine.util.Constants;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.messaging.MessageHeaders;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {BusinessEventListener.class})
public class BusinessEventListenerTest {

    private static final String TOPIC = "test_topic";
    private static final int PARTITION = 1;
    private static final long OFFSET = 1;
    private static final String TEST_KEY = "testKey";
    private static final String USER_ID = "userId";
    private static final String CONTEXT_ID = "contextId";

    @MockBean
    private BusinessEventHandler eventHandler;

    @Autowired
    private BusinessEventListener businessEventListener;

    private ExecutionContext context;

    @Before
    public void setup() {
        context = ExecutionContext.builder()
                .userId(USER_ID)
                .contextIdentifier(CONTEXT_ID)
                .build();
    }

    @Test
    public void consumerShouldAcceptBusinessEvents() {
        //given
        BusinessEvent businessEvent = SimpleBusinessEvent
                .builder()
                .build();
        String key = TEST_KEY;
        ConsumerRecord<String, BusinessEvent> consumerRecord =
                new ConsumerRecord<>(TOPIC, PARTITION, OFFSET, key, businessEvent);

        Map<String, Object> header = new HashMap<>();
        header.put(Constants.USER_ID, USER_ID);
        header.put(Constants.CONTEXT_IDENTIFIER, CONTEXT_ID);
        MessageHeaders messageHeaders = new MessageHeaders(header);
        given(eventHandler.handle(businessEvent, context)).willReturn(true);

        //when
        boolean res = businessEventListener.listen(consumerRecord, messageHeaders);

        //then
        assertTrue(res);
    }

    @Test
    public void consumerShouldCallHandler() {
        //given
        BusinessEvent businessEvent = SimpleBusinessEvent.builder()
                .build();
        String key = "testKey";
        ConsumerRecord<String, BusinessEvent> consumerRecord =
                new ConsumerRecord<>(TOPIC, PARTITION, OFFSET, key, businessEvent);

        Map<String, Object> header = new HashMap<>();
        header.put(Constants.USER_ID, USER_ID);
        header.put(Constants.CONTEXT_IDENTIFIER, CONTEXT_ID);
        MessageHeaders messageHeaders = new MessageHeaders(header);

        //when
        boolean res = businessEventListener.listen(consumerRecord, messageHeaders);

        //then
        Mockito.verify(eventHandler, times(1)).handle(businessEvent, context);
    }
}