package frame.query;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bean.Model;
import main.Query;
import service.ModelService;

public class ModelFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField txtSd;
	private JTextField modelName;
	private JTextField manufacturer;
	
	private ModelService modelService;
	private Model model;
	private JTextField seats;

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
	
	public void run() {
		try {
			ModelFrame window = new ModelFrame();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public ModelFrame() {
		initialize();
		modelService = new ModelService();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 464, 318);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(getContentPane());
		frame.getContentPane().setLayout(null);
		Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize= frame.getSize();
		frame.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);
	}
	
	private JPanel getContentPane() {
		if(contentPane == null) {
			contentPane = new JPanel();
			contentPane.setBackground(new Color(153, 204, 102));
			
			JLabel lblModel = new JLabel("Model");
			lblModel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblModel.setForeground(new Color(51, 102, 153));
			lblModel.setBackground(Color.BLACK);
			lblModel.setBounds(32, 25, 106, 18);
			contentPane.add(lblModel);
			
			JLabel lblModelNum = new JLabel("modelNum:");
			lblModelNum.setForeground(new Color(0, 0, 153));
			lblModelNum.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblModelNum.setBounds(60, 61, 99, 18);
			contentPane.add(lblModelNum);
			
			txtSd = new JTextField();
			txtSd.setBounds(160, 60, 142, 24);
			contentPane.add(txtSd);
			txtSd.setColumns(10);
			
			JLabel lblName = new JLabel("modelName:");
			lblName.setForeground(new Color(0, 0, 153));
			lblName.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblName.setBounds(32, 110, 99, 18);
			contentPane.add(lblName);
			
			modelName = new JTextField();
			modelName.setEditable(false);
			modelName.setBounds(124, 109, 86, 24);
			contentPane.add(modelName);
			modelName.setColumns(10);
			
			JLabel lblManufacturer = new JLabel("manufacturer:");
			lblManufacturer.setForeground(new Color(0, 0, 153));
			lblManufacturer.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblManufacturer.setBounds(14, 147, 117, 18);
			contentPane.add(lblManufacturer);
			
			manufacturer = new JTextField();
			manufacturer.setEditable(false);
			manufacturer.setBounds(124, 146, 86, 24);
			contentPane.add(manufacturer);
			manufacturer.setColumns(10);
			
			JButton btnSearch = new JButton("Search");
			btnSearch.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnSearch.setBackground(new Color(153, 204, 102));
			btnSearch.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					String txt = txtSd.getText();
					int memNum = Integer.parseInt(txt);
					model = modelService.query(memNum);
					modelName.setText(model.getModelName());
					manufacturer.setText(model.getManufacturer());
					seats.setText("" + model.getSeats());
				}
			});
			btnSearch.setBounds(173, 208, 113, 27);
			contentPane.add(btnSearch);
			
			JButton btnBack = new JButton("back");
			btnBack.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnBack.setBackground(new Color(153, 204, 102));
			btnBack.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Query query = new Query();
					query.run();
					frame.dispose();
				}
			});
			btnBack.setBounds(32, 208, 113, 27);
			contentPane.add(btnBack);
			
			JButton btnExit = new JButton("exit");
			btnExit.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnExit.setBackground(new Color(153, 204, 102));
			btnExit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					frame.dispose();
				}
			});
			btnExit.setBounds(311, 208, 113, 27);
			contentPane.add(btnExit);
			
			JLabel lblseats = new JLabel("seats:");
			lblseats.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblseats.setForeground(new Color(0, 0, 153));
			lblseats.setBounds(242, 146, 44, 19);
			contentPane.add(lblseats);
			
			seats = new JTextField();
			seats.setEditable(false);
			seats.setBounds(289, 146, 86, 24);
			contentPane.add(seats);
			seats.setColumns(10);
		}
		return contentPane;
	}
}
