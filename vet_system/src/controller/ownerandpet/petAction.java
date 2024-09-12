package controller.ownerandpet;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Caret;
import javax.swing.text.DefaultCaret;

import model.ownerandpet.pet;
import util.calfile;

public class petAction extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextPane variety;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					petAction frame = new petAction();
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
	public petAction() {
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
		
		JLabel lblNewLabel_2 = new JLabel("寵物資訊");
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
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(211, 231, 223));
		panel_1.setBounds(15, 230, 860, 5);
		panel.add(panel_1);
		
		JLabel petnamelabel = new JLabel("寵物名：");
		petnamelabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		petnamelabel.setBounds(25, 260, 100, 40);
		panel.add(petnamelabel);
		
		JLabel specieslabel = new JLabel("物種：");
		specieslabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		specieslabel.setBounds(290, 260, 80, 40);
		panel.add(specieslabel);
		
		String[] itemsSpecies = {"犬", "貓"};
		
		JLabel varietylabel = new JLabel("品種：");
		varietylabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		varietylabel.setBounds(540, 260, 80, 40);
		panel.add(varietylabel);
		
		JLabel sexlabel = new JLabel("性別：");
		sexlabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		sexlabel.setBounds(25, 325, 80, 40);
		panel.add(sexlabel);
		
		String[] itemSex = {"公", "母"};
		
		JLabel yearslabel = new JLabel("生日：");
		yearslabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		yearslabel.setBounds(185, 325, 80, 40);
		panel.add(yearslabel);
		
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
		
		JLabel colorlabel = new JLabel("花色：");
		colorlabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		colorlabel.setBounds(25, 400, 80, 40);
		panel.add(colorlabel);
		
		JLabel feedinglabel = new JLabel("餵藥方式：");
		feedinglabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		feedinglabel.setBounds(240, 400, 120, 40);
		panel.add(feedinglabel);
		
		String[] itemsFeeding = {"藥粉","藥丸","藥水"};
		
		JLabel drugallergylabel_1 = new JLabel("是否對藥物過敏：");
		drugallergylabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		drugallergylabel_1.setBounds(460, 400, 150, 40);
		panel.add(drugallergylabel_1);
		
		JLabel note = new JLabel("寵物注意事項：");
		note.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		note.setBounds(25, 470, 150, 40);
		panel.add(note);
		
		
		JTextPane ownerPhone = new JTextPane();
		ownerPhone.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		ownerPhone.setEditable(false);
		ownerPhone.setBackground(new Color(232, 232, 232));
		ownerPhone.setBounds(400, 100, 160, 40);
		panel.add(ownerPhone);
		
		JTextPane petName = new JTextPane();
		petName.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		petName.setEditable(false);
		petName.setBackground(new Color(232, 232, 232));
		petName.setBounds(102, 260, 160, 40);
		panel.add(petName);
		
		JTextPane species = new JTextPane();
		species.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		species.setEditable(false);
		species.setBackground(new Color(232, 232, 232));
		species.setBounds(350, 260, 160, 40);
		panel.add(species);
		
		variety = new JTextPane();
		variety.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		variety.setEditable(false);
		variety.setBackground(new Color(232, 232, 232));
		variety.setBounds(605, 260, 160, 40);
		panel.add(variety);
		
		JTextPane sex = new JTextPane();
		sex.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		sex.setEditable(false);
		sex.setBackground(new Color(232, 232, 232));
		sex.setBounds(85, 325, 50, 40);
		panel.add(sex);
		
		JTextPane birthday = new JTextPane();
		birthday.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		birthday.setEditable(false);
		birthday.setBackground(new Color(232, 232, 232));
		birthday.setBounds(245, 325, 160, 40);
		panel.add(birthday);
		
		JTextPane sterilization = new JTextPane();
		sterilization.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		sterilization.setEditable(false);
		sterilization.setBackground(new Color(232, 232, 232));
		sterilization.setBounds(700, 325, 50, 40);
		panel.add(sterilization);
		
		JTextPane color = new JTextPane();
		color.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		color.setEditable(false);
		color.setBackground(new Color(232, 232, 232));
		color.setBounds(85, 400, 120, 40);
		panel.add(color);
		
		JTextPane feeding = new JTextPane();
		feeding.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		feeding.setEditable(false);
		feeding.setBackground(new Color(232, 232, 232));
		feeding.setBounds(335, 400, 100, 40);
		panel.add(feeding);
		
		JTextPane drugallery = new JTextPane();
		drugallery.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		drugallery.setEditable(false);
		drugallery.setBackground(new Color(232, 232, 232));
		drugallery.setBounds(615, 400, 53, 40);
		panel.add(drugallery);
		
		JTextPane noteContent = new JTextPane();
		noteContent.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		noteContent.setEditable(false);
		noteContent.setBackground(new Color(232, 232, 232));
		noteContent.setBounds(154, 470, 600, 40);
		panel.add(noteContent);
		
		JTextPane drugallergyContent = new JTextPane();
		drugallergyContent.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		drugallergyContent.setEditable(false);
		drugallergyContent.setBackground(new Color(232, 232, 232));
		drugallergyContent.setBounds(666, 400, 182, 40);
		panel.add(drugallergyContent);
		
		List<pet> listPet = (List<pet>) calfile.readfile("petInfo.txt");
		System.out.println("Line 287 :" + listPet );
		if(listPet != null)
		{
			
			pet p = listPet.get(0);
			ownerName.setText(p.getOwnerName());
			ownerPhone.setText(p.getOwnerPhone());
			ownerAddress.setText(p.getOwnerAddress());
			petName.setText(p.getPetName());
			species.setText(p.getSpecies());
			variety.setText(p.getVariety());
			sex.setText(p.getSex());
			birthday.setText(p.getBirthday());
			age.setText(p.getAge().toString());
			sterilization.setText(p.getSterilization());
			color.setText(p.getColor());
			feeding.setText(p.getFeeding());
			drugallery.setText(p.getDrugAllergy());
			drugallergyContent.setText(p.getDrugAllergyContent());
			noteContent.setText(p.getNoteContent());
			
			
		}
		
		////////////button/////////////////////////////////////////////////////////
		
		
		JButton addpetvet = new JButton("醫療預約");
		addpetvet.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		addpetvet.setBackground(new Color(253, 253, 208));
		addpetvet.setBounds(250, 545, 150, 50);
		panel.add(addpetvet);
		
		JButton addpetgroomer_1_1 = new JButton("美容紀錄");
		addpetgroomer_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		addpetgroomer_1_1.setBackground(new Color(245, 231, 240));
		addpetgroomer_1_1.setBounds(475, 545, 150, 50);
		panel.add(addpetgroomer_1_1);
		
		JButton addpetgroomer_1_1_1 = new JButton("醫療紀錄");
		addpetgroomer_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		addpetgroomer_1_1_1.setBackground(new Color(253, 253, 208));
		addpetgroomer_1_1_1.setBounds(700, 545, 150, 50);
		panel.add(addpetgroomer_1_1_1);
		

		JButton addpetgroomer = new JButton("美容預約");
		addpetgroomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		addpetgroomer.setBackground(new Color(245, 231, 240));
		addpetgroomer.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		addpetgroomer.setBounds(25, 545, 150, 50);
		panel.add(addpetgroomer); 
		
		JButton updatepet = new JButton("修改寵物資料");
		updatepet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updatePet frame = new updatePet();
				frame.setVisible(true);
			}
		});
		updatepet.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		updatepet.setBackground(new Color(211, 231, 223));
		updatepet.setBounds(690, 20, 150, 40);
		panel.add(updatepet);
		
		JButton updateowner = new JButton("修改飼主資料");
		updateowner.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateOwner frame = new updateOwner();
				frame.setVisible(true);
				dispose();
			}
		});


		updateowner.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		updateowner.setBackground(new Color(211, 231, 223));
		updateowner.setBounds(500, 20, 150, 40);
		panel.add(updateowner);
		
	}
}//結束{號，不可以不見