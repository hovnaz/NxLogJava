package FilteringCollection___Task_3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterItems {

    public static void main(String[] args) {
        final List<AgentInfoBean> agentInfos = fetchItems();
        List<String> states = Arrays.asList("ACTIVE", "Idle");

        List<AgentInfoBean> filteredResults = filterByStates(agentInfos, states);
        System.out.println(filteredResults);
    }

    public static List<AgentInfoBean> filterByStates(List<AgentInfoBean> agentInfos, List<String> states) {
        return agentInfos.stream()
                .filter(item -> states.contains(item.status()))
                .collect(Collectors.toList());
    }

    private static List<AgentInfoBean> fetchItems() {
        // Replace this with your actual fetchItems implementation
        return Arrays.asList(
                new AgentInfoBean("ACTIVE"),
                new AgentInfoBean("IN_PROGRESS"),
                new AgentInfoBean("INACTIVE")
        );
    }
}
