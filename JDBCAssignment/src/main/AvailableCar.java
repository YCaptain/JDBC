package main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.Color;

public class AvailableCar {

	private JFrame frame;
	public JTextArea textArea;
	private String text;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				run();
			}
		});
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void run(String text) {
		try {
			AvailableCar window = new AvailableCar(text);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public AvailableCar(String text) {
		this.text = text;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 102, 102));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 770, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textArea = new JTextArea();
		textArea.setTabSize(50);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBounds(46, 28, 592, 336);
		textArea.setText(text);
		frame.getContentPane().add(textArea);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(362, 28, 21, 161);
		frame.getContentPane().add(scrollBar);
		
		JButton btnBack = new JButton("back");
		btnBack.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Enter enter = new Enter();
				enter.run();
				frame.dispose();
			}
		});
		
		btnBack.setBounds(46, 377, 113, 27);
		frame.getContentPane().add(btnBack);
		
		JButton btnExit = new JButton("exit");
		btnExit.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		btnExit.setBounds(579, 377, 113, 27);
		frame.getContentPane().add(btnExit);
	}
}
