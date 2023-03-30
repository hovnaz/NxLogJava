package VersionComparator___Task_1;

public class VersionComparator {

    public static void main(String[] args) {
        String agentVersion = "2.10.5";
        String currentAgentVersion = "2.9.100";
        boolean result = isCurrentVersionHigherOrEqual(agentVersion, currentAgentVersion);
        System.out.println("Result: " + result);
    }

    public static boolean isCurrentVersionHigherOrEqual(String agentVersion, String currentAgentVersion) {
        if (ValidationUtils.isEmptyString(currentAgentVersion) || ValidationUtils.isEmptyString(agentVersion)) {
            return false;
        }

        String[] currentAgentVersionParts = currentAgentVersion.split("\\.");
        String[] agentVersionParts = agentVersion.split("\\.");

        for (int i = 0; i < currentAgentVersionParts.length && i < agentVersionParts.length; i++) {
            int currentPart = Integer.parseInt(currentAgentVersionParts[i]);
            int part = Integer.parseInt(agentVersionParts[i]);

            if (currentPart > part) {
                return true;
            } else if (currentPart < part) {
                return false;
            }
        }

        return true;
    }
}
