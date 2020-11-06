import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class SortAlgorithm extends JPanel implements Runnable, ActionListener {
	
	int[] array;
	Dimension framesize; 
	double BAR_WIDTH;
	private Rectangle2D rect;
	int current_place = 0;
	int min_place = 0;
	int speed = 100;
	int arraySize = 0;
			
	public SortAlgorithm(int speed, int arraySize) {
		this.speed = speed;
		this.arraySize = arraySize;
		generateRandArray();
		setSize(800,500);
		createAndShowGUI();
		//setBackground(Color.BLACK);
		
	}

	@Override
	abstract public void run();
	
	//swaps the min or first value and the i value or the second value in the array
	public void swap(int min, int i) {
		System.out.println("swapping " + array[min] + " and " +  array[i]);
		int temp = array[min]; 
		array[min] = array[i]; 
		array[i] = temp;
		min_place = min;
		current_place = i;
		
		try {
			Thread.sleep(speed);
			validate();
			repaint();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//generates a array with random ints
	public void generateRandArray() {
		array = new int[arraySize];
		
		for(int i = 0; i < array.length; i++) {
			Random rand = new Random();
			array[i] = rand.nextInt(450);
			//System.out.println(array[i]);
		}
		
	}
	
	private void createAndShowGUI() {
		setLayout(new BorderLayout());
		JButton b = new JButton("Click to start the sort");
		b.addActionListener(this);   
		add(b, BorderLayout.NORTH);
		setVisible(true);
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		System.out.println("painting");
		
		framesize = getSize();
		BAR_WIDTH = ((double)framesize.width / this.arraySize);
		System.out.println(framesize.width + " " + BAR_WIDTH);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		
		for(int i = 0; i < array.length; i++) {
            rect = new Rectangle2D.Double(BAR_WIDTH * i, framesize.height - array[i], BAR_WIDTH, array[i]);
            g2.fill(rect);
			//g2.drawRect(BAR_WIDTH * i, framesize.height - array[i], BAR_WIDTH, array[i]);
            if(min_place == i || current_place == i) {
            	g2.setColor(Color.RED);
            }else {
            	g2.setColor(Color.BLACK);
            }
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Pressed button");
		run();
		
	}

	

}
