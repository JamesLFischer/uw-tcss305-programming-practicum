package view;

import javax.swing.*;
import java.awt.*;

public class CrapsView extends JFrame {
    private JLabel die1Label;
    private JLabel die2Label;
    private JLabel rollTotalLabel;
    private JLabel pointLabel;
    private JLabel messageLabel;
    private JLabel playerWinsLabel;
    private JLabel houseWinsLabel;
    private JTextField bankBalanceField;
    private JTextField betField;
    private JButton rollButton;
    private JButton playAgainButton;

    public CrapsView() {
        setTitle("Game of Craps");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        die1Label = new JLabel("Die 1: ");
        die2Label = new JLabel("Die 2: ");
        rollTotalLabel = new JLabel("Roll Total: ");
        pointLabel = new JLabel("Point: ");
        messageLabel = new JLabel("Welcome to Craps!");
        playerWinsLabel = new JLabel("Player Wins: 0");
        houseWinsLabel = new JLabel("House Wins: 0");

        bankBalanceField = new JTextField("Bank Balance: 0");
        betField = new JTextField("Enter Bet");

        rollButton = new JButton("Roll Dice");
        playAgainButton = new JButton("Play Again");
        playAgainButton.setEnabled(false);

        add(die1Label);
        add(die2Label);
        add(rollTotalLabel);
        add(pointLabel);
        add(messageLabel);
        add(playerWinsLabel);
        add(houseWinsLabel);
        add(bankBalanceField);
        add(betField);
        add(rollButton);
        add(playAgainButton);
    }

    public JLabel getDie1Label() {
        return die1Label;
    }

    public JLabel getDie2Label() {
        return die2Label;
    }

    public JLabel getRollTotalLabel() {
        return rollTotalLabel;
    }

    public JLabel getPointLabel() {
        return pointLabel;
    }

    public JLabel getMessageLabel() {
        return messageLabel;
    }

    public JLabel getPlayerWinsLabel() {
        return playerWinsLabel;
    }

    public JLabel getHouseWinsLabel() {
        return houseWinsLabel;
    }

    public JTextField getBankBalanceField() {
        return bankBalanceField;
    }

    public JTextField getBetField() {
        return betField;
    }

    public JButton getRollButton() {
        return rollButton;
    }

    public JButton getPlayAgainButton() {
        return playAgainButton;
    }
}