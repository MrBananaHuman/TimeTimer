package com.banana.time.timer;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

public class TimeTimer extends JApplet {
	public static JFrame frame = new JFrame("Hello");
	public static String timerTime = null;
	public static TimerPanel timerPanel = new TimerPanel();
	static JPopupMenu pop;

	static KeyListener listener = new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyChar() == 'r') {
				timerTime = JOptionPane.showInputDialog(frame, "Please enter a minute", null);
				timerPanel.timerTime = Integer.parseInt(timerTime);
				timerPanel.startMin = Calendar.getInstance().get(Calendar.MINUTE) + 60;
			}
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
		}

	};

	public static void initial() {
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setAlwaysOnTop(true);
		frame.setType(javax.swing.JFrame.Type.UTILITY);
		frame.getRootPane().putClientProperty("apple.awt.draggableWindowBackground", false);
		frame.setLocation(0, 0); // 1620 780
		frame.setSize(1920, 1080);
		frame.getContentPane().setLayout(new java.awt.BorderLayout(0, 0));
		frame.setBackground(new Color(0, 0, 0, 0));
		
		frame.getContentPane().add(timerPanel, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		TimeTimer kk = new TimeTimer();
		kk.frame.addKeyListener(listener);
		kk.initial();
	}
}
