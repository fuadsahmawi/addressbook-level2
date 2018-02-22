package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static seedu.addressbook.common.Utils.isAnyNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {


    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, new Integer(1));
        assertNotUnique(null, 1, new Integer(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
    }
    
    @Test
    public void utils_isAnyNull_returnsTrue() {
        
        //only one null object
        assertTrue(isAnyNull((Object) null));
        
        //multiple null objects
        assertTrue(isAnyNull(null, null));
        assertTrue(isAnyNull(null, null, null));
        assertTrue(isAnyNull(null, null ,null, null));
        
        //multiple null + non-null objects
        assertTrue(isAnyNull("a", null, "b"));
        assertTrue(isAnyNull(1, "a", "abc", null));
        
    }

    @Test
    public void utils_isAnyNull_returnsFalse() {

        //empty list
        assertFalse(isAnyNull());
        
        //one object
        assertFalse(isAnyNull("a"));

        //multiple objects
        assertFalse(isAnyNull("a", "b"));
        assertFalse(isAnyNull(1, "abc", "a", "b", 2));
        assertFalse(isAnyNull("d", "e", 3, 5, 7));

    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
