package iPharmacyDrugStore;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class userApp extends JFrame {

	
	//---------------------//
	//DECLARING COMPONENTS
	private login mainForm;
	private JPanel contentPane;
	private JPanel topPanel;
	private JLabel close; 
	private JLabel title; 
	private JLabel header;
	private JPanel sideNav;
	private JLabel home;
	private JLabel inv;
	private JLabel user;
	private JLabel pos;
	private JLabel log;
	private JLabel logout;
	private JLabel side;
	private JPanel info;
	private JLabel userInfoLabel;
	private JLabel userRoleLabel;
	private JComboBox userRoleField;
	private JLabel userNameLabel;
	private JTextField userNameField;
	private JLabel userPassLabel;
	private JPasswordField userPassField;
	private JLabel userFnameLabel;
	private JTextField userFnameField;
	private JLabel userLnameLabel;
	private JTextField userLnameField;
	private JLabel userPhoneLabel;
	private JTextField userPhoneField;
	private JButton userAdd;
	private JButton userUpdate;
	private JPanel list;
	private JLabel listLabel;
	private JLabel listDes;
	private JLabel lhRole;
	private JLabel lhUsername;
	private JLabel lhPass;
	private JLabel lhFname;
	private JLabel lhLname;
	private JLabel lhContact;
	private JLabel listHeader;
	private JScrollPane scrollPane;
	private JTable userTable;
	private DefaultTableModel userModel;
	private JButton addUser;
	private JButton updateUser;
	private JButton delUser;
	//---------------------//

	
	//---------------------//
	//Declaration on image
	private ImageIcon homePic;
	private ImageIcon inv30Pic;
	private ImageIcon user30Pic;
	private ImageIcon pos30Pic;
	private ImageIcon logoutPic;
	private ImageIcon log30Pic;
	//--------------------//

	
	
	//--------------------//
	//MAIN FUNCTION TO SET USER APP VISIBLE
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userApp frame = new userApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//--------------------//
	
	
	
	//--------------------//
	//FUNCTION TO SHOW USER DATABASE TO APP
	public void showTable() {
		try {
			
			userModel.setRowCount(0);
			Class.forName("com.mysql.cj.jdbc.Driver");
                                                        Connection con = DriverManager.getConnection("jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_5cc5f084e523d86?user=b0084868bdbc27&password=ba102649");
			
                        Statement stm = con.createStatement();
			String sql = "SELECT * FROM users";
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				String[] data = {rs.getString("role"), rs.getString("username"), rs.getString("password"), rs.getString("fname"), rs.getString("lname"), rs.getString("contact")};
				userModel.addRow(data);
			}
			
		} catch (ClassNotFoundException | SQLException e1) {
			
			e1.printStackTrace();
		}
		
		userTable.getColumnModel().getColumn(0).setPreferredWidth(0);
	}
	//--------------------//

	
	//--------------------//
	//CONTENTS OF USER APP
	public userApp(){
		this.mainForm = new login();
		
		//FRAME 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1065, 650);
		setUndecorated(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(new Color(255, 255, 255));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
		//THIS IS WHERE PICS/ICON ARE DECLARED
		homePic = new ImageIcon(this.getClass().getResource("/home30.png"));
		inv30Pic = new ImageIcon(this.getClass().getResource("/inv30.png"));
		user30Pic = new ImageIcon(this.getClass().getResource("/user30.png"));
		pos30Pic = new ImageIcon(this.getClass().getResource("/pos30.png"));
		log30Pic = new ImageIcon(this.getClass().getResource("/log30.png"));
		logoutPic = new ImageIcon(this.getClass().getResource("/logout.png"));
		
		//-------------------------------//
		//TOP PANEL//
		topPanel = new JPanel();
		topPanel.setBounds(0, 0, 1065, 35);
		contentPane.add(topPanel);
		topPanel.setLayout(null);
		
		close = new JLabel("X");
		close.setBounds(1012, 0, 32, 34);
		topPanel.add(close);
		close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		close.setHorizontalAlignment(SwingConstants.CENTER);
		close.setHorizontalTextPosition(SwingConstants.CENTER);
		close.setForeground(new Color(255, 255, 255));
		close.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		
		title = new JLabel("PharmaEasy Drugstore");
		title.setBounds(20, 0, 198, 35);
		topPanel.add(title);
		title.setForeground(new Color(255, 255, 255));
		title.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		
		header = new JLabel("");
		header.setBounds(0, 0, 1065, 35);
		topPanel.add(header);
		header.setOpaque(true);
		header.setBackground(Color.decode("#197D4B"));
		//-------------------------------//
	
		
		
		//-------------------------------//
		//SIDENAV//
		sideNav = new JPanel();
		sideNav.setBounds(0, 35, 75, 615);
		contentPane.add(sideNav);
		sideNav.setLayout(null);

		home = new JLabel(homePic);
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				adHome adminPage = new adHome();
				adminPage.show();
			}
		});
		home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		home.setBounds(25, 90, 30, 30);
		sideNav.add(home);
		home.setToolTipText("Home");
		
		inv = new JLabel(inv30Pic);
		inv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				invApp invA = new invApp();
				invA.show();
			}
		});
		inv.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		inv.setBounds(25, 140, 30, 30);
		sideNav.add(inv);
		inv.setToolTipText("Inventory");
		
		user = new JLabel(user30Pic);
		user.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		user.setBounds(25, 190, 30, 30);
		sideNav.add(user);
		user.setToolTipText("User");
		
		pos = new JLabel(pos30Pic);
		pos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				posApp posA = new posApp();
				posA.show();
			}
		});
		pos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pos.setBounds(25, 240, 30, 30);
		sideNav.add(pos);
		pos.setToolTipText("POS");
		
		log = new JLabel(log30Pic);
		log.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		log.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				logApp logA = new logApp();
				logA.show();
			}
		});
		log.setToolTipText("Transaction Log");
		log.setBounds(25, 295, 30, 30);
		sideNav.add(log);
		
		logout = new JLabel(logoutPic);
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainForm.runMain();
				setVisible(false);
				dispose();
			}
		});
		logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logout.setBounds(25, 555, 30, 30);
		sideNav.add(logout);
		logout.setToolTipText("Log Out");
		
		side = new JLabel("");
		side.setBounds(0, 0, 75, 615);
		sideNav.add(side);
		side.setOpaque(true);
		side.setBackground(new Color(60, 179, 113));
		//-------------------------------//
		
		
		
		//-------------------------------//
		//PANEL FOR SHOWING USER LIST//
		list = new JPanel();
		list.setBackground(Color.WHITE);
		list.setBounds(75, 35, 735, 615);
		contentPane.add(list);
		list.setLayout(null);
		
		listLabel = new JLabel("List of Users");
		listLabel.setBounds(30, 30, 370, 55);
		list.add(listLabel);
		listLabel.setForeground(new Color(25, 125, 75));
		listLabel.setFont(new Font("Candara", Font.BOLD, 40));
		
		listDes = new JLabel("Showing all the users of the system and their info.\r\n");
		listDes.setBounds(30, 80, 360, 24);
		list.add(listDes);
		listDes.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		
		lhRole = new JLabel(" Role");
		lhRole.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
		lhRole.setForeground(Color.WHITE);
		lhRole.setHorizontalAlignment(SwingConstants.LEFT);
		lhRole.setBounds(30, 113, 62, 33);
		list.add(lhRole);
		
		lhUsername = new JLabel("Username");
		lhUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lhUsername.setForeground(Color.WHITE);
		lhUsername.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
		lhUsername.setBounds(93, 113, 121, 33);
		list.add(lhUsername);
		
		lhPass = new JLabel("Password");
		lhPass.setHorizontalAlignment(SwingConstants.LEFT);
		lhPass.setForeground(Color.WHITE);
		lhPass.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
		lhPass.setBounds(216, 113, 121, 33);
		list.add(lhPass);
		
		lhFname = new JLabel("First Name");
		lhFname.setHorizontalAlignment(SwingConstants.LEFT);
		lhFname.setForeground(Color.WHITE);
		lhFname.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
		lhFname.setBounds(337, 113, 121, 33);
		list.add(lhFname);
		
		lhLname = new JLabel("Last Name");
		lhLname.setHorizontalAlignment(SwingConstants.LEFT);
		lhLname.setForeground(Color.WHITE);
		lhLname.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
		lhLname.setBounds(457, 113, 121, 33);
		list.add(lhLname);
		
		lhContact = new JLabel("Contact");
		lhContact.setHorizontalAlignment(SwingConstants.LEFT);
		lhContact.setForeground(Color.WHITE);
		lhContact.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
		lhContact.setBounds(583, 113, 121, 33);
		list.add(lhContact);
		
		listHeader = new JLabel("");
		listHeader.setBackground(Color.decode("#197D4B"));
		listHeader.setOpaque(true);
		listHeader.setBounds(30, 113, 674, 33);
		list.add(listHeader);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBackground(Color.ORANGE);
		scrollPane.setBounds(30, 125, 675, 400);
		list.add(scrollPane);
		
		userTable = new JTable();
		userTable.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		userTable.setRowHeight(25);
		userTable.setBorder(null);
		userModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Roles", "Username", "Password", "First Name", "Last Name", "Contact"
				}
			)
				
				//FUNCTION TO MAKE TABLE NOT EDITABLE
				{
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
				};
		
		userTable.setSelectionBackground(new Color(102, 205, 170));
		userTable.setGridColor(Color.decode("#197D4B"));
		userTable.setBackground(Color.WHITE);
		userTable.setModel(userModel);
		
		scrollPane.setViewportView(userTable);	
		
		
		//FUNCTION TO OPEN ADD USERS FORM
		addUser = new JButton("Add Users");
		addUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userInfoLabel.setText("Register");
				userAdd.show();
				info.show();
			}
		});
		addUser.setIgnoreRepaint(true);
		addUser.setForeground(Color.WHITE);
		addUser.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		addUser.setFocusPainted(false);
		addUser.setDefaultCapable(false);
		addUser.setBorderPainted(false);
		addUser.setBorder(null);
		addUser.setBackground(new Color(60, 179, 113));
		addUser.setBounds(30, 547, 110, 36);
		list.add(addUser);
		
		
		//FUNCTION TO DELETE USERS FROM DATABASE
		delUser = new JButton("Delete");
		delUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		delUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int column1 = 1;
				int column2 = 5;
				int row = userTable.getSelectedRow();
				String usName = userTable.getModel().getValueAt(row, column1).toString();
				String contacts = userTable.getModel().getValueAt(row, column2).toString();
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					                                Connection con = DriverManager.getConnection("jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_5cc5f084e523d86?user=b0084868bdbc27&password=ba102649");
					
					String delete1 = " DELETE FROM users WHERE username='"+ usName +"' AND contact='" + contacts + "';";
					
					
					PreparedStatement preparedStmt = con.prepareStatement(delete1);
					preparedStmt.execute();
					
					showTable();
					
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		delUser.setIgnoreRepaint(true);
		delUser.setForeground(Color.WHITE);
		delUser.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		delUser.setFocusPainted(false);
		delUser.setDefaultCapable(false);
		delUser.setBorderPainted(false);
		delUser.setBorder(null);
		delUser.setBackground(new Color(60, 179, 113));
		delUser.setBounds(270, 547, 110, 36);
		list.add(delUser);
		
		
		//GET SELECTED  ROW AND SET INFO TO THE FORM
		updateUser = new JButton("Update");
		updateUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		updateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.show();
				userInfoLabel.setText("Update");
				userAdd.hide();
				userUpdate.show();
				
				int row = userTable.getSelectedRow();
				String role = userTable.getModel().getValueAt(row, 0).toString();
				String usName = userTable.getModel().getValueAt(row, 1).toString();
				String pass = userTable.getModel().getValueAt(row, 2).toString();
				String fnameS = userTable.getModel().getValueAt(row, 3).toString();
				String lnameS = userTable.getModel().getValueAt(row, 4).toString();
				String contacts = userTable.getModel().getValueAt(row, 5).toString();
				
				userRoleField.setSelectedItem(role);
				userNameField.setText(usName);
				userPassField.setText(pass);
				userFnameField.setText(fnameS);
				userLnameField.setText(lnameS);
				userPhoneField.setText(contacts);
			}
		});
		updateUser.setIgnoreRepaint(true);
		updateUser.setForeground(Color.WHITE);
		updateUser.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		updateUser.setFocusPainted(false);
		updateUser.setDefaultCapable(false);
		updateUser.setBorderPainted(false);
		updateUser.setBorder(null);
		updateUser.setBackground(new Color(60, 179, 113));
		updateUser.setBounds(150, 547, 110, 36);
		list.add(updateUser);
		//-------------------------------//
		
		
		
		//-------------------------------//
		//PANEL FOR THE ADD AND UPDATE FORMS
		info = new JPanel();
		info.hide();
		info.setBackground(Color.decode("#74c69d"));
		info.setBounds(810, 35, 255, 615);
		contentPane.add(info);
		info.setLayout(null);

		userInfoLabel = new JLabel("Information");
		userInfoLabel.setForeground(Color.WHITE);
		userInfoLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 26));
		userInfoLabel.setBounds(30, 30, 175, 39);
		info.add(userInfoLabel);
		
		userRoleLabel = new JLabel("Role");
		userRoleLabel.setForeground(Color.WHITE);
		userRoleLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		userRoleLabel.setBounds(30, 80, 80, 14);
		info.add(userRoleLabel);
		
		String[] options = {"admin", "user"};
		userRoleField = new JComboBox(options);
		userRoleField.setOpaque(false);
		userRoleField.setBounds(30, 105, 175, 25);
		info.add(userRoleField);
		
		userNameLabel = new JLabel("Username");
		userNameLabel.setForeground(Color.WHITE);
		userNameLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		userNameLabel.setBounds(30, 151, 80, 14);
		info.add(userNameLabel);
		
		userNameField = new JTextField();
		userNameField.setBorder(null);
		userNameField.setColumns(10);
		userNameField.setBounds(30, 176, 175, 25);
		info.add(userNameField);
		
		userPassLabel = new JLabel("Password");
		userPassLabel.setForeground(Color.WHITE);
		userPassLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		userPassLabel.setBounds(30, 226, 80, 14);
		info.add(userPassLabel);
		
		userPassField = new JPasswordField();
		userPassField.setBorder(null);
		userPassField.setBounds(30, 251, 175, 25);
		info.add(userPassField);
		
		userFnameLabel = new JLabel("First Name");
		userFnameLabel.setForeground(Color.WHITE);
		userFnameLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		userFnameLabel.setBounds(30, 306, 80, 14);
		info.add(userFnameLabel);
		
		userFnameField = new JTextField();
		userFnameField.setColumns(10);
		userFnameField.setBorder(null);
		userFnameField.setBounds(30, 331, 175, 25);
		info.add(userFnameField);
		
		userLnameLabel = new JLabel("Last Name");
		userLnameLabel.setForeground(Color.WHITE);
		userLnameLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		userLnameLabel.setBounds(30, 386, 80, 14);
		info.add(userLnameLabel);
		
		userLnameField = new JTextField();
		userLnameField.setColumns(10);
		userLnameField.setBorder(null);
		userLnameField.setBounds(30, 411, 175, 25);
		info.add(userLnameField);
		
		userPhoneLabel = new JLabel("Contact Number");
		userPhoneLabel.setForeground(Color.WHITE);
		userPhoneLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		userPhoneLabel.setBounds(30, 465, 161, 14);
		info.add(userPhoneLabel);
		
		userPhoneField = new JTextField();
		userPhoneField.setColumns(10);
		userPhoneField.setBorder(null);
		userPhoneField.setBounds(30, 490, 175, 25);
		info.add(userPhoneField);
		
		
		//FUNCTION TO ADD USERS TO USER DATABASE
		userAdd = new JButton("Add User");
		userAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		userAdd.hide();
		userAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					                                Connection con = DriverManager.getConnection("jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_5cc5f084e523d86?user=b0084868bdbc27&password=ba102649");
					
					String insert1 = " INSERT INTO users VALUES (?, ?, ?, ?, ?, ?)";
					
					String roleS = userRoleField.getSelectedItem().toString(),
					usernameS = userNameField.getText(),
					passS = userPassField.getText(),
					fnameS = userFnameField.getText(),
					lnameS = userLnameField.getText(), 
					contactS = userPhoneField.getText();
					
					PreparedStatement preparedStmt = con.prepareStatement(insert1);
					preparedStmt.setString (1, roleS);
					preparedStmt.setString (2, usernameS);
					preparedStmt.setString (3, passS);
					preparedStmt.setString (4, fnameS);
					preparedStmt.setString (5, lnameS);
					preparedStmt.setString (6, contactS);
					preparedStmt.execute();
					
					
					showTable();
					info.hide();
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		userAdd.setIgnoreRepaint(true);
		userAdd.setForeground(new Color(60, 179, 113));
		userAdd.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		userAdd.setFocusPainted(false);
		userAdd.setDefaultCapable(false);
		userAdd.setBorderPainted(false);
		userAdd.setBorder(null);
		userAdd.setBackground(Color.WHITE);
		userAdd.setBounds(30, 545, 110, 36);
		info.add(userAdd);
		
		
		//FUNCTION TO UPDATE USER IN USER DATABASE
		userUpdate = new JButton("Update");
		userUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		userUpdate.hide();
		userUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int column1 = 1;
				int column2 = 5;
				int row = userTable.getSelectedRow();
				String usName = userTable.getModel().getValueAt(row, column1).toString();
				String contacts = userTable.getModel().getValueAt(row, column2).toString();
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					                                Connection con = DriverManager.getConnection("jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_5cc5f084e523d86?user=b0084868bdbc27&password=ba102649");
					
					String insert1 = " INSERT INTO users VALUES (?, ?, ?, ?, ?, ?)";
					
					String roleS = userRoleField.getSelectedItem().toString(),
					usernameS = userNameField.getText(),
					passS = userPassField.getText(),
					fnameS = userFnameField.getText(),
					lnameS = userLnameField.getText(), 
					contactS = userPhoneField.getText();
					
					String delete1 = " DELETE FROM users WHERE username='"+ usName +"' AND contact='" + contacts + "';";
					PreparedStatement preparedStmt1 = con.prepareStatement(delete1);
					preparedStmt1.execute();
					
					PreparedStatement preparedStmt = con.prepareStatement(insert1);
					preparedStmt.setString (1, roleS);
					preparedStmt.setString (2, usernameS);
					preparedStmt.setString (3, passS);
					preparedStmt.setString (4, fnameS);
					preparedStmt.setString (5, lnameS);
					preparedStmt.setString (6, contactS);
					preparedStmt.execute();
					
					
					showTable();
					info.hide();
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		userUpdate.setIgnoreRepaint(true);
		userUpdate.setForeground(new Color(60, 179, 113));
		userUpdate.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		userUpdate.setFocusPainted(false);
		userUpdate.setDefaultCapable(false);
		userUpdate.setBorderPainted(false);
		userUpdate.setBorder(null);
		userUpdate.setBackground(Color.WHITE);
		userUpdate.setBounds(95, 545, 110, 36);
		info.add(userUpdate);
		showTable();
		//-------------------------------//
		
	}
}
