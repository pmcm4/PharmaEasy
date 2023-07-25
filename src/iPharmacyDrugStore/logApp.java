package iPharmacyDrugStore;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class logApp extends JFrame {


		//---------------------//
		//DECLARING VARIABLES
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
		private JPanel list;
		private JLabel logLabel;
		private JLabel logDes;
		private JLabel logNo;
		private JLabel logCashier;
		private JLabel logItems;
		private JLabel logTotal;
		private JLabel logDate;
		private JLabel logHeader;
		private JTable logTable;
		private JScrollPane scrollPane;
		private DefaultTableModel userModel;
		//---------------------//

		
		//---------------------//
		//Declaration on image
		private ImageIcon homePic;
		private ImageIcon inv30Pic;
		private ImageIcon user30Pic;
		private ImageIcon pos30Pic;
		private ImageIcon log30Pic;
		private ImageIcon logoutPic;
		//--------------------//

		
		//---------------------//
		//MAIN FUNCTION TO SET LOG APP VISIBLE//
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						logApp frame = new logApp();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		//---------------------//
		
		
		
		//---------------------//
		//FUNCTION FOR SHOWING LOG DATABASE//
		public void showTable() {
			try {
				
				userModel.setRowCount(0);
				Class.forName("com.mysql.cj.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_5cc5f084e523d86?user=b0084868bdbc27&password=ba102649");
				
				Statement stm = con.createStatement();
				String sql = "SELECT * FROM log";
				ResultSet rs = stm.executeQuery(sql);
				
				while(rs.next()) {
					String[] data = {rs.getString("trno"), rs.getString("cashier"), rs.getString("prodName"), rs.getString("total"), rs.getString("date")};
					userModel.addRow(data);
				}
				
			} catch (ClassNotFoundException | SQLException e1) {
				
				e1.printStackTrace();
			}
			
			logTable.getColumnModel().getColumn(0).setPreferredWidth(0);
		}
		//---------------------//


		
		//---------------------//
		//CONTENTS OF LOG APP//
		public logApp(){
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
			user.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					userApp userA = new userApp();
					userA.show();
				}
			});
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
			log.setToolTipText("Transaction Log");
			
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
			
			list = new JPanel();
			list.setBackground(Color.WHITE);
			list.setBounds(75, 35, 990, 615);
			contentPane.add(list);
			list.setLayout(null);
			
			logLabel = new JLabel("Transaction Logs");
			logLabel.setBounds(30, 55, 370, 55);
			list.add(logLabel);
			logLabel.setForeground(new Color(25, 125, 75));
			logLabel.setFont(new Font("Candara", Font.BOLD, 40));
			
			logDes = new JLabel("This is where all of the transactinos are stored.");
			logDes.setBounds(30, 105, 360, 24);
			list.add(logDes);
			logDes.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
			
			logNo = new JLabel("Transcation No.");
			logNo.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
			logNo.setForeground(Color.WHITE);
			logNo.setHorizontalAlignment(SwingConstants.LEFT);
			logNo.setBounds(33, 138, 99, 33);
			list.add(logNo);
			
			logCashier = new JLabel("Cashier");
			logCashier.setHorizontalAlignment(SwingConstants.LEFT);
			logCashier.setForeground(Color.WHITE);
			logCashier.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
			logCashier.setBounds(165, 138, 121, 33);
			list.add(logCashier);
			
			logItems = new JLabel("Purchased Items");
			logItems.setHorizontalAlignment(SwingConstants.LEFT);
			logItems.setForeground(Color.WHITE);
			logItems.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
			logItems.setBounds(365, 138, 147, 33);
			list.add(logItems);
			
			logTotal = new JLabel("Total");
			logTotal.setHorizontalAlignment(SwingConstants.LEFT);
			logTotal.setForeground(Color.WHITE);
			logTotal.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
			logTotal.setBounds(560, 138, 121, 33);
			list.add(logTotal);
			
			logDate = new JLabel("Date");
			logDate.setHorizontalAlignment(SwingConstants.LEFT);
			logDate.setForeground(Color.WHITE);
			logDate.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
			logDate.setBounds(760, 138, 121, 33);
			list.add(logDate);
			
			logHeader = new JLabel("");
			logHeader.setBackground(Color.decode("#197D4B"));
			logHeader.setOpaque(true);
			logHeader.setBounds(30, 138, 930, 33);
			list.add(logHeader);
			
			scrollPane = new JScrollPane();
			scrollPane.setBorder(null);
			scrollPane.setBackground(Color.ORANGE);
			scrollPane.setBounds(30, 150, 930, 400);
			list.add(scrollPane);
			
			logTable = new JTable();
			logTable.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			logTable.setRowHeight(25);
			logTable.setBorder(null);
			userModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID No", "Product Name", "Category", "Stock", "Price"
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
			logTable.setSelectionBackground(new Color(102, 205, 170));
			logTable.setGridColor(Color.decode("#197D4B"));
			logTable.setBackground(Color.WHITE);
			logTable.setModel(userModel);
			showTable();
			
			scrollPane.setViewportView(logTable);
			//-------------------------------//
			
			
	}
}
