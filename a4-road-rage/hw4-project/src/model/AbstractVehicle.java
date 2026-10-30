package model;

import java.util.Random;

/**
 * Abstract parent class for all vehicle types.
 */
public abstract class AbstractVehicle implements Vehicle {

    private final int myDeathTime;
    private final int myInitialX;
    private final int myInitialY;
    private final Direction myInitialDirection;
    private int myX;
    private int myY;
    private Direction myDirection;
    private boolean isAlive;
    private int deathCounter;

    /**
     * Constructs an AbstractVehicle.
     *
     * @param theX Initial X coordinate.
     * @param theY Initial Y coordinate.
     * @param theDir Initial direction.
     * @param theDeathTime Number of updates to revive.
     */
    protected AbstractVehicle(final int theX, final int theY, final Direction theDir, final int theDeathTime) {
        myX = theX;
        myY = theY;
        myDirection = theDir;
        myDeathTime = theDeathTime;
        myInitialX = theX;
        myInitialY = theY;
        myInitialDirection = theDir;
        isAlive = true;
    }

    @Override
    public int getX() {
        return myX;
    }

    @Override
    public int getY() {
        return myY;
    }

    @Override
    public Direction getDirection() {
        return myDirection;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public void poke() {
        if (!isAlive) {
            deathCounter++;
            if (deathCounter == myDeathTime) {
                isAlive = true;
                myDirection = Direction.random();
            }
        }
    }

    @Override
    public int getDeathTime() {
        return myDeathTime;
    }

    @Override
    public void reset() {
        myX = myInitialX;
        myY = myInitialY;
        myDirection = myInitialDirection;
        isAlive = true;
        deathCounter = 0;
    }

    @Override
    public void collide(final Vehicle theOther) {
        if (isAlive && theOther.isAlive() && myDeathTime > theOther.getDeathTime()) {
            isAlive = false;
        }
    }

    @Override
    public void setX(final int theX) {
        myX = theX;
    }

    @Override
    public void setY(final int theY) {
        myY = theY;
    }

    @Override
    public void setDirection(final Direction theDir) {
        myDirection = theDir;
    }

    @Override
    public String getImageFileName() {
        return isAlive ? getClass().getSimpleName().toLowerCase() + ".gif"
                       : getClass().getSimpleName().toLowerCase() + "_dead.gif";
    }
}
