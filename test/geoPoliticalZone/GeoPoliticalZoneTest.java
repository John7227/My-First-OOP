package geoPoliticalZone;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GeoPoliticalZoneTest {

    @Test
    public void testIPutAState_AndItGivesMeTheGeoPoliticalZOne() {
        PoliticalZone Zone = new PoliticalZone();

        assertEquals("NORTH CENTRAL", Zone.getZone("kogi"));

    }

    @Test
    public void testIPutAWrongState_AndItThrowsAnIllegalException() {
        PoliticalZone Zone = new PoliticalZone();

        assertThrows(IllegalArgumentException.class, () -> Zone.getZone("human"));

    }
}
