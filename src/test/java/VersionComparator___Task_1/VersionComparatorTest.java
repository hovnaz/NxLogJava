package VersionComparator___Task_1;

import org.junit.jupiter.api.Test;

import static VersionComparator___Task_1.VersionComparator.isCurrentVersionHigherOrEqual;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VersionComparatorTest {

    @Test
    void testIsCurrentVersionHigherOrEqual() {
        assertTrue(isCurrentVersionHigherOrEqual("1.0.0", "1.0.0"));
        assertTrue(isCurrentVersionHigherOrEqual("1.0.0", "1.0.1"));
        assertTrue(isCurrentVersionHigherOrEqual("1.0.0", "1.1.0"));
        assertTrue(isCurrentVersionHigherOrEqual("1.0.0", "2.0.0"));

        assertTrue(isCurrentVersionHigherOrEqual("1.1", "1.1.0"));
        assertTrue(isCurrentVersionHigherOrEqual("1.1", "1.1.1"));

        assertTrue(isCurrentVersionHigherOrEqual("1.1.0", "1.1"));
        assertTrue(isCurrentVersionHigherOrEqual("1.0.9", "1.1"));


        assertFalse(isCurrentVersionHigherOrEqual("1.0.1", "1.0.0"));
        assertFalse(isCurrentVersionHigherOrEqual("1.1.0", "1.0.0"));
        assertFalse(isCurrentVersionHigherOrEqual("2.0.0", "1.0.0"));


        // Test cases for empty or null strings
        assertFalse(isCurrentVersionHigherOrEqual("", ""));
        assertFalse(isCurrentVersionHigherOrEqual(null, null));
        assertFalse(isCurrentVersionHigherOrEqual("1.0.0", ""));
        assertFalse(isCurrentVersionHigherOrEqual("", "1.0.0"));
        assertFalse(isCurrentVersionHigherOrEqual("1.0.0", null));
        assertFalse(isCurrentVersionHigherOrEqual(null, "1.0.0"));
    }

}
