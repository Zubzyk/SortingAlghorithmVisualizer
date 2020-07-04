package com.local.learningProjects.SortingAlghorithmVisualizer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Viewport extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private enum sortingAlghorithm {
		BUBBLE_SORT,
		SELECTION_SORT,
		INSERTION_SORT,
		MERGE_SORT,
		QUICK_SORT,
		HEAP_SORT,
		NONE;
	}
	
	private sortingAlghorithm currentAlgorithm = sortingAlghorithm.NONE;
	
	private int[] data;
	private HashSet<Integer> highlightedBlue;
	private HashSet<Integer> highlightedGreen;
	private HashSet<Integer> highlightedRed;
	
	private int bubbleSort_i;
	private boolean bubbleSort_completeFlag;
	
	private int selectionSort_i;
	private int selectionSort_j;
	private int selectionSort_smallest;
	
	private int insertionSort_i;
	private int insertionSort_j;
	private boolean insertionSort_flag;
	
	Timer solveClock;
	ActionListener taskPerformer;
	
	public Viewport()
	{
		super();
		this.setPreferredSize(new Dimension(800, 300));
		
		this.data = new int[128];
		this.highlightedBlue = new HashSet<Integer>();
		this.highlightedGreen = new HashSet<Integer>();
		this.highlightedRed = new HashSet<Integer>();
		
		randomizeData();
		
		int delay = 5; //milliseconds
		taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
		        solve();
		    }
		};
		solveClock = new Timer(delay, taskPerformer);
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
		g2d.setColor(Color.BLACK);
		
		//prepare bar size data
		int barMaxWidth = this.getSize().width / this.data.length;
		int barWidth = barMaxWidth - 2;
		int barMaxHeight = this.getSize().height;
		
		//paint bars
		for (int i = 0; i < this.data.length; i++)
		{	
			int posX = i * barMaxWidth + 1;
			int barHeight = (this.data[i] * barMaxHeight) / this.data.length;
			int posY = this.getSize().height - barHeight;
			g2d.fillRect(posX, posY, barWidth, barHeight);
		}
		
		//paint highlights
		paintHighlighted(g2d, highlightedBlue, Color.BLUE);
		paintHighlighted(g2d, highlightedGreen, Color.GREEN);
		paintHighlighted(g2d, highlightedRed, Color.RED);
	}
	
	private void paintHighlighted(Graphics2D g2d, HashSet<Integer> highlighted, Color c) 
	{
		g2d.setColor(c);
		
		int barMaxWidth = this.getSize().width / this.data.length;
		int barWidth = barMaxWidth - 2;
		int barMaxHeight = this.getSize().height;
		
		for (Integer in : highlighted)
		{
			int posX = in * barMaxWidth + 1;
			int barHeight = (this.data[in] * barMaxHeight) / this.data.length;
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

		this.clearHighlights();
		
		this.repaint();
	}
	
	private void solve()
	{
		switch (currentAlgorithm) {
		case BUBBLE_SORT:
			step_BubbleSort();
			break;
		case SELECTION_SORT:
			 step_SelectionSort();
			 break;
		case INSERTION_SORT:
			 step_insertionSort();
			 break;
		case MERGE_SORT:
			 step_mergeSort();
			 break;
		case QUICK_SORT:
			 step_quickSort();
			 break;
		case HEAP_SORT:
			 step_heapSort();
			 break;
		case NONE:
			break;
		default:
			break;
		}
	}
	
	public void startBubbleSort()
	{
		this.currentAlgorithm = sortingAlghorithm.BUBBLE_SORT;
		this.bubbleSort_i = 0;
		this.bubbleSort_completeFlag = true;
		this.clearHighlights();
		this.solveClock.restart();
	}
	
	public void startSelectionSort()
	{
		this.currentAlgorithm = sortingAlghorithm.SELECTION_SORT;
		this.selectionSort_i = 0;
		this.selectionSort_j = 0;
		this.selectionSort_smallest = 0;
		this.clearHighlights();
		this.solveClock.restart();
	}
	
	public void startInsertionSort()
	{
		this.currentAlgorithm = sortingAlghorithm.INSERTION_SORT;
		this.insertionSort_i = 0;
		this.insertionSort_j = 0;
		this.insertionSort_flag = true;
		this.clearHighlights();
		this.solveClock.restart();
	}
	
	public void startMergeSort()
	{
		
	}
	
	public void startQuickSort()
	{
		
	}
	
	public void startHeapSort()
	{
		
	}
	
	private void finish()
	{
		this.currentAlgorithm = sortingAlghorithm.NONE;
		this.solveClock.stop();
	}
	
	public void setAnimationTimerDelay(int delay)
	{
		this.solveClock.setDelay(delay);
	}
	
	public void stopSolving()
	{
		this.currentAlgorithm = sortingAlghorithm.NONE;
		this.solveClock.stop();
		this.clearHighlights();
		this.repaint();
	}
	
	private void clearHighlights() 
	{
		this.highlightedBlue.clear();
		this.highlightedGreen.clear();
		this.highlightedRed.clear();
	}
	
	private void swapDataEntries(int index_1, int index_2)
	{
		int tmp_data = data[index_1];
		data[index_1] = data[index_2];
		data[index_2] = tmp_data;
	}
	
	private void step_BubbleSort() 
	{
		if (bubbleSort_i >= data.length - 1)
		{
			//if we have arrived at the end of array
			if (bubbleSort_completeFlag)
			{
				//and nothing was changed in data
				highlightedGreen.add(bubbleSort_i);
				finish();
			} else {
				//else restart index and flag
				bubbleSort_i = 0;
				bubbleSort_completeFlag = true;
			}
		} else if (data[bubbleSort_i] <= data[bubbleSort_i + 1])
		{
			//if elements are placed correctly advance to next
			bubbleSort_i++;
		} else 
		{
			//if data is placed incorrectly swap
			this.swapDataEntries(bubbleSort_i, bubbleSort_i + 1);
			
			//set flag indicating something was not in proper order
			bubbleSort_completeFlag = false;
			highlightedGreen.clear();
		}
		
		//set highlight on current pair
		this.highlightedBlue.clear();
		if (bubbleSort_i < data.length - 1) this.highlightedBlue.add(bubbleSort_i);
		if (bubbleSort_i < data.length - 1) this.highlightedBlue.add(bubbleSort_i + 1);
		
		//set highlight on all previous if all are in proper order
		if ((bubbleSort_completeFlag) & (bubbleSort_i > 0)) highlightedGreen.add(bubbleSort_i - 1);
		
		this.repaint();
	}
	
	private void step_SelectionSort() 
	{
		//if checked all
		if (this.selectionSort_j == this.data.length - 1)
		{
			//swap smallest value with first of unsorted
			this.swapDataEntries(selectionSort_i, selectionSort_smallest);
			
			//update highlight, increment unsolved section index and update moving index
			this.highlightedGreen.add(this.selectionSort_i);
			this.selectionSort_i++;
			this.selectionSort_j = this.selectionSort_i;
			this.selectionSort_smallest = this.selectionSort_i;
			
			if (this.selectionSort_i == this.data.length - 1)
			{
				this.highlightedGreen.add(this.selectionSort_i);
				this.finish();
			}
		} else {
			//increment moving index and check if smallest
			this.selectionSort_j++;
			
			if (this.data[this.selectionSort_j] < this.data[this.selectionSort_smallest])
			{
				this.selectionSort_smallest = this.selectionSort_j;
			}
		}
		
		//set highlight on current element
		this.highlightedBlue.clear();
		this.highlightedRed.clear();
		if (this.selectionSort_i != this.data.length - 1)
		{
			this.highlightedBlue.add(this.selectionSort_j);
			this.highlightedRed.add(this.selectionSort_smallest);
		}
		
		this.repaint();
	}
	
	private void step_insertionSort()
	{
		//if found position of element
		if (this.insertionSort_flag)
		{
			this.insertionSort_flag = false;
			this.insertionSort_j = this.insertionSort_i;
			this.insertionSort_i++;
			
			if (this.insertionSort_i == this.data.length)
			{
				this.finish();
				this.highlightedRed.clear();
				this.highlightedBlue.clear();
				this.highlightedGreen.add(this.insertionSort_i - 1);
			} else
			{
				//clear red highlights, add blue highlight to new searched element, add green highlight to previous blue element
				this.highlightedRed.clear();
				this.highlightedBlue.clear();
				this.highlightedBlue.add(this.insertionSort_i);
				this.highlightedGreen.add(this.insertionSort_i - 1);
			}
		} else
		{
			if (this.data[this.insertionSort_j] <= this.data[this.insertionSort_i] )
			{
				this.insertionSort_flag = true;
				
				int temp = this.data[this.insertionSort_i];
				
				//shift data entries to right
				for (int i = this.insertionSort_i; i > this.insertionSort_j + 1; i--)
				{
					this.data[i] = data[i-1];
				}
				
				this.data[this.insertionSort_j + 1] = temp;
			} else
			{
				this.insertionSort_j--;
				
				if (this.insertionSort_j < 0) 
				{
					this.insertionSort_j = 0;
					this.insertionSort_flag = true;
					
					int temp = this.data[this.insertionSort_i];
					
					//shift data entries to right
					for (int i = this.insertionSort_i; i > this.insertionSort_j; i--)
					{
						this.data[i] = data[i-1];
					}
					
					this.data[this.insertionSort_j] = temp;
				}
			}
			
		}
		
		if (this.insertionSort_i != this.data.length) this.highlightedRed.add(this.insertionSort_j);
		
		this.repaint();
	}
	
	private void step_mergeSort()
	{
		
	}
	
	private void step_quickSort()
	{
		
	}
	
	private void step_heapSort()
	{
		
	}
}
