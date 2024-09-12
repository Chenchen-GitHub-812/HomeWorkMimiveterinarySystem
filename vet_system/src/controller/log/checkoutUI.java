package controller.log;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.pos.homeUI;
import model.staff.attendancetable;
import model.staff.staff_table;
import service.impl.attendanc_service_impl;
import util.calfile;
import util.catchtime;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class checkoutUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private attendanc_service_impl asi= new attendanc_service_impl();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkoutUI frame = new checkoutUI();
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
	public checkoutUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 242, 255));
		panel.setBounds(0, 0, 450, 500);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel outputstaffnumber = new JLabel("");
		outputstaffnumber.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		outputstaffnumber.setHorizontalAlignment(SwingConstants.CENTER);
		outputstaffnumber.setVerticalAlignment(SwingConstants.CENTER);
		outputstaffnumber.setBounds(25, 30, 120, 65);
		panel.add(outputstaffnumber);
	
		JLabel outputname = new JLabel("");
		outputname.setVerticalAlignment(SwingConstants.CENTER);
		outputname.setHorizontalAlignment(SwingConstants.CENTER);
		outputname.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		outputname.setBounds(150, 30, 120, 65);
		panel.add(outputname);
		
		JLabel output_1 = new JLabel("登出成功");
		output_1.setForeground(new Color(98, 98, 98));
		output_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		output_1.setBounds(300, 30, 100, 65);
		panel.add(output_1);
		
		JLabel lblNewLabel_2 = new JLabel("日期：");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		lblNewLabel_2.setBounds(25, 120, 150, 60);
		panel.add(lblNewLabel_2);
		
		JLabel date = new JLabel("");
		date.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		date.setBounds(110, 120, 265, 60);
		panel.add(date);
		
		
		
		JLabel lblNewLabel = new JLabel("上班打卡：");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		lblNewLabel.setBounds(25, 200, 150, 60);
		panel.add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("下班打卡：");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		lblNewLabel_1.setBounds(25, 300, 150, 60);
		panel.add(lblNewLabel_1);
		

		JLabel checkintime = new JLabel("");
		checkintime.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		checkintime.setBounds(160, 200, 265, 60);
		
		panel.add(checkintime);
		
		JLabel checkouttime = new JLabel("");
		checkouttime.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		checkouttime.setBounds(160, 300, 265, 60);
		catchtime ctout=new catchtime();
		ctout.catchtime(checkouttime);
		panel.add(checkouttime);
		/*
		staff_table st = (staff_table) calfile.readfile("Atrs.txt");
		if(st != null)
		{
		outputstaffnumber.setText(st.getStaffnumber());
		outputname.setText(st.getName());
		}
		else
		{
			System.out.println("Can not find file");
		}
		*/
		attendancetable at = (attendancetable) calfile.readfile("pounchcard.txt");
		if(at != null)
		{
			outputstaffnumber.setText(at.getStaffnumber());
			outputname.setText(at.getName());
			date.setText(at.getDate());
			checkintime.setText(at.getCheck_in_time());
		}
		///////////////////////////////////////////////////////////////////////
		JButton OK = new JButton("確認");
		OK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login frame = new login();
				frame.setVisible(true);
				asi.checkout(outputstaffnumber.getText(), checkouttime.getText());
				dispose();
			}
		});
		OK.setFont(new Font("微軟正黑體", Font.BOLD, 22));
		OK.setBackground(new Color(223, 223, 223));
		OK.setBounds(162, 400, 120, 40);
		panel.add(OK);
		
		
		
		
	
	}
}
