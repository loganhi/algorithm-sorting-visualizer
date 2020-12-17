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
	
	Thread sortingThread;
	int[] array;
	Dimension framesize; 
	double BAR_WIDTH;
	private Rectangle2D rect;

	//Vars for keeping track of the bar painting for comparisons
	int current_place = -1;
	int swap = -1;
	int middle = -1;

	//user controlled vars through the GUI
	int speed = 100;
	int arraySize = 0;

	public SortAlgorithm(int speed, int arraySize) {
		sortingThread = new Thread(this);
		this.speed = speed;
		this.arraySize = arraySize;
		generateRandArray();
		setSize(800,500);
		createAndShowGUI();
		
		//setBackground(Color.BLACK);
		
	}
	
	//swaps the min or first value and the i value or the second value in the array
	public void swap(int min, int i) {
		System.out.println("swapping " + array[min] + " and " +  array[i]);
		int temp = array[min]; 
		array[min] = array[i]; 
		array[i] = temp;
		swap = min;
		current_place = i;
	}

	public void randomizeArray(){

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
		//System.out.println(framesize.width + " " + BAR_WIDTH);
		Graphics2D g2 = (Graphics2D) g;

		for(int i = 0; i < array.length; i++) {
            rect = new Rectangle2D.Double(BAR_WIDTH * i, framesize.height - array[i], BAR_WIDTH, array[i]);

            if(swap == i || current_place == i) {
            	g2.setColor(new Color(155, 246, 255));
            }
			else if(i == middle) {
				System.out.println(middle);
				g2.setColor(new Color(255, 173, 173));
			}else if (i < middle){
				g2.setColor(new Color(253, 255, 182));
			}
            else {
            	g2.setColor(new Color(52, 58, 64));
            }
			g2.fill(rect);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Pressed button");
		sortingThread.start();
		
	}
}
