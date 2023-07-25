package iPharmacyDrugStore;

import java.awt.EventQueue;
import java.util.jar.Attributes.Name;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;


import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Icon;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class login {

	//------------------------//
	//DECLARING COMPONENTS//
	private static JFrame frame;
	private JLabel iconlabel;
	private JLabel backg;
	private JLabel whitebg;
	private JLabel welcome;
	private JLabel sign;
	private JTextField userField;
	private JLabel userIcon;
	private JLabel userBorder;
	private JLabel passIcon;
	private JLabel passBorder;
	private JPasswordField passField;
	private JButton signButton;
	private JPanel popPanel;
	private JLabel popBg;
	private JButton closePop;
	private JLabel popLabel1;
	private JLabel popLabel2;
	//------------------------//
	
	
	
	//---------------------//
	//DECLARATION ON IMAGE//
	private ImageIcon icons;
	private ImageIcon bg;
	private ImageIcon usIcon;
	private ImageIcon psIcon;
	//---------------------//
	
	
	
	//---------------------//
	//DECLARATION ON VARIABLES//
	int i = 0, j = 0;
	//---------------------//
	
	
	//---------------------//
	//MAIN FUNCTION TO SHOW FRAME//
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//---------------------//
	
	
	//---------------------//
	//FUNCTION TO SHOW FRAME//
	public static void runMain() {
		frame.show();
	}
	//---------------------//
	
	
	//---------------------//
	//INITIALIZE LOG IN//
	public login() {
		initialize();
	}
	//---------------------//

	
	//---------------------//
	//CONTENTS OF LOGIN//
	private void initialize() {
	
		
		//SETTINGS FOR JFRAME//
		frame = new JFrame();
		frame.setBounds(100, 100, 670, 490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		//INITIALIZE IMAGE
		icons = new ImageIcon(this.getClass().getResource("/icon.png"));
		usIcon = new ImageIcon(this.getClass().getResource("/user.png"));
		bg = new ImageIcon(this.getClass().getResource("/bg.png"));
		psIcon = new ImageIcon(this.getClass().getResource("/psIcon.png"));
		
		
		
		//---------------------------------------//
		//POP UP IF USERNAME OR PASSWORD IS WRONG//
		popPanel = new JPanel();
		popPanel.hide();
		popPanel.setBounds(144, 160, 380, 187);
		frame.getContentPane().add(popPanel);
		popPanel.setLayout(null);
		
		popLabel2 = new JLabel("Please Try Again");
		popLabel2.setHorizontalTextPosition(SwingConstants.CENTER);
		popLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		popLabel2.setForeground(Color.WHITE);
		popLabel2.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		popLabel2.setBounds(0, 67, 380, 36);
		popPanel.add(popLabel2);
		
		popLabel1 = new JLabel("Wrong Username or Password");
		popLabel1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		popLabel1.setForeground(Color.WHITE);
		popLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
		popLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		popLabel1.setBounds(0, 37, 380, 36);
		popPanel.add(popLabel1);
		
		closePop = new JButton("Close");
		closePop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				popPanel.hide();
			}
		});
		closePop.setIgnoreRepaint(true);
		closePop.setForeground(new Color(60, 179, 113));
		closePop.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		closePop.setFocusPainted(false);
		closePop.setDefaultCapable(false);
		closePop.setBorderPainted(false);
		closePop.setBorder(null);
		closePop.setBackground(Color.WHITE);
		closePop.setBounds(134, 114, 110, 36);
		popPanel.add(closePop);
		
		popBg = new JLabel("");
		popBg.setBackground(new Color(60, 179, 113));
		popBg.setOpaque(true);
		popBg.setBounds(0, 0, 380, 187);
		popPanel.add(popBg);
		//---------------------------------------//		
		

		
		//---------------------------------------//
		//CODE FOR THE DESIGN OF LOG IN PAGE//
		sign = new JLabel("Sign In To Your Account");
		sign.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		sign.setHorizontalAlignment(SwingConstants.CENTER);
		sign.setHorizontalTextPosition(SwingConstants.CENTER);
		sign.setBounds(252, 206, 168, 24);
		frame.getContentPane().add(sign);
		
		
		iconlabel = new JLabel(icons);
		iconlabel.requestFocusInWindow();
		iconlabel.setBorder(null);
		iconlabel.setBackground(Color.decode("#FEFEFC"));
		iconlabel.setBounds(289, 64, 90, 90);
		frame.getContentPane().add(iconlabel);
		
		userIcon = new JLabel(usIcon);
		userIcon.setBounds(186, 246, 36, 36);
		frame.getContentPane().add(userIcon);
		
		userField = new JTextField("Username");
		userField.setOpaque(false);
		userField.setBorder(null);
		userField.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		
		//FUNCTION TO EMPTY USERNAME FIELD
		userField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				i++;
				if(i==1) {
					userField.setText("");
				}
			}
		});
		
		userField.setBackground(Color.decode("#FEFEFC"));
		userField.setBounds(232, 246, 250, 36);
		
		frame.getContentPane().add(userField);
		userField.setColumns(10);
		
		userBorder = new JLabel("");
		userBorder.setEnabled(false);
		userBorder.setFocusable(false);
		userBorder.setFocusTraversalKeysEnabled(false);
		userBorder.setBorder(new LineBorder(new Color(60, 179, 113)));
		userBorder.setBounds(186, 246, 296, 36);
		frame.getContentPane().add(userBorder);
		
	
		passIcon = new JLabel(psIcon);
		passIcon.setBounds(186, 311, 36, 36);
		frame.getContentPane().add(passIcon);
		
		passField = new JPasswordField();
		
		//FUNCTION TO EMPTY PASSWORD FIELD
		passField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				passField.setText("");
			}
		});
		
		passField.setBorder(null);
		passField.setText("Password");
		passField.setOpaque(false);
		passField.setBounds(232, 311, 250, 36);
		frame.getContentPane().add(passField);
		
		passBorder = new JLabel("");
		passBorder.setFocusable(false);
		passBorder.setFocusTraversalKeysEnabled(false);
		passBorder.setEnabled(false);
		passBorder.setBorder(new LineBorder(new Color(60, 179, 113)));
		passBorder.setBounds(186, 311, 296, 36);
		frame.getContentPane().add(passBorder);
		
		signButton = new JButton("Log In");
		signButton.setForeground(Color.WHITE);
		
		
		
		//---------------------------------------//
		//FUNCTION TO LOG IN OR DENY//
		signButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					                                Connection con = DriverManager.getConnection("jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_5cc5f084e523d86?user=b0084868bdbc27&password=ba102649");

					
					File file = new File("user.txt");
					
					if(!file.exists())
						file.createNewFile();
					PrintWriter pw = new PrintWriter(file);
					
					String us = userField.getText();
					String ps = passField.getText();
					
					Statement stm = con.createStatement();
					String sql = "SELECT * FROM users";
					ResultSet rs = stm.executeQuery(sql);
					
					while(rs.next()) {
						String roles = rs.getString("role");
						String username = rs.getString("username");
						String pass = rs.getString("password");
						String fname = rs.getString("fname");
						String lname = rs.getString("lname");
	
						if(roles.equals("admin")) {
							if(ps.equals(pass) && us.equals(username)){
								frame.dispose();
								adHome adminPage = new adHome();
								adminPage.show();
								pw.print(fname + " " + lname);
								pw.close();
								break;
							}
							
						}
						
						else if(roles.equals("user")) {
							if(ps.equals(pass) && us.equals(username)){
								frame.dispose();
								cposApp userpage = new cposApp();
								userpage.show();
								pw.print(fname + " " + lname);
								break;
							}
							
							//FUNCTION IF USERNAME AND PASSWORD IS WRONG
							
								
							
						}
						
					}
					popPanel.show();	
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		//---------------------------------------//
		
		
		signButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		signButton.setBorder(null);
		signButton.setBorderPainted(false);
		signButton.setDefaultCapable(false);
		signButton.setFocusPainted(false);
		signButton.setIgnoreRepaint(true);
		signButton.setBackground(new Color(60, 179, 113));
		signButton.setBounds(278, 375, 110, 36);
		frame.getContentPane().add(signButton);
		
		welcome = new JLabel("Welcome To PharmaEasy!");
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		welcome.setBounds(210, 160, 250, 42);
		frame.getContentPane().add(welcome);
		
		whitebg = new JLabel("");
		whitebg.setOpaque(true);
		whitebg.setBackground(Color.decode("#FEFEFC"));
		whitebg.setBounds(144, 45, 380, 400);
		frame.getContentPane().add(whitebg);
		backg = new JLabel(bg);
		backg.setBorder(null);
		backg.setBounds(0, 0, 670, 490);
		frame.getContentPane().add(backg);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
	}
}
