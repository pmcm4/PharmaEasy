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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class cposApp extends JFrame {

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
		private JLabel prodLabel;
		private JLabel prodDes;
		private JLabel prodCart;
		private JLabel prodSearchLogo;
		private JTextField prodSearchField;
		private JLabel prodNo;
		private JLabel prodName;
		private JLabel prodCat;
		private JLabel prodPrice;
		private JLabel prodHeader;
		private JScrollPane scrollPane;
		private JTable prodTable;
		private DefaultTableModel userModel;
		private JButton addCart;
		private JButton checkCart;
		//---------------------//

		
		//---------------------//
		//Declaration on image
		private ImageIcon homePic;
		private ImageIcon inv30Pic;
		private ImageIcon user30Pic;
		private ImageIcon pos30Pic;
		private ImageIcon log30Pic;
		private ImageIcon logoutPic;
		private ImageIcon cart30Pic;
		private ImageIcon search25Pic;
		//--------------------//

		
		
		//--------------------//
		//MAIN FUNCTION TO SET POS APP VISIBLE
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						cposApp frame = new cposApp();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		//--------------------//
		
		
		
		//--------------------//
		//FUNCTION TO SHOW PRODUCT DATABASE//
		public void showTable() {
			try {
				
				userModel.setRowCount(0);
				Class.forName("com.mysql.cj.jdbc.Driver");
                                                                Connection con = DriverManager.getConnection("jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_5cc5f084e523d86?user=b0084868bdbc27&password=ba102649");
				
				Statement stm = con.createStatement();
				String sql = "SELECT * FROM inventory";
				ResultSet rs = stm.executeQuery(sql);
				
				while(rs.next()) {
					String[] data = {rs.getString("idno"), rs.getString("prodName"), rs.getString("category"), rs.getString("price")};
					userModel.addRow(data);
				}
				
			} catch (ClassNotFoundException | SQLException e1) {
				
				e1.printStackTrace();
			}
			
			prodTable.getColumnModel().getColumn(0).setPreferredWidth(0);
		}
		//--------------------//
		
		
		
		//--------------------//
		//FUNCTION FOR SEARCHING
		public void search(String str) {
			userModel = (DefaultTableModel) prodTable.getModel();
			TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(userModel);
			prodTable.setRowSorter(trs);
			trs.setRowFilter(RowFilter.regexFilter(str));
		}
		//--------------------//
		
		
		//--------------------//
		//CONTENTS OF POS APP
		public cposApp(){
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
			setContentPane(contentPane);
			
			
			//THIS IS WHERE PICS/ICON ARE DECLARED
			homePic = new ImageIcon(this.getClass().getResource("/home30.png"));
			inv30Pic = new ImageIcon(this.getClass().getResource("/inv30.png"));
			user30Pic = new ImageIcon(this.getClass().getResource("/user30.png"));
			pos30Pic = new ImageIcon(this.getClass().getResource("/pos30.png"));
			log30Pic = new ImageIcon(this.getClass().getResource("/log30.png"));
			logoutPic = new ImageIcon(this.getClass().getResource("/logout.png"));
			cart30Pic = new ImageIcon(this.getClass().getResource("/cart30.png"));
			search25Pic = new ImageIcon(this.getClass().getResource("/search25.png"));
			contentPane.setLayout(null);
		
			
			
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
			home.setToolTipText("This Options is for Admins Only");
			
			inv = new JLabel(inv30Pic);
			inv.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			inv.setBounds(25, 140, 30, 30);
			sideNav.add(inv);
			inv.setToolTipText("This Options is for Admins Only");
			
			user = new JLabel(user30Pic);
			user.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			user.setBounds(25, 190, 30, 30);
			sideNav.add(user);
			user.setToolTipText("This Options is for Admins Only");
			
			pos = new JLabel(pos30Pic);
			pos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			pos.setBounds(25, 240, 30, 30);
			sideNav.add(pos);
			pos.setToolTipText("POS");

			log = new JLabel(log30Pic);
			log.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			log.setToolTipText("This Options is for Admins Only");
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
			//--------------------//
			
			
			//--------------------//
			//PANEL FOR PRODUCT TABLE
			list = new JPanel();
			list.setBackground(Color.WHITE);
			list.setBounds(75, 35, 990, 615);
			contentPane.add(list);
			list.setLayout(null);
			
			prodLabel = new JLabel("Products");
			prodLabel.setBounds(30, 30, 370, 55);
			list.add(prodLabel);
			prodLabel.setForeground(new Color(25, 125, 75));
			prodLabel.setFont(new Font("Candara", Font.BOLD, 40));
			
			prodDes = new JLabel("Click the product that you want below and press add to cart.");
			prodDes.setBounds(30, 80, 399, 24);
			list.add(prodDes);
			prodDes.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
			
			prodCart = new JLabel(cart30Pic);
			prodCart.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					ccheckout cartA = new ccheckout();
					cartA.show();
				}
			});
			prodCart.setToolTipText("Check Cart");
			prodCart.setBounds(914, 30, 30, 30);
			list.add(prodCart);
			
			prodSearchLogo = new JLabel(search25Pic);
			prodSearchLogo.setToolTipText("Check Cart");
			prodSearchLogo.setBounds(555, 75, 25, 25);
			list.add(prodSearchLogo);
			
			prodSearchField = new JTextField();
			prodSearchField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					String searchS = prodSearchField.getText();
					search(searchS);
				}
			});
			prodSearchField.setSelectedTextColor(new Color(255, 255, 255));
			prodSearchField.setForeground(new Color(0, 128, 0));
			prodSearchField.setBorder(new LineBorder(new Color(46, 139, 87)));
			prodSearchField.setSelectionColor(new Color(0, 128, 0));
			prodSearchField.setBounds(590, 75, 350, 25);
			prodSearchField.setColumns(10);
			list.add(prodSearchField);
			
			prodNo = new JLabel("ID No.");
			prodNo.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
			prodNo.setForeground(Color.WHITE);
			prodNo.setHorizontalAlignment(SwingConstants.CENTER);
			prodNo.setBounds(33, 113, 180, 33);
			list.add(prodNo);
			
			prodName = new JLabel("Product Name");
			prodName.setHorizontalAlignment(SwingConstants.CENTER);
			prodName.setForeground(Color.WHITE);
			prodName.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
			prodName.setBounds(215, 113, 240, 33);
			list.add(prodName);
			
			prodCat = new JLabel("Category");
			prodCat.setHorizontalAlignment(SwingConstants.CENTER);
			prodCat.setForeground(Color.WHITE);
			prodCat.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
			prodCat.setBounds(455, 113, 245, 33);
			list.add(prodCat);
			
			prodPrice = new JLabel("Price");
			prodPrice.setHorizontalAlignment(SwingConstants.CENTER);
			prodPrice.setForeground(Color.WHITE);
			prodPrice.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
			prodPrice.setBounds(700, 113, 244, 33);
			list.add(prodPrice);
			
			prodHeader = new JLabel("");
			prodHeader.setBackground(Color.decode("#197D4B"));
			prodHeader.setOpaque(true);
			prodHeader.setBounds(30, 113, 914, 33);
			list.add(prodHeader);
			
			scrollPane = new JScrollPane();
			scrollPane.setBorder(null);
			scrollPane.setBackground(Color.ORANGE);
			scrollPane.setBounds(30, 125, 915, 400);
			list.add(scrollPane);
			
			prodTable = new JTable();
			prodTable.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			prodTable.setRowHeight(25);
			prodTable.setBorder(null);
			userModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID No", "Product Name", "Category", "Price"
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
			prodTable.setSelectionBackground(new Color(102, 205, 170));
			prodTable.setGridColor(Color.decode("#197D4B"));
			prodTable.setBackground(Color.WHITE);
			prodTable.setModel(userModel);
			
			//FUNCTION TO CENTER VALUES IN THE PRODUCT TABLE
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			for(int x=0;x<4;x++){
		         prodTable.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
		    }
			scrollPane.setViewportView(prodTable);		
			
			
			//BUTTON FOR ADDING PRODUCT TO CART
			addCart = new JButton("Add to Cart");
			addCart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			addCart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int z=0, stock = 0;
					int row = prodTable.getSelectedRow();
					String idS = prodTable.getModel().getValueAt(row, 0).toString();
					String pnameS = prodTable.getModel().getValueAt(row, 1).toString();
					String catS = prodTable.getModel().getValueAt(row, 2).toString();
					String priceS = prodTable.getModel().getValueAt(row, 3).toString();
					int idNo = Integer.parseInt(idS);
					double priceNo = Double.parseDouble(priceS);
					
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						                                Connection con = DriverManager.getConnection("jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_5cc5f084e523d86?user=b0084868bdbc27&password=ba102649");
						
						Statement gs = con.createStatement();
						String gStock =  "SELECT * FROM inventory WHERE idno =" + idNo + ";";
						ResultSet rss = gs.executeQuery(gStock);
						
						while(rss.next()) {
							stock = rss.getInt("stock");
						}
						
						String insert1 = " INSERT INTO cart VALUES (?, ?, ?, ?, ?, ?)";
						
						PreparedStatement preparedStmt = con.prepareStatement(insert1);
						preparedStmt.setInt(1, idNo);
						preparedStmt.setString (2, pnameS);
						preparedStmt.setString (3, catS);
						preparedStmt.setDouble (4, priceNo);
						preparedStmt.setInt(5,1);
						preparedStmt.setInt(6, stock);
						
						Statement stm = con.createStatement();
						String sql = "SELECT idno FROM cart";
						ResultSet rs = stm.executeQuery(sql);
						
						
						while(rs.next()) {
							int idN = rs.getInt("idno");
							if(idN == idNo) {
								z = 1;
								break;
							}
						}
						
						if(z==0) {
							preparedStmt.execute();
						}
						
					} catch (ClassNotFoundException | SQLException e1) {
						
						e1.printStackTrace();
					}
				}
			});
			addCart.setIgnoreRepaint(true);
			addCart.setForeground(Color.WHITE);
			addCart.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
			addCart.setFocusPainted(false);
			addCart.setDefaultCapable(false);
			addCart.setBorderPainted(false);
			addCart.setBorder(null);
			addCart.setBackground(new Color(60, 179, 113));
			addCart.setBounds(30, 547, 110, 36);
			list.add(addCart);
			
			
			//FUNCTION TO GO TO CART
			checkCart = new JButton("Check Cart");
			checkCart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			checkCart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					ccheckout cartA = new ccheckout();
					cartA.show();
				}
			});
			checkCart.setIgnoreRepaint(true);
			checkCart.setForeground(Color.WHITE);
			checkCart.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
			checkCart.setFocusPainted(false);
			checkCart.setDefaultCapable(false);
			checkCart.setBorderPainted(false);
			checkCart.setBorder(null);
			checkCart.setBackground(new Color(60, 179, 113));
			checkCart.setBounds(150, 547, 110, 36);
			list.add(checkCart);
			showTable();
			//-------------------------------//
			
			
	}
}
