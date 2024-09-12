package controller.ownerandpet;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Caret;
import javax.swing.text.DefaultCaret;

import daO.IdGenerator_dao_impl;
import model.IdGenerator;
import model.ownerandpet.pet;
import service.impl.pet_service_impl;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import util.Listener_Manager;
import util.calculateAge;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class addOwnerAndPet extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ownerphone;
	private JTextField petname;
	private JTextField variety;
	private JTextField textField;
	private calculateAge ca=new calculateAge();
	private JTextField color;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField drugallergycontent;
	private JTextField notecontent;
	private JTextField ownername;
	private JTextField owneraddress;
	private pet_service_impl psi = new pet_service_impl();
	private String selectedOption;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addOwnerAndPet frame = new addOwnerAndPet();
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
	public addOwnerAndPet() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(244, 249, 248));
		panel.setBounds(0, 0, 900, 650);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("新增飼主及寵物資料");
		lblNewLabel_2.setForeground(new Color(83, 83, 83));
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		lblNewLabel_2.setBorder(new MatteBorder(0, 0, 2, 0, new Color(82, 82, 82)));
		lblNewLabel_2.setBounds(10, 15, 860, 60);
		panel.add(lblNewLabel_2);
		
		JLabel namelabel = new JLabel("飼主姓名：");
		namelabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		namelabel.setBounds(25, 100, 100, 40);
		panel.add(namelabel);
      
		
		JLabel namelabel_1 = new JLabel("飼主電話：");
		namelabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		namelabel_1.setBounds(300, 100, 100, 40);
		panel.add(namelabel_1);
		
		JLabel addresslabel_2 = new JLabel("地址：");
		addresslabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		addresslabel_2.setBounds(25, 165, 100, 40);
		panel.add(addresslabel_2);
		
		
		ownerphone = new JTextField();
		ownerphone.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		ownerphone.setBounds(400, 100, 185, 40);
		panel.add(ownerphone);
		ownerphone.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(211, 231, 223));
		panel_1.setBounds(15, 230, 860, 5);
		panel.add(panel_1);
		
		JLabel petnamelabel = new JLabel("寵物名：");
		petnamelabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		petnamelabel.setBounds(25, 260, 100, 40);
		panel.add(petnamelabel);
		
		petname = new JTextField();
		petname.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		petname.setBounds(110, 260, 200, 40);
		panel.add(petname);
		petname.setColumns(10);
		
		JLabel specieslabel = new JLabel("物種：");
		specieslabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		specieslabel.setBounds(335, 260, 80, 40);
		panel.add(specieslabel);
		
		String[] itemsSpecies = {"犬", "貓"};
		JComboBox species = new JComboBox(itemsSpecies);
		species.setBackground(new Color(211, 231, 223));
		species.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		species.setBounds(400, 260, 60, 40);
		panel.add(species);
		
		JLabel varietylabel = new JLabel("品種：");
		varietylabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		varietylabel.setBounds(500, 260, 80, 40);
		panel.add(varietylabel);
		
		variety = new JTextField();
		variety.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		variety.setColumns(10);
		variety.setBounds(560, 260, 200, 40);
		panel.add(variety);
		
		JLabel sexlabel = new JLabel("性別：");
		sexlabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		sexlabel.setBounds(25, 325, 80, 40);
		panel.add(sexlabel);
		
		String[] itemSex = {"公", "母"};
		JComboBox sex = new JComboBox(itemSex);
		sex.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		sex.setBackground(new Color(211, 231, 223));
		sex.setBounds(90, 325, 60, 40);
		panel.add(sex);
		
		JLabel birthdaylabel = new JLabel("生日：");
		birthdaylabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		birthdaylabel.setBounds(185, 325, 80, 40);
		panel.add(birthdaylabel);
		

		JTextField birthday = new JTextField();
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
		birthday.setBounds(250, 325, 180, 40);
		panel.add(birthday);
		
		JLabel agelabel = new JLabel("年齡：");
		agelabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		agelabel.setBounds(460, 325, 80, 40);
		panel.add(agelabel);
		
		JTextPane age = new JTextPane();
		age.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		age.setEditable(false);
		age.setBackground(new Color(232, 232, 232));
		age.setBounds(525, 325, 50, 40);
		panel.add(age);
		
		JLabel sterilizationlabel = new JLabel("是否結紮：");
		sterilizationlabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		sterilizationlabel.setBounds(600, 325, 120, 40);
		panel.add(sterilizationlabel);
		
		String[] itemsSterilization = {"是","否"};
		JComboBox sterilization = new JComboBox(itemsSterilization);
		sterilization.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		sterilization.setBackground(new Color(211, 231, 223));
		sterilization.setBounds(700, 325, 60, 40);
		panel.add(sterilization);
		
		JLabel colorlabel = new JLabel("花色：");
		colorlabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		colorlabel.setBounds(25, 400, 80, 40);
		panel.add(colorlabel);
		
		color = new JTextField();
		color.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		color.setColumns(10);
		color.setBounds(85, 400, 120, 40);
		panel.add(color);
		
		JLabel feedinglabel = new JLabel("餵藥方式：");
		feedinglabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		feedinglabel.setBounds(240, 400, 120, 40);
		panel.add(feedinglabel);
		
		String[] itemsFeeding = {"藥粉","藥丸","藥水"};
		JComboBox feeding = new JComboBox(itemsFeeding);
		feeding.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		feeding.setBackground(new Color(211, 231, 223));
		feeding.setBounds(350, 400, 90, 40);
		panel.add(feeding);
		
		JLabel drugallergylabel_1 = new JLabel("是否對藥物過敏：");
		drugallergylabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		drugallergylabel_1.setBounds(460, 400, 150, 40);
		panel.add(drugallergylabel_1);
		
		JRadioButton no = new JRadioButton("否");
		buttonGroup.add(no);
		no.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		no.setOpaque(false);
		no.setBounds(615, 400, 60, 40);
		panel.add(no);
		
		JRadioButton yes = new JRadioButton("是");
		buttonGroup.add(yes);
		yes.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		yes.setOpaque(false);
		yes.setBounds(670, 400, 60, 40);
		panel.add(yes);
		
		
		
		drugallergycontent = new JTextField();
		drugallergycontent.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		drugallergycontent.setColumns(10);
		drugallergycontent.setBounds(725, 400, 145, 40);
		panel.add(drugallergycontent);
		
		JLabel note = new JLabel("寵物注意事項：");
		note.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		note.setBounds(25, 470, 150, 40);
		panel.add(note);
		
		notecontent = new JTextField();
		notecontent.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		notecontent.setColumns(10);
		notecontent.setBounds(164, 470, 708, 40);
		panel.add(notecontent);
		
		
		
		ownername = new JTextField();
		ownername.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		ownername.setColumns(10);
		ownername.setBounds(120, 100, 150, 40);
		panel.add(ownername);
		
		owneraddress = new JTextField();
		owneraddress.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		owneraddress.setColumns(10);
		owneraddress.setBounds(80, 165, 785, 40);
		panel.add(owneraddress);
		
		
		
		 birthday.getDocument().addDocumentListener(new DocumentListener() {
	            @Override
	            public void insertUpdate(DocumentEvent e) {
	            	ca.calculateforAge(birthday,age);
	            }

	            @Override
	            public void removeUpdate(DocumentEvent e) {
	            	ca.calculateforAge(birthday,age);
	            }

	            @Override
	            public void changedUpdate(DocumentEvent e) {
	            	ca.calculateforAge(birthday,age);
	            }
		 
		 });
		
		 ///////////////////button///////////////////////////////////////////////////
			JButton addPetbutton = new JButton("新增");
			addPetbutton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					selectedOption = "";
					if(yes.isSelected()) {
						selectedOption = "是";
					}
					else if(no.isSelected()) {
						selectedOption="否";
					}
					
					List<pet> listPet = new ArrayList();
					int Age = Integer.parseInt(age.getText());
					
					pet p = new pet();
					p.setOwnerName(ownername.getText());
					p.setOwnerPhone(ownerphone.getText());
					p.setOwnerAddress(owneraddress.getText());
					p.setPetName(petname.getText());
					p.setSpecies((String)species.getSelectedItem());
					p.setVariety(variety.getText());
					p.setSex((String)sex.getSelectedItem());
					p.setBirthday(birthday.getText());
					p.setAge(Age);
					p.setSterilization((String)sterilization.getSelectedItem());
					p.setColor(color.getText());
					p.setFeeding((String)feeding.getSelectedItem());
					p.setDrugAllergy(selectedOption);
					System.out.println("Line 354 : " + selectedOption);
					p.setDrugAllergyContent(drugallergycontent.getText());
					p.setNoteContent(notecontent.getText());
					
					psi.addPet(p);
					Listener_Manager.getInstance().notifyListeners(p);
					
					JTextField[] pettextfile = {ownername, ownerphone, owneraddress, petname, variety, birthday, color, drugallergycontent, notecontent};
					for(int i=0; i<pettextfile.length; i++)
					{
						pettextfile[i].setText("");
					}
					//dispose();
				}
			});
			addPetbutton.setBackground(new Color(211, 231, 223));
			addPetbutton.setFont(new Font("微軟正黑體", Font.BOLD, 18));
			addPetbutton.setBounds(760, 545, 90, 50);
			panel.add(addPetbutton);
			
			JButton exitbutton = new JButton("離開");
			exitbutton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
				}
			});
			
			exitbutton.setBackground(new Color(211, 231, 223));
			exitbutton.setFont(new Font("微軟正黑體", Font.BOLD, 18));
			exitbutton.setBounds(25, 545, 90, 50);
			panel.add(exitbutton);
			
			/*
			JLabel petId = new JLabel("petId");
			petId.setFont(new Font("微軟正黑體", Font.BOLD, 25));
			petId.setBounds(750, 20, 100, 40);
			panel.add(petId);
			
			IdGenerator_dao_impl idi= new IdGenerator_dao_impl();
			idi.loadCurrentMaxId("pet");
			IdGenerator ig = new IdGenerator();
			String petID = ig.generateNewId("p");
			petId.setText(petID);
			*/
		 
	}
}//結束{號，不可以不見
