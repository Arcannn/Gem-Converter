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

        // adding J lable to prompt user to select gem type.
        JLabel gemLabel = new JLabel("Please Select type of gem: ");
        gbc.gridx = 0; // column
        gbc.gridx = 0; // row
        gbc.anchor = GridBagConstraints.WEST; // align left EAST for right.
        add(gemLabel, gbc);

        // adding a DROPDOWN BAR. which is JComboBox
        String[] gemTypes = {"Sapphires", "Emeralds", "Diamonds","Rubies","Dragonstones"};
        JComboBox<String> gemComboBox = new JComboBox<>(gemTypes);
        gbc.gridx = 1;
        gbc.gridy =0;
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

        // adding a button for submisson
        JButton submitButton = new JButton("Submit yo gems");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // spans across 2 columns.
        gbc.anchor = GridBagConstraints.CENTER; // centers button.
        add(submitButton, gbc);

        // action listener to check event.
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // retrieve gem type
                String selectedGem = (String) gemComboBox.getSelectedItem();

                // retrieve number of gems, must be integer!
                int gemCount;
                try {
                    gemCount = Integer.parseInt(gemCountField.getText()); // get the input from text field
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(GemCoverterApplicationGUI.this,
                            "Please Enter valid number of gems.",
                            "Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // test result TEMP
                String message = "You selected " + gemCount +  " " + selectedGem + ".";
                JOptionPane.showMessageDialog(GemCoverterApplicationGUI.this,
                        message,
                        "result",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
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
