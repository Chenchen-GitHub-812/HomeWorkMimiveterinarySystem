package controller.ownerandpet;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import service.impl.pet_service_impl;
import util.Listener_Manager;
import util.calculateAge;
import util.calfile;

import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.ownerandpet.pet;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class updatePet extends JFrame {

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
	private JTextField species;
	private JTextField sex;
	private JTextField age;
	private JTextField sterilization;
	private JTextField feeding;
	private JTextField drugallergy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updatePet frame = new updatePet();
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
	public updatePet() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 905, 586);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(231, 243, 243));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(244, 249, 248));
		panel.setBounds(0, 0, 900, 650);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel petnamelabel = new JLabel("寵物名：");
		petnamelabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		petnamelabel.setBounds(20, 190, 100, 40);
		panel.add(petnamelabel);
		
		petname = new JTextField();
		petname.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		petname.setBounds(105, 190, 200, 40);
		panel.add(petname);
		petname.setColumns(10);
		
		JLabel specieslabel = new JLabel("物種：");
		specieslabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		specieslabel.setBounds(330, 190, 80, 40);
		panel.add(specieslabel);
		
		String[] itemsSpecies = {"犬", "貓"};
		
		JLabel varietylabel = new JLabel("品種：");
		varietylabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		varietylabel.setBounds(495, 190, 80, 40);
		panel.add(varietylabel);
		
		variety = new JTextField();
		variety.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		variety.setColumns(10);
		variety.setBounds(555, 190, 200, 40);
		panel.add(variety);
		
		JLabel sexlabel = new JLabel("性別：");
		sexlabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		sexlabel.setBounds(20, 255, 80, 40);
		panel.add(sexlabel);
		
		String[] itemSex = {"公", "母"};
		
		JLabel yearslabel = new JLabel("生日：");
		yearslabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		yearslabel.setBounds(180, 255, 80, 40);
		panel.add(yearslabel);
		

		JTextField birthday = new JTextField();
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
		birthday.setBounds(245, 255, 180, 40);
		panel.add(birthday);
		
		JLabel agelabel = new JLabel("年齡：");
		agelabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		agelabel.setBounds(455, 255, 80, 40);
		panel.add(agelabel);
		
		
		JLabel sterilizationlabel = new JLabel("是否結紮：");
		sterilizationlabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		sterilizationlabel.setBounds(595, 255, 120, 40);
		panel.add(sterilizationlabel);
		
		String[] itemsSterilization = {"是","否"};
		
		JLabel colorlabel = new JLabel("花色：");
		colorlabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		colorlabel.setBounds(20, 330, 80, 40);
		panel.add(colorlabel);
		
		color = new JTextField();
		color.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		color.setColumns(10);
		color.setBounds(80, 330, 120, 40);
		panel.add(color);
		
		JLabel feedinglabel = new JLabel("餵藥方式：");
		feedinglabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		feedinglabel.setBounds(235, 330, 120, 40);
		panel.add(feedinglabel);
		
		String[] itemsFeeding = {"藥粉","藥丸","藥水"};
		
		JLabel drugallergylabel_1 = new JLabel("是否對藥物過敏：");
		drugallergylabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		drugallergylabel_1.setBounds(455, 330, 150, 40);
		panel.add(drugallergylabel_1);
		
		
		
		drugallergycontent = new JTextField();
		drugallergycontent.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		drugallergycontent.setColumns(10);
		drugallergycontent.setBounds(680, 330, 145, 40);
		panel.add(drugallergycontent);
		
		JLabel note = new JLabel("寵物注意事項：");
		note.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		note.setBounds(20, 400, 150, 40);
		panel.add(note);
		
		noteContent = new JTextField();
		noteContent.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		noteContent.setColumns(10);
		noteContent.setBounds(159, 400, 708, 40);
		panel.add(noteContent);
		
		JLabel lblNewLabel_2 = new JLabel("修改寵物資料");
		lblNewLabel_2.setForeground(new Color(83, 83, 83));
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		lblNewLabel_2.setBorder(new MatteBorder(0, 0, 2, 0, new Color(82, 82, 82)));
		lblNewLabel_2.setBounds(17, 15, 860, 60);
		panel.add(lblNewLabel_2);
		
		
		JLabel lblid_1 = new JLabel("寵物ID：");
		lblid_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblid_1.setBounds(20, 115, 100, 40);
		panel.add(lblid_1);
		
		JTextPane id = new JTextPane();
		id.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		id.setEditable(false);
		id.setBackground(new Color(232, 232, 232));
		id.setBounds(105, 115, 50, 40);
		panel.add(id);
		
		species = new JTextField();
		species.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		species.setColumns(10);
		species.setBounds(385, 190, 80, 40);
		panel.add(species);
		
		sex = new JTextField();
		sex.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		sex.setColumns(10);
		sex.setBounds(85, 255, 80, 40);
		panel.add(sex);
		
		age = new JTextField();
		age.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		age.setColumns(10);
		age.setBounds(515, 255, 50, 40);
		panel.add(age);
		
		sterilization = new JTextField();
		sterilization.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		sterilization.setColumns(10);
		sterilization.setBounds(692, 257, 80, 40);
		panel.add(sterilization);
		
		feeding = new JTextField();
		feeding.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		feeding.setColumns(10);
		feeding.setBounds(335, 330, 80, 40);
		panel.add(feeding);
		
		drugallergy = new JTextField();
		drugallergy.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		drugallergy.setColumns(10);
		drugallergy.setBounds(605, 330, 50, 40);
		panel.add(drugallergy);
		
		String searchPetName = "";
		String searchOwnerPhone = "";
		List<pet> listPet = (List<pet>) calfile.readfile("petInfo.txt");
		if(listPet != null)
		{
			pet p = listPet.get(0);
			searchPetName = p.getPetName();
			searchOwnerPhone = p.getOwnerPhone();
		}
	
		
		List<pet> listPet2 = psi.searchPetNameAndOwnerPhone(searchPetName, searchOwnerPhone);
		
		if(listPet2 != null) {
			pet p = listPet2.get(0);
			id.setText(String.valueOf(p.getId()));
			petname.setText(p.getPetName());
			variety.setText(p.getVariety());
			sex.setText(p.getSex());
			birthday.setText(p.getBirthday());
			age.setText(p.getAge().toString());
			sterilization.setText(p.getSterilization());
			color.setText(p.getColor());
			feeding.setText(p.getFeeding());
			drugallergy.setText(p.getDrugAllergy());
			drugallergycontent.setText(p.getDrugAllergyContent());
			noteContent.setText(p.getNoteContent());
			
		}
		
		////////////////button///////////////////////////////////////
		
		

		JButton exitbutton = new JButton("離開");
		exitbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		exitbutton.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		exitbutton.setBackground(new Color(211, 231, 223));
		exitbutton.setBounds(31, 466, 90, 50);
		panel.add(exitbutton);
		
		JButton updatePetbutton = new JButton("修改");
		updatePetbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pet p = new pet();
				p.setId(Integer.parseInt(id.getText()));
				p.setPetName(petname.getText());
				p.setSpecies(species.getText());
				p.setVariety(variety.getText());
				p.setSex(sex.getText());
				p.setBirthday(birthday.getText());
				p.setAge(Integer.parseInt(age.getText()));
				p.setSterilization(sterilization.getText());
				p.setColor(color.getText());
				p.setFeeding(feeding.getText());
				p.setDrugAllergy(drugallergy.getText());
				p.setDrugAllergyContent(drugallergycontent.getText());
				p.setNoteContent(noteContent.getText());
				
				psi.updatePet(p);
			}
		});
		updatePetbutton.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		updatePetbutton.setBackground(new Color(211, 231, 223));
		updatePetbutton.setBounds(766, 466, 90, 50);
		panel.add(updatePetbutton);
		
		
		
		
	}
	
	
}//不可以不見
