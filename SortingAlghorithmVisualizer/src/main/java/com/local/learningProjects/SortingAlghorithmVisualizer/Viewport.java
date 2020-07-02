package com.local.learningProjects.SortingAlghorithmVisualizer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JPanel;

public class Viewport extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private int[] data;
	private HashSet<Integer> highlighted;
	
	public Viewport()
	{
		super();
		this.setPreferredSize(new Dimension(800, 300));
		
		this.data = new int[128];
		randomizeData();
		
		this.highlighted = new HashSet<Integer>();
		highlighted.add(4);
		highlighted.add(5);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		//background
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, this.getSize().width, this.getSize().height);
		
		//paint data bars
		paintData(g2d);
	}
	
	private void paintData(Graphics2D g2d) 
	{
		//prepare bar size data
		int barMaxWidth = this.getSize().width / this.data.length;
		int barWidth = barMaxWidth - 2;
		int barMaxHeight = this.getSize().height;
		
		//paint bars
		for (int i = 0; i < this.data.length; i++)
		{
			if (highlighted.contains(i))
			{
				g2d.setColor(Color.GREEN);
			} else
			{
				g2d.setColor(Color.BLACK);
			}
			
			int posX = i * barMaxWidth + 1;
			int barHeight = (this.data[i] * barMaxHeight) / this.data.length;
			int posY = this.getSize().height - barHeight;
			g2d.fillRect(posX, posY, barWidth, barHeight);
		}
	}
	
	public void randomizeData() 
	{
		//prepere and fill set (O(n))
		ArrayList<Integer> set = new ArrayList<Integer>();
		
		for (int i = 0; i < this.data.length; i++)
		{
			set.add(i);
		}
		
		//randomly fill data
		for (int i = 0; i < this.data.length; i++)
		{
			int random = (int)(Math.random() * set.size());
			this.data[i] = set.get(random);
			set.remove(random);
		}
	}
}
