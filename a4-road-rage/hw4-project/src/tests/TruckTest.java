package tests;

import static org.junit.jupiter.api.Assertions.*;
import model.Truck;
import model.Direction;
import model.Terrain;
import model.Light;
import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * Unit tests for the Truck class.
 */
public class TruckTest {

    @Test
    public void testConstructor() {
        final Truck truck = new Truck(5, 10, Direction.NORTH);
        assertEquals(5, truck.getX());
        assertEquals(10, truck.getY());
        assertEquals(Direction.NORTH, truck.getDirection());
        assertTrue(truck.isAlive());
        assertEquals(0, truck.getDeathTime());
    }

    @Test
    public void testCanPass() {
        final Truck truck = new Truck(0, 0, Direction.NORTH);

        // Can pass STREET, LIGHT, and CROSSWALK if not RED.
        assertTrue(truck.canPass(Terrain.STREET, Light.GREEN));
        assertTrue(truck.canPass(Terrain.LIGHT, Light.YELLOW));
        assertTrue(truck.canPass(Terrain.CROSSWALK, Light.GREEN));
        assertFalse(truck.canPass(Terrain.CROSSWALK, Light.RED));

        // Cannot pass WALL or other invalid terrains.
        assertFalse(truck.canPass(Terrain.WALL, Light.GREEN));
    }

    @Test
    public void testChooseDirection() {
        final Truck truck = new Truck(0, 0, Direction.NORTH);

        // Simulate neighbors with valid and invalid terrains.
        final Map<Direction, Terrain> neighbors = Map.of(
                Direction.NORTH, Terrain.STREET,
                Direction.EAST, Terrain.WALL,
                Direction.SOUTH, Terrain.LIGHT,
                Direction.WEST, Terrain.CROSSWALK
        );

        // Prefer NORTH if STREET is available.
        assertEquals(Direction.NORTH, truck.chooseDirection(neighbors));

        // Test fallback logic if primary direction is invalid.
        final Map<Direction, Terrain> newNeighbors = Map.of(
                Direction.NORTH, Terrain.WALL,
                Direction.EAST, Terrain.STREET,
                Direction.SOUTH, Terrain.LIGHT,
                Direction.WEST, Terrain.CROSSWALK
        );
        assertEquals(Direction.EAST, truck.chooseDirection(newNeighbors));
    }

    @Test
    public void testCollisionBehavior() {
        final Truck truck = new Truck(0, 0, Direction.NORTH);
        final Truck otherTruck = new Truck(1, 1, Direction.SOUTH);

        truck.collide(otherTruck);
        assertTrue(truck.isAlive());
    }

    @Test
    public void testReset() {
        final Truck truck = new Truck(5, 10, Direction.NORTH);
        truck.setX(0);
        truck.setY(0);
        truck.setDirection(Direction.SOUTH);
        truck.reset();

        assertEquals(5, truck.getX());
        assertEquals(10, truck.getY());
        assertEquals(Direction.NORTH, truck.getDirection());
    }
}
