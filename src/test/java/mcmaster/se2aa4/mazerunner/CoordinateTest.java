package mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ca.mcmaster.se2aa4.mazerunner.Coordinate;

class CoordinateTest {

    @Test
    void testEquals() {
        Coordinate coord1 = new Coordinate(1, 1);
        Coordinate coord2 = new Coordinate(1, 1);
        Coordinate coord3 = new Coordinate(2, 2);

        assertEquals(coord1, coord2);
        assertNotEquals(coord1, coord3);
        assertNotEquals(coord2, coord3);
    }

    @Test
    void testHashCode() {
        Coordinate coord1 = new Coordinate(1, 1);
        Coordinate coord2 = new Coordinate(1, 1);
        Coordinate coord3 = new Coordinate(2, 2);

        assertEquals(coord1.hashCode(), coord2.hashCode());
        assertNotEquals(coord1.hashCode(), coord3.hashCode());
        assertNotEquals(coord2.hashCode(), coord3.hashCode());
    }
 }
