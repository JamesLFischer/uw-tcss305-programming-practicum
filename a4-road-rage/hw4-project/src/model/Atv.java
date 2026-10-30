package model;

import java.util.Map;

/**
 * Represents an ATV in the simulation.
 */
public class Atv extends AbstractVehicle {

    /**
     * Constructs an ATV.
     *
     * @param theX Initial X coordinate.
     * @param theY Initial Y coordinate.
     * @param theDir Initial direction.
     */
    public Atv(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, 25); // ATVs stay dead for 25 cycles
    }

    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        return theTerrain != Terrain.WALL; // ATVs can pass any terrain except walls
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
        return terrain != Terrain.WALL;
    }
}
