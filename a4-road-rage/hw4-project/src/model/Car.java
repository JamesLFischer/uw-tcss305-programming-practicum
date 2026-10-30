package model;

import java.util.Map;

/**
 * Represents a Car in the simulation.
 */
public class Car extends AbstractVehicle {

    public Car(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, 15);
    }

    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        return theTerrain == Terrain.STREET || theTerrain == Terrain.LIGHT && theLight != Light.RED;
    }

    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        if (neighbors.get(getDirection()) == Terrain.STREET) return getDirection();
        // Further logic follows Truck...
    }
}
