package FilteringCollection___Task_3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilterItemsTest {

    private List<AgentInfoBean> agentInfos;
    private List<String> states;

    @BeforeEach
    void setUp() {
        agentInfos = Arrays.asList(
                new AgentInfoBean("ACTIVE"),
                new AgentInfoBean("IN_PROGRESS"),
                new AgentInfoBean("IDLE"),
                new AgentInfoBean("INACTIVE")
        );

        states = Arrays.asList("ACTIVE", "IDLE");
    }

    @Test
    void filterByStates() {
        List<AgentInfoBean> expectedResult = Arrays.asList(
                new AgentInfoBean("ACTIVE"),
                new AgentInfoBean("IDLE")
        );

        List<AgentInfoBean> actualResult = FilterItems.filterByStates(agentInfos, states);

        assertEquals(expectedResult, actualResult);
    }
}