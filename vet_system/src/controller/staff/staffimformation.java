package controller.staff;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.staff.staff_table;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import service.impl.staff_service_impl;

public class staffimformation extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField sex;
	private JTextField idnumber;
	private JTextField birthday;
	private JTextField address;
	private JTextField email;
	private JTextField phone;
	private JTextField emerygency_contact_name;
	private JTextField emerygency_contact_phone;
	private JTextField emerygency_contact_relationship;
	private JTextField end_date;
	private JTextField start_date;
	private JTextField staffnumber;
	private JTextField password;
	private staff_service_impl ssi=new staff_service_impl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					staffimformation frame = new staffimformation();
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
	public staffimformation() {
		setTitle("員工資訊");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("＊姓名：");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 90, 90, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("＊性別：");
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(270, 90, 80, 40);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("＊身份證字號：");
		lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(460, 90, 130, 40);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("＊出生年月日：");
		lblNewLabel_1_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1_1_1.setBounds(800, 90, 150, 40);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("＊地址：");
		lblNewLabel_1_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1_2.setBounds(10, 160, 90, 40);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel banner = new JLabel("員工基本資料");
		banner.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		banner.setBounds(10, 10, 200, 40);
		contentPane.add(banner);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(0, 0, 1200, 750);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 174));
		panel_1.setBounds(10, 60, 1160, 5);
		panel.add(panel_1);
		
		name = new JTextField();
		name.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		name.setBounds(90, 90, 150, 40);
		panel.add(name);
		name.setColumns(10);
		
		sex = new JTextField();
		sex.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		sex.setColumns(10);
		sex.setBounds(350, 90, 70, 40);
		panel.add(sex);
		
		idnumber = new JTextField();
		idnumber.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		idnumber.setColumns(10);
		idnumber.setBounds(600, 90, 150, 40);
		panel.add(idnumber);
		
		birthday = new JTextField();
		birthday.setText("yyyy/MM/dd");
		birthday.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(birthday.getText().equals("yyyy/MM/dd"))
				{
					birthday.setText("");
				}
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				if(birthday.getText().isEmpty())
				{
					birthday.setText("yyyy/MM/dd");
				}
			}
		});
		birthday.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		birthday.setColumns(10);
		birthday.setBounds(930, 90, 180, 40);
		panel.add(birthday);
		
		address = new JTextField();
		address.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		address.setColumns(10);
		address.setBounds(90, 160, 400, 40);
		panel.add(address);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("＊E-mail：");
		lblNewLabel_1_1_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1_2_1.setBounds(770, 160, 120, 40);
		panel.add(lblNewLabel_1_1_2_1);
		
		email = new JTextField();
		email.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		email.setColumns(10);
		email.setBounds(870, 160, 250, 40);
		panel.add(email);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("＊電話：");
		lblNewLabel_1_1_3.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1_3.setBounds(520, 160, 80, 40);
		panel.add(lblNewLabel_1_1_3);
		
		phone = new JTextField();
		phone.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		phone.setColumns(10);
		phone.setBounds(600, 160, 150, 40);
		panel.add(phone);
		
		JLabel lblNewLabel_1_1_2_2 = new JLabel("＊緊急聯絡人：");
		lblNewLabel_1_1_2_2.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1_2_2.setBounds(10, 230, 150, 40);
		panel.add(lblNewLabel_1_1_2_2);
		
		emerygency_contact_name = new JTextField();
		emerygency_contact_name.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		emerygency_contact_name.setColumns(10);
		emerygency_contact_name.setBounds(150, 230, 150, 40);
		panel.add(emerygency_contact_name);
		
		JLabel lblNewLabel_1_1_2_2_1 = new JLabel("＊緊急聯絡電話：");
		lblNewLabel_1_1_2_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1_2_2_1.setBounds(333, 230, 150, 40);
		panel.add(lblNewLabel_1_1_2_2_1);
		
		emerygency_contact_phone = new JTextField();
		emerygency_contact_phone.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		emerygency_contact_phone.setColumns(10);
		emerygency_contact_phone.setBounds(500, 230, 150, 40);
		panel.add(emerygency_contact_phone);
		
		JLabel lblNewLabel_1_1_2_2_1_1 = new JLabel("＊緊急聯絡人關係：");
		lblNewLabel_1_1_2_2_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1_2_2_1_1.setBounds(700, 230, 180, 40);
		panel.add(lblNewLabel_1_1_2_2_1_1);
		
		emerygency_contact_relationship = new JTextField();
		emerygency_contact_relationship.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		emerygency_contact_relationship.setColumns(10);
		emerygency_contact_relationship.setBounds(880, 230, 150, 40);
		panel.add(emerygency_contact_relationship);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(255, 255, 174));
		panel_1_1.setBounds(10, 340, 1160, 5);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_1_1_2_2_2 = new JLabel("＊到職日：");
		lblNewLabel_1_1_2_2_2.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1_2_2_2.setBounds(10, 380, 100, 40);
		panel.add(lblNewLabel_1_1_2_2_2);
		
		JLabel lblNewLabel_1_1_2_2_2_1 = new JLabel("離職日：");
		lblNewLabel_1_1_2_2_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1_2_2_2_1.setBounds(300, 380, 100, 40);
		panel.add(lblNewLabel_1_1_2_2_2_1);
		
		end_date = new JTextField();
		end_date.setText("yyyy/MM/dd");
		end_date.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(end_date.getText().equals("yyyy/MM/dd"))
				{
					end_date.setText("");
				}
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				if(end_date.getText().isEmpty())
				{
					end_date.setText("yyyy/MM/dd");
				}
			}
		});
		end_date.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		end_date.setColumns(10);
		end_date.setBounds(380, 380, 150, 40);
		panel.add(end_date);
		
		start_date = new JTextField();
		start_date.setText("yyyy/MM/dd");
		start_date.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(start_date.getText().equals("yyyy/MM/dd"))
				{
					start_date.setText("");
				}
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				if(start_date.getText().isEmpty())
				{
					start_date.setText("yyyy/MM/dd");
				}
			}
		});
		start_date.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		start_date.setColumns(10);
		start_date.setBounds(110, 380, 150, 40);
		panel.add(start_date);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("＊員工編號：");
		lblNewLabel_1_1_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1_1_2.setBounds(570, 380, 130, 40);
		panel.add(lblNewLabel_1_1_1_2);
		
		staffnumber = new JTextField();
		staffnumber.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		staffnumber.setColumns(10);
		staffnumber.setBounds(690, 380, 150, 40);
		panel.add(staffnumber);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("＊員工密碼：");
		lblNewLabel_1_1_1_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1_1_2_1.setBounds(870, 380, 130, 40);
		panel.add(lblNewLabel_1_1_1_2_1);
		
		password = new JTextField();
		password.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		password.setColumns(10);
		password.setBounds(990, 380, 150, 40);
		panel.add(password);
		
		JButton add = new JButton("送出");
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				staff_table st = new staff_table();
				st.setName(name.getText());
				st.setSex(sex.getText());
				st.setIdnumber(idnumber.getText());
				st.setBirthday(birthday.getText());
				st.setAddress(address.getText());
				st.setPhone(phone.getText());
				st.setEmail(email.getText());
				st.setEmergency_contact_name(emerygency_contact_name.getText());
				st.setEmergency_contact_phone(emerygency_contact_phone.getText());
				st.setEmergency_contact_relationship(emerygency_contact_relationship.getText());
				st.setStart_date(start_date.getText());
				st.setStaffnumber(staffnumber.getText());
				st.setStaffpassword(password.getText());
				ssi.addstaff(st);
				
				name.setText("");
				sex.setText("");
				idnumber.setText("");
				birthday.setText("");
				address.setText("");
				phone.setText("");
				email.setText("");
				emerygency_contact_name.setText("");
				emerygency_contact_phone.setText("");
				emerygency_contact_relationship.setText("");
				start_date.setText("");
				staffnumber.setText("");
				password.setText("");
			}
		});
		add.setBackground(new Color(227, 227, 227));
		add.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		add.setBounds(970, 480, 170, 50);
		panel.add(add);
		
		JButton modify = new JButton("變更資料");
		modify.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		modify.setBackground(new Color(227, 227, 227));
		modify.setBounds(669, 480, 170, 50);
		panel.add(modify);
	}
}
