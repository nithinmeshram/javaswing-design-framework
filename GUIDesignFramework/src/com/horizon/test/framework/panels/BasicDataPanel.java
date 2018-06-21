package com.horizon.test.framework.panels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.horizon.test.framework.model.BasicDataModel;


public class BasicDataPanel extends JPanel implements BasicUiPanel {

    private static final long serialVersionUID = 7117728205975476509L;

    private JTextField        inputField;

    private List<JComponent>  components;

    private JTextField        resultsField;


    public BasicDataPanel() {

        this.setBorder(BorderFactory.createLineBorder(Color.RED));
        this.setLayout(new GridBagLayout());
    }


    @Override
    public BasicUiPanel createUI() {

        System.out.println("createUI...");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(4, 2, 4, 2);
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.weightx = 0.5;
        gbc.ipadx = 4;
        gbc.ipady = 10;

        gbc.gridx = 1;
        gbc.gridy = 0;

        JLabel label = new JLabel("Provide Fetch ID: ");
        this.add(label, gbc);

        gbc.weightx = 1;
        gbc.gridx = 1;
        gbc.gridy = 1;

        this.inputField = new JTextField(36);
        this.add(this.inputField, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 2;

        JButton button = new JButton("Submit");
        this.add(button, gbc);
        this.getComponentsToRegister().add(button);

        gbc.gridx = 1;
        gbc.gridy = 3;

        JLabel resultLabel = new JLabel("Result: ");
        this.add(resultLabel, gbc);

        gbc.weightx = 1;
        gbc.gridx = 1;
        gbc.gridy = 4;

        this.resultsField = new JTextField(36);
        this.add(this.resultsField, gbc);

        return this;
    }


    @Override
    public List<JComponent> getComponentsToRegister() {

        if (this.components == null) {
            this.components = new ArrayList<JComponent>();
        }

        return this.components;
    }


    @Override
    public void setUIData(Set<String> inputKeys, Map<String, BasicDataModel> dataMap) {

        System.out.println("setUIData...");
        if (inputKeys != null && inputKeys.size() > 0) {
            if (dataMap != null && dataMap.size() > 0) {
                for (String key : inputKeys) {
                    this.resultsField.setText(dataMap.get(key).toString());
                }
            }
        }
    }


    public JTextField getInputField() {

        return this.inputField;
    }
}
