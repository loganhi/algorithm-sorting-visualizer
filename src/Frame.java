import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//Frame extends the JFrame class to add functionality 
public class Frame extends JFrame implements ActionListener{ 
	SortAlgorithm selection;
	
	JPanel menuPanel;
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
	private void initialize() {

		menuPanel = new JPanel();
		this.getContentPane().add(menuPanel, "name_3100283044700");
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

		JPanel titlePanel = new JPanel();
		menuPanel.add(titlePanel);
		FlowLayout fl_titlePanel = new FlowLayout(FlowLayout.CENTER, 5, 5);
		titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));

		JLabel lblSortingAlgorithem = new JLabel("Sorting Algorithm Visualizer");
		lblSortingAlgorithem.setFont(new Font("Tahoma", Font.PLAIN, 26));
		titlePanel.add(lblSortingAlgorithem);

		JPanel userInputPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) userInputPanel.getLayout();
		menuPanel.add(userInputPanel);

		//creating the buttons to control functionality of the app.
		String[] sortingAlgos = { "SelectionSort", "MergeSort" };
		selectsortingAlgos = new JComboBox<String>(sortingAlgos);
		startSort = new JButton("Click to start the sort");
		String[] speeds = { "Slow", "Medium", "Fast"};
		selectSpeed = new JComboBox<String>(speeds);
		String[] arraySizes = { "Small", "Medium", "Large"};
		selectArraySize = new JComboBox<String>(arraySizes);

		//adding action listeners to the button
		selectsortingAlgos.addActionListener(this);
		startSort.addActionListener(this);
		selectSpeed.addActionListener(this);
		selectArraySize.addActionListener(this);

		//adding the buttons the app.
		userInputPanel.add(startSort);
		userInputPanel.add(selectsortingAlgos);
		userInputPanel.add(selectSpeed);
		userInputPanel.add(selectArraySize);
	}
	
	public void createAndShowGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,500);
		setLayout(new CardLayout());
		initialize();
//		createMainMenu();
//		addButtons();
//		addCards();
		//add(selection, BorderLayout.CENTER);

//		JButton b = new JButton("Click to start the sort");
//		b.addActionListener(this);
//		add(b, BorderLayout.SOUTH);
//
		setVisible(true);

	}

	private void createMainMenu() {
		//creating the main menu and the corresponding buttons

		//MainMenu = new JPanel();

		name = new JLabel("Logan's Sorting Algorithm Visualization", null, JLabel.CENTER);
		String[] sortingAlgos = { "SelectionSort", "MergeSort" };
		selectsortingAlgos = new JComboBox<String>(sortingAlgos);
		startSort = new JButton("Click to start the sort");
		String[] speeds = { "Slow", "Medium", "Fast"};
		selectSpeed = new JComboBox<String>(speeds);
		String[] arraySizes = { "Small", "Medium", "Large"};
		selectArraySize = new JComboBox<String>(arraySizes);

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
			} else if(selectsortingAlgos.getSelectedItem() == "MergeSort") {
				selection = new MergeSort(speed, arraySize);
			}
			
			add(selection);
			selection.setVisible(true);
			menuPanel.setVisible(false);
		}
		
		if(e.getSource() == selectSpeed) {
			System.out.println("clicked");
			if(selectSpeed.getSelectedItem() == "Slow") {
				speed = 800;
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
