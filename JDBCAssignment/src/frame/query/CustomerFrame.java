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

import bean.Customer;
import main.Query;
import service.CustomerService;

public class CustomerFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField txtSd;
	private JTextField name;
	private JTextField sex;
	private JTextField address;
	private JTextField city;
	private JTextField phone;
	
	private CustomerService customerService;
	private Customer customer;
	private JTextField country;

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
			CustomerFrame window = new CustomerFrame();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public CustomerFrame() {
		initialize();
		customerService = new CustomerService();
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
			
			JLabel lblRentalCar = new JLabel("Customer");
			lblRentalCar.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblRentalCar.setForeground(new Color(51, 102, 153));
			lblRentalCar.setBackground(Color.BLACK);
			lblRentalCar.setBounds(32, 25, 106, 18);
			contentPane.add(lblRentalCar);
			
			JLabel lblSSN = new JLabel("ssn:");
			lblSSN.setForeground(new Color(0, 0, 153));
			lblSSN.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblSSN.setBounds(54, 54, 35, 18);
			contentPane.add(lblSSN);
			
			txtSd = new JTextField();
			txtSd.setBounds(91, 53, 163, 24);
			contentPane.add(txtSd);
			txtSd.setColumns(10);
			
			JLabel lblName = new JLabel("name:");
			lblName.setForeground(new Color(0, 0, 153));
			lblName.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblName.setBounds(49, 94, 40, 18);
			contentPane.add(lblName);
			
			name = new JTextField();
			name.setEditable(false);
			name.setBounds(91, 91, 86, 24);
			contentPane.add(name);
			name.setColumns(10);
			
			JLabel lblSex = new JLabel("sex:");
			lblSex.setForeground(new Color(0, 0, 153));
			lblSex.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblSex.setBounds(232, 94, 37, 18);
			contentPane.add(lblSex);
			
			sex = new JTextField();
			sex.setEditable(false);
			sex.setBounds(273, 91, 86, 24);
			contentPane.add(sex);
			sex.setColumns(10);
			
			JLabel lblAddress = new JLabel("address:");
			lblAddress.setForeground(new Color(0, 0, 153));
			lblAddress.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblAddress.setBounds(24, 125, 86, 18);
			contentPane.add(lblAddress);
			
			address = new JTextField();
			address.setEditable(false);
			address.setBounds(91, 122, 86, 24);
			contentPane.add(address);
			address.setColumns(10);
			
			JLabel lblPhone = new JLabel("phone:");
			lblPhone.setForeground(new Color(0, 0, 153));
			lblPhone.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblPhone.setBounds(41, 156, 48, 18);
			contentPane.add(lblPhone);
			
			JLabel lblCity = new JLabel("city:");
			lblCity.setForeground(new Color(0, 0, 153));
			lblCity.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblCity.setBounds(221, 125, 48, 18);
			contentPane.add(lblCity);
			
			city = new JTextField();
			city.setEditable(false);
			city.setBounds(273, 122, 86, 24);
			contentPane.add(city);
			city.setColumns(10);
			
			phone = new JTextField();
			phone.setEditable(false);
			phone.setBounds(91, 153, 86, 24);
			contentPane.add(phone);
			phone.setColumns(10);
			
			JButton btnSearch = new JButton("Search");
			btnSearch.setFont(new Font("Arial Black", Font.PLAIN, 15));
			btnSearch.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					String txt = txtSd.getText();
					int ssn = Integer.parseInt(txt);
					customer = customerService.query(ssn);
					name.setText(customer.getName());
					sex.setText(customer.getSex().toString());
					address.setText(customer.getAddress());
					city.setText(customer.getCity());
					country.setText(customer.getCountry());
					phone.setText("" + customer.getPhone());
				}
			});
			btnSearch.setBounds(162, 213, 113, 27);
			contentPane.add(btnSearch);
			
			JButton btnBack = new JButton("back");
			btnBack.setFont(new Font("Arial Black", Font.PLAIN, 15));
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
			btnExit.setFont(new Font("Arial Black", Font.PLAIN, 15));
			btnExit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					frame.dispose();
				}
			});
			btnExit.setBounds(305, 213, 113, 27);
			contentPane.add(btnExit);
			
			JLabel lblCountry = new JLabel("country:");
			lblCountry.setForeground(new Color(0, 0, 153));
			lblCountry.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblCountry.setBounds(197, 156, 72, 18);
			contentPane.add(lblCountry);
			
			country = new JTextField();
			country.setEditable(false);
			country.setBounds(273, 153, 86, 24);
			contentPane.add(country);
			country.setColumns(10);
		}
		return contentPane;
	}
}
