package main;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import bean.Model;
import service.CarService;
import service.CustomerService;
import service.MemberService;
import service.ModelService;
import service.NonMemberService;
import service.RentalCarService;
import service.RentsService;
import service.SoldCarService;

public class MainClient extends JFrame implements ActionListener, ListSelectionListener{
	private JPanel jContentPane = null;
	
	private JLabel lblOption = null;
	private JLabel lblEntity = null;
	private JButton btnRun = null;
	private JButton btnEnter = null;
	private JTable tblData = null;
	private JScrollPane jScrollPane = null;
	private JComboBox comboOption = null;
	private JComboBox comboEntity = null;
	private JLabel lblTxt = null;
	private JTextField txtData = null;
	
	
	private DataTableModel dataModel;
	private OptionComboModel comboModel1;
	private EntityComboModel comboModel2;
	
	private static enum Type{
		MODEL, CAR, RENTALCAR, SOLDCAR, CUSTOMER, MEMBER, NONMEMBER, RENTS
	}


	private ModelService modelService;
	private CarService carService;
	private RentalCarService rentalCarService;
	private SoldCarService soldCarService;
	private CustomerService customerService;
	private MemberService memberService;
	private NonMemberService nonMemberService;
	private RentsService rentsService;
	
	public MainClient() {
		super();
		initialize();
		
		getTxtData().setEnabled(false);
		getLblTxt().setEnabled(false);
		getBtnEnter().setEnabled(false);
		
		dataModel = new DataTableModel();
		getTblData().setModel(dataModel);
		
	//	comboModel1 = new OptionComboModel();
	//	comboModel2 = new EntityComboModel();
		
		getComboOption().setModel(comboModel1);
		getComboEntity().setModel(comboModel2);
		
	}
	
	private void initialize() {
		this.setSize(560, 330);
		this.setContentPane(getJContentPane());
		this.setTitle("JDBC assignment-------Yao Chenzhen");

		modelService = new ModelService();
		carService = new CarService();
		rentalCarService = new RentalCarService();
		soldCarService = new SoldCarService();
		customerService = new CustomerService();
		memberService = new MemberService();
		nonMemberService = new NonMemberService();
		rentsService = new RentsService();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private class DataTableModel extends AbstractTableModel {
		private List data = new ArrayList();

		private Type type;
		
		public void updateDate(List l) {
			data = l;
			fireTableDataChanged();
		}
		
		public List getData() {
			return data;
		}
		

		@Override
		public int getColumnCount() {
			if(type == Type.MODEL)
				return 4;
			return 0;
		}

		@Override
		public int getRowCount() {
			return data.size();
		}
		
		@Override
		public String getColumnName(int col) {
			switch(type){
			case MODEL:
				if (col == 0)
					return "modelNum";
				else if (col == 1)
					return "modelName";
				else if (col == 2)
					return "manufacturer";
				else
					return "seats";
			default:
				return null;
			}
		}

		@Override
		public Object getValueAt(int row, int col) {
			if (type == Type.MODEL) {
				if (col == 0)
					return new Integer(((Model)(data.get(row))).getModelNum());
				else if (col == 1)
					return ((Model)(data.get(row))).getModelName();
				else if (col == 2)
					return ((Model)(data.get(row))).getManufacturer();
				else
					return new Integer(((Model)(data.get(row))).getSeats());
			}
			return null;
		}
		
	}
	
	private class OptionComboModel implements ComboBoxModel {
		private List data = new ArrayList();
		private int selected = 0;
		
		public OptionComboModel(List list) {
			data = list;
		}

		@Override
		public void addListDataListener(ListDataListener arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Object getElementAt(int i) {
			return data.get(i);
		}

		@Override
		public int getSize() {
			return data.size();
		}

		@Override
		public void removeListDataListener(ListDataListener arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Object getSelectedItem() {
			return data.get(selected);
		}

		@Override
		public void setSelectedItem(Object o) {
			selected = data.indexOf(o);
		}
		
	}
	
	private class EntityComboModel implements ComboBoxModel {
		private List data = new ArrayList();
		private int selected = 0;
		
		public EntityComboModel(List list) {
			data = list;
		}

		@Override
		public void addListDataListener(ListDataListener l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Object getElementAt(int i) {
			return data.get(i);
		}

		@Override
		public int getSize() {
			return data.size();
		}

		@Override
		public void removeListDataListener(ListDataListener l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Object getSelectedItem() {
			return data.get(selected);
		}

		@Override
		public void setSelectedItem(Object o) {
			selected = data.indexOf(o);
		}
		
	}
	
	private JPanel getJContentPane() {
		if(jContentPane == null) {
			jContentPane = new JPanel();
			GridBagConstraints consGridBagConstraints1 = new GridBagConstraints();
			GridBagConstraints consGridBagConstraints2 = new GridBagConstraints();
			GridBagConstraints consGridBagConstraints3 = new GridBagConstraints();
			GridBagConstraints consGridBagConstraints4 = new GridBagConstraints();
			GridBagConstraints consGridBagConstraints5 = new GridBagConstraints();
			GridBagConstraints consGridBagConstraints6 = new GridBagConstraints();
			GridBagConstraints consGridBagConstraints7 = new GridBagConstraints();
			GridBagConstraints consGridBagConstraints8 = new GridBagConstraints();
			GridBagConstraints consGridBagConstraints9 = new GridBagConstraints();
			consGridBagConstraints1.insets = new java.awt.Insets(33,14,10,6);
			consGridBagConstraints1.ipady = 6;
			consGridBagConstraints1.ipadx = 34;
			consGridBagConstraints1.gridy = 0;
			consGridBagConstraints1.gridx = 0;
			consGridBagConstraints2.insets = new java.awt.Insets(33,3,10,5);
			consGridBagConstraints2.ipady = 6;
			consGridBagConstraints2.ipadx = 27;
			consGridBagConstraints2.gridy = 0;
			consGridBagConstraints2.gridx = 3;
			consGridBagConstraints3.insets = new java.awt.Insets(30,8,6,18);
			consGridBagConstraints3.ipady = 3;
			consGridBagConstraints3.gridy = 0;
			consGridBagConstraints3.gridx = 5;
			consGridBagConstraints4.insets = new java.awt.Insets(7,15,4,18);
			consGridBagConstraints4.ipady = -246;
			consGridBagConstraints4.ipadx = 66;
			consGridBagConstraints4.fill = java.awt.GridBagConstraints.BOTH;
			consGridBagConstraints4.weighty = 1.0;
			consGridBagConstraints4.weightx = 1.0;
			consGridBagConstraints4.gridwidth = 6;
			consGridBagConstraints4.gridy = 1;
			consGridBagConstraints4.gridx = 0;
			consGridBagConstraints5.insets = new java.awt.Insets(11,5,16,2);
			consGridBagConstraints5.ipadx = 62;
			consGridBagConstraints5.fill = java.awt.GridBagConstraints.HORIZONTAL;
			consGridBagConstraints5.weightx = 1.0;
			consGridBagConstraints5.gridy = 2;
			consGridBagConstraints5.gridx = 2;
			consGridBagConstraints6.insets = new java.awt.Insets(11,17,15,4);
			consGridBagConstraints6.ipady = 5;
			consGridBagConstraints6.ipadx = 36;
			consGridBagConstraints6.gridwidth = 2;
			consGridBagConstraints6.gridy = 2;
			consGridBagConstraints6.gridx = 0;
			consGridBagConstraints7.insets = new java.awt.Insets(5,96,10,18);
			consGridBagConstraints7.ipady = 6;
			consGridBagConstraints7.ipadx = 10;
			consGridBagConstraints7.gridwidth = 2;
			consGridBagConstraints7.gridy = 2;
			consGridBagConstraints7.gridx = 4;
			consGridBagConstraints8.insets = new java.awt.Insets(32,6,8,18);
			consGridBagConstraints8.ipadx = 68;
			consGridBagConstraints8.fill = java.awt.GridBagConstraints.HORIZONTAL;
			consGridBagConstraints8.weightx = 1.0;
			consGridBagConstraints8.gridwidth = 2;
			consGridBagConstraints8.gridy = 0;
			consGridBagConstraints8.gridx = 1;
			consGridBagConstraints9.insets = new java.awt.Insets(32,5,8,8);
			consGridBagConstraints9.ipadx = 68;
			consGridBagConstraints9.fill = java.awt.GridBagConstraints.HORIZONTAL;
			consGridBagConstraints9.weightx = 1.0;
			consGridBagConstraints9.gridy = 0;
			consGridBagConstraints9.gridx = 4;
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(getLblOption(), consGridBagConstraints1);
			jContentPane.add(getLblEntity(), consGridBagConstraints2);
			jContentPane.add(getBtnRun(), consGridBagConstraints3);
			jContentPane.add(getJScrollPane(), consGridBagConstraints4);
			jContentPane.add(getTxtData(), consGridBagConstraints5);
			jContentPane.add(getLblTxt(), consGridBagConstraints6);
			jContentPane.add(getBtnEnter(), consGridBagConstraints7);
			jContentPane.add(getComboOption(), consGridBagConstraints8);
			jContentPane.add(getComboEntity(), consGridBagConstraints9);
		}
		return jContentPane;
	}
	
	private JLabel getLblOption() {
		if(lblOption == null) {
			lblOption = new JLabel();
			lblOption.setText("Option:");
			lblOption.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblOption;
	}
	
	private JLabel getLblEntity() {
		if(lblEntity == null) {
			lblEntity = new JLabel();
			lblEntity.setText("Entity:");
			lblEntity.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblEntity;
	}
	
	private JButton getBtnRun() {
		if(btnRun == null) {
			btnRun = new JButton();
			btnRun.setText("Run");
			btnRun.setMnemonic(KeyEvent.VK_S);
			btnRun.addActionListener(this);
		}
		return btnRun;
	}
	
	private JTable getTblData() {
		if(tblData == null) {
			tblData = new JTable();
			tblData.getSelectionModel().addListSelectionListener(this);
			tblData.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return tblData;
	}
	
	private JScrollPane getJScrollPane() {
		if(jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getTblData());
		}
		return jScrollPane;
	}
	
	private JLabel getLblTxt() {
		if(lblTxt == null) {
			lblTxt = new JLabel();
			lblTxt.setText("Enter data:");
			lblTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblTxt;
	}
	
	private JTextField getTxtData() {
		if(txtData == null) {
			txtData = new JTextField();
		}
		return txtData;
	}
	
	private JButton getBtnEnter() {
		if(btnEnter == null) {
			btnEnter = new JButton();
			btnEnter.setText("Enter");
			btnEnter.addActionListener(this);
		}
		return btnEnter;
	}
	
	private JComboBox getComboOption() {
		if(comboOption == null) {
			comboOption=  new JComboBox();
		}
		return comboOption;
	}
	
	private JComboBox getComboEntity() {
		if(comboEntity == null) {
			comboEntity = new JComboBox();
		}
		return comboEntity;
	}
	
} // decl-index=0 visual-constraint="10,10"
