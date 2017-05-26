package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import bean.Car;
import utils.JdbcUtils;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Enter {

	private JFrame frame;
	private JPanel contentPane;

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
			Enter window = new Enter();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public Enter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(getContentPane());
		Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize= frame.getSize();
		frame.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);
	}
	
	private JPanel getContentPane() {
		if(contentPane == null) {
			contentPane = new JPanel();
			contentPane.setBackground(new Color(102, 153, 204));
			contentPane.setLayout(null);
		JButton btnQuery = new JButton("Query");
		btnQuery.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnQuery.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Query query = new Query();
				query.run();
				frame.dispose();
			}
		});
		btnQuery.setBounds(79, 81, 113, 27);
		contentPane.add(btnQuery);
		
		JButton btnInsert = new JButton("Insert");

		btnInsert.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnInsert.setBounds(237, 81, 113, 27);
		contentPane.add(btnInsert);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Update update = new Update();
				update.run();
				frame.dispose();
			}
		});
		btnUpdate.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnUpdate.setBounds(79, 121, 113, 27);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnDelete.setBounds(237, 121, 113, 27);
		contentPane.add(btnDelete);
		
		JButton btnBack = new JButton("back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame mainFrame = new MainFrame();
				mainFrame.main(null);
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnBack.setBounds(14, 213, 113, 27);
		contentPane.add(btnBack);
		
		JButton btnExit = new JButton("exit");
		btnExit.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnExit.setBounds(305, 213, 113, 27);
		contentPane.add(btnExit);
		
		JButton btnAvailabelCar = new JButton("Availabel Car");
		btnAvailabelCar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connection con = null;
				Statement st = null;
				ResultSet rs = null;
				try{
					con = JdbcUtils.getConnection();
					String sql = "SELECT * FROM cars WHERE cars.registrationNumber <> ANY(SELECT registrationNumber FROM soldCars)";
					st = con.createStatement();
					rs = st.executeQuery(sql);
					String out = "";
					while(rs.next()) {
						Car car = new Car();
						car.updateRegistrationNumber(rs.getInt("registrationNumber"));
						car.updateModelNum(rs.getInt("modelNum"));
						car.updateDateOfManuFacture(rs.getDate("dateOfManuFacture"));
						out += car.toString() + "\n";
					}
					AvailableCar ac = new AvailableCar(out);
					ac.run(out);
					frame.dispose();
				} catch(Exception ex) {
					ex.printStackTrace();
				} finally {
					JdbcUtils.free(null, st, con);
				}
				
			}
		});
		btnAvailabelCar.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnAvailabelCar.setBounds(98, 32, 228, 27);
		contentPane.add(btnAvailabelCar);
		}
		return contentPane;
	}
}
