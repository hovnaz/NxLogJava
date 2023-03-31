package FilteringCollection___Task_3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterItemsTest {

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
    public void filterByStates_returnsExpectedResult() {
        List<AgentInfoBean> expectedResult = Arrays.asList(
                new AgentInfoBean("ACTIVE"),
                new AgentInfoBean("IDLE")
        );

        List<AgentInfoBean> actualResult = FilterItems.filterByStates(agentInfos, states);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void filterByStates_returnsEmptyList_whenInputListIsEmpty() {
        List<AgentInfoBean> expectedResult = Collections.emptyList();
        List<AgentInfoBean> actualResult = FilterItems.filterByStates(Collections.emptyList(), states);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void filterByStates_returnsEmptyList_whenInputStatesListIsEmpty() {
        List<AgentInfoBean> expectedResult = Collections.emptyList();
        List<AgentInfoBean> actualResult = FilterItems.filterByStates(agentInfos, Collections.emptyList());
        assertEquals(expectedResult, actualResult);
    }
}
