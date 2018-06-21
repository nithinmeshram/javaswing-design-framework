package com.horizon.test.framework.listeners;

import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

import com.horizon.test.framework.command.BasicFetchActionCommand;
import com.horizon.test.framework.command.BasicActionCommand;
import com.horizon.test.framework.model.BasicDataModel;
import com.horizon.test.framework.panels.BasicDataPanel;


public class BasicUiActionListener implements BasicUiListener<BasicDataPanel> {

    private BasicDataPanel              panel;
    private BasicActionCommand actionCommand;


    public BasicUiActionListener(BasicDataPanel basicDataPanel) {

        this.panel = basicDataPanel;
    }


    @Override
    public void initializeUIComponents() {

        System.out.println("initializeUIComponents...");
        this.panel.createUI();
        List<JComponent> componentsToRegister = this.panel.getComponentsToRegister();
        if (componentsToRegister != null && componentsToRegister.size() != 0) {
            for (JComponent jComponent : componentsToRegister) {
                if (jComponent instanceof JButton) {
                    JButton button = (JButton) jComponent;
                    button.addActionListener(this);
                }
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("actionCommand: " + e.getActionCommand());
        if (this.panel == null) {
            throw new RuntimeException("Target panel is null");
        }

        String fetchID = null;
        if ("Submit".equals(e.getActionCommand())) {
            fetchID = this.panel.getInputField().getText();
            System.out.println("fetchID: " + fetchID);
            this.actionCommand = new BasicFetchActionCommand(fetchID);
        }

        Set<String> inputKeys = new HashSet<String>();
        inputKeys.add(fetchID);
        try {
            Map<String, BasicDataModel> dataMap = this.actionCommand.perform();
            System.out.println("dataMap: " + dataMap);
            this.panel.setUIData(inputKeys, dataMap);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this.panel, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }


    @Override
    public BasicDataPanel getPanel() {

        return this.panel;
    }
}
