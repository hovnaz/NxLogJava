package VersionComparator___Task_1;

public class VersionComparator {

    public static void main(String[] args) {
        String agentVersion = "2.10.5";
        String currentAgentVersion = "2.9.100";
        boolean result = isCurrentVersionHigherOrEqual(agentVersion, currentAgentVersion);
        System.out.println("Result: " + result);
    }

    public static boolean isCurrentVersionHigherOrEqual(String agentVersion, String currentAgentVersion) {
        if (isEmptyString(currentAgentVersion) || isEmptyString(agentVersion)) {
            return false;
        }

        String[] currentVersionParts = currentAgentVersion.split("\\.");
        String[] versionParts = agentVersion.split("\\.");

        for (int i = 0; i < currentVersionParts.length && i < versionParts.length; i++) {
            int currentPart = Integer.parseInt(currentVersionParts[i]);
            int part = Integer.parseInt(versionParts[i]);

            if (currentPart != part) {
                return currentPart > part;
            }
        }
        return true;
    }

    public static boolean isEmptyString(String str) {
        return str == null || str.trim().isEmpty();
    }
}