package frame.query;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;

import bean.Model;
import bean.RentalCar;
import main.Query;
import service.ModelService;
import service.RentalCarService;

import javax.swing.DropMode;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RentalCarFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField txtSd;
	private JTextField modelName;
	private JTextField modelNum;
	private JTextField manufacturer;
	private JTextField seats;
	private JTextField dataOfManufacture;
	
	private RentalCarService rentalCarService;
	private ModelService modelService;

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
			RentalCarFrame window = new RentalCarFrame();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public RentalCarFrame() {
		initialize();
		rentalCarService = new RentalCarService();
		modelService = new ModelService();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
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
			contentPane.setForeground(new Color(0, 0, 153));
			
			JLabel lblRentalCar = new JLabel("Rental Car");
			lblRentalCar.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblRentalCar.setForeground(new Color(51, 102, 153));
			lblRentalCar.setBackground(Color.BLACK);
			lblRentalCar.setBounds(32, 25, 106, 18);
			contentPane.add(lblRentalCar);
			
			JLabel lblRegistrationNumber = new JLabel("registration number:");
			lblRegistrationNumber.setForeground(new Color(0, 0, 153));
			lblRegistrationNumber.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblRegistrationNumber.setBounds(42, 56, 176, 18);
			contentPane.add(lblRegistrationNumber);
			
			txtSd = new JTextField();
			txtSd.setBounds(214, 53, 163, 24);
			contentPane.add(txtSd);
			txtSd.setColumns(10);
			
			JLabel lblModelName = new JLabel("model name:");
			lblModelName.setForeground(new Color(0, 0, 153));
			lblModelName.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblModelName.setBounds(32, 94, 95, 18);
			contentPane.add(lblModelName);
			
			modelName = new JTextField();
			modelName.setBounds(122, 91, 86, 24);
			contentPane.add(modelName);
			modelName.setColumns(10);
			
			JLabel lblModelNum = new JLabel("model num:");
			lblModelNum.setForeground(new Color(0, 0, 153));
			lblModelNum.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblModelNum.setBounds(232, 94, 86, 18);
			contentPane.add(lblModelNum);
			
			modelNum = new JTextField();
			modelNum.setBounds(314, 91, 86, 24);
			contentPane.add(modelNum);
			modelNum.setColumns(10);
			
			JLabel lblManufacturer = new JLabel("manufacturer:");
			lblManufacturer.setForeground(new Color(0, 0, 153));
			lblManufacturer.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblManufacturer.setBounds(14, 125, 106, 18);
			contentPane.add(lblManufacturer);
			
			manufacturer = new JTextField();
			manufacturer.setBounds(122, 125, 86, 24);
			contentPane.add(manufacturer);
			manufacturer.setColumns(10);
			
			JLabel lblDateOfManufacture = new JLabel("date of manufacture:");
			lblDateOfManufacture.setForeground(new Color(0, 0, 153));
			lblDateOfManufacture.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblDateOfManufacture.setBounds(14, 160, 160, 18);
			contentPane.add(lblDateOfManufacture);
			
			JLabel lblSeats = new JLabel("seats:");
			lblSeats.setForeground(new Color(0, 0, 153));
			lblSeats.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblSeats.setBounds(263, 125, 48, 18);
			contentPane.add(lblSeats);
			
			seats = new JTextField();
			seats.setBounds(314, 125, 86, 24);
			contentPane.add(seats);
			seats.setColumns(10);
			
			dataOfManufacture = new JTextField();
			dataOfManufacture.setBounds(180, 159, 152, 24);
			contentPane.add(dataOfManufacture);
			dataOfManufacture.setColumns(10);
			
			JButton btnInsert = new JButton("Insert");
			btnInsert.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnInsert.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					String txt = txtSd.getText();
					int registration = Integer.parseInt(txt);
					RentalCar rc = rentalCarService.query(registration);
					int modelN = rc.getModelNum();
					Model mol = modelService.query(modelN);
					System.out.println(mol.toString());
					modelNum.setText("" + modelN);
					modelName.setText(mol.getModelName());
					manufacturer.setText(mol.getManufacturer());
					seats.setText("" + mol.getSeats());
					dataOfManufacture.setText(rc.getDateOfManufacture().toString());
					
				}
			});
			btnInsert.setBounds(162, 213, 113, 27);
			contentPane.add(btnInsert);
			
			JButton btnBack = new JButton("back");
			btnBack.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnBack.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Query query = new Query();
					query.run();
					frame.dispose();
				}
			});
			btnBack.setBounds(14, 213, 113, 27);
			contentPane.add(btnBack);
			
			JButton btnExit = new JButton("exit");
			btnExit.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnExit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					frame.dispose();
				}
			});
			btnExit.setBounds(305, 213, 113, 27);
			contentPane.add(btnExit);
		}
		return contentPane;
	}
	
}
