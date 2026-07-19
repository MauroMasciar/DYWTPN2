package ui;

import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class GeneralSummary extends JInternalFrame {
    private JPanel panelTitle = new JPanel();
    private JLabel lblTitle = new JLabel("Resumen general");
    private JPanel panelTime = new JPanel();
    private JLabel lblTotalTime = new JLabel("Tiempo total");
    private JLabel lblTotalTimeHoursValue = new JLabel("7387h 52m");
    private JLabel lblTotalTimeDaysValue = new JLabel("327d 0h 52m");
    private JPanel panelGameStarted = new JPanel();
    private JLabel lblTotalGamesStarted = new JLabel("Juegos iniciados");
    private JLabel lblTotalGamesStartedValue = new JLabel("152");
    private JPanel panelCompleted = new JPanel();
    private JLabel lblCompleted = new JLabel("Completados");
    private JLabel lblCompletedValue = new JLabel("48");
    private JPanel panelSessions = new JPanel();
    private JLabel lblSessions = new JLabel("Sesiones");
    private JLabel lblSessionsValue = new JLabel("96");
    
    public GeneralSummary() {
        initComponents();
    }

    public void initComponents() {
        setLayout(new GridBagLayout());
        panelTitle.setLayout(new GridBagLayout());
        panelTime.setLayout(new GridBagLayout());
        panelGameStarted.setLayout(new GridBagLayout());
        panelCompleted.setLayout(new GridBagLayout());
        panelSessions.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        GridBagConstraints gbcPanels = new GridBagConstraints();

        gbcPanels.gridx = 0;
        gbcPanels.gridy = 0;
        gbcPanels.gridwidth = 1;
        gbcPanels.gridheight = 1;
        gbcPanels.weightx = 1.0;
        gbcPanels.weighty = 1.0;
        gbcPanels.ipadx = 1;
        gbcPanels.ipady = 1;
        gbcPanels.fill = GridBagConstraints.HORIZONTAL;

        panelTitle.add(lblTitle, gbcPanels);

        gbcPanels.gridx = 0;
        gbcPanels.gridy = 0;
        panelTime.add(lblTotalTime, gbcPanels);
        gbcPanels.gridy++;
        panelTime.add(lblTotalTimeHoursValue, gbcPanels);
        gbcPanels.gridy++;
        panelTime.add(lblTotalTimeDaysValue, gbcPanels);

        gbcPanels.gridx = 0;
        gbcPanels.gridy = 0;
        panelGameStarted.add(lblTotalGamesStarted, gbcPanels);
        gbcPanels.gridy++;
        panelGameStarted.add(lblTotalGamesStartedValue, gbcPanels);

        gbcPanels.gridx = 0;
        gbcPanels.gridy = 0;
        panelCompleted.add(lblCompleted, gbcPanels);
        gbcPanels.gridy++;
        panelCompleted.add(lblCompletedValue, gbcPanels);

        gbcPanels.gridx = 0;
        gbcPanels.gridy = 0;
        panelSessions.add(lblSessions, gbcPanels);
        gbcPanels.gridy++;
        panelSessions.add(lblSessionsValue, gbcPanels);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.ipadx = 1;
        gbc.ipady = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(panelTitle, gbc);
        gbc.gridwidth = 1;
        gbc.gridy++;
        add(panelTime, gbc);
        gbc.gridx++;
        add(panelGameStarted, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        add(panelCompleted, gbc);
        gbc.gridx++;
        add(panelSessions, gbc);

        Border linea = BorderFactory.createLineBorder(Color.DARK_GRAY, 1);
        Border margen = BorderFactory.createEmptyBorder(10, 10, 10, 10);

        panelTime.setBorder(BorderFactory.createCompoundBorder(linea, margen));
        panelGameStarted.setBorder(BorderFactory.createCompoundBorder(linea, margen));
        panelCompleted.setBorder(BorderFactory.createCompoundBorder(linea, margen));
        panelSessions.setBorder(BorderFactory.createCompoundBorder(linea, margen));

        pack();
        setVisible(true);
    }
}
