package controller;

import model.BankAccount;
import model.CrapsGame;
import view.CrapsView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrapsController {
    private CrapsGame game;
    private BankAccount bankAccount;
    private CrapsView view;

    public CrapsController() {
        game = new CrapsGame();
        view = new CrapsView();

        view.getRollButton().addActionListener(new RollDiceListener());
        view.getPlayAgainButton().addActionListener(new PlayAgainListener());

        view.setVisible(true);
    }

    private class RollDiceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double bet = Double.parseDouble(view.getBetField().getText());
                bankAccount.placeBet(bet);

                int[] dice = game.rollDice();
                int rollTotal = dice[0] + dice[1];
                String outcome = game.calculateOutcome(rollTotal);

                view.getDie1Label().setText("Die 1: " + dice[0]);
                view.getDie2Label().setText("Die 2: " + dice[1]);
                view.getRollTotalLabel().setText("Roll Total: " + rollTotal);
                view.getMessageLabel().setText(outcome);

                if (outcome.contains("Wins")) {
                    view.getPlayAgainButton().setEnabled(true);
                    view.getRollButton().setEnabled(false);
                }

                if (outcome.contains("Player Wins")) {
                    bankAccount.updateBalance(true, bet);
                }

                view.getBankBalanceField().setText("Bank Balance: " + bankAccount.getBalance());

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Invalid bet or game state.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class PlayAgainListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.resetGame();
            view.getPlayAgainButton().setEnabled(false);
            view.getRollButton().setEnabled(true);
            view.getMessageLabel().setText("New Round Started!");
            view.getRollTotalLabel().setText("Roll Total: ");
            view.getPointLabel().setText("Point: ");
        }
    }

    public static void main(String[] args) {
        new CrapsController();
    }
}