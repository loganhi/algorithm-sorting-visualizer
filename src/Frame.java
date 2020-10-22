import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//Frame extends the JFrame class to add functionality 
public class Frame extends JFrame{ 
	SelectionSort selection;
	
	//creating the main menu and the corresponding buttons
	JPanel MainMenu = new JPanel(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	
	JLabel name = new JLabel("Logan's Sorting Algorithm Visualization");
	String[] sortingAlgos = { "SelectionSort" };
	JComboBox<String> selectsortingAlgos = new JComboBox<String>(sortingAlgos);
	JButton startSort = new JButton("Click to start the sort");
	String[] speeds = { "Slow", "Medium", "Fast"};
	JComboBox<String> selectSpeed = new JComboBox<String>(speeds);
	String[] arraySizes = { "Small", "Medium", "Large"};
	JComboBox<String> selectArraySize = new JComboBox<String>(arraySizes);
	
	
	public Frame() {
		createAndShowGUI();
			
	}
	
	public void createAndShowGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,500);
		setLayout(new CardLayout());
		addButtons();
		addCards();
		//add(selection, BorderLayout.CENTER);
		
//		JButton b = new JButton("Click to start the sort");
//		b.addActionListener(this);   
//		add(b, BorderLayout.SOUTH);
//		
		setVisible(true);
		
	}
	
	private void addCards() {
		add(MainMenu);
	}
	
	private void addButtons() {
		c.gridx = 1;
		c.gridy = 0;
		MainMenu.add(name, c);
		c.gridx = 0;
		c.gridy = 1;
		MainMenu.add(selectsortingAlgos, c);
		c.gridx = 1;
		MainMenu.add(startSort, c);
		c.gridx = 2;
		MainMenu.add(selectSpeed, c);
		c.gridx = 3;
		MainMenu.add(selectArraySize, c);
	}
	
}
