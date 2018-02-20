package com.kasten.chess.views;

import com.kasten.chess.containers.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class OptionsWindow extends Window {
    private ButtonGroup themeGroup;
    private ButtonGroup opponentGroup;
    private ButtonGroup difficultyGroup;
    private JButton cancelButton;
    private JButton applyButton;

    public OptionsWindow(GUI container, HashMap<String, String> state) {
        super(container, state);
        setTitle("Game Options");

        String theme = state.get("theme");
        String opponent = state.get("opponent");
        String difficulty = state.get("difficulty");

        /* Options Buttons */

        /* Day/Night Mode */
        JLabel themeHeading = new JLabel("Display Theme:");
        themeHeading.setBounds(20, 20, 200, 30);
        themeHeading.setForeground(textColor);
        JRadioButton dayRadio = new JRadioButton("Day Mode");
        dayRadio.setBounds(50, 50, 150, 20);
        dayRadio.setForeground(textColor);
        dayRadio.setActionCommand("day");
        JRadioButton nightRadio = new JRadioButton("Night Mode");
        nightRadio.setBounds(50, 75, 150, 20);
        nightRadio.setForeground(textColor);
        nightRadio.setActionCommand("night");
        if (theme.equals("day")) dayRadio.setSelected(true);
        else nightRadio.setSelected(true);
        themeGroup = new ButtonGroup();
        themeGroup.add(dayRadio);
        themeGroup.add(nightRadio);
        add(themeHeading);
        add(dayRadio);
        add(nightRadio);

        /* Human/Computer Opponent */
        JLabel opponentHeading = new JLabel("Opponent Type:");
        opponentHeading.setBounds(20, 120, 200, 30);
        opponentHeading.setForeground(textColor);
        JRadioButton humanRadio = new JRadioButton("Human");
        humanRadio.setBounds(50, 150, 150, 20);
        humanRadio.setForeground(textColor);
        humanRadio.setActionCommand("human");
        JRadioButton robotRadio = new JRadioButton("AI-Powered Robot");
        robotRadio.setBounds(50, 175, 150, 20);
        robotRadio.setForeground(textColor);
        robotRadio.setActionCommand("robot");
        if (opponent.equals("human")) humanRadio.setSelected(true);
        else robotRadio.setSelected(true);
        opponentGroup = new ButtonGroup();
        opponentGroup.add(humanRadio);
        opponentGroup.add(robotRadio);
        add(opponentHeading);
        add(humanRadio);
        add(robotRadio);

        /* Difficulty Selection */
        JLabel difficultyHeading = new JLabel("Difficulty Level:");
        difficultyHeading.setBounds(20, 220, 200, 30);
        difficultyHeading.setForeground(textColor);
        JRadioButton easyRadio = new JRadioButton("Easy");
        easyRadio.setBounds(50, 250, 150, 20);
        easyRadio.setForeground(textColor);
        easyRadio.setActionCommand("easy");
        JRadioButton normalRadio = new JRadioButton("Normal");
        normalRadio.setBounds(50, 275, 150, 20);
        normalRadio.setForeground(textColor);
        normalRadio.setActionCommand("normal");
        JRadioButton hardRadio = new JRadioButton("Hard");
        hardRadio.setBounds(50, 300, 150, 20);
        hardRadio.setForeground(textColor);
        hardRadio.setActionCommand("hard");
        if (difficulty.equals("easy")) easyRadio.setSelected(true);
        else if (difficulty.equals("normal")) normalRadio.setSelected(true);
        else hardRadio.setSelected(true);
        difficultyGroup = new ButtonGroup();
        difficultyGroup.add(easyRadio);
        difficultyGroup.add(normalRadio);
        difficultyGroup.add(hardRadio);
        add(difficultyHeading);
        add(easyRadio);
        add(normalRadio);
        add(hardRadio);

        /* 'Apply' and 'Cancel' Buttons */
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(20, 380, 100, 40);
        cancelButton.addActionListener(this);
        applyButtonTheme(cancelButton);
        add(cancelButton);
        applyButton = new JButton("Apply");
        applyButton.setBounds(280, 380, 100, 40);
        applyButton.addActionListener(this);
        applyButtonTheme(applyButton);
        add(applyButton);
        getRootPane().setDefaultButton(applyButton);
        applyButton.requestFocus();
        setVisible(true);
    }

    private void setSelectedOptions() {
        state.put("theme", themeGroup.getSelection().getActionCommand());
        state.put("opponent", opponentGroup.getSelection().getActionCommand());
        state.put("difficulty", difficultyGroup.getSelection().getActionCommand());
        state.put("view", "main");
        myGUI.setOptions(state);
    }

    /* Button Handler */
    public void actionPerformed(ActionEvent e) {
        String buttonType = e.getActionCommand();
        setVisible(false);
        switch (buttonType) {
            case "Cancel":
                myGUI.setView("main");
                break;
            case "Apply":
                setSelectedOptions();
                break;
        }
    }
}
