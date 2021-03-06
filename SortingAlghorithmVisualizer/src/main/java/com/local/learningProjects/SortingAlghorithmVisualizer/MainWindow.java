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
	//private static final String problemSizeLabelText = "Problem Size";
	private static final String stopButtonText = "Stop";
	private static final String randomizeButtonText = "Randomize";
	private static final String animationSpeedSliderLabelText = "Animation Speed";
	private static final String bubbleSortButtonText = "Bubble sort";
	private static final String selectionSortButtonText = "Selection sort";
	private static final String insertionSortButtonText = "Insertion sort";
	private static final String mergeSortButtonText = "Merge sort";
	private static final String quickSortButtonText = "Quick sort";
	private static final String heapSortButtonText = "Heap sort";
	
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
	private JButton selectionSortButton;
	private JButton insertionSortButton;
	private JButton mergeSortButton;
	private JButton quickSortButton;
	private JButton heapSortButton;
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
		this.selectionSortButton = new JButton(selectionSortButtonText);
		this.insertionSortButton = new JButton(insertionSortButtonText);
		this.mergeSortButton = new JButton(mergeSortButtonText);
		this.quickSortButton = new JButton(quickSortButtonText);
		this.heapSortButton = new JButton(heapSortButtonText);
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
        this.algorithmPanel.add(selectionSortButton);
        this.algorithmPanel.add(insertionSortButton);
        this.algorithmPanel.add(mergeSortButton);
        this.algorithmPanel.add(quickSortButton);
        this.algorithmPanel.add(heapSortButton);
        
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
	    this.selectionSortButton.addActionListener(this);
	    this.insertionSortButton.addActionListener(this);
	    this.mergeSortButton.addActionListener(this);
	    this.quickSortButton.addActionListener(this);
	    this.heapSortButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == this.randomizeButton) this.randomize();
		if (e.getSource() == this.bubbleSortButton) this.viewport.startBubbleSort();
		if (e.getSource() == this.selectionSortButton) this.viewport.startSelectionSort();
		if (e.getSource() == this.insertionSortButton) this.viewport.startInsertionSort();
		if (e.getSource() == this.mergeSortButton) this.viewport.startMergeSort();
		if (e.getSource() == this.quickSortButton) this.viewport.startQuickSort();
		if (e.getSource() == this.heapSortButton) this.viewport.startHeapSort();
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
