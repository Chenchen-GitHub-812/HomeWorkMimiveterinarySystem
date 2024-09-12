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
public class addPet extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ownerPhone;
	private JTextField petname;
	private JTextField variety;
	private JTextField textField;
	private calculateAge ca=new calculateAge();
	private JTextField color;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField drugallergycontent;
	private JTextField noteContent;
	private pet_service_impl psi= new pet_service_impl();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addPet frame = new addPet();
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
	public addPet() {
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
		
		JLabel lblNewLabel_2 = new JLabel("新增寵物資料");
		lblNewLabel_2.setForeground(new Color(83, 83, 83));
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		lblNewLabel_2.setBorder(new MatteBorder(0, 0, 2, 0, new Color(82, 82, 82)));
		lblNewLabel_2.setBounds(10, 15, 860, 60);
		panel.add(lblNewLabel_2);
		
		JLabel namelabel = new JLabel("飼主姓名：");
		namelabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		namelabel.setBounds(25, 100, 100, 40);
		panel.add(namelabel);
		
		JTextPane ownerName = new JTextPane();
		ownerName.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		ownerName.setBackground(new Color(232, 232, 232));
		ownerName.setBounds(120, 100, 160, 40);
		Caret caretName = ownerName.getCaret();
        caretName.setBlinkRate(0);  // 設置光標閃爍率為0，這樣光標就不會顯示
        ownerName.setEditable(false);
        ownerName.setCaret(new DefaultCaret() {
            @Override
            public void paint(Graphics g) {
                // 不繪製光標
            }
        });
		panel.add(ownerName);
		
		JLabel namelabel_1 = new JLabel("飼主電話：");
		namelabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		namelabel_1.setBounds(300, 100, 100, 40);
		panel.add(namelabel_1);
		
		JLabel addresslabel_2 = new JLabel("地址：");
		addresslabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		addresslabel_2.setBounds(25, 165, 100, 40);
		panel.add(addresslabel_2);
		
		JTextPane ownerAddress = new JTextPane();
		ownerAddress.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		ownerAddress.setBackground(new Color(232, 232, 232));
		ownerAddress.setBounds(90, 165, 750, 40);
		Caret caretAddress = ownerAddress.getCaret();
		caretAddress.setBlinkRate(0);  // 設置光標閃爍率為0，這樣光標就不會顯示
        ownerAddress.setEditable(false);
        ownerAddress.setCaret(new DefaultCaret() {
            @Override
            public void paint(Graphics g) {
                // 不繪製光標
   
            }
        });
		panel.add(ownerAddress);
		
		ownerPhone = new JTextField();
		ownerPhone.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		ownerPhone.setBounds(400, 100, 185, 40);
		panel.add(ownerPhone);
		ownerPhone.setColumns(10);
		
		
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
		
		JLabel yearslabel = new JLabel("生日：");
		yearslabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		yearslabel.setBounds(185, 325, 80, 40);
		panel.add(yearslabel);
		

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
		birthday.setFont(new Font("微軟正黑體", Font.BOLD, 18));
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
		
		noteContent = new JTextField();
		noteContent.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		noteContent.setColumns(10);
		noteContent.setBounds(164, 470, 708, 40);
		panel.add(noteContent);
		
		/*//發現會有空號問題，待處理
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
		////////////button/////////////////////////////////////////////////////////////////////////
		

		JButton searchPhoneButton = new JButton("查詢");
		searchPhoneButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[][] petData = psi.searchOwnerPhone(ownerPhone.getText());
				if(petData.length > 0) {
					ownerName.setText((String) petData[0][1]);
					ownerAddress.setText((String) petData[0][3]);
				} else {
					error frame = new error();
					frame.setVisible(true);
					dispose();
					
				}
			}
		});
		searchPhoneButton.setBackground(new Color(211, 231, 223));
		searchPhoneButton.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		searchPhoneButton.setBounds(600, 100, 65, 40);
		panel.add(searchPhoneButton);
		
		
		JButton addPetbutton = new JButton("新增");
		addPetbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pet p = new pet();
				 	p.setOwnerName(ownerName.getText());
			        p.setOwnerPhone(ownerPhone.getText());
			        p.setOwnerAddress(ownerAddress.getText());
			        p.setPetName(petname.getText());
			        p.setSpecies(species.getSelectedItem().toString());
			        p.setVariety(variety.getText());
			        p.setSex(sex.getSelectedItem().toString());
			        p.setBirthday(birthday.getText());
			        p.setAge(Integer.parseInt(age.getText()));
			        p.setSterilization(sterilization.getSelectedItem().toString());
			        p.setColor(color.getText());
			        p.setFeeding(feeding.getSelectedItem().toString());
			        p.setDrugAllergy(yes.isSelected() ? "是" : "否");
			        p.setDrugAllergyContent(drugallergycontent.getText());
			        p.setNoteContent(noteContent.getText());
				
			        psi.addPet(p);
			        Listener_Manager.getInstance().notifyListeners(p);
			        
			        petname.setText("");
			        variety.setText("");
			        birthday.setText("yyyy/MM/dd");
			        age.setText("");
			        color.setText("");
			        drugallergycontent.setText("");
			        noteContent.setText("");
				
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
			}
		});
		exitbutton.setBackground(new Color(211, 231, 223));
		exitbutton.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		exitbutton.setBounds(25, 545, 90, 50);
		panel.add(exitbutton);
		
		
		
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
		
		 
	}
}//結束{號，不可以不見
