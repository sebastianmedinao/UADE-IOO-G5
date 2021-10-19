package com.UADE.view;

import javax.swing.*;

public class TestUI {
    private JPanel InicioTest;
    private JLabel lblTest;
    private JButton button1;

    public static void main(String[] args) {
        JFrame root = new JFrame("Test Title");
        root.setContentPane(new TestUI().InicioTest);
        root.setLocationRelativeTo(null);
        root.setSize(400, 400);
        root.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        root.setVisible(true);
    }
}
