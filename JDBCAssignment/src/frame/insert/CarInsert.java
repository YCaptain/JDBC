package frame.insert;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bean.Car;
import main.Insert;
import service.CarService;
public class CarInsert {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField regisNum;
	private JTextField modelNum;
	private JTextField dateOfManufacture;
	
	private CarService carService;

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
			CarInsert window = new CarInsert();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public CarInsert() {
		initialize();
		carService = new CarService();
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
			
			JLabel lblCar = new JLabel("Car");
			lblCar.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblCar.setForeground(new Color(51, 102, 153));
			lblCar.setBackground(Color.BLACK);
			lblCar.setBounds(32, 25, 106, 18);
			contentPane.add(lblCar);
			
			JLabel lblRegistrationNumber = new JLabel("registration number:");
			lblRegistrationNumber.setForeground(new Color(0, 0, 153));
			lblRegistrationNumber.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblRegistrationNumber.setBounds(42, 56, 176, 18);
			contentPane.add(lblRegistrationNumber);
			
			regisNum = new JTextField();
			regisNum.setBounds(214, 53, 152, 24);
			contentPane.add(regisNum);
			regisNum.setColumns(10);
			
			JLabel lblModelNum = new JLabel("model num:");
			lblModelNum.setForeground(new Color(0, 0, 153));
			lblModelNum.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblModelNum.setBounds(111, 92, 86, 18);
			contentPane.add(lblModelNum);
			
			modelNum = new JTextField();
			modelNum.setBounds(214, 91, 152, 24);
			contentPane.add(modelNum);
			modelNum.setColumns(10);
			
			JLabel lblDateOfManufacture = new JLabel("date of manufacture:");
			lblDateOfManufacture.setForeground(new Color(0, 0, 153));
			lblDateOfManufacture.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblDateOfManufacture.setBounds(42, 136, 160, 18);
			contentPane.add(lblDateOfManufacture);
			
			dateOfManufacture = new JTextField();
			dateOfManufacture.setBounds(214, 135, 152, 24);
			contentPane.add(dateOfManufacture);
			dateOfManufacture.setColumns(10);
			
			JButton btnInsert = new JButton("Insert");
			btnInsert.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnInsert.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					String txt = regisNum.getText();
					int registration = Integer.parseInt(txt);
					Car car = new Car();
					car.updateRegistrationNumber(registration);
					car.updateModelNum(Integer.parseInt(modelNum.getText()));
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					try {
						Date date = sdf.parse(dateOfManufacture.getText());
						car.updateDateOfManuFacture(date);
						carService.regist(car);
						JOptionPane.showMessageDialog(null, "Insert success", "message", JOptionPane.INFORMATION_MESSAGE);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					
				}
			});
			btnInsert.setBounds(162, 213, 113, 27);
			contentPane.add(btnInsert);
			
			JButton btnBack = new JButton("back");
			btnBack.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnBack.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Insert insert = new Insert();
					insert.run();
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
