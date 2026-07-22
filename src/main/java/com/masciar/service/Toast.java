package com.masciar.service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class Toast {
    public static void showToast(Component parent, String mensaje) {

    	Window window = SwingUtilities.getWindowAncestor(parent);
        JWindow toast = new JWindow(window);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(30,45,30,45));
        panel.setBackground(new Color(45,45,48));

        JLabel label = new JLabel(mensaje);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 24));

        panel.add(label);

        toast.add(panel);
        toast.pack();

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        int x = screen.width - toast.getWidth() - 20;
        int y = screen.height - toast.getHeight() - 50;

        toast.setLocation(x, y);
        
        toast.setAlwaysOnTop(true);
        toast.setVisible(true);

        new Timer(4000, e -> {
            toast.dispose();
        }) {{
            setRepeats(false);
            start();
        }};
    }
}
