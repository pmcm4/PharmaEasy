package iPharmacyDrugStore;

import com.toedter.calendar.JDateChooser;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class invApp extends JFrame {


		//---------------------//
		//DECLARING COMPONENTS
		private login mainForm;
		private JPanel contentPane;
		private JPanel topPanel;
		private JLabel close; 
		private JLabel title; 
		private JLabel header;
		private JPanel sideNav;
		private JLabel logout;
		private JLabel home;
		private JLabel inv;
		private JLabel user;
		private JLabel pos;
		private JLabel log;
		private JLabel side;
		private JPanel list;
		private JLabel invLabel;
		private JLabel invDes;
		private JLabel lhBg;
		private JLabel lhID;
		private JLabel lhProdName;
		private JLabel lhCat;
		private JLabel lhStock;
		private JLabel lhPrice;
                private JLabel lhExpi;
                private JLabel lhWeight;
		private DefaultTableModel userModel;
		private JTable invTable;
		private JScrollPane scrollPane;
		private JButton addProd;
		private JButton delProd;
		private JButton updateProd;
		private JPanel info;
		private JLabel pinfoLabel;
		private JLabel pnoLabel;
		private JTextField pnoField;
                private JLabel weightLabel;
		private JTextField weightField;
		private JLabel pnameLabel;
                private JLabel proNo;
		private JTextField pnameField;
		private JLabel pcatLabel;
		private JTextField pcatField;
		private JLabel pstockLabel;
		private JTextField pstockField;
		private JLabel ppriceLabel;
		private JTextField ppriceField;
		private JButton addProdDB;
		private JButton updateProdDB;
                private JLabel eexpiLabel;
                private JDateChooser eexpiDate;
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
		//MAIN FUNCTION TO SET FRAME VISIBLE//
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						invApp frame = new invApp();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		//---------------------//
		
		
		//---------------------//
		//FUNCTION TO SHOW INVENTORY TABLE//
		public void showTable() {
			try {
				
				userModel.setRowCount(0);
				Class.forName("com.mysql.cj.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_5cc5f084e523d86?user=b0084868bdbc27&password=ba102649");
				
				Statement stm = con.createStatement();
				String sql = "SELECT * FROM inventory";
				ResultSet rs = stm.executeQuery(sql);
				
				while(rs.next()) {
					String[] data = {rs.getString("idno"), rs.getString("prodName"), rs.getString("category"), rs.getString("stock"), rs.getString("price"), rs.getString("weight"), rs.getString("expi")};
					userModel.addRow(data);
				}
				
			} catch (ClassNotFoundException | SQLException e1) {
				
				e1.printStackTrace();
			}
			
			invTable.getColumnModel().getColumn(0).setPreferredWidth(0);
		}
		//---------------------//

		private Date parseDate(String dateStr) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        return dateFormat.parse(dateStr);
                    } catch (ParseException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
		
		//---------------------//
		//CONTENTS OF INVENTORY APP//
		public invApp(){
			
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
			contentPane.setLayout(null);
			
			//THIS IS WHERE PICS/ICON ARE DECLARED
			homePic = new ImageIcon(this.getClass().getResource("/home30.png"));
			inv30Pic = new ImageIcon(this.getClass().getResource("/inv30.png"));
			user30Pic = new ImageIcon(this.getClass().getResource("/user30.png"));
			pos30Pic = new ImageIcon(this.getClass().getResource("/pos30.png"));
			log30Pic = new ImageIcon(this.getClass().getResource("/log30.png"));
			logoutPic = new ImageIcon(this.getClass().getResource("/logout.png"));
			
		
			//-----------------------------//
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
			
			
			class CenterRenderer extends DefaultTableCellRenderer {
                            public CenterRenderer() {
                                setHorizontalAlignment(SwingConstants.CENTER);
                            }
                        }
			//-------------------------------//
			//TABLE FOR SHOWING INVENTORY DATABASE 
			list = new JPanel();
			list.setBackground(Color.WHITE);
			list.setBounds(75, 35, 735, 615);
			contentPane.add(list);
			list.setLayout(null);
			
			invLabel = new JLabel("Item Inventory");
			invLabel.setBounds(30, 30, 370, 55);
			list.add(invLabel);
			invLabel.setForeground(new Color(25, 125, 75));
			invLabel.setFont(new Font("Candara", Font.BOLD, 40));
			
			invDes = new JLabel("Showing all the products and their info.\r\n");
			invDes.setBounds(30, 80, 360, 24);
			list.add(invDes);
			invDes.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
			
			lhID = new JLabel("ID No.");
			lhID.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
			lhID.setForeground(Color.WHITE);
			lhID.setHorizontalAlignment(SwingConstants.LEFT);
			lhID.setBounds(45, 113, 62, 33);
			list.add(lhID);
			
			lhProdName = new JLabel("Product Name");
			lhProdName.setHorizontalAlignment(SwingConstants.LEFT);
			lhProdName.setForeground(Color.WHITE);
			lhProdName.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
			lhProdName.setBounds(118, 113, 121, 33);
			list.add(lhProdName);
			
			lhCat = new JLabel("Category");
			lhCat.setHorizontalAlignment(SwingConstants.LEFT);
			lhCat.setForeground(Color.WHITE);
			lhCat.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
			lhCat.setBounds(260, 113, 121, 33);
			list.add(lhCat);
			
			lhStock = new JLabel("Stock");
			lhStock.setHorizontalAlignment(SwingConstants.LEFT);
			lhStock.setForeground(Color.WHITE);
			lhStock.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
			lhStock.setBounds(370, 113, 121, 33);
			list.add(lhStock);
			
			lhPrice = new JLabel("Price");
			lhPrice.setHorizontalAlignment(SwingConstants.LEFT);
			lhPrice.setForeground(Color.WHITE);
			lhPrice.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
			lhPrice.setBounds(435, 113, 121, 33);
			list.add(lhPrice);
                        
                        lhWeight = new JLabel("Weight");
			lhWeight.setHorizontalAlignment(SwingConstants.LEFT);
			lhWeight.setForeground(Color.WHITE);
			lhWeight.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
			lhWeight.setBounds(505, 113, 121, 33);
			list.add(lhWeight);
                        
                        lhExpi = new JLabel("Expiration Date");
                        lhExpi.setHorizontalAlignment(SwingConstants.LEFT);
			lhExpi.setForeground(Color.WHITE);
			lhExpi.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
			lhExpi.setBounds(580, 113, 121, 33);
			list.add(lhExpi);
			
			lhBg = new JLabel("");
			lhBg.setBackground(Color.decode("#197D4B"));
			lhBg.setOpaque(true);
			lhBg.setBounds(30, 113, 674, 33);
			list.add(lhBg);
			
			scrollPane = new JScrollPane();
			scrollPane.setBorder(null);
			scrollPane.setBackground(Color.ORANGE);
			scrollPane.setBounds(30, 125, 675, 400);
			list.add(scrollPane);
                        
                        
			
			invTable = new JTable();
                        
			invTable.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			invTable.setRowHeight(25);
			invTable.setBorder(null);
                        
			userModel = new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"ID No", "Product Name", "Category", "Stock", "Price", "Weight", "Expiration"
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
                        
			
			invTable.setSelectionBackground(new Color(102, 205, 170));
			invTable.setGridColor(Color.decode("#197D4B"));
			invTable.setBackground(Color.WHITE);
			invTable.setModel(userModel);
                        TableColumnModel columnModel = invTable.getColumnModel();
                        columnModel.getColumn(3).setPreferredWidth(20);
                        columnModel.getColumn(4).setPreferredWidth(20);
                        columnModel.getColumn(5).setPreferredWidth(20);
                        
                        DefaultTableCellRenderer centerRenderer = new CenterRenderer();
                        for (int i = 0; i < invTable.getColumnCount(); i++) {
                            invTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                        }

			scrollPane.setViewportView(invTable);
                        
			
			
			//FUNCTION TO SET PRODUCT ID NO TO INFO PRODUCT FIELD
			addProd = new JButton("Add Product");
			addProd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			addProd.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					int i = 1;
					pinfoLabel.setText("Register");
					addProdDB.show();
					updateProdDB.hide();
					info.show();
					

					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_5cc5f084e523d86?user=b0084868bdbc27&password=ba102649");
						
						Statement stm = con.createStatement();
						String sql = "SELECT * FROM inventory";
						ResultSet rs = stm.executeQuery(sql);
						
						while(rs.next()) {
							i = i + 1;
						}
						
						String text = Integer.toString(i);
						pnoField.setText(text);
						
					} catch (ClassNotFoundException | SQLException e1) {
						
						e1.printStackTrace();
					}
				}
			});
			addProd.setIgnoreRepaint(true);
			addProd.setForeground(Color.WHITE);
			addProd.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
			addProd.setFocusPainted(false);
			addProd.setDefaultCapable(false);
			addProd.setBorderPainted(false);
			addProd.setBorder(null);
			addProd.setBackground(new Color(60, 179, 113));
			addProd.setBounds(30, 547, 110, 36);
			list.add(addProd);
                            
			
			//FUNCTION TO SET INFORMATIONS TO INFO PRODUCT FIELDS
			updateProd = new JButton("Update");
			updateProd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			updateProd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addProdDB.hide();
					info.show();
					pinfoLabel.setText("Update");
					updateProdDB.show();
                                        
                                        
					proNo = new JLabel();
					int row = invTable.getSelectedRow();
					String idno = invTable.getModel().getValueAt(row, 0).toString();
					String pName = invTable.getModel().getValueAt(row, 1).toString();
					String cat = invTable.getModel().getValueAt(row, 2).toString();
					String stocks = invTable.getModel().getValueAt(row, 3).toString();
					String price = invTable.getModel().getValueAt(row, 4).toString();
                                        String weight = invTable.getModel().getValueAt(row, 5).toString();
					String expiryDate = invTable.getModel().getValueAt(row, 6).toString(); 

					pnoField.setText(idno);
					pnameField.setText(pName);
					pcatField.setText(cat);
					pstockField.setText(stocks);
                                        ppriceField.setText(price);
					weightField.setText(weight);
                                        eexpiDate.setDate(parseDate(expiryDate)); 
					
				}
			});
			updateProd.setIgnoreRepaint(true);
			updateProd.setForeground(Color.WHITE);
			updateProd.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
			updateProd.setFocusPainted(false);
			updateProd.setDefaultCapable(false);
			updateProd.setBorderPainted(false);
			updateProd.setBorder(null);
			updateProd.setBackground(new Color(60, 179, 113));
			updateProd.setBounds(150, 547, 110, 36);
			list.add(updateProd);
			
			
			//FUNCTION TO DELETE IN DATABASE
			delProd = new JButton("Delete");
			delProd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			delProd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int column1 = 0;
					int j=1, x = 0,z;
					int row = invTable.getSelectedRow();
					String delS = invTable.getModel().getValueAt(row, column1).toString();
					int delNo = Integer.parseInt(delS);
					
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						                                Connection con = DriverManager.getConnection("jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_5cc5f084e523d86?user=b0084868bdbc27&password=ba102649");
						
						String delete1 = " DELETE FROM inventory WHERE idno="+ delNo +" ;";
						
						PreparedStatement preparedStmt = con.prepareStatement(delete1);
						
						preparedStmt.execute();
						
						Statement stm = con.createStatement();
						String sql = "SELECT * FROM inventory";
						ResultSet rs = stm.executeQuery(sql);
						
						String upNo = "UPDATE inventory SET idno = ? WHERE idno = ?;";
						PreparedStatement statement1 = con.prepareStatement(upNo);
						
						while(rs.next()) {
							j++;
						}
						
						for(x=0;x<=j;x++) {
							z = x - 1;
							statement1.setInt(1, z);
							statement1.setInt(2, x);
							if(x > row) {
								statement1.executeUpdate();
							}
							
						}
						
						showTable();
						
						con.close();
						
					} catch (ClassNotFoundException | SQLException e1) {
						
						e1.printStackTrace();
					}
				}
			});
			delProd.setIgnoreRepaint(true);
			delProd.setForeground(Color.WHITE);
			delProd.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
			delProd.setFocusPainted(false);
			delProd.setDefaultCapable(false);
			delProd.setBorderPainted(false);
			delProd.setBorder(null);
			delProd.setBackground(new Color(60, 179, 113));
			delProd.setBounds(270, 547, 110, 36);
			list.add(delProd);
			
			
			
			//FORM WHEN ADDING AND UPDATING INVENTORY DATABASE
			info = new JPanel();
			info.hide();
			info.setBackground(Color.decode("#74c69d"));
			info.setBounds(810, 35, 255, 615);
			contentPane.add(info);
			info.setLayout(null);

			pinfoLabel = new JLabel("Information");
			pinfoLabel.setForeground(Color.WHITE);
			pinfoLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 26));
			pinfoLabel.setBounds(30, 30, 175, 39);
			info.add(pinfoLabel);
			
                        
                       
			pnoLabel = new JLabel("Product Number");
			pnoLabel.setForeground(Color.WHITE);
			pnoLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
			pnoLabel.setBounds(30, 80, 190, 14);
			info.add(pnoLabel);
			
			pnoField = new JTextField();
			pnoField.setBorder(null);
			pnoField.setColumns(10);
			pnoField.setBounds(30, 105, 175, 25);
			info.add(pnoField);
			
			pnameLabel = new JLabel("Product Name");
			pnameLabel.setForeground(Color.WHITE);
			pnameLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
			pnameLabel.setBounds(30, 135, 175, 25);
			info.add(pnameLabel);
			
			pnameField = new JTextField();
			pnameField.setBorder(null);
			pnameField.setColumns(10);
			pnameField.setBounds(30, 160, 175, 25);
			info.add(pnameField);
			
			pcatLabel = new JLabel("Category");
			pcatLabel.setForeground(Color.WHITE);
			pcatLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
			pcatLabel.setBounds(30, 185, 80, 25);
			info.add(pcatLabel);
			
			pcatField = new JTextField();
			pcatField.setColumns(10);
			pcatField.setBorder(null);
			pcatField.setBounds(30, 215, 175, 25);
			info.add(pcatField);
			
			pstockLabel = new JLabel("Stock\r\n");
			pstockLabel.setForeground(Color.WHITE);
			pstockLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
			pstockLabel.setBounds(30, 240, 80, 25);
			info.add(pstockLabel);
			
			pstockField = new JTextField();
			pstockField.setColumns(10);
			pstockField.setBorder(null);
			pstockField.setBounds(30, 270, 175, 25);
			info.add(pstockField);
			
			ppriceLabel = new JLabel("Price");
			ppriceLabel.setForeground(Color.WHITE);
			ppriceLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
			ppriceLabel.setBounds(30, 295, 80, 25);
			info.add(ppriceLabel);
			
			ppriceField = new JTextField();
			ppriceField.setColumns(10);
			ppriceField.setBorder(null);
			ppriceField.setBounds(30, 325, 175, 25);
			info.add(ppriceField);
                        
                        weightLabel = new JLabel("Weight");
			weightLabel.setForeground(Color.WHITE);
			weightLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
			weightLabel.setBounds(30, 350, 80, 25);
			info.add(weightLabel);
                        
                        weightField = new JTextField();
			weightField.setColumns(10);
			weightField.setBorder(null);
			weightField.setBounds(30, 380, 175, 25);
			info.add(weightField);
                        
                        
                        
                        
                        eexpiLabel = new JLabel("Expiry Date");
			eexpiLabel.setForeground(Color.WHITE);
			eexpiLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
			eexpiLabel.setBounds(30, 405, 175, 25);
			info.add(eexpiLabel);
			
			eexpiDate = new JDateChooser();
			eexpiDate.setBounds(30, 435, 175, 25);
			info.add(eexpiDate);
			
                        
			
			//ADDING A PRODUCT IN DATABASE
			addProdDB = new JButton("Add Product");
			addProdDB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			addProdDB.hide();
			addProdDB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
                                    
                                    
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						                                Connection con = DriverManager.getConnection("jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_5cc5f084e523d86?user=b0084868bdbc27&password=ba102649");
						
						String insert1 = " INSERT INTO inventory VALUES (?, ?, ?, ?, ?, ?, ?)";
						
						String proNo = pnoField.getText(),
						pnameS = pnameField.getText(),
						catS = pcatField.getText(),
						stock = pstockField.getText(),
						price = ppriceField.getText();
                                                String weight = weightField.getText();
                                                Date expirationDate = eexpiDate.getDate();
                                                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String expiDate = dateFormat.format(expirationDate);

						int pNo = Integer.parseInt(proNo), sNo = Integer.parseInt(stock);
						double prNo = Double.parseDouble(price);
                                                
						
						PreparedStatement preparedStmt = con.prepareStatement(insert1);
						preparedStmt.setInt(1, pNo);
						preparedStmt.setString (2, pnameS);
						preparedStmt.setString (3, catS);
						preparedStmt.setInt (4, sNo);
						preparedStmt.setDouble(5, prNo);
                                                preparedStmt.setString(6, expiDate);
                                                preparedStmt.setString(7, weight);
						preparedStmt.execute();
						
						
						showTable();
						info.hide();
						con.close();
						
					} catch (ClassNotFoundException | SQLException e1) {
						
						e1.printStackTrace();
					}
				}
			});
			addProdDB.setIgnoreRepaint(true);
			addProdDB.setForeground(new Color(60, 179, 113));
			addProdDB.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
			addProdDB.setFocusPainted(false);
			addProdDB.setDefaultCapable(false);
			addProdDB.setBorderPainted(false);
			addProdDB.setBorder(null);
			addProdDB.setBackground(Color.WHITE);
			addProdDB.setBounds(30, 485, 110, 36);
			info.add(addProdDB);
			
			
			//UPDATING A PRODUCT IN DATABASE
			updateProdDB = new JButton("Update");
			updateProdDB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			updateProdDB.hide();
			updateProdDB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {					
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_5cc5f084e523d86?user=b0084868bdbc27&password=ba102649");
						
						String 
						idnoS = pnoField.getText(),
						pnameS = pnameField.getText(),
						catS = pcatField.getText(),
						stockS = pstockField.getText(),
						priceS = ppriceField.getText(),
                                                weightS = weightField.getText();
                                                Date expirationDate = eexpiDate.getDate();
                                                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String expiDate = dateFormat.format(expirationDate);
						
						int stockN = Integer.parseInt(stockS), idnoN = Integer.parseInt(idnoS);
						double priceN = Double.parseDouble(priceS);
						
						
                                                String upNo = "UPDATE inventory SET prodname = '" + pnameS + "', category = '" + catS + "',  stock = " + stockN + ", price =" + priceN + ", expi = '"+ expiDate + "', weight = '"+ weightS + "' WHERE idno = " + idnoN + ";";
						PreparedStatement statement1 = con.prepareStatement(upNo);
						statement1.executeUpdate();
						
						showTable();
						info.hide();
						con.close();
						
					} catch (ClassNotFoundException | SQLException e1) {
						
						e1.printStackTrace();
					}
				}
			});
			updateProdDB.setIgnoreRepaint(true);
			updateProdDB.setForeground(new Color(60, 179, 113));
			updateProdDB.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
			updateProdDB.setFocusPainted(false);
			updateProdDB.setDefaultCapable(false);
			updateProdDB.setBorderPainted(false);
			updateProdDB.setBorder(null);
			updateProdDB.setBackground(Color.WHITE);
			updateProdDB.setBounds(95, 540, 110, 36);
			info.add(updateProdDB);
			showTable();
			//-------------------------------//
	
                }
                
}
