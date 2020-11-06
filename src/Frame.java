import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//Frame extends the JFrame class to add functionality 
public class Frame extends JFrame implements ActionListener{ 
	SortAlgorithm selection;
	
	JPanel MainMenu;
	JComboBox<String> selectsortingAlgos;
	JLabel name;
	JButton startSort;
	JComboBox<String> selectSpeed;
	JComboBox<String> selectArraySize;
	
	int speed = 100;
	int arraySize = 20;
	
	
	public Frame() {
		createAndShowGUI();
			
	}
	
	public void createAndShowGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,500);
		setLayout(new CardLayout());
		createMainMenu();
		addButtons();
		addCards();
		//add(selection, BorderLayout.CENTER);
		
//		JButton b = new JButton("Click to start the sort");
//		b.addActionListener(this);   
//		add(b, BorderLayout.SOUTH);
//		
		setVisible(true);
		
	}
	
	private void createMainMenu() {
		//creating the main menu and the corresponding buttons
		MainMenu = new JPanel(new GridBagLayout());
		
		name = new JLabel("Logan's Sorting Algorithm Visualization");
		String[] sortingAlgos = { "SelectionSort", "InsertionSort" };
		selectsortingAlgos = new JComboBox<String>(sortingAlgos);
		startSort = new JButton("Click to start the sort");
		String[] speeds = { "Slow", "Medium", "Fast"};
		selectSpeed = new JComboBox<String>(speeds);
		String[] arraySizes = { "Small", "Medium", "Large"};
		selectArraySize = new JComboBox<String>(arraySizes);
		
	}

	private void addCards() {
		add(MainMenu);
	}
	
	private void addButtons() {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 0; 
		MainMenu.add(name, c);
		c.gridx = 0;
		c.gridy = 1;
		MainMenu.add(selectsortingAlgos, c);
		selectsortingAlgos.addActionListener(this);
		c.gridx = 1;
		MainMenu.add(startSort, c);
		startSort.addActionListener(this);
		c.gridx = 2;
		MainMenu.add(selectSpeed, c);
		selectSpeed.addActionListener(this);
		c.gridx = 3;
		MainMenu.add(selectArraySize, c);
		selectArraySize.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == selectsortingAlgos) {
			System.out.println("clicked " + selectsortingAlgos.getSelectedItem());
			
		}
		
		if(e.getSource() == startSort) {
			System.out.println("clicked");
			
			if(selectsortingAlgos.getSelectedItem() == "SelectionSort") {
				selection = new SelectionSort(speed, arraySize);
				System.out.println("added sort");
			}
			
			add(selection);
			selection.setVisible(true);
			MainMenu.setVisible(false);
		}
		
		if(e.getSource() == selectSpeed) {
			System.out.println("clicked");
			if(selectSpeed.getSelectedItem() == "Slow") {
				speed = 500;
			}else if(selectSpeed.getSelectedItem() == "Medium") {
				speed = 250;
			}else if(selectSpeed.getSelectedItem() == "Fast") {
				speed = 50;
			}
		}
		
		if(e.getSource() == selectArraySize) {
			System.out.println("clicked");
			if(selectArraySize.getSelectedItem() == "Small") {
				arraySize = 20;
			}else if(selectArraySize.getSelectedItem() == "Medium") {
				arraySize = 100;
			}else if(selectArraySize.getSelectedItem() == "Large") {
				arraySize = 500;
			}
		}
		
	}
	
}
