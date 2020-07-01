package com.local.learningProjects.SortingAlghorithmVisualizer;

import java.awt.EventQueue;

public class App 
{
	private static MainWindow instance;
	
    public static void main( String[] args )
    {
    	EventQueue.invokeLater(new Runnable()
	    			{
    					public void run()
    					{
    						instance = new MainWindow();
    					}
	    			}
    			);
    }
}
