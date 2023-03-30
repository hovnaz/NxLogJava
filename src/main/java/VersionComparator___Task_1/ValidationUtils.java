package VersionComparator___Task_1;

import java.util.Objects;

public class ValidationUtils {

    public static boolean isEmptyString(String str) {
        return Objects.isNull(str) || str.trim().isEmpty();
    }
}
