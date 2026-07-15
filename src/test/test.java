package test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test extends JFrame implements ActionListener {
    JButton pausa = new JButton("Pausa");
    JButton reanudar = new JButton("reanudar");

    public LocalDateTime playStart;
    public LocalDateTime pauseStart;
    public Timer t;
    public boolean pause = false;
    public int totalTime;
    public int totalSecondsPlaying;
    public int totalSecondsPaused;

    public test() {
        playStart = LocalDateTime.now();
        t = new Timer(1000, e -> run());
    	t.start();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(pausa);
        add(reanudar);
        pausa.addActionListener(this);
        reanudar.addActionListener(this);
        pack();
        setVisible(true);
    }

    public void run() {
        

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pausa) {
            pauseStart = LocalDateTime.now();
            pause = true;
            totalSecondsPlaying += ChronoUnit.SECONDS.between(playStart, LocalDateTime.now());
        } else {
            playStart = LocalDateTime.now();
            pause = false;
            totalSecondsPaused += ChronoUnit.SECONDS.between(pauseStart, LocalDateTime.now());
        }
        
    }
}