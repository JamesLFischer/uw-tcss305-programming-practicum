package model;

import java.util.Random;

public class CrapsGame {
    private int playerWins;
    private int houseWins;
    private int point;
    private boolean pointSet;

    private Random random;

    public CrapsGame() {
        this.playerWins = 0;
        this.houseWins = 0;
        this.point = 0;
        this.pointSet = false;
        this.random = new Random();
    }

    public int[] rollDice() {
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;
        return new int[]{die1, die2};
    }

    public String calculateOutcome(int rollTotal) {
        if (!pointSet) {
            if (rollTotal == 7 || rollTotal == 11) {
                playerWins++;
                return "Player Wins!";
            } else if (rollTotal == 2 || rollTotal == 3 || rollTotal == 12) {
                houseWins++;
                return "House Wins!";
            } else {
                point = rollTotal;
                pointSet = true;
                return "Point is set to: " + point;
            }
        } else {
            if (rollTotal == point) {
                playerWins++;
                pointSet = false;
                return "Player Wins by hitting the point!";
            } else if (rollTotal == 7) {
                houseWins++;
                pointSet = false;
                return "House Wins by rolling 7!";
            } else {
                return "Roll again!";
            }
        }
    }

    public void resetGame() {
        point = 0;
        pointSet = false;
    }

    public int getPlayerWins() {
        return playerWins;
    }

    public int getHouseWins() {
        return houseWins;
    }
}