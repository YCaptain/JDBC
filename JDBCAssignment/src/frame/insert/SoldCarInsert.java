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
import bean.SoldCar;
import main.Query;
import service.CarService;
import service.SoldCarService;

public class SoldCarInsert {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField regisNum;
	private JTextField ssn;
	
	private SoldCarService soldCarService;
	private JTextField txtSd;
	private JTextField orderDate;
	private JTextField requiredDate;
	private JTextField soldPrice;

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
			SoldCarInsert window = new SoldCarInsert();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public SoldCarInsert() {
		initialize();
		soldCarService = new SoldCarService();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 542, 415);
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
			
			JLabel lblSoldCar = new JLabel("Sold Car");
			lblSoldCar.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblSoldCar.setForeground(new Color(51, 102, 153));
			lblSoldCar.setBackground(Color.BLACK);
			lblSoldCar.setBounds(32, 25, 106, 18);
			contentPane.add(lblSoldCar);
			
			JLabel lblRegistrationNumber = new JLabel("registration number:");
			lblRegistrationNumber.setForeground(new Color(0, 0, 153));
			lblRegistrationNumber.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblRegistrationNumber.setBounds(43, 112, 176, 18);
			contentPane.add(lblRegistrationNumber);
			
			regisNum = new JTextField();
			regisNum.setBounds(201, 111, 86, 24);
			contentPane.add(regisNum);
			regisNum.setColumns(10);
			
			JLabel lblSSN = new JLabel("ssn:");
			lblSSN.setForeground(new Color(0, 0, 153));
			lblSSN.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblSSN.setBounds(166, 174, 35, 18);
			contentPane.add(lblSSN);
			
			ssn = new JTextField();
			ssn.setBounds(201, 173, 86, 24);
			contentPane.add(ssn);
			ssn.setColumns(10);
			
			JButton btnInsert = new JButton("Insert");
			btnInsert.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnInsert.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					String txt = regisNum.getText();
					int registration = Integer.parseInt(txt);
					CarService carService = new CarService();
					Car car = carService.query(registration);
					SoldCar soldCar = new SoldCar(car);
					soldCar.updateSoldNumber(Integer.parseInt(txtSd.getText()));
					soldCar.updateSoldPrice(Integer.parseInt(soldPrice.getText()));
					soldCar.updateSSN(Integer.parseInt(ssn.getText()));
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					try {
						Date date = sdf.parse(orderDate.getText());
						Date date2 = sdf.parse(requiredDate.getText());
						soldCar.updateOrderDate(date);
						soldCar.updateRequiredDate(date2);
						soldCarService.regist(soldCar);
						JOptionPane.showMessageDialog(null, "Insert success", "message", JOptionPane.INFORMATION_MESSAGE);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			});
			btnInsert.setBounds(201, 309, 113, 27);
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
			btnBack.setBounds(32, 309, 113, 27);
			contentPane.add(btnBack);
			
			JButton btnExit = new JButton("exit");
			btnExit.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnExit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					frame.dispose();
				}
			});
			btnExit.setBounds(379, 309, 113, 27);
			contentPane.add(btnExit);
			
			JLabel lblSoldNum = new JLabel("Sold Num:");
			lblSoldNum.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblSoldNum.setForeground(new Color(0, 0, 153));
			lblSoldNum.setBounds(43, 77, 95, 18);
			contentPane.add(lblSoldNum);
			
			txtSd = new JTextField();
			txtSd.setBounds(129, 75, 104, 24);
			contentPane.add(txtSd);
			txtSd.setColumns(10);
			
			JLabel lblOrderdate = new JLabel("order Date:");
			lblOrderdate.setForeground(new Color(0, 0, 153));
			lblOrderdate.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblOrderdate.setBounds(115, 204, 95, 18);
			contentPane.add(lblOrderdate);
			
			orderDate = new JTextField();
			orderDate.setBounds(201, 203, 86, 24);
			contentPane.add(orderDate);
			orderDate.setColumns(10);
			
			JLabel lblRequireddate = new JLabel("required Date:");
			lblRequireddate.setForeground(new Color(0, 0, 153));
			lblRequireddate.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblRequireddate.setBounds(93, 235, 126, 18);
			contentPane.add(lblRequireddate);
			
			requiredDate = new JTextField();
			requiredDate.setBounds(201, 235, 86, 24);
			contentPane.add(requiredDate);
			requiredDate.setColumns(10);
			
			JLabel lblSoldPrice = new JLabel("sold price:");
			lblSoldPrice.setForeground(new Color(0, 0, 153));
			lblSoldPrice.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblSoldPrice.setBounds(115, 143, 86, 18);
			contentPane.add(lblSoldPrice);
			
			soldPrice = new JTextField();
			soldPrice.setColumns(10);
			soldPrice.setBounds(201, 143, 86, 24);
			contentPane.add(soldPrice);
		}
		return contentPane;
	}
}
