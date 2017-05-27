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
import bean.SoldCar;
import main.Query;
import service.ModelService;
import service.SoldCarService;

public class SoldCarFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField regisNum;
	private JTextField modelName;
	private JTextField modelNum;
	private JTextField manufacturer;
	private JTextField seats;
	private JTextField dataOfManufacture;
	
	private SoldCarService soldCarService;
	private ModelService modelService;
	private JTextField txtSd;
	private JTextField orderDate;
	private JTextField requiredDate;

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
			SoldCarFrame window = new SoldCarFrame();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public SoldCarFrame() {
		initialize();
		soldCarService = new SoldCarService();
		modelService = new ModelService();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 542, 397);
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
			regisNum.setEditable(false);
			regisNum.setBounds(201, 111, 163, 24);
			contentPane.add(regisNum);
			regisNum.setColumns(10);
			
			JLabel lblModelName = new JLabel("model name:");
			lblModelName.setForeground(new Color(0, 0, 153));
			lblModelName.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblModelName.setBounds(43, 143, 95, 18);
			contentPane.add(lblModelName);
			
			modelName = new JTextField();
			modelName.setEditable(false);
			modelName.setBounds(147, 142, 86, 24);
			contentPane.add(modelName);
			modelName.setColumns(10);
			
			JLabel lblModelNum = new JLabel("model num:");
			lblModelNum.setForeground(new Color(0, 0, 153));
			lblModelNum.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblModelNum.setBounds(247, 143, 86, 18);
			contentPane.add(lblModelNum);
			
			modelNum = new JTextField();
			modelNum.setEditable(false);
			modelNum.setBounds(328, 142, 86, 24);
			contentPane.add(modelNum);
			modelNum.setColumns(10);
			
			JLabel lblManufacturer = new JLabel("manufacturer:");
			lblManufacturer.setForeground(new Color(0, 0, 153));
			lblManufacturer.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblManufacturer.setBounds(32, 174, 106, 18);
			contentPane.add(lblManufacturer);
			
			manufacturer = new JTextField();
			manufacturer.setEditable(false);
			manufacturer.setBounds(147, 173, 86, 24);
			contentPane.add(manufacturer);
			manufacturer.setColumns(10);
			
			JLabel lblDateOfManufacture = new JLabel("date of manufacture:");
			lblDateOfManufacture.setForeground(new Color(0, 0, 153));
			lblDateOfManufacture.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblDateOfManufacture.setBounds(14, 210, 160, 18);
			contentPane.add(lblDateOfManufacture);
			
			JLabel lblSeats = new JLabel("seats:");
			lblSeats.setForeground(new Color(0, 0, 153));
			lblSeats.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblSeats.setBounds(276, 174, 48, 18);
			contentPane.add(lblSeats);
			
			seats = new JTextField();
			seats.setEditable(false);
			seats.setBounds(328, 173, 86, 24);
			contentPane.add(seats);
			seats.setColumns(10);
			
			dataOfManufacture = new JTextField();
			dataOfManufacture.setEditable(false);
			dataOfManufacture.setBounds(181, 209, 152, 24);
			contentPane.add(dataOfManufacture);
			dataOfManufacture.setColumns(10);
			
			JButton btnInsert = new JButton("Insert");
			btnInsert.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnInsert.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					String txt = txtSd.getText();
					int soldN = Integer.parseInt(txt);
					SoldCar rc = soldCarService.query(soldN);
					int modelN = rc.getModelNum();
					Model mol = modelService.query(modelN);
					regisNum.setText("" + rc.getRegistrationNumber());
					modelNum.setText("" + modelN);
					modelName.setText(mol.getModelName());
					manufacturer.setText(mol.getManufacturer());
					seats.setText("" + mol.getSeats());
					dataOfManufacture.setText(rc.getDateOfManufacture().toString());
					orderDate.setText(rc.getOrderDate().toString());
					requiredDate.setText(rc.getRequiredDate().toString());
				}
			});
			btnInsert.setBounds(201, 291, 113, 27);
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
			btnBack.setBounds(25, 291, 113, 27);
			contentPane.add(btnBack);
			
			JButton btnExit = new JButton("exit");
			btnExit.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnExit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					frame.dispose();
				}
			});
			btnExit.setBounds(380, 291, 113, 27);
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
			lblOrderdate.setBounds(32, 248, 106, 18);
			contentPane.add(lblOrderdate);
			
			orderDate = new JTextField();
			orderDate.setEditable(false);
			orderDate.setBounds(129, 248, 86, 24);
			contentPane.add(orderDate);
			orderDate.setColumns(10);
			
			JLabel lblRequireddate = new JLabel("required Date:");
			lblRequireddate.setForeground(new Color(0, 0, 153));
			lblRequireddate.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblRequireddate.setBounds(247, 248, 126, 18);
			contentPane.add(lblRequireddate);
			
			requiredDate = new JTextField();
			requiredDate.setEditable(false);
			requiredDate.setBounds(364, 245, 86, 24);
			contentPane.add(requiredDate);
			requiredDate.setColumns(10);
		}
		return contentPane;
	}
	
}
