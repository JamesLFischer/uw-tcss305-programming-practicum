package model;

import java.util.Map;

/**
 * Represents a Truck in the simulation.
 */
public class Truck extends AbstractVehicle {

    /**
     * Constructs a Truck.
     *
     * @param theX Initial X coordinate.
     * @param theY Initial Y coordinate.
     * @param theDir Initial direction.
     */
    public Truck(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, 0);
    }

    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        return theTerrain == Terrain.STREET || theTerrain == Terrain.LIGHT || 
               (theTerrain == Terrain.CROSSWALK && theLight != Light.RED);
    }

    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        if (isValidDirection(getDirection(), theNeighbors)) {
            return getDirection();
        }
        if (isValidDirection(getDirection().left(), theNeighbors)) {
            return getDirection().left();
        }
        if (isValidDirection(getDirection().right(), theNeighbors)) {
            return getDirection().right();
        }
        return getDirection().reverse();
    }

    private boolean isValidDirection(final Direction dir, final Map<Direction, Terrain> neighbors) {
        final Terrain terrain = neighbors.get(dir);
        return terrain == Terrain.STREET || terrain == Terrain.LIGHT || terrain == Terrain.CROSSWALK;
    }
}
