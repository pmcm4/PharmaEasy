package iPharmacyDrugStore;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class adHome extends JFrame {

	private final login mainForm;
	
	 public adHome( login form ){
		   mainForm = form;
	 }
	
	//------------------------//
	//DECLARING COMPONENTS
	private JPanel contentPane;
	private JLabel greet;
	private JLabel close;
	private JLabel title;
	private JLabel header;
	private JLabel side;
	private JLabel adminDes;
	private JLabel invIcon;
	private JLabel boxInv;
	private JLabel invTitle;
	private JLabel invDes;
	private JLabel invDes1;
	private JLabel line1;
	private JLabel for1;
	private JPanel invPanel;
	private JPanel userPanel;
	private JLabel userIcon;
	private JLabel userTitle;
	private JLabel userDes1;
	private JLabel userDes2;
	private JLabel for2;
	private JLabel boxUser;
	private JLabel line2;
	private JPanel posPanel;
	private JLabel posIcon;
	private JLabel posTitle;
	private JLabel posDes1;
	private JLabel posDes2;
	private JLabel line3;
	private JLabel for3;
	private JLabel boxPos;
	private JLabel home;
	private JLabel inv;
	private JLabel user;
	private JLabel pos;
	private JLabel log;
	private JLabel logout;
	private JPanel sideNav;
	private JPanel topPanel;
	//------------------------//
		

	
	//---------------------//
	//Declaration on image
	private ImageIcon invPic;
	private ImageIcon userPic;
	private ImageIcon posPic;
	private ImageIcon homePic;
	private ImageIcon inv30Pic;
	private ImageIcon user30Pic;
	private ImageIcon pos30Pic;
	private ImageIcon logoutPic;
	private ImageIcon log30Pic;
	//--------------------//
		
		
	//---------------------//
	//MAIN FUNCTION TO SET FRAME VISIBLE//
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adHome frame = new adHome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//---------------------//
	
	
	//---------------------//
	//CONTENTS OF ADHOME FRAME//
	public adHome() {
		
		this.mainForm = new login();
		
		//FRAME 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1065, 650);
		setUndecorated(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 100, 0)));
		setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		//THIS IS WHERE PICS/ICON ARE DECLARED
		invPic = new ImageIcon(this.getClass().getResource("/inv.png"));
		userPic = new ImageIcon(this.getClass().getResource("/user1.png"));
		posPic = new ImageIcon(this.getClass().getResource("/cashier.png"));
		homePic = new ImageIcon(this.getClass().getResource("/home30.png"));
		inv30Pic = new ImageIcon(this.getClass().getResource("/inv30.png"));
		user30Pic = new ImageIcon(this.getClass().getResource("/user30.png"));
		pos30Pic = new ImageIcon(this.getClass().getResource("/pos30.png"));
		log30Pic = new ImageIcon(this.getClass().getResource("/log30.png"));
		logoutPic = new ImageIcon(this.getClass().getResource("/logout.png"));
		//-------------------------------//
		
		
		
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
		//-------------------------------//
		
		
		
		//-------------------------------//
		//INVENTORY PANEL//
		invPanel = new JPanel();
		invPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				invApp invA = new invApp();
				invA.show();
			}
		});
		invPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		invPanel.setBounds(140, 240, 280, 310);
		contentPane.add(invPanel);
		invPanel.setLayout(null);
		invIcon = new JLabel(invPic);
		invIcon.setBounds(25, 25, 70, 70);
		invPanel.add(invIcon);
		
		invTitle = new JLabel("Inventory");
		invTitle.setBounds(35, 106, 102, 34);
		invPanel.add(invTitle);
		invTitle.setForeground(new Color(255, 255, 255));
		invTitle.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 19));
		
		invDes = new JLabel("Go to the Inventory App.");
		invDes.setBounds(35, 147, 212, 34);
		invPanel.add(invDes);
		invDes.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		invDes.setForeground(new Color(255, 255, 255));
		
		invDes1 = new JLabel("Let you manage the inventory");
		invDes1.setBounds(35, 172, 212, 34);
		invPanel.add(invDes1);
		invDes1.setForeground(Color.WHITE);
		invDes1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		
		line1 = new JLabel("___________________________________");
		line1.setBounds(35, 222, 212, 14);
		invPanel.add(line1);
		line1.setForeground(new Color(255, 255, 255));
		
		for1 = new JLabel("Only for Managers");
		for1.setBounds(35, 242, 212, 34);
		invPanel.add(for1);
		for1.setForeground(Color.WHITE);
		for1.setFont(new Font("Yu Gothic Medium", Font.ITALIC, 14));
		
		boxInv = new JLabel("");
		boxInv.setBounds(0, 0, 280, 310);
		invPanel.add(boxInv);
		boxInv.setBackground(new Color(60, 179, 113));
		boxInv.setOpaque(true);
		//-------------------------------//
		
		
		
		//-------------------------------//
		//USER PANEL//
		userPanel = new JPanel();
		userPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		userPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				userApp userA = new userApp();
				userA.show();
			}
		});
		userPanel.setLayout(null);
		userPanel.setBounds(430, 240, 280, 310);
		contentPane.add(userPanel);
		
		
		userIcon = new JLabel(userPic);
		userIcon.setBounds(20, 25, 70, 70);
		userPanel.add(userIcon);
		
		userTitle = new JLabel("Users");
		userTitle.setForeground(Color.WHITE);
		userTitle.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 19));
		userTitle.setBounds(35, 106, 102, 34);
		userPanel.add(userTitle);
		
		userDes1 = new JLabel("Go to the Users App.");
		userDes1.setForeground(Color.WHITE);
		userDes1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		userDes1.setBounds(35, 147, 212, 34);
		userPanel.add(userDes1);
		
		userDes2 = new JLabel("Manage the all users in app");
		userDes2.setForeground(Color.WHITE);
		userDes2.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		userDes2.setBounds(35, 172, 212, 34);
		userPanel.add(userDes2);
		
		line2 = new JLabel("___________________________________");
		line2.setForeground(Color.WHITE);
		line2.setBounds(35, 222, 212, 14);
		userPanel.add(line2);
		
		for2 = new JLabel("Only for Managers");
		for2.setForeground(Color.WHITE);
		for2.setFont(new Font("Yu Gothic Medium", Font.ITALIC, 14));
		for2.setBounds(35, 242, 212, 34);
		userPanel.add(for2);
		
		boxUser = new JLabel("");
		boxUser.setOpaque(true);
		boxUser.setBackground(new Color(60, 179, 113));
		boxUser.setBounds(0, 0, 280, 310);
		userPanel.add(boxUser);
		//-------------------------------//
		
		
		
		
		//-------------------------------//
		//POSPANEL//
		posPanel = new JPanel();
		posPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				posApp posA = new posApp();
				posA.show();
			}
		});
		posPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		posPanel.setLayout(null);
		posPanel.setBounds(720, 240, 280, 310);
		contentPane.add(posPanel);
		
		posIcon = new JLabel(posPic);
		posIcon.setBounds(20, 25, 70, 70);
		posPanel.add(posIcon);
		
		posTitle = new JLabel("Point of Sale");
		posTitle.setForeground(Color.WHITE);
		posTitle.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 19));
		posTitle.setBounds(35, 106, 130, 34);
		posPanel.add(posTitle);
		
		posDes1 = new JLabel("Go to the POS App.");
		posDes1.setForeground(Color.WHITE);
		posDes1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		posDes1.setBounds(35, 147, 212, 34);
		posPanel.add(posDes1);
		
		posDes2 = new JLabel("Track all the sales\r\n");
		posDes2.setForeground(Color.WHITE);
		posDes2.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		posDes2.setBounds(35, 172, 212, 34);
		posPanel.add(posDes2);
		
		line3 = new JLabel("___________________________________");
		line3.setForeground(Color.WHITE);
		line3.setBounds(35, 222, 212, 14);
		posPanel.add(line3);
		
		for3 = new JLabel("For Managers and Users\r\n");
		for3.setForeground(Color.WHITE);
		for3.setFont(new Font("Yu Gothic Medium", Font.ITALIC, 14));
		for3.setBounds(35, 242, 212, 34);
		posPanel.add(for3);
		
		boxPos = new JLabel("");
		boxPos.setOpaque(true);
		boxPos.setBackground(new Color(60, 179, 113));
		boxPos.setBounds(0, 0, 280, 310);
		posPanel.add(boxPos);
		//-------------------------------//
		
		
		//GREETINGS LABEL// 
		greet = new JLabel("Welcome, Manager!");
		greet.setFont(new Font("Candara", Font.BOLD, 40));
		greet.setBounds(140, 120, 370, 55);
		greet.setForeground(Color.decode("#197D4B"));
		contentPane.add(greet);
		
		adminDes = new JLabel("Showing all the options for the Manager.\r\n");
		adminDes.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		adminDes.setBounds(145, 175, 286, 24);
		contentPane.add(adminDes);
		//-------------------------------//
	}
}
