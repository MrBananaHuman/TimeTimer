package com.banana.time.timer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JPanel;
import javax.swing.Timer;

public class TimerPanel extends JPanel implements ActionListener {
	public int startMin = 0;
	public int currentMin = 0;
	public int timerTime = 0;
	int startAngle = 0;
	int endAngle = 0;
	int timeDiff = 0;

	public TimerPanel() {
		Timer timer = new Timer(500, this);
		timer.start();
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.translate(1900, 1050);
		Paint paint = new GradientPaint(-150, -150, Color.white, 150, 150, Color.gray);
		g2.setPaint(paint);
		g2.fillOval(-190, -190, 150, 150);
		g2.setColor(Color.black);
		Stroke stroke = new BasicStroke(1);
		g2.setStroke(stroke);
		g2.drawOval(-190, -190, 150, 150);
		g2.translate(-115, -115);

		g2.setColor(Color.black);
		for (int i = 0; i < 12; i++) {
			g2.rotate(2 * Math.PI / 12);
			g2.fill3DRect(-3, -85, 3, 15, true);
		};
		g2.setColor(Color.red);
		timeDiff = (currentMin - startMin);
		
		startAngle = 90 - (timerTime * 6) + timeDiff;
		endAngle = timerTime * 6 - timeDiff;
		
		if(endAngle > 5 && timerTime > 0) {
			g2.fillArc(-75,-75,150,150,startAngle, endAngle);
		} else {
			g2.fillArc(-75,-75,150,150,0, 0);
		}
	}

	public void actionPerformed(ActionEvent e) {
		currentMin = Calendar.getInstance().get(Calendar.MINUTE) + 60;
		repaint();
	}
}