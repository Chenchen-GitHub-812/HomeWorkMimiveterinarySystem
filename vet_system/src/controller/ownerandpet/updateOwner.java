package controller.ownerandpet;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import javax.swing.text.Caret;
import javax.swing.text.DefaultCaret;

import model.ownerandpet.owner;
import model.ownerandpet.pet;
import service.impl.owner_service_impl;
import util.Listener_Manager;
import util.calfile;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class updateOwner extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ownerName;
	private JTextField ownerPhone;
	private JTextField ownerAddress;
	private owner_service_impl osi = new owner_service_impl();
	private pet p;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateOwner frame = new updateOwner();
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
	public updateOwner() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 904, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(237, 245, 245));
		panel.setBounds(0, 0, 890, 413);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("修改飼主資料");
		lblNewLabel_2.setForeground(new Color(83, 83, 83));
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		lblNewLabel_2.setBorder(new MatteBorder(0, 0, 2, 0, new Color(82, 82, 82)));
		lblNewLabel_2.setBounds(30, 20, 860, 60);
		panel.add(lblNewLabel_2);
		
		JLabel namelabel = new JLabel("飼主姓名：");
		namelabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		namelabel.setBounds(30, 174, 100, 40);
		panel.add(namelabel);
		
		ownerName = new JTextField();
		ownerName.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		ownerName.setColumns(10);
		ownerName.setBounds(125, 174, 150, 40);
		panel.add(ownerName);
		
		JLabel namelabel_1 = new JLabel("飼主電話：");
		namelabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		namelabel_1.setBounds(305, 174, 100, 40);
		panel.add(namelabel_1);
		
		ownerPhone = new JTextField();
		ownerPhone.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		ownerPhone.setColumns(10);
		ownerPhone.setBounds(405, 174, 185, 40);
		panel.add(ownerPhone);
		
		JLabel addresslabel_2 = new JLabel("地址：");
		addresslabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		addresslabel_2.setBounds(30, 238, 100, 40);
		panel.add(addresslabel_2);
		
		ownerAddress = new JTextField();
		ownerAddress.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		ownerAddress.setColumns(10);
		ownerAddress.setBounds(85, 239, 785, 40);
		panel.add(ownerAddress);
		
		JLabel lblid = new JLabel("飼主ID：");
		lblid.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblid.setBounds(30, 109, 100, 40);
		panel.add(lblid);
		
		
		JTextPane id = new JTextPane();
		id.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		id.setBackground(new Color(232, 232, 232));
		id.setBounds(115, 109, 50, 40);
		Caret caretName = id.getCaret();
        caretName.setBlinkRate(0);  // 設置光標閃爍率為0，這樣光標就不會顯示
        id.setEditable(false);
        id.setCaret(new DefaultCaret() {
            @Override
            public void paint(Graphics g) {
                // 不繪製光標
            }
        });
		panel.add(id);
		
		String searchPhoneNumber = "";
		List<pet> listPet = (List<pet>) calfile.readfile("petInfo.txt");
		if (listPet != null)
		{
			pet p = listPet.get(0);
			searchPhoneNumber = p.getOwnerPhone();	
			System.out.println(searchPhoneNumber);
		}
		System.out.println(searchPhoneNumber);
		List<owner> listOwner = osi.searchPhone(searchPhoneNumber);
		if(listOwner != null)
		{
			owner o = listOwner.get(0);
			//int Id = Integer.parseInt(o.getId());
			id.setText(String.valueOf(o.getId()));
			ownerName.setText(o.getOwnerName());
			ownerPhone.setText(o.getOwnerPhone());
			ownerAddress.setText(o.getOwnerAddddress());
			
			
		}
		
		
		////////////////////////////////////////////////////////////////
		
		
		JButton exitbutton = new JButton("離開");
		exitbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		exitbutton.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		exitbutton.setBackground(new Color(211, 231, 223));
		exitbutton.setBounds(32, 307, 90, 50);
		panel.add(exitbutton);
		
		JButton addPetbutton = new JButton("修改");
		addPetbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 owner o = new owner();
		            o.setId(Integer.parseInt(id.getText()));  // 從表單中獲取 owner ID
		            o.setOwnerName(ownerName.getText());  // 從表單中獲取姓名
		            o.setOwnerPhone(ownerPhone.getText());  // 從表單中獲取電話號碼
		            o.setOwnerAddddress(ownerAddress.getText());  // 從表單中獲取地址
		    
		            
		     
		             // 更新資料庫中的 owner 資料
		            osi.updateOwner(o);
		            dispose();
				
			}
		});
		addPetbutton.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		addPetbutton.setBackground(new Color(211, 231, 223));
		addPetbutton.setBounds(767, 307, 90, 50);
		panel.add(addPetbutton);
	}
}
