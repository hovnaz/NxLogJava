## Task I

The following method compares product version in the format "<major_version>.<minor_version>.<build_number>" and gives
greater or equal result for current version.

### Code

    public static boolean isCurrentVersionHigherOrEqual(String agentVersion, String currentAgentVersion) {
        boolean result = false;
        if (!ValidationUtils.isEmptyString(currentAgentVersion) && !ValidationUtils.isEmptyString(agentVersion)) {
            String _currentAgentVersion = currentAgentVersion.replaceAll("\\.", "");
            String _agentVersion = agentVersion.replaceAll("\\.", "");
            result = Integer.valueOf(_currentAgentVersion) >= Integer.valueOf(_agentVersion);
        }

        return result;
    }

### Code

Is there a problem in the code which will give incorrect result for some values, and if there is write solution which
will give the correct result.
