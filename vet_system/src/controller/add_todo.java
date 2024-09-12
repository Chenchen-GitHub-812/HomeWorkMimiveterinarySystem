package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class add_todo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField content;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_todo frame = new add_todo();
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
	public add_todo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 291);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 244, 255));
		panel.setBounds(0, 0, 800, 266);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("日期：");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel.setBounds(20, 20, 60, 40);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("時間：");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1.setBounds(250, 20, 60, 40);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("建立人：");
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(20, 75, 80, 40);
		panel.add(lblNewLabel_1_1);
		
		JLabel date = new JLabel("DATE");
		date.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		date.setBounds(80, 20, 150, 40);
		panel.add(date);
		
		JLabel time = new JLabel("time");
		time.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		time.setBounds(310, 20, 150, 40);
		panel.add(time);
		
		JLabel staffnumber = new JLabel("staffnumber");
		staffnumber.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		staffnumber.setBounds(100, 75, 120, 40);
		panel.add(staffnumber);
		
		JLabel staffname = new JLabel("staffnumber");
		staffname.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		staffname.setBounds(230, 75, 120, 40);
		panel.add(staffname);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("交接內容：");
		lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(20, 130, 100, 40);
		panel.add(lblNewLabel_1_1_1);
		
		content = new JTextField();
		content.setBounds(120, 130, 500, 40);
		panel.add(content);
		content.setColumns(10);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("完成人：");
		lblNewLabel_1_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1_2.setBounds(23, 199, 80, 40);
		panel.add(lblNewLabel_1_1_2);
		
		JLabel staffnumber_1 = new JLabel("staffnumber");
		staffnumber_1.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		staffnumber_1.setBounds(103, 199, 120, 40);
		panel.add(staffnumber_1);
		
		JLabel staffname_1 = new JLabel("staffnumber");
		staffname_1.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		staffname_1.setBounds(233, 199, 120, 40);
		panel.add(staffname_1);
		
		JButton btnNewButton = new JButton("送出");
		btnNewButton.setBackground(new Color(255, 255, 234));
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton.setBounds(650, 130, 85, 40);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("對象：");
		lblNewLabel_1_1_3.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1_3.setBounds(360, 75, 60, 40);
		panel.add(lblNewLabel_1_1_3);
		
		String[] items = {"行政", "醫療", "美容"};
		JComboBox transferto = new JComboBox(items);
		transferto.setBackground(new Color(255, 255, 234));
		transferto.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		transferto.setBounds(425, 80, 100, 30);
		panel.add(transferto);
		
	
	}
}
