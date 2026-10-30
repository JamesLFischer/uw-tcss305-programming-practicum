package model;

import java.util.Map;

/**
 * Represents a Bicycle in the simulation.
 */
public class Bicycle extends AbstractVehicle {

    /**
     * Constructs a Bicycle.
     *
     * @param theX Initial X coordinate.
     * @param theY Initial Y coordinate.
     * @param theDir Initial direction.
     */
    public Bicycle(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, 35); // Bicycles stay dead for 35 cycles
    }

    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        return theTerrain == Terrain.TRAIL ||
               (theTerrain == Terrain.STREET && (theLight == Light.GREEN || theLight == Light.YELLOW));
    }

    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        if (theNeighbors.get(getDirection()) == Terrain.TRAIL) {
            return getDirection();
        }
        if (theNeighbors.get(getDirection().left()) == Terrain.TRAIL) {
            return getDirection().left();
        }
        if (theNeighbors.get(getDirection().right()) == Terrain.TRAIL) {
            return getDirection().right();
        }
        return super.chooseDirection(theNeighbors);
    }
}
