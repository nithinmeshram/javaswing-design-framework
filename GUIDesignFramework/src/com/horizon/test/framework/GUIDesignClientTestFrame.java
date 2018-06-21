package com.horizon.test.framework;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.horizon.test.framework.listeners.BasicUiActionListener;
import com.horizon.test.framework.listeners.BasicUiListener;
import com.horizon.test.framework.panels.BasicDataPanel;


public class GUIDesignClientTestFrame {

    private JFrame frame;


    public GUIDesignClientTestFrame() {

        int width = 1024;
        int height = 768;

        this.frame = new JFrame();
        this.frame.setTitle("Enter your test title");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setContentPane(new JPanel());
        this.frame.getContentPane().setLayout(new BorderLayout());

        this.frame.setSize(new Dimension(width, height));
        this.frame.setLocationRelativeTo(null);

        JDesktopPane deskTopPane = new JDesktopPane();
        this.frame.add(deskTopPane);

        JPanel basicPanel = this.addBasicPanel();
        this.frame.getContentPane().add(basicPanel);

        this.frame.setVisible(true);
    }


    private JPanel addBasicPanel() {

        BasicUiListener<BasicDataPanel> listener = new BasicUiActionListener(new BasicDataPanel());
        listener.initializeUIComponents();

        return listener.getPanel();
    }


    public static void main(String[] args) {

        new GUIDesignClientTestFrame();
    }
}
