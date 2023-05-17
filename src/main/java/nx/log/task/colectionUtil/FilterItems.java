package nx.log.task.colectionUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterItems {

    private static final String[] VALUES = {"ACTIVE", "Idle"};

    /**
     * Main method that fetches a list of {@link AgentInfoBean} objects and filters them by their status state.
     * Prints the filtered list to the console.
     */
    public static void main(String[] args) {
        final List<AgentInfoBean> agentInfos = fetchItems();
        List<String> states = Arrays.asList(VALUES);

        List<AgentInfoBean> filteredResults = filterByStates(agentInfos, states);
        System.out.println(filteredResults);
    }

    /**
     * Filters a list of {@link AgentInfoBean} objects based on their status state.
     * @param agentInfos the list of {@link AgentInfoBean} objects to filter
     * @param states the list of valid status values
     * @return a new list of {@link AgentInfoBean} objects whose status state is in the provided list of valid status values
     */
    public static List<AgentInfoBean> filterByStates(List<AgentInfoBean> agentInfos, List<String> states) {
        return agentInfos.stream()
                .filter(item -> states.contains(item.getStatus()))
                .collect(Collectors.toList());
    }

    public static List<AgentInfoBean> fetchItems() {
        return Arrays.asList(
                new AgentInfoBean(VALUES[0]),
                new AgentInfoBean(VALUES[1]),
                new AgentInfoBean("INACTIVE")
        );
    }
}
