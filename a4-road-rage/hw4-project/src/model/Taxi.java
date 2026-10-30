package model;

import java.util.Map;

/**
 * Represents a Taxi in the simulation.
 */
public class Taxi extends AbstractVehicle {

    /**
     * Constructs a Taxi.
     *
     * @param theX Initial X coordinate.
     * @param theY Initial Y coordinate.
     * @param theDir Initial direction.
     */
    public Taxi(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, 15); // Taxis stay dead for 15 cycles
    }

    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        return theTerrain == Terrain.STREET || 
               theTerrain == Terrain.LIGHT && theLight != Light.RED || 
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
