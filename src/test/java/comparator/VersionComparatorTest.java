package comparator;

import org.junit.jupiter.api.Test;

import static nx.log.task.comparator.VersionComparator.isCurrentVersionHigherOrEqual;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VersionComparatorTest {

    @Test
    public void isCurrentVersionHigherOrEqual_successWithEqualsValues() {
        assertTrue(isCurrentVersionHigherOrEqual("1.0.0", "1.0.0"));
        assertTrue(isCurrentVersionHigherOrEqual("1.1", "1.1.0"));
        assertTrue(isCurrentVersionHigherOrEqual("1.1.0", "1.1"));
    }

    @Test
    public void isCurrentVersionHigherOrEqual_successWithDifferentValues() {
        assertTrue(isCurrentVersionHigherOrEqual("1.0.0", "1.0.1"));
        assertTrue(isCurrentVersionHigherOrEqual("1.0.0", "1.1.0"));
        assertTrue(isCurrentVersionHigherOrEqual("1.0.0", "2.0.0"));
        assertTrue(isCurrentVersionHigherOrEqual("1.1", "1.1.1"));
        assertTrue(isCurrentVersionHigherOrEqual("1.0.9", "1.1"));
        assertFalse(isCurrentVersionHigherOrEqual("1.0.1", "1.0.0"));
        assertFalse(isCurrentVersionHigherOrEqual("1.1.0", "1.0.0"));
        assertFalse(isCurrentVersionHigherOrEqual("2.0.0", "1.0.0"));
    }

    @Test
    public void isCurrentVersionHigherOrEqual_failWithNullableValue() {
        assertFalse(isCurrentVersionHigherOrEqual(null, null));
        assertFalse(isCurrentVersionHigherOrEqual("1.0.0", null));
        assertFalse(isCurrentVersionHigherOrEqual(null, "1.0.0"));
    }

    @Test
    public void isCurrentVersionHigherOrEqual_failWithBlankValue() {
        assertFalse(isCurrentVersionHigherOrEqual(" ", ""));
        assertFalse(isCurrentVersionHigherOrEqual("", " "));
        assertFalse(isCurrentVersionHigherOrEqual("1.0.0", ""));
        assertFalse(isCurrentVersionHigherOrEqual("", "1.0.0"));
    }

    @Test
    public void isCurrentVersionHigherOrEqual_failWithInvalidValue() {
        assertFalse(isCurrentVersionHigherOrEqual("dgbdtg.edtrg", "sr.sr"));
        assertFalse(isCurrentVersionHigherOrEqual("1.0.0", "serf.1"));
        assertFalse(isCurrentVersionHigherOrEqual("1.d.1d.0", "1.0.0"));
    }
}
