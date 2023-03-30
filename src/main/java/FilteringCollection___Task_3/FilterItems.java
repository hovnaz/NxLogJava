package FilteringCollection___Task_3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FilterItems {

    public static void main(String[] args) {
        List<AgentInfoBean> agentInfos = fetchItems();
        Set<String> states = new HashSet<>(Arrays.asList("ACTIVE", "IN_PROGRESS"));

        List<AgentInfoBean> filteredResults = agentInfos.stream()
                .filter(item -> states.contains(item.getStatus())).toList();

        filteredResults.forEach(System.out::println);
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
