package com.local.learningProjects.SortingAlghorithmVisualizer;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.Spring;
import javax.swing.SpringLayout;

public class MainWindow extends JFrame implements ComponentListener, ActionListener
{
	private static final long serialVersionUID = -8818973763021032820L;
	private static final String windowName = "Sorting Alghorithm Visualizer";
	private static final String problemSizeLabelText = "Problem Size";
	private static final String stopResumeButtonText_a = "Resume";
	private static final String stopResumeButtonText_b = "Stop";
	private static final String randomizeButtonText = "Randomize";
	private static final String animationSpeedSliderLabelText = "Animation Speed";
	private static final String bubbleSortButtonText = "Bubble sort";
	private static final String aSortButtonText = "a sort";
	private static final String bSortButtonText = "b sort";
	private static final String cSortButtonText = "c sort";
	private static final String dSortButtonText = "d sort";
	private static final String eSortButtonText = "e sort";
	
	private Viewport viewport;
	private JPanel controlPanel;
	private JPanel algorithmPanel;
	//private JPanel problemSizeSubPanel;
	//private JLabel problemSizeLabel;
	//private JTextPane problemSizeTextField;
	private JButton stopResumeButton;
	private JButton randomizeButton;
	private JPanel animationSpeedSliderSubPanel;
	private JLabel animationSpeedSliderLabel;
	private JSlider animationSpeedSlider;
	private JButton bubbleSortButton;
	private JButton aSortButton;
	private JButton bSortButton;
	private JButton cSortButton;
	private JButton dSortButton;
	private JButton eSortButton;
	private JPanel infoPanel;
	private JLabel infoLabel;
	
	public MainWindow()
	{
		super(windowName);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.viewport = new Viewport();
		this.controlPanel = new JPanel(new GridLayout(1, 4));
		this.algorithmPanel = new JPanel(new GridLayout(1, 6));
		//this.problemSizeSubPanel = new JPanel(new GridLayout(2,1));
		this.animationSpeedSliderSubPanel = new JPanel(new GridLayout(2,1));
		//this.problemSizeLabel = new JLabel(problemSizeLabelText, JLabel.CENTER);
		//this.problemSizeTextField = new JTextPane();
		this.stopResumeButton = new JButton(stopResumeButtonText_a);
		this.randomizeButton = new JButton(randomizeButtonText);
		this.animationSpeedSliderLabel = new JLabel(animationSpeedSliderLabelText, JLabel.CENTER);
		this.animationSpeedSlider = new JSlider();
		this.bubbleSortButton = new JButton(bubbleSortButtonText);
		this.aSortButton = new JButton(aSortButtonText);
		this.bSortButton = new JButton(bSortButtonText);
		this.cSortButton = new JButton(cSortButtonText);
		this.dSortButton = new JButton(dSortButtonText);
		this.eSortButton = new JButton(eSortButtonText);
		this.infoPanel = new JPanel(new FlowLayout());
		this.infoLabel = new JLabel("test label", JLabel.CENTER);
		
		Container contentPane = this.getContentPane();
        SpringLayout layout = new SpringLayout();
        contentPane.setLayout(layout);
        
        contentPane.add(controlPanel);
        contentPane.add(viewport);
        contentPane.add(algorithmPanel);
        contentPane.add(infoPanel);
        
        //problemSizeSubPanel.add(problemSizeLabel);
        //problemSizeSubPanel.add(problemSizeTextField);
        //controlPanel.add(problemSizeSubPanel);
        controlPanel.add(randomizeButton);
        controlPanel.add(stopResumeButton);
        animationSpeedSliderSubPanel.add(animationSpeedSliderLabel);
        animationSpeedSliderSubPanel.add(animationSpeedSlider);
        controlPanel.add(animationSpeedSliderSubPanel);
        
        algorithmPanel.add(bubbleSortButton);
        algorithmPanel.add(aSortButton);
        algorithmPanel.add(bSortButton);
        algorithmPanel.add(cSortButton);
        algorithmPanel.add(dSortButton);
        algorithmPanel.add(eSortButton);
        
        infoPanel.add(infoLabel);
        
        layout.putConstraint(SpringLayout.WEST, contentPane, -10, SpringLayout.WEST, controlPanel);
        layout.putConstraint(SpringLayout.NORTH, contentPane, -10, SpringLayout.NORTH, controlPanel);
        layout.putConstraint(SpringLayout.EAST, contentPane, 10, SpringLayout.EAST, controlPanel);
        layout.putConstraint(SpringLayout.SOUTH, contentPane, 10, SpringLayout.SOUTH, infoPanel);
        
        
        layout.putConstraint(SpringLayout.WEST, controlPanel, 10, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, controlPanel, 10, SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST, viewport, 10, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, viewport, 10, SpringLayout.SOUTH, controlPanel);
        layout.putConstraint(SpringLayout.EAST, viewport, -10, SpringLayout.EAST, contentPane);
        
        layout.putConstraint(SpringLayout.NORTH, algorithmPanel, 10, SpringLayout.SOUTH, viewport);
        layout.putConstraint(SpringLayout.EAST, algorithmPanel, -10, SpringLayout.EAST, contentPane);
        layout.putConstraint(SpringLayout.WEST, algorithmPanel, 10, SpringLayout.WEST, contentPane); 
        
        layout.putConstraint(SpringLayout.NORTH, infoPanel, 10, SpringLayout.SOUTH, algorithmPanel);
        layout.putConstraint(SpringLayout.EAST, infoPanel, -10, SpringLayout.EAST, contentPane);
        layout.putConstraint(SpringLayout.WEST, infoPanel, 10, SpringLayout.WEST, contentPane); 
		
		this.setLocation(300,100); 
		this.setPreferredSize(new Dimension(935, 512));
        this.setMinimumSize(new Dimension(935, 512));
        controlPanel.setMaximumSize(new Dimension(4192, 100));
        algorithmPanel.setMaximumSize(new Dimension(4192, 100));
        infoPanel.setMaximumSize(new Dimension(4192, 100));
        
		this.pack();
	    this.setVisible(true);   
	    
	    this.addComponentListener(this);
	    randomizeButton.addActionListener(this);
	}

	public void componentResized(ComponentEvent e) 
	{
		//dostosuj rozmiar elementów
		//this.pack();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		if (e.getSource() == randomizeButton) randomize();
	}
	
	private void randomize()
	{
		viewport.randomizeData();
		viewport.repaint();
	}

	//unused
	public void componentMoved(ComponentEvent e) {}
	public void componentShown(ComponentEvent e) {}
	public void componentHidden(ComponentEvent e) {}
}
