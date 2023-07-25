package iPharmacyDrugStore;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.ComponentOrientation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.Component;


public class ccheckout extends JFrame {


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
		private JLabel coutLabel;
		private JLabel coutId;
		private JLabel coutProdname;
		private JLabel coutCategory;
		private JLabel coutStock;
		private JLabel coutQuantity;
		private JLabel coutPrice;
		private JLabel coutHeader;
		private JTable coutTable;
		private JScrollPane scrollPane;
		private DefaultTableModel userModel;
		private JLabel coutDiscountLabel;
		private JTextField coutDiscountField;
		private JButton coutDiscountDrop;
		private JButton coutDiscountPwd;
		private JButton coutDiscountSenior;
		private JButton coutDiscountNone;
		private JLabel coutQuanLabel;
		private JTextField coutQuanField;
		private JButton coutQuanApply;
		private JLabel coutTotalLabel;
		private JLabel coutTotaldLabel;
		private JButton coutRemove;
		private JButton coutCheckout;
		private BufferedReader br = null;
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

		
		//--------------------//
		//MAIN FUNCTION TO SET CHECKOUT APP VISIBLE//
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						ccheckout frame = new ccheckout();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		//--------------------//
		
		
		
		//--------------------//
		//FUNCTION TO SHOW CART DATABASE TO TABLE
		public void showTable() {
			try {
				userModel.setRowCount(0);
				Class.forName("com.mysql.cj.jdbc.Driver");
				                                Connection con = DriverManager.getConnection("jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_5cc5f084e523d86?user=b0084868bdbc27&password=ba102649");
				
				Statement stm = con.createStatement();
				String sql = "SELECT * FROM cart";
				ResultSet rs = stm.executeQuery(sql);
				
				while(rs.next()) {
					String[] data = {rs.getString("idno"), rs.getString("prodName"), rs.getString("category"), rs.getString("stock"), rs.getString("quantity"), rs.getString("price")};
					userModel.addRow(data);
				}
				
			} catch (ClassNotFoundException | SQLException e1) {
				
				e1.printStackTrace();
			}
			
			coutTable.getColumnModel().getColumn(0).setPreferredWidth(0);
		}
		//--------------------//
		
		
		//--------------------//
		//FUNCTION FOR COMPUTING TOTAL PURCHASED
		public void computeTotal() {
			try {
				String discount = coutDiscountField.getText();
				double inTotal=0, finalTotal = 0, dis = 0; 
				Class.forName("com.mysql.cj.jdbc.Driver");
				                                Connection con = DriverManager.getConnection("jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_5cc5f084e523d86?user=b0084868bdbc27&password=ba102649");
				
				Statement stm = con.createStatement();
				String sql = "SELECT * FROM cart";
				ResultSet rs = stm.executeQuery(sql);
				
				while(rs.next()) {
					int quan = rs.getInt("quantity");
					double pr = rs.getDouble("price");
					inTotal += quan * pr;
				}
				
				if(discount.equals("None")) {
					finalTotal = (inTotal * 0.12) + inTotal;
				}
				
				else {
					dis = inTotal * 0.8;
					finalTotal = dis * 1.12;
					
				}
				
				BigDecimal bd = new BigDecimal(finalTotal).setScale(2, RoundingMode.HALF_UP);
				double fTotal = bd.doubleValue();
				String finalTotalS = Double.toString(fTotal);
				coutTotaldLabel.setText(finalTotalS);
				
			} catch (ClassNotFoundException | SQLException e1) {
				
				e1.printStackTrace();
			}
		}
		//--------------------//
		
		
		
		//--------------------//
		//CONTENTS OF CHECKOUT APP
		public ccheckout(){
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
			home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			home.setBounds(25, 90, 30, 30);
			sideNav.add(home);
			home.setToolTipText("Home");
			
			inv = new JLabel(inv30Pic);
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
					cposApp posA = new cposApp();
					posA.show();
				}
			});
			pos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			pos.setBounds(25, 240, 30, 30);
			sideNav.add(pos);
			pos.setToolTipText("POS");
			
			log = new JLabel(log30Pic);
			log.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
			logout.setToolTipText("Home");
			
			side = new JLabel("");
			side.setBounds(0, 0, 75, 615);
			sideNav.add(side);
			side.setOpaque(true);
			side.setBackground(new Color(60, 179, 113));
			//--------------------//
			
			
			//--------------------//
			//CHECKOUT PANEL
			list = new JPanel();
			list.setBackground(new Color(60, 179, 113));
			list.setBounds(75, 35, 990, 615);
			contentPane.add(list);
			list.setLayout(null);
			
			coutLabel = new JLabel("Check Out");
			coutLabel.setBounds(30, 47, 370, 55);
			list.add(coutLabel);
			coutLabel.setForeground(new Color(255, 255, 255));
			coutLabel.setFont(new Font("Candara", Font.BOLD, 40));
			
			coutId = new JLabel("ID No.");
			coutId.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
			coutId.setForeground(Color.WHITE);
			coutId.setHorizontalAlignment(SwingConstants.CENTER);
			coutId.setBounds(33, 113, 95, 33);
			list.add(coutId);
			
			coutProdname = new JLabel("Product Name");
			coutProdname.setHorizontalAlignment(SwingConstants.CENTER);
			coutProdname.setForeground(Color.WHITE);
			coutProdname.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
			coutProdname.setBounds(125, 113, 157, 33);
			list.add(coutProdname);
			
			coutCategory = new JLabel("Category");
			coutCategory.setHorizontalAlignment(SwingConstants.CENTER);
			coutCategory.setForeground(Color.WHITE);
			coutCategory.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
			coutCategory.setBounds(281, 113, 157, 33);
			list.add(coutCategory);
			
			coutStock = new JLabel("Stock");
			coutStock.setHorizontalAlignment(SwingConstants.CENTER);
			coutStock.setForeground(Color.WHITE);
			coutStock.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
			coutStock.setBounds(439, 113, 157, 33);
			list.add(coutStock);
			
			coutQuantity = new JLabel("Quantity");
			coutQuantity.setHorizontalAlignment(SwingConstants.CENTER);
			coutQuantity.setForeground(Color.WHITE);
			coutQuantity.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
			coutQuantity.setBounds(596, 113, 157, 33);
			list.add(coutQuantity);
			
			coutPrice = new JLabel("Price");
			coutPrice.setHorizontalAlignment(SwingConstants.CENTER);
			coutPrice.setForeground(Color.WHITE);
			coutPrice.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
			coutPrice.setBounds(753, 113, 157, 33);
			list.add(coutPrice);
			
			coutHeader = new JLabel("");
			coutHeader.setBackground(Color.decode("#197D4B"));
			coutHeader.setOpaque(true);
			coutHeader.setBounds(30, 113, 880, 33);
			list.add(coutHeader);
			
			

			//TABLE FOR THE CART
			scrollPane = new JScrollPane();
			scrollPane.setBorder(new LineBorder(new Color(0, 128, 0)));
			scrollPane.setBackground(Color.ORANGE);
			scrollPane.setBounds(30, 125, 880, 219);
			list.add(scrollPane);
			
			coutTable = new JTable();
			coutTable.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			coutTable.setRowHeight(25);
			coutTable.setBorder(null);
			userModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID No", "Product Name", "Category", "Quantity", "Stock", "Price"
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
			coutTable.setSelectionBackground(new Color(102, 205, 170));
			coutTable.setGridColor(Color.decode("#197D4B"));
			coutTable.setBackground(Color.WHITE);
			coutTable.setModel(userModel);
			
			//FUNCTION FOR CENTERING VALUES IN A TABLE
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			for(int x=0;x<6;x++){
		         coutTable.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
		        }
			showTable();
			
			scrollPane.setViewportView(coutTable);
			//--------------------//
			
			
			coutDiscountLabel = new JLabel("Discount");
			coutDiscountLabel.setForeground(new Color(255, 255, 255));
			coutDiscountLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
			coutDiscountLabel.setBounds(30, 370, 110, 20);
			list.add(coutDiscountLabel);
			
			coutDiscountField = new JTextField();
			coutDiscountField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			coutDiscountField.setText("None");
			coutDiscountField.setEditable(false);
			coutDiscountField.setColumns(10);
			coutDiscountField.setBorder(null);
			coutDiscountField.setBounds(30, 400, 160, 25);
			list.add(coutDiscountField);
			
			//FUNCTION FOR DROP DOWN
			coutDiscountDrop = new JButton("\u2193");
			coutDiscountDrop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					coutDiscountPwd.show();
					coutDiscountSenior.show();
					coutDiscountNone.show();
				}
			});
			coutDiscountDrop.setHorizontalTextPosition(SwingConstants.CENTER);
			coutDiscountDrop.setIgnoreRepaint(true);
			coutDiscountDrop.setForeground(new Color(0, 128, 0));
			coutDiscountDrop.setFont(new Font("Tahoma", Font.BOLD, 17));
			coutDiscountDrop.setFocusPainted(false);
			coutDiscountDrop.setDefaultCapable(false);
			coutDiscountDrop.setBorderPainted(false);
			coutDiscountDrop.setBorder(null);
			coutDiscountDrop.setBackground(Color.WHITE);
			coutDiscountDrop.setBounds(190, 400, 20, 25);
			list.add(coutDiscountDrop);
			
			//SETTING DISCOUNT FIELD TO NONE
			coutDiscountNone = new JButton("None");
			coutDiscountNone.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					coutDiscountField.setText("None");
					coutDiscountPwd.hide();
					coutDiscountSenior.hide();
					coutDiscountNone.hide();
					
					computeTotal();
				}
			});
			coutDiscountNone.setIgnoreRepaint(true);
			coutDiscountNone.setForeground(new Color(0, 128, 0));
			coutDiscountNone.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
			coutDiscountNone.setFocusPainted(false);
			coutDiscountNone.setDefaultCapable(false);
			coutDiscountNone.setBorderPainted(false);
			coutDiscountNone.setBorder(null);
			coutDiscountNone.setBackground(Color.WHITE);
			coutDiscountNone.setBounds(30, 475, 180, 25);
			coutDiscountNone.hide();
			
			//SETTING DISCOUNT FIELD TO SENIOR
			coutDiscountSenior = new JButton("Senior (%)");
			coutDiscountSenior.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					coutDiscountField.setText("Senior");
					coutDiscountPwd.hide();
					coutDiscountSenior.hide();
					coutDiscountNone.hide();
					
					computeTotal();
				}
			});
			coutDiscountSenior.setIgnoreRepaint(true);
			coutDiscountSenior.setForeground(new Color(0, 128, 0));
			coutDiscountSenior.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
			coutDiscountSenior.setFocusPainted(false);
			coutDiscountSenior.setDefaultCapable(false);
			coutDiscountSenior.setBorderPainted(false);
			coutDiscountSenior.setBorder(null);
			coutDiscountSenior.setBackground(Color.WHITE);
			coutDiscountSenior.setBounds(30, 450, 180, 25);
			coutDiscountSenior.hide();
			
			//SETTING DISCOUNT FIELD TO PWD
			coutDiscountPwd = new JButton("PWD (%)");
			coutDiscountPwd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					coutDiscountField.setText("PWD");
					coutDiscountPwd.hide();
					coutDiscountSenior.hide();
					coutDiscountNone.hide();
					
					computeTotal();
				}
			});
			coutDiscountPwd.setIgnoreRepaint(true);
			coutDiscountPwd.setForeground(new Color(0, 128, 0));
			coutDiscountPwd.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
			coutDiscountPwd.setFocusPainted(false);
			coutDiscountPwd.setDefaultCapable(false);
			coutDiscountPwd.setBorderPainted(false);
			coutDiscountPwd.setBorder(null);
			coutDiscountPwd.setBackground(Color.WHITE);
			coutDiscountPwd.setBounds(30, 425, 180, 25);
			coutDiscountPwd.hide();
			list.add(coutDiscountPwd);
			list.add(coutDiscountSenior);
			list.add(coutDiscountNone);
			
			coutQuanLabel = new JLabel("Edit Quantity");
			coutQuanLabel.setHorizontalAlignment(SwingConstants.LEFT);
			coutQuanLabel.setForeground(Color.WHITE);
			coutQuanLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
			coutQuanLabel.setBounds(250, 370, 110, 20);
			list.add(coutQuanLabel);
			
			coutQuanField = new JTextField();
			coutQuanField.setColumns(10);
			coutQuanField.setBorder(null);
			coutQuanField.setBounds(250, 400, 175, 25);
			list.add(coutQuanField);
			
			//APPLYING NEW QUANTITY TO THE CART DATABASE
			coutQuanApply = new JButton("Apply");
			coutQuanApply.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int row = coutTable.getSelectedRow();
					String updateQ = coutTable.getModel().getValueAt(row, 0).toString();
					String quanS = coutQuanField.getText();
					int idNo = Integer.parseInt(updateQ);
					int quanN = Integer.parseInt(quanS);
					
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						                                Connection con = DriverManager.getConnection("jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_5cc5f084e523d86?user=b0084868bdbc27&password=ba102649");
						
						String update = " UPDATE cart SET quantity = " + quanN + " WHERE idno="+ idNo +" ;";
						PreparedStatement preparedStmt = con.prepareStatement(update);
						
						preparedStmt.executeUpdate();
						showTable();
						con.close();
						
						computeTotal();
						
					} catch (ClassNotFoundException | SQLException e1) {
						
						e1.printStackTrace();
					}
				}
			});
			coutQuanApply.setIgnoreRepaint(true);
			coutQuanApply.setForeground(new Color(0, 128, 0));
			coutQuanApply.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
			coutQuanApply.setFocusPainted(false);
			coutQuanApply.setDefaultCapable(false);
			coutQuanApply.setBorderPainted(false);
			coutQuanApply.setBorder(null);
			coutQuanApply.setBackground(Color.WHITE);
			coutQuanApply.setBounds(250, 450, 110, 36);
			list.add(coutQuanApply);
			
			//REMOVING A ITEM IN THE CART DATABASE
			coutRemove = new JButton("Remove");
			coutRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int row = coutTable.getSelectedRow();
					String delS = coutTable.getModel().getValueAt(row, 0).toString();
					int delNo = Integer.parseInt(delS);
					
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						                                Connection con = DriverManager.getConnection("jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_5cc5f084e523d86?user=b0084868bdbc27&password=ba102649");
						
						String delete1 = " DELETE FROM cart WHERE idno="+ delNo +" ;";
						
						PreparedStatement preparedStmt = con.prepareStatement(delete1);
						
						preparedStmt.execute();
						showTable();
						con.close();
						
						computeTotal();
						
					} catch (ClassNotFoundException | SQLException e1) {
						
						e1.printStackTrace();
					}
				}
			});
			
			coutTotalLabel = new JLabel("Total");
			coutTotalLabel.setHorizontalAlignment(SwingConstants.LEFT);
			coutTotalLabel.setForeground(Color.WHITE);
			coutTotalLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
			coutTotalLabel.setBounds(680, 370, 110, 33);
			list.add(coutTotalLabel);
			
			coutTotaldLabel = new JLabel("Total");
			coutTotaldLabel.setHorizontalAlignment(SwingConstants.LEFT);
			coutTotaldLabel.setForeground(Color.WHITE);
			coutTotaldLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 25));
			coutTotaldLabel.setBounds(680, 400, 230, 60);
			list.add(coutTotaldLabel);
			coutRemove.setIgnoreRepaint(true);
			coutRemove.setForeground(new Color(0, 128, 0));
			coutRemove.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
			coutRemove.setFocusPainted(false);
			coutRemove.setDefaultCapable(false);
			coutRemove.setBorderPainted(false);
			coutRemove.setBorder(null);
			coutRemove.setBackground(Color.WHITE);
			coutRemove.setBounds(680, 460, 110, 40);
			list.add(coutRemove);
			
			//CHECK OUT FUNCTION
			coutCheckout = new JButton("Check Out");
			coutCheckout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						                                Connection con = DriverManager.getConnection("jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_5cc5f084e523d86?user=b0084868bdbc27&password=ba102649");
						
						String fiTotal = coutTotaldLabel.getText();
						String disc = coutDiscountField.getText();
						File file = new File("receipt.txt");
						br = new  BufferedReader(new FileReader("user.txt"));
						String cashierName = br.readLine();
						
						if(!file.exists())
							file.createNewFile();
						
						
						PrintWriter pw = new PrintWriter(file);
						pw.println("*************************");
						pw.println("iPharmacy Drug Store");
						pw.println("*************************");
						pw.println("\nOfficial Receipt\n");
						pw.println("Contact Number : (LAGAY NYO NALANG HEHE =)");
						pw.println("Location : (LAGAY NYO NALANG OLETS)");
						pw.println("Cashier : " + cashierName);
						pw.println("*************************");
						pw.println("\nProducts");
						Statement stm = con.createStatement();
						
						int i = 1;
						String log = "SELECT * FROM log";
						ResultSet logrs = stm.executeQuery(log);
						while(logrs.next()){
							i = i + 1;
						}
						
						String logS = "";
						String sql = "SELECT * FROM cart";
						ResultSet rs = stm.executeQuery(sql);
						String update = " UPDATE inventory SET stock = ? WHERE idno = ? ;";
						PreparedStatement preparedStmt = con.prepareStatement(update);
						String empty = " DELETE FROM cart WHERE idno = ?;";
						PreparedStatement preparedStmt1 = con.prepareStatement(empty);
						
						
						while(rs.next()) {
							String prodName = rs.getString("prodName");
							int idNo = rs.getInt("idno");
							int quan = rs.getInt("quantity");
							int stockN = rs.getInt("stock");
							double price = rs.getDouble("price");
							double total = price * quan;
							int upStock = stockN - quan; 
							String prodB = quan + " x " + prodName + ", ";
							logS = logS.concat(prodB);
							
							pw.printf("%-20s %-5d x %.2f = %.2f\n", prodName, quan, price, total);
				
							preparedStmt.setInt(1, upStock);
							preparedStmt.setInt(2, idNo);
							preparedStmt1.setInt(1, idNo);
							
							
							preparedStmt.executeUpdate();
							preparedStmt1.execute();
						}
						
						pw.println("*************************\n");
						String tTotal = "Total :";
						String tDisc = "Discount :";
						pw.printf("%-20s %s \n", tTotal, fiTotal);
						pw.printf("%-20s %s \n", tDisc, disc);
						
						DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
						Date date = new Date();
						String dateS = dateFormat.format(date);
						double dTotal = Double.parseDouble(fiTotal);
								
						String insertLog = " INSERT INTO log VALUES (?, ?, ?, ?, ?)";
						PreparedStatement logStatement = con.prepareStatement(insertLog);
						logStatement.setInt(1, i);
						logStatement.setString (2, cashierName);
						logStatement.setString (3, logS);
						logStatement.setDouble (4, dTotal);
						logStatement.setString (5, dateS);
						logStatement.execute();
				
						
						
						confirm confirmPage = new confirm();
						confirmPage.show();
						
						showTable();
						con.close();
						pw.close();
						
					} catch (ClassNotFoundException | SQLException e1) {
						
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			coutCheckout.setIgnoreRepaint(true);
			coutCheckout.setForeground(new Color(0, 128, 0));
			coutCheckout.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
			coutCheckout.setFocusPainted(false);
			coutCheckout.setDefaultCapable(false);
			coutCheckout.setBorderPainted(false);
			coutCheckout.setBorder(null);
			coutCheckout.setBackground(Color.WHITE);
			coutCheckout.setBounds(800, 460, 110, 40);
			list.add(coutCheckout);
			
			computeTotal();
			//-------------------------------//
			
	}
}
