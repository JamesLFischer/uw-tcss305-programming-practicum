package model;

import java.util.Map;

/**
 * Represents a Human in the simulation.
 */
public class Human extends AbstractVehicle {

    /**
     * Constructs a Human.
     *
     * @param theX Initial X coordinate.
     * @param theY Initial Y coordinate.
     * @param theDir Initial direction.
     */
    public Human(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, 45); // Humans stay dead for 45 cycles
    }

    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        return theTerrain == Terrain.GRASS || 
               (theTerrain == Terrain.CROSSWALK && theLight != Light.GREEN);
    }

    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        if (theNeighbors.get(getDirection()) == Terrain.CROSSWALK) {
            return getDirection();
        }
        if (theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK) {
            return getDirection().left();
        }
        if (theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK) {
            return getDirection().right();
        }
        return getDirection().reverse();
    }
}
