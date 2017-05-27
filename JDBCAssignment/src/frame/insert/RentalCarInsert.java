package frame.insert;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bean.Car;
import bean.RentalCar;
import main.Insert;
import service.CarService;
import service.ModelService;
import service.RentalCarService;

public class RentalCarInsert {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField txtSd;
	private JTextField modelNum;
	
	private RentalCarService rentalCarService;
	private ModelService modelService;
	private JTextField rentPrice;

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
			RentalCarInsert window = new RentalCarInsert();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public RentalCarInsert() {
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
			
			JLabel lblModelNum = new JLabel("model num:");
			lblModelNum.setForeground(new Color(0, 0, 153));
			lblModelNum.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblModelNum.setBounds(112, 104, 86, 18);
			contentPane.add(lblModelNum);
			
			modelNum = new JTextField();
			modelNum.setBounds(214, 103, 86, 24);
			contentPane.add(modelNum);
			modelNum.setColumns(10);
			
			JButton btnSearch = new JButton("Search");
			btnSearch.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnSearch.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					String txt = txtSd.getText();
					int registration = Integer.parseInt(txt);
					CarService carService = new CarService();
					Car car = carService.query(registration);
					RentalCar rc = new RentalCar(car);
					rc.updateRentPrice(Integer.parseInt(rentPrice.getText()));
					rentalCarService.regist(rc);
					JOptionPane.showMessageDialog(null, "Insert success", "message", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			btnSearch.setBounds(162, 213, 113, 27);
			contentPane.add(btnSearch);
			
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
			
			JLabel lblRentPrice = new JLabel("rent price:");
			lblRentPrice.setForeground(new Color(0, 0, 153));
			lblRentPrice.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblRentPrice.setBounds(112, 147, 93, 18);
			contentPane.add(lblRentPrice);
			
			rentPrice = new JTextField();
			rentPrice.setBounds(214, 146, 86, 24);
			contentPane.add(rentPrice);
			rentPrice.setColumns(10);
		}
		return contentPane;
	}
}
