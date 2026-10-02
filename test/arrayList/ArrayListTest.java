package arrayList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayListTest {

    @Test
    public void testThatTheArrayListIsEmpty() {
        ArrayList myArrayList = new ArrayList();

        assertTrue(myArrayList.isEmpty());
    }

    @Test
    public void testThatIAddASpecificElementAndItAppendsToTheEndOfTheList() {
        ArrayList myArrayList = new ArrayList();

        myArrayList.add("First");
        assertFalse(myArrayList.isEmpty());
    }

}
