package controller.todo;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.to_do;
import model.staff.staff_table;
import service.impl.todo_service_impl;
import util.Listener_Manager;

import util.calfile;
import util.catchtime;
import javax.swing.JTextArea;

public class finishtodo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private todo_service_impl tdsi = new todo_service_impl();
	private to_do td= new to_do();
	private Listener_Manager listenerManger = Listener_Manager.getInstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					finishtodo frame = new finishtodo();
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
	public finishtodo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 686,450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 244, 255));
		panel.setBounds(0, 0, 680, 450);
		contentPane.add(panel);
		panel.setLayout(null);
		
		////////LabelnoUse/////////////////////////////////////
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
		lblNewLabel_1_1.setBounds(150, 75, 80, 40);
		panel.add(lblNewLabel_1_1);
		
		
		
		JLabel lblNewLabel_1_1_1 = new JLabel("交接內容：");
		lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(20, 130, 100, 40);
		panel.add(lblNewLabel_1_1_1);
		
		
		
		JLabel lblNewLabel_1_1_3 = new JLabel("對象：");
		lblNewLabel_1_1_3.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1_3.setBounds(380, 75, 60, 40);
		panel.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("建立人：");
		lblNewLabel_1_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1_2.setBounds(20, 350, 80, 40);
		panel.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("編號：");
		lblNewLabel_1_1_3_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1_3_1.setBounds(25, 75, 60, 40);
		panel.add(lblNewLabel_1_1_3_1);
		
		
		////////Label/////////////////////////////////////
		
		JLabel date = new JLabel("DATE");
		date.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		date.setBounds(80, 20, 150, 40);
		catchtime ct=new catchtime();
		ct.catchdate(date);
		panel.add(date);
		
		JLabel time = new JLabel("time");
		time.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		time.setBounds(310, 20, 150, 40);
		ct.catchtime(time);
		panel.add(time);
		
		JLabel staffnumber = new JLabel("staffnumber");
		staffnumber.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		staffnumber.setBounds(230, 75, 120, 40);
		panel.add(staffnumber);
	
		
		JLabel transferto = new JLabel("who");
		transferto.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		transferto.setBounds(450, 75, 60, 40);
		panel.add(transferto);
		
		JTextArea content = new JTextArea();
		content.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		content.setBounds(25, 168, 596, 155);
		panel.add(content);
		
		
		JLabel finishedstaffnumber = new JLabel("staffnumber");
		finishedstaffnumber.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		finishedstaffnumber.setBounds(105, 350, 120, 40);
		panel.add(finishedstaffnumber);
		staff_table st = (staff_table) calfile.readfile("Atrs.txt");				
		finishedstaffnumber.setText(st.getStaffnumber());

		JLabel number = new JLabel("number");
		number.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		number.setBounds(82, 75, 60, 40);
		panel.add(number);
		
		
		List<to_do> todoList = (List<to_do>) calfile.readfile("todoItem.txt");
		
		if(todoList != null)
		{
		to_do td=todoList.get(0);
		number.setText(td.getNumber().toString());;
		date.setText(td.getAddDate());	
		time.setText(td.getAddTime());
		staffnumber.setText(td.getAddStaffNumber());
		transferto.setText(td.getTransferTo());
		content.setText(td.getContent());
		
				
		}
		else
		{
			System.out.println("Can not find file");
		}
		
		JButton finish = new JButton("完成");
		finish.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int Number=Integer.parseInt(number.getText());
				staff_table st = (staff_table) calfile.readfile("Atrs.txt");
				String Finishedstaffnumber = finishedstaffnumber.getText();
				td.setFinishedStaffNumber(Finishedstaffnumber);
				tdsi.update(Number, Finishedstaffnumber);
				listenerManger.getInstance().notifyListeners(td);
				
				dispose();
				
			}
		});
		

		finish.setBackground(new Color(255, 255, 234));
		finish.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		finish.setBounds(412, 350, 85, 40);
		panel.add(finish);
		
		JButton exit = new JButton("刪除");
		exit.setForeground(new Color(85, 85, 85));
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer Number = Integer.parseInt(number.getText());
				tdsi.delete(Number);
				listenerManger.getInstance().notifyListeners(td);
				dispose();
			}
		});
		exit.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		exit.setBackground(new Color(192, 192, 192));
		exit.setBounds(532, 350, 85, 40);
		panel.add(exit);
		
		
	}
}
