package nx.log.task.comparator;

import java.util.function.Predicate;

/**
 * The {@code VersionComparator} interface defines methods for comparing numeric version numbers.
 */
public interface VersionComparator {

    /**
     * Determines if the current version is higher than or equal to a target version.
     *
     * @param agentVersion the target version to compare against
     * @param currentAgentVersion the current version
     * @return {@code true} if the current version is higher than or equal to the target version, otherwise {@code false}
     */
    static boolean isCurrentVersionHigherOrEqual(String agentVersion, String currentAgentVersion) {
        if (!Utils.isCorrectVersionSyntax(currentAgentVersion) || !Utils.isCorrectVersionSyntax(agentVersion)) {
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

    /**
     * The {@code Utils} interface provides utility methods for working with version numbers.
     */
    interface Utils {

        /**
         * A {@code Predicate} that tests if a given string consists of only numeric characters.
         */
        Predicate<String> IS_NUMERIC = s -> s.matches("\\d+");

        /**
         * Determines if a given string is null or contains only whitespace.
         *
         * @param str the string to check
         * @return {@code true} if the string is null or contains only whitespace, otherwise {@code false}
         */
        static boolean isEmptyString(String str) {
            return str == null || str.trim().isEmpty();
        }

        /**
         * Determines if a given string has the correct syntax for a version number.
         *
         * @param version the version string to check
         * @return {@code true} if the string has the correct syntax, otherwise {@code false}
         */
        static boolean isCorrectVersionSyntax(String version) {
            return !isEmptyString(version) && IS_NUMERIC.test(version.replaceAll("\\.", ""));
        }
    }
}
