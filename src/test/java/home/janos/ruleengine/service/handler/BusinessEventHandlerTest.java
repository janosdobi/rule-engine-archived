package home.janos.ruleengine.service.handler;

import home.janos.ruleengine.model.context.ExecutionContext;
import home.janos.ruleengine.model.event.BusinessEvent;
import home.janos.ruleengine.model.event.SimpleBusinessEvent;
import home.janos.ruleengine.service.RuleApplicator;
import home.janos.ruleengine.service.mapper.RuleMapper;
import home.janos.ruleengine.service.producer.RuleResultProducer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SimpleBusinessEventHandler.class})
public class BusinessEventHandlerTest {

    private static final String USER_ID = "userId";
    private static final String CONTEXT_ID = "contextId";

    @MockBean
    private RuleApplicator ruleApplicator;

    @MockBean
    private RuleMapper ruleMapper;

    @MockBean
    private RuleResultProducer ruleResultProducer;

    @Autowired
    private SimpleBusinessEventHandler eventHandler;

    private ExecutionContext context;

    @Before
    public void setup() {
        context = ExecutionContext.builder()
                .userId(USER_ID)
                .contextIdentifier(CONTEXT_ID)
                .build();
    }

    @Test
    public void handleShouldReturnTrueIfSuccessful() {
        //given
        BusinessEvent businessEvent = SimpleBusinessEvent
                .builder()
                .build();

        //when
        boolean res = eventHandler.handle(businessEvent, context);

        //then
        assertTrue(res);
    }
}