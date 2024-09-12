package controller.log;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.staff.staff_table;
import service.impl.staff_service_impl;
import util.calfile;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField staffnumber;
	private JPasswordField password;
	private staff_service_impl ssi = new staff_service_impl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setTitle("POS系統登入畫面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 242, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		ImageIcon icon=new ImageIcon(getClass().getResource("/banner.png"));
		/*
		if(icon.getIconWidth() == -1)
		{
			System.out.println("失敗");
		}
		else
		{
			System.out.println("成功");
		}
		*/
		Image img= icon.getImage();
		Image newImg=img.getScaledInstance(400, 200, Image.SCALE_SMOOTH);
		icon=new ImageIcon(newImg);
		
		JLabel banner = new JLabel("");
		banner.setBounds(10, 10, 470, 160);
		banner.setIcon(icon);
		banner.setHorizontalAlignment(SwingConstants.CENTER);
		banner.setVerticalAlignment(SwingConstants.CENTER);
		contentPane.add(banner);
		
		JLabel lblNewLabel = new JLabel("Staff ID :");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		lblNewLabel.setBounds(65, 220, 120, 60);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 244, 172));
		panel.setBounds(8, 191, 470, 5);
		contentPane.add(panel);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		lblPassword.setBounds(65, 290, 120, 60);
		contentPane.add(lblPassword);
		
		staffnumber = new JTextField();
		staffnumber.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		staffnumber.setBounds(185, 225, 210, 50);
		contentPane.add(staffnumber);
		staffnumber.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(185, 300, 210, 50);
		contentPane.add(password);
		
		///////////////////    button    /////////////////////////////////
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Staffnumber=staffnumber.getText();
				String Password = password.getText();
				
				staff_table s = ssi.login(Staffnumber, Password);
				System.out.println(s);
				if(s != null)
				{
					calfile.savefile(s, "Atrs.txt");
					checkinUI frame = new checkinUI();
					frame.setVisible(true);
					//calfile.savefile(s, "LoginName.txt");
					dispose();
				}
				else
				{
					error frame = new error();
					frame.setVisible(true);
				}
						
			}
		});
		btnLogin.setBackground(new Color(223, 223, 223));
		btnLogin.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		btnLogin.setBounds(296, 387, 162, 50);
		contentPane.add(btnLogin);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(new Color(223, 223, 223));
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnExit.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		btnExit.setBounds(27, 389, 162, 50);
		contentPane.add(btnExit);
	}
}
