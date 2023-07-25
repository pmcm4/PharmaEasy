package iPharmacyDrugStore;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class cconfirm extends JFrame {

	private JPanel contentPane;
	private JLabel cClose;
	private JLabel cLabel2;
	private JLabel cLabel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cconfirm frame = new cconfirm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public cconfirm() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cLabel = new JLabel("Order Confirmed");
		cLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		cLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cLabel.setForeground(Color.WHITE);
		cLabel.setFont(new Font("Candara", Font.BOLD, 27));
		cLabel.setBounds(0, 110, 480, 50);
		contentPane.add(cLabel);
		
		cLabel2 = new JLabel("Thank you for shopping in us. We hope to see you again");
		cLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		cLabel2.setForeground(Color.WHITE);
		cLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cLabel2.setAlignmentX(0.5f);
		cLabel2.setBounds(0, 154, 480, 30);
		contentPane.add(cLabel2);
		
		cClose = new JLabel("X");
		cClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				cposApp posPage = new cposApp();
				ccheckout checkoutPage = new ccheckout();
				checkoutPage.hide();
				posPage.show();
			}
		});
		cClose.setHorizontalTextPosition(SwingConstants.CENTER);
		cClose.setHorizontalAlignment(SwingConstants.CENTER);
		cClose.setForeground(Color.WHITE);
		cClose.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		cClose.setBounds(448, 0, 32, 34);
		contentPane.add(cClose);
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
}
