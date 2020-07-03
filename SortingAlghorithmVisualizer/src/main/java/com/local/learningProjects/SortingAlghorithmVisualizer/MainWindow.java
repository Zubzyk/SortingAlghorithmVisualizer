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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainWindow extends JFrame implements ActionListener, ChangeListener
{
	private static final long serialVersionUID = -8818973763021032820L;
	private static final String windowName = "Sorting Alghorithm Visualizer";
	private static final String problemSizeLabelText = "Problem Size";
	private static final String stopButtonText = "Stop";
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
	private JButton stopButton;
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
		this.stopButton = new JButton(stopButtonText);
		this.randomizeButton = new JButton(randomizeButtonText);
		this.animationSpeedSliderLabel = new JLabel(animationSpeedSliderLabelText, JLabel.CENTER);
		this.animationSpeedSlider = new JSlider(1, 10, 5);
		this.bubbleSortButton = new JButton(bubbleSortButtonText);
		this.aSortButton = new JButton(aSortButtonText);
		this.bSortButton = new JButton(bSortButtonText);
		this.cSortButton = new JButton(cSortButtonText);
		this.dSortButton = new JButton(dSortButtonText);
		this.eSortButton = new JButton(eSortButtonText);
		this.infoPanel = new JPanel(new FlowLayout());
		this.infoLabel = new JLabel("", JLabel.CENTER);
		
		this.animationSpeedSlider.setMinorTickSpacing(1);
		this.animationSpeedSlider.setMajorTickSpacing(3);
		this.animationSpeedSlider.setPaintLabels(true);
		
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
        this.controlPanel.add(randomizeButton);
        this.controlPanel.add(stopButton);
        this.animationSpeedSliderSubPanel.add(animationSpeedSliderLabel);
        this.animationSpeedSliderSubPanel.add(animationSpeedSlider);
        this.controlPanel.add(animationSpeedSliderSubPanel);
        
        this.algorithmPanel.add(bubbleSortButton);
        this.algorithmPanel.add(aSortButton);
        this.algorithmPanel.add(bSortButton);
        this.algorithmPanel.add(cSortButton);
        this.algorithmPanel.add(dSortButton);
        this.algorithmPanel.add(eSortButton);
        
        this.infoPanel.add(infoLabel);
        
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
        this.controlPanel.setMaximumSize(new Dimension(4192, 100));
        this.algorithmPanel.setMaximumSize(new Dimension(4192, 100));
        this.infoPanel.setMaximumSize(new Dimension(4192, 100));
        
		this.pack();
	    this.setVisible(true);   
	    
	    this.randomizeButton.addActionListener(this);
	    this.bubbleSortButton.addActionListener(this);
	    this.stopButton.addActionListener(this);
	    this.animationSpeedSlider.addChangeListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == this.randomizeButton) this.randomize();
		if (e.getSource() == this.bubbleSortButton) this.viewport.startBubbleSort();
		if (e.getSource() == this.stopButton) this.viewport.stopSolving();
	}
	
	public void stateChanged(ChangeEvent e) 
	{
		JSlider source = (JSlider)e.getSource();
		if (!source.getValueIsAdjusting())
		{
			this.viewport.setAnimationTimerDelay(11 - source.getValue());
		}
	}
	
	private void randomize()
	{
		this.viewport.randomizeData();
	}

	//unused	
}
