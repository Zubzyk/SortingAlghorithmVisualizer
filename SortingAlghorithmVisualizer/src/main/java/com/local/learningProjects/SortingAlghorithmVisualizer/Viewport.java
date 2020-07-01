package com.local.learningProjects.SortingAlghorithmVisualizer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Viewport extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	public Viewport()
	{
		super();
		this.setPreferredSize(new Dimension(800, 300));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.WHITE);
		
		g2d.fillRect(0, 0, this.getSize().width, this.getSize().height);
	}
}
