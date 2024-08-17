package com.sparrow.gem.converter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GemCoverterApplicationGUI  extends JFrame {
    public GemCoverterApplicationGUI(){
        setTitle("BoarGang Gem Converter");

        // set size of the window
        setSize(500,300);

        // set the default to close running when exitting app.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // make window visible on load.
        setVisible(true);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10); // padding

        // adding JLabel to prompt user to select gem type.
        JLabel gemLabel = new JLabel("Please Select type of gem: ");
        gbc.gridx = 0; // column
        gbc.gridx = 0; // row
        gbc.anchor = GridBagConstraints.WEST; // align left EAST for right.
        add(gemLabel, gbc);

        // adding a DROPDOWN BAR. which is JComboBox
        String[] gemTypes = {"Sapphires", "Emeralds", "Diamonds","Rubies","Dragonstones"};
        JComboBox<String> gemComboBox = new JComboBox<>(gemTypes);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(gemComboBox, gbc);

        // add a space for where to enter gem amount. this is the prompt.
        JLabel countLabel = new JLabel("Enter the number of gems:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(countLabel, gbc);

        // for number of gems text field - JTextField
        JTextField gemCountField = new JTextField(10); // 10 columns wide
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.WEST;
        add(gemCountField, gbc);


        // asks if gems are cut or uncut.
        JLabel cutLabel = new JLabel("Are your gems cut or uncut?");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cutLabel, gbc);

        // cut or uncut - JComboBox
        String[] cutOptions = {"Cut", "Uncut"};
        JComboBox<String> cutComboBox = new JComboBox<>(cutOptions);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cutComboBox, gbc);


        JLabel jewelryLabel = new JLabel("Select the type of jewelry:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        jewelryLabel.setVisible(false);
        add(jewelryLabel, gbc);

        String[] jewelryTypes = {"Necklaces", "Rings", "Bracelets", "Amulet"};
        JComboBox<String> jewelryComboBox = new JComboBox<>(jewelryTypes);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        jewelryComboBox.setVisible(false);
        add(jewelryComboBox, gbc);

        // adding a button for submisson
        JButton submitButton = new JButton("Submit yo gems");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2; // spans across 2 columns.
        gbc.anchor = GridBagConstraints.CENTER; // centers button.
        add(submitButton, gbc);

        // action listener to check event.
        cutComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCutOption = (String) cutComboBox.getSelectedItem();
                if ("Cut".equalsIgnoreCase(selectedCutOption)) {
                    jewelryLabel.setVisible(true);
                    jewelryComboBox.setVisible(true);
                } else {
                    jewelryLabel.setVisible(false);
                    jewelryComboBox.setVisible(false);
                }
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve the selected gem type
                String selectedGem;
                selectedGem = (String) gemComboBox.getSelectedItem();

                // Retrieve the number of gems must be int
                int gemCount;
                try {
                    gemCount = Integer.parseInt(gemCountField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(GemCoverterApplicationGUI.this,
                            "Please enter a valid number of gems.",
                            "Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Retrieve cut or uncut option
                String selectedCutOption = (String) cutComboBox.getSelectedItem();

                if ("Cut".equalsIgnoreCase(selectedCutOption)) {
                    // Retrieve the selected jewelry type
                    String selectedJewelry = (String) jewelryComboBox.getSelectedItem();

                    // Calculate XP based on the selected gem and jewelry type
                    assert selectedGem != null;
                    int totalXP = calculateXPForJewelry(selectedGem, selectedJewelry, gemCount);

                    // Display the result
                    String message = "You selected " + gemCount + " cut " + selectedGem + " to make " + selectedJewelry + ".\n"
                            + "Total XP: " + totalXP + " XP.";
                    JOptionPane.showMessageDialog(GemCoverterApplicationGUI.this,
                            message,
                            "Result",
                            JOptionPane.INFORMATION_MESSAGE);

                } else if ("Uncut".equalsIgnoreCase(selectedCutOption)) {
                    // Calculate XP for cutting uncut gems
                    assert selectedGem != null;
                    int uncutXP = calculateXPForUncutGems(selectedGem, gemCount);

                    // Display the result
                    String message = "You selected " + gemCount + " uncut " + selectedGem + ".\n"
                            + "Total XP for cutting: " + uncutXP + " XP.";
                    JOptionPane.showMessageDialog(GemCoverterApplicationGUI.this,
                            message,
                            "Result",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    private int calculateXPForJewelry(String gem, String jewelry, int count) {
        int xp = 0;
        switch (gem.toLowerCase()) {
            case "sapphires":
                if (jewelry.equalsIgnoreCase("Necklaces")) xp = 55;
                else if (jewelry.equalsIgnoreCase("Rings")) xp = 40;
                else if (jewelry.equalsIgnoreCase("Bracelets")) xp = 60;
                else if (jewelry.equalsIgnoreCase("Amulets")) xp = 65;
                break;
            case "emeralds":
                if (jewelry.equalsIgnoreCase("Necklaces")) xp = 60;
                else if (jewelry.equalsIgnoreCase("Rings")) xp = 55;
                else if (jewelry.equalsIgnoreCase("Bracelets")) xp = 65;
                else if (jewelry.equalsIgnoreCase("Amulets")) xp = 70;
                break;
            case "diamonds":
                if (jewelry.equalsIgnoreCase("Necklaces")) xp = 90;
                else if (jewelry.equalsIgnoreCase("Rings")) xp = 85;
                else if (jewelry.equalsIgnoreCase("Bracelets")) xp = 95;
                else if (jewelry.equalsIgnoreCase("Amulets")) xp = 100;
                break;
            case "rubies":
                if (jewelry.equalsIgnoreCase("Necklaces")) xp = 75;
                else if (jewelry.equalsIgnoreCase("Rings")) xp = 70;
                else if (jewelry.equalsIgnoreCase("Bracelets")) xp = 80;
                else if (jewelry.equalsIgnoreCase("Amulets")) xp = 85;
                break;
            case "dragonstones":
                if (jewelry.equalsIgnoreCase("Necklaces")) xp = 150;
                else if (jewelry.equalsIgnoreCase("Rings")) xp = 140;
                else if (jewelry.equalsIgnoreCase("Bracelets")) xp = 160;
                else if (jewelry.equalsIgnoreCase("Amulets")) xp = 165;
                break;
        }
        return xp * count;
    }

    // Method to calculate XP for cutting uncut gems
    private int calculateXPForUncutGems(String gem, int count) {
        int xp = 0;
        switch (gem.toLowerCase()) {
            case "sapphires":
                xp = 50;
                break;
            case "emeralds":
                xp = 67;
                break;
            case "diamonds":
                xp = 107;
                break;
            case "rubies":
                xp = 85;
                break;
            case "dragonstones":
                xp = 150;
                break;
        }
        return xp * count;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GemCoverterApplicationGUI();
            }
        });
    }
}
