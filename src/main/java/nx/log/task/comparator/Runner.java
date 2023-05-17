package nx.log.task.comparator;

import static nx.log.task.comparator.VersionComparator.isCurrentVersionHigherOrEqual;

public class Runner implements VersionComparator{

    public static void main(String[] args) {
        String agentVersion = "2.10.5";
        String currentAgentVersion = "2.9.100";
        boolean result = isCurrentVersionHigherOrEqual(agentVersion, currentAgentVersion);
        System.out.println("Result: " + result);
    }
}
