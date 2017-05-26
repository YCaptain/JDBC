package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import frame.query.CarFrame;
import frame.query.CustomerFrame;
import frame.query.MemberFrame;
import frame.query.ModelFrame;
import frame.query.RentalCarFrame;
import frame.query.SoldCarFrame;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

public class Query {

	private JFrame frame;
	private JPanel contentPane;
	private JButton btnCustomer;
	private JButton btnMember;
	private JButton btnCar;
	private JButton btnModel;
	private JButton btnRentalcar;
	private JButton btnSoldcar;
	private JButton btnBack;
	private JButton btnExit;
	private JLabel lblEntity;

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
			Query window = new Query();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public Query() {
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
		frame.getContentPane().setLayout(null);
		Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize= frame.getSize();
		frame.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);
		
	}
	
	private JPanel getContentPane() {
		if(contentPane == null) {
			contentPane = new JPanel();
			contentPane.setBackground(new Color(102, 153, 204));
			contentPane.setForeground(new Color(0, 0, 0));
			contentPane.add(getBtnMember());
			contentPane.add(getBtnCar());
			contentPane.add(getBtnModel());
			contentPane.add(getBtnRentalcar());
			contentPane.add(getBtnSoldcar());
			contentPane.add(getBtnBack());
			contentPane.add(getBtnExit());
			contentPane.add(getLblEntity());
			contentPane.add(getBtnCustomer());
		}
		return contentPane;
	}
	private JButton getBtnCustomer() {
		if (btnCustomer == null) {
			btnCustomer = new JButton("Customer");
			btnCustomer.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnCustomer.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					CustomerFrame customerFrame = new CustomerFrame();
					customerFrame.run();
					frame.dispose();
				}
			});
			btnCustomer.setBounds(57, 55, 132, 27);
		}
		return btnCustomer;
	}
	private JButton getBtnMember() {
		if (btnMember == null) {
			btnMember = new JButton("Member");
			btnMember.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnMember.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					MemberFrame memberFrame = new MemberFrame();
					memberFrame.run();
					frame.dispose();
				}
			});
			btnMember.setBounds(57, 95, 132, 27);
		}
		return btnMember;
	}
	private JButton getBtnCar() {
		if (btnCar == null) {
			btnCar = new JButton("Car");
			btnCar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					CarFrame carFrame = new CarFrame();
					carFrame.run();
					frame.dispose();
				}
			});
			btnCar.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnCar.setBounds(249, 55, 132, 27);
		}
		return btnCar;
	}
	private JButton getBtnModel() {
		if (btnModel == null) {
			btnModel = new JButton("Model");
			btnModel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ModelFrame modelFrame = new ModelFrame();
					modelFrame.run();
					frame.dispose();
				}
			});
			btnModel.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnModel.setBounds(57, 135, 132, 27);
		}
		return btnModel;
	}
	private JButton getBtnRentalcar() {
		if (btnRentalcar == null) {
			btnRentalcar = new JButton("RentalCar");
			btnRentalcar.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnRentalcar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					RentalCarFrame rentalCarFrame = new RentalCarFrame();
					rentalCarFrame.run();
					frame.dispose();
				}
			});
			btnRentalcar.setBounds(249, 95, 132, 27);
		}
		return btnRentalcar;
	}
	private JButton getBtnSoldcar() {
		if (btnSoldcar == null) {
			btnSoldcar = new JButton("SoldCar");
			btnSoldcar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					SoldCarFrame soldCarFrame = new SoldCarFrame();
					soldCarFrame.run();
					frame.dispose();
				}
			});
			btnSoldcar.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnSoldcar.setBounds(249, 135, 132, 27);
		}
		return btnSoldcar;
	}
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("back");
			btnBack.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Enter enter = new Enter();
					enter.run();
					frame.dispose();
				}
			});
			btnBack.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnBack.setBounds(14, 201, 113, 27);
		}
		return btnBack;
	}
	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("exit");
			btnExit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					frame.dispose();
				}
			});
			btnExit.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnExit.setBounds(305, 201, 113, 27);
		}
		return btnExit;
	}
	private JLabel getLblEntity() {
		if (lblEntity == null) {
			lblEntity = new JLabel("Entity");
			lblEntity.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblEntity.setBounds(27, 24, 61, 18);
		}
		return lblEntity;
	}
}
