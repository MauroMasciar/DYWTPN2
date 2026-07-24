package com.masciar.ui;

import com.masciar.app.Main;
import com.masciar.controller.PlayingController;
import com.masciar.listener.GameSelectedListener;
import com.masciar.model.Games;

import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.awt.event.ActionEvent;

public class GamesList extends JInternalFrame implements ActionListener, ListSelectionListener {
	private static final long serialVersionUID = 6376047769180646261L;
	JDesktopPane desktopPane;
	
	// Panel ListGames
	private JTextField txtSearchGame = new JTextField();
	private JLabel lblMyGames = new JLabel("MIS JUEGOS");
	private JButton btnLaunch = new JButton("Lanzar");
	private JList<Games> jlistGames = new JList<>();
	private JScrollPane scrollPane = new JScrollPane(jlistGames);
	private DefaultListModel<Games> model = new DefaultListModel<>();
	private GameSelectedListener listener;
	
	public GamesList(JDesktopPane desktopPane) {
		this.desktopPane = desktopPane;
		setSize(300, 600);
		//GridBagConstraints gbcListGames = new GridBagConstraints();
		jlistGames.setModel(model);
		jlistGames.setCellRenderer(new GameRenderer());
		
		// TODO: Esto no debe ir aca, enviar a Services
		Main.gameRepository.games_list.sort(Comparator.comparing(Games::getName, String.CASE_INSENSITIVE_ORDER));
		for(Games game : Main.gameRepository.games_list) { 
			model.addElement(game); 
		}

		JPanel panel = new JPanel(new BorderLayout());
		JPanel panelNorth = new JPanel(new BorderLayout());
		panelNorth.add(txtSearchGame, BorderLayout.NORTH);
		panelNorth.add(lblMyGames, BorderLayout.SOUTH);
		panel.add(panelNorth, BorderLayout.NORTH);
		panel.add(scrollPane, BorderLayout.CENTER);
		panel.add(btnLaunch, BorderLayout.SOUTH);

		jlistGames.addListSelectionListener(this);

		add(panel);

		btnLaunch.addActionListener(this);

		setVisible(true);
	}

	public void setListener(GameSelectedListener listener) {
        this.listener = listener;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnLaunch) {
			try {
				@SuppressWarnings("unused")
				PlayingController pc = new PlayingController(jlistGames.getSelectedValue(), desktopPane);
			} catch (NullPointerException ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(listener != null) {
			listener.selectionChanged((Games) jlistGames.getSelectedValue());
		}
	}
}
