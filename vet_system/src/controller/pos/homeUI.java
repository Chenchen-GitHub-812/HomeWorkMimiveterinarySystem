package controller.pos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import controller.log.checkoutUI;
import controller.ownerandpet.addOwnerAndPet;
import controller.ownerandpet.addPet;
import controller.ownerandpet.petAction;
import controller.ownerandpet.updateOwner;
import controller.todo.add_todo;
import controller.todo.finishtodo;
import model.to_do;
import model.ownerandpet.pet;
import model.staff.staff_table;
import service.impl.pet_service_impl;
import service.impl.todo_service_impl;
import util.AddListener;
import util.Item;
import util.Listener_Manager;

import util.calfile;
import util.catchtime;
import util.setTableSize;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListCellRenderer;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JTextField;




public class homeUI extends JFrame implements AddListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int hoverIndex = -1;
	private JTable table;
	private todo_service_impl tdsi=new todo_service_impl();
	private DefaultTableModel tableModelUnfinished;
	private DefaultTableModel tableModelFinished;
	private DefaultTableModel petModel;
	private Listener_Manager listenerManger = Listener_Manager.getInstance();
	private JTable table_unfinished;
	private JTable table_finished;
	private int xPos;
	private int yPos;
	private JTextField searchphone;
	private JTextField searchPetName;
	private JTable tablePetInfo;
	private pet_service_impl psi= new pet_service_impl();
	private to_do td;
	private pet p;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homeUI frame = new homeUI();
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
	public homeUI() {
		listenerManger.addListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(20, 20, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());  // 使用 BorderLayout 來自動適應視窗大小
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
	
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 247, 255));
		panel.setBounds(0, 0, 1500, 800);
		panel.setLayout(null);
		contentPane.add(panel);
		
		JLabel staffnumber = new JLabel("staffnumber");
		staffnumber.setForeground(new Color(128, 128, 128));
		staffnumber.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		staffnumber.setBounds(33, 25, 120, 40);
		panel.add(staffnumber);
	
		
		JLabel staffname = new JLabel("staffname");
		staffname.setForeground(new Color(128, 128, 128));
		staffname.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		staffname.setBounds(140, 25, 103, 40);
		panel.add(staffname);
		staff_table st = (staff_table) calfile.readfile("Atrs.txt");
		
		if(st != null)
		{
		staffnumber.setText(st.getStaffnumber());
		staffname.setText(st.getName());
		}
		else
		{
			System.out.println("Can not find file");
		}
		
		JLabel datetime = new JLabel("time");
		catchtime ct=new catchtime();
		Timer timer = new Timer(1000,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ct.catchtimenow(datetime);
			}
		});
		timer.start();
		datetime.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		datetime.setBounds(1182, 22, 248, 40);
		panel.add(datetime);
		
		
		
		
		JPanel panel_cards = new JPanel();
		panel_cards.setBounds(400, 85, 1050, 662);
		panel_cards.setBackground(new Color(238, 247, 255));
		panel_cards.setLayout(new CardLayout());
		panel.add(panel_cards);
		
//------清單選項-待辦交接事項-------------------------------------------------------------------------------------------------------------------------
		JPanel announcement = new JPanel(); 
		announcement.setBackground(new Color(255, 255, 234));
		announcement.setLayout(null);
		panel_cards.add(announcement,"待辦交接事項");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(238, 247, 255));
		panel_1.setBounds(11, 9, 1027, 642);
		announcement.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("待辦交接事項");
		lblNewLabel.setForeground(new Color(83, 83, 83));
		lblNewLabel.setBounds(15, 10, 1000, 60);
		lblNewLabel.setBorder(new MatteBorder(0, 0, 2, 0, new Color(82, 82, 82))); 
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		panel_1.add(lblNewLabel);
		
		//--------未完成待辦事項------------------------------------------------------------------------------------------------------------------
		String[] columnNames = {"編號","日期", "時間", "交接人員", "類別", "內容","是否完成","完成人員"};
		Object[][] initialData_unfinish = tdsi.searchfished("false");
		DefaultTableModel model_unfinished = new DefaultTableModel(initialData_unfinish, columnNames) {
			 @Override
			    public boolean isCellEditable(int row, int column) {
			        return false;  // 禁止所有單元格編輯
			    }
		};
		table_unfinished = new JTable(model_unfinished);
		setTableSize sts_unfinished = new setTableSize();
		sts_unfinished.adjustColumnWidths(table_unfinished);
		sts_unfinished.setTableFont(table_unfinished);
		table_unfinished.setBackground(new Color(238, 247, 255));

		JScrollPane scrollPane_unfinished = new JScrollPane(table_unfinished);
		scrollPane_unfinished.setBounds(15,80,1000,226);
		panel_1.add(scrollPane_unfinished);
	
		table_unfinished.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int row = table_unfinished.getSelectedRow();  // 獲取被點擊的行
		        int column = 0;  // 獲取被點擊的列
		        Object idValue = table_unfinished.getValueAt(row,column);
		        if(idValue != null) {
		        	int number=(Integer) idValue;
		        	List<to_do> td =tdsi.searchnumber(number);
		        	calfile.savefile(td, "todoItem.txt");
		        	
		        }
		        
		        // 獲取該行該列的值
		       Object value = table_unfinished.getValueAt(row, column);
		      //  System.out.println("點擊的行: " + row + ", 列: " + column + ", 值: " + value);
		        
		        // 根據點擊的行或列進行判斷
		        if (value != null) {
		        	finishtodo frame = new finishtodo();
					frame.setVisible(true);  // 打開新的 UI 界面
		        }
		    }
		});
		
		
		
		//--------已完成待辦事項------------------------------------------------------------------------------------------------------------------

		Object[][] initialData_finished = tdsi.searchfished("yes");
		DefaultTableModel modelfinished = new DefaultTableModel(initialData_finished, columnNames) {
			 @Override
			    public boolean isCellEditable(int row, int column) {
			        return false;  // 禁止所有單元格編輯
			    }
		};
		table_finished = new JTable(modelfinished);
		setTableSize stsfinished = new setTableSize();
		stsfinished.adjustColumnWidths(table_finished);
		stsfinished.setTableFont(table_finished);
		table_finished.setBackground(new Color(238, 247, 255));

		JScrollPane scrollPane_finished = new JScrollPane(table_finished);
		scrollPane_finished.setBounds(15,400,1000,231);
		panel_1.add(scrollPane_finished);
		
		JLabel lblNewLabel_1 = new JLabel("已完成");
		lblNewLabel_1.setForeground(new Color(83, 83, 83));
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		lblNewLabel_1.setBorder(new MatteBorder(0, 0, 2, 0, new Color(82, 82, 82)));
		lblNewLabel_1.setBounds(15, 330, 1000, 60);
		panel_1.add(lblNewLabel_1);
		
		
		initTableModels();
		
		JButton btnNewButton_1 = new JButton("新增待辦事項");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				add_todo frame = new add_todo();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 234));
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		btnNewButton_1.setForeground(new Color(83, 83, 83));
		btnNewButton_1.setBounds(860, 15, 150, 40);
		panel_1.add(btnNewButton_1);
		
		
		
//---清單選項-寵物與飼主資料---------------------------------------------------------------------------------------------------------------
	JPanel addOwnerAndPet = new JPanel(); 
	addOwnerAndPet.setBackground(new Color(225, 240, 240));
	addOwnerAndPet.setLayout(null);
	panel_cards.add(addOwnerAndPet,"飼主與寵物資料");
	

	JPanel panel_2 = new JPanel();
	panel_2.setBackground(new Color(238, 247, 255));
	panel_2.setPreferredSize(new Dimension(1030, 800));
	panel_2.setBounds(11, 9, 1027, 642);
	panel_2.setLayout(null);
	addOwnerAndPet.add(panel_2);
	
	JLabel lblNewLabel_2 = new JLabel("飼主與寵物資料");
	lblNewLabel_2.setForeground(new Color(83, 83, 83));
	lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 25));
	lblNewLabel_2.setBorder(new MatteBorder(0, 0, 2, 0, new Color(82, 82, 82)));
	lblNewLabel_2.setBounds(9, 8, 1000, 60);
	panel_2.add(lblNewLabel_2);

	
	JLabel phonelabel = new JLabel("用電話號碼查詢：");
	phonelabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
	phonelabel.setBounds(15, 80, 150, 40);
	panel_2.add(phonelabel);
	
	JLabel namelabel = new JLabel("用寵物名查詢：");
	namelabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
	namelabel.setBounds(550, 80, 150, 40);
	panel_2.add(namelabel);
	
	searchphone = new JTextField();
	searchphone.setFont(new Font("微軟正黑體", Font.BOLD, 18));
	searchphone.setBounds(170, 80, 200, 40);
	panel_2.add(searchphone);
	searchphone.setColumns(10);
	
	searchPetName = new JTextField();
	searchPetName.setFont(new Font("微軟正黑體", Font.BOLD, 18));
	searchPetName.setColumns(10);
	searchPetName.setBounds(685, 80, 200, 40);
	panel_2.add(searchPetName);
	
	/////////////飼主與寵物資料的表格//////////////////////////
	
	String[] petInfoColumn = {"編號","飼主姓名","飼主電話","地址","寵物姓名","物種","品種","性別","生日","年齡","是否結紮","毛色","餵藥習慣","藥物過敏","藥物過敏項目","其他注意事項"};
	
	petModel = new DefaultTableModel(null, petInfoColumn) {
	@Override
    public boolean isCellEditable(int row, int column) {
        return false;  // 禁止所有單元格編輯
	}
	};

	

	
	tablePetInfo = new JTable(petModel);
	setTableSize stsPetInfo = new setTableSize();
	stsPetInfo.adjustColumnWidths(tablePetInfo);
	stsPetInfo.setTableFont(tablePetInfo);
	tablePetInfo.setBounds(15, 146, 2000, 631);
	tablePetInfo.setBackground(new Color(238, 247, 255));
	
	JScrollPane scrollPanePetInfo = new JScrollPane(tablePetInfo);
	scrollPanePetInfo.setBounds(25, 140, 1000, 471);
	scrollPanePetInfo.setPreferredSize(new Dimension(3000, 500));
	panel_2.add(scrollPanePetInfo);
	scrollPanePetInfo.setViewportView(tablePetInfo);

	
	tablePetInfo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	
	

	tablePetInfo.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
	        int row = tablePetInfo.getSelectedRow();  // 獲取被點擊的行
	        int column = 0;  // 獲取被點擊的列
	        Object idValue = tablePetInfo.getValueAt(row, column);  // 假設第一列是 ID 列
	        
	        if (idValue != null) {
	            // 假設第一列是編號，將其轉換為整數類型
	            int number = (Integer) idValue;

	            // 從數據庫或其他來源獲取與該 ID 對應的寵物資料
	            List<pet> petList = psi.searchId(number);  // 假設 searchId 方法會根據 ID 返回寵物資料
	          

	            if (petList == null || petList.isEmpty()) {
	                JOptionPane.showMessageDialog(null, "找不到對應的寵物資料");
	                return;  // 如果找不到資料，直接返回，避免繼續操作
	            }
	            // 將結果保存到文件中
	            calfile.savefile(petList, "petInfo.txt");
	        }

	        // 獲取該行的數據，用於判斷是否進行下一步操作
	        Object value = tablePetInfo.getValueAt(row, column);
	        

	        // 如果該行的數據存在，打開新 UI 界面
	        if (value != null) {
	            petAction frame = new petAction();
	            frame.setVisible(true);  // 打開新的 UI 界面
	        }
	    }
	});
	
	//-------button--------------------------------------------------------------
	
	JButton addOwner = new JButton("新增飼主與寵物資料");
			addOwner.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					addOwnerAndPet frame = new addOwnerAndPet();
					frame.setVisible(true);
				}
			});
			addOwner.setBackground(new Color(211, 231, 223));
			addOwner.setFont(new Font("微軟正黑體", Font.BOLD, 18));
			addOwner.setBounds(800, 15, 200, 40);
			panel_2.add(addOwner);
			
			JButton addPet = new JButton("新增寵物資料");
			addPet.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					addPet frame = new addPet();
					frame.setVisible(true);
				}
			});
			addPet.setFont(new Font("微軟正黑體", Font.BOLD, 18));
			addPet.setBackground(new Color(211, 231, 223));
			addPet.setBounds(630, 15, 150, 40);
			panel_2.add(addPet);
	
	JButton searchPhoneButton = new JButton("查詢");
			searchPhoneButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String searchPhone = searchphone.getText().trim();
					Object[][] petInfoDate = psi.searchOwnerPhone(searchPhone);
					//System.out.println("line 423:" + petInfoDate.length);
					if(!searchPhone.isEmpty()) {
						
						updateTableData(tablePetInfo, petModel, petInfoDate);
						
					} else {
						JOptionPane.showMessageDialog(null, "請輸入電話號碼或寵物名查詢");
					}
					
					
				}
			});
			searchPhoneButton.setBackground(new Color(225, 240, 240));
			searchPhoneButton.setFont(new Font("微軟正黑體", Font.BOLD, 15));
			searchPhoneButton.setBounds(380, 80, 65, 40);
			panel_2.add(searchPhoneButton);
	
	JButton searchPetNameButton = new JButton("查詢");
			searchPetNameButton.setFont(new Font("微軟正黑體", Font.BOLD, 15));
			searchPetNameButton.setBackground(new Color(225, 240, 240));
			searchPetNameButton.setBounds(900, 80, 65, 40);
			panel_2.add(searchPetNameButton);

			searchPetNameButton.addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
			        String SearchPetName = searchPetName.getText().trim();
			        if (!SearchPetName.isEmpty()) {
			            Object[][] searchData = psi.searchPetName(SearchPetName);
			           // System.out.println(Arrays.deepToString(searchData));  // 打印返回的数据
			            updateTableData(tablePetInfo, petModel, searchData);
			        } else {
			            JOptionPane.showMessageDialog(null, "請輸入寵物名進行查詢");
			        }
			    }
			});
			
	JButton refreshbutton = new JButton();
			ImageIcon refreshIcon = new ImageIcon(getClass().getResource("/refresh.png"));
			Image refreshImg = refreshIcon.getImage();
			Image resizedImage = refreshImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			refreshbutton.setToolTipText("重新整理");
			refreshbutton.setBounds(180, 15, 70, 50);
			refreshbutton.setContentAreaFilled(false);
			refreshbutton.setBorderPainted(false);
			//refreshbutton.setFocusPainted(false);
			refreshbutton.setOpaque(false);
			panel_2.add(refreshbutton);
			refreshbutton.setIcon(new ImageIcon(resizedImage));
			refreshbutton.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseEntered(MouseEvent e) {
			        // 當滑鼠移到按鈕上時放大圖標
			        Image enlargedImage = refreshImg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);  // 放大後的圖標
			        refreshbutton.setIcon(new ImageIcon(enlargedImage));
			    }

			    @Override
			    public void mouseExited(MouseEvent e) {
			        // 當滑鼠移出按鈕時恢復圖標
			        refreshbutton.setIcon(new ImageIcon(resizedImage));
			    }
				@Override
				public void mouseClicked(MouseEvent e) {
					refreshOwnerPetTable();
				}
			});
//清選項-寵物美容預約---------------------------------------------------------------------------------------------------------------
	
	
	JPanel reservePetgrooming = new JPanel();
	reservePetgrooming.add(new JLabel("寵物美容預約"));
	panel_cards.add(reservePetgrooming,"寵物美容預約");
	
	// 清單選項 - 寵物醫療預約
	JPanel reservePetMedical = new JPanel();
	reservePetMedical.add(new JLabel("寵物醫療預約"));
	panel_cards.add(reservePetMedical, "寵物醫療預約");
	
	//清單選項 - 結帳
	JPanel pay = new JPanel();
	pay.add(new JLabel("結帳"));
	panel_cards.add(pay, "結帳");
	
	ImageIcon[] icons= {
			new ImageIcon(getClass().getResource("/to_do.png")),
			new ImageIcon(getClass().getResource("/add.png")),
			new ImageIcon(getClass().getResource("/grooming.png")),
			new ImageIcon(getClass().getResource("/medical.png")),
			new ImageIcon(getClass().getResource("/cash.png"))
	};
	
	int iconWidth = 30;
	int iconHeight = 30;
	for(int i =0; i< icons.length; i++)
		{
		Image img = icons[i].getImage().getScaledInstance(iconWidth,iconHeight,Image.SCALE_SMOOTH);
		icons[i] = new ImageIcon(img);
		}
	String[] pages= {"待辦交接事項","飼主與寵物資料", "寵物美容預約", "寵物醫療預約","結帳"};
	DefaultListModel<Item> modellist = new DefaultListModel<>();
		for(int j = 0; j< pages.length; j++)
		{
			modellist.addElement(new Item(pages[j], icons[j]));
		}
	
	JList<Item> list = new JList<>(modellist);
	list.setFont(new Font("微軟正黑體", Font.BOLD, 18));
	list.setFixedCellHeight(60);
	list.setOpaque(false);
	list.setBorder(null);
	list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	
	list.setCellRenderer(new DefaultListCellRenderer(){
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			label.setBorder(noFocusBorder);
			if(value instanceof Item) {
				Item item = (Item) value;
				label.setText(item.getText());
				label.setIcon(item.getIcon());
				label.setOpaque(false);
			
				if(index == hoverIndex) {
					ImageIcon icon = (ImageIcon) item.getIcon();
					Image img= icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
					label.setFont(new Font("微軟正黑體", Font.BOLD, 22));
					label.setIcon(new ImageIcon(img));
			
	
				}
			}
			return label;
		}
		
	});
	
	list.addMouseMotionListener(new MouseAdapter() {
		@Override
		public void mouseMoved(MouseEvent e) {
			int index = list.locationToIndex(e.getPoint());
			if(index != hoverIndex) {
				hoverIndex = index;
				list.repaint();
			}
		}
	});
	JScrollPane listScrollPane = new JScrollPane(list);
	listScrollPane.setBounds(30, 85, 300, 540);
	listScrollPane.setOpaque(false);
	listScrollPane.getViewport().setBorder(null);
	listScrollPane.setBorder(null);

	listScrollPane.getViewport().setOpaque(false);
	
	panel.add(listScrollPane);
	
	list.addListSelectionListener(e->{
		if(!e.getValueIsAdjusting()) {
			Item selectedItem = list.getSelectedValue();
			if(selectedItem != null)
			{
		CardLayout c1=(CardLayout)(panel_cards.getLayout());
		c1.show(panel_cards, selectedItem.getText());
			}
		}
	});
	
	list.addListSelectionListener(e -> {
	    if (!e.getValueIsAdjusting()) {  // 確保不會多次重複觸發
	        Item selectedItem = list.getSelectedValue();
	        if (selectedItem != null) {
	            CardLayout c1 = (CardLayout) (panel_cards.getLayout());
	            c1.show(panel_cards, selectedItem.getText());  // 切換到所選頁面
	            
	            // 每次點擊選項後刷新頁面
	            refreshPage(selectedItem.getText());  // 調用刷新頁面的邏輯
	        }
	    }
	});



		
	
	
		///////按鈕們/////////////////////////////////////////////////////////////////////////////////
		
		
		JButton btnNewButton = new JButton("登出");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				checkoutUI frame = new checkoutUI();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(236, 236, 236));
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton.setBounds(120, 650, 100, 40);
		panel.add(btnNewButton);
		
		JPanel marqueePanel = new JPanel();
		marqueePanel.setBounds(408, 25, 740, 40);  // 設置滾動範圍的寬度和高度
		marqueePanel.setLayout(null);  // 使用絕對佈局
		marqueePanel.setBackground(Color.WHITE); // 設置背景顏色，方便看出範圍
		
		panel.add(marqueePanel);
		
		//跑馬燈
		JLabel marquee = new JLabel("老師!!! 我能力不足，時間不夠，寫不完!!!!     ");
		//int labelWidth = marquee.getPreferredSize().width;
		marquee.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		marquee.setBounds(0, 0,marquee.getPreferredSize().width, 40);
		marqueePanel.add(marquee);
		
		
		xPos =marqueePanel.getWidth();
		yPos = 0;
		 //marquee.setLocation(xPos, yPos);  // Y 軸與 table 對齊
	     
		Timer timer1 = new Timer(50,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//每次更新x座標，重繪文字
				xPos -=3;
				if(xPos + (marquee.getWidth()+10) < 0) {
					xPos = marqueePanel.getWidth();
				}
				marquee.setLocation(xPos, yPos);
				marquee.repaint();
			}
		});
		timer1.start();
		
	
		
		
	
	
	}//結束刮號 不能不見
		
		
		
		
	
	///////一些我不知道要怎麼分出去的方法//////////////////////////////////////////////////////////////////////////
	// 刷新不同頁面的邏輯 給list用的
		private void refreshPage(String selectedPage) {
		    switch (selectedPage) {
		        case "待辦交接事項":
		        	
		        	updateTodoList(table_unfinished, tableModelUnfinished, "false");  // 更新未完成事項
		    	    updateTodoList(table_finished, tableModelFinished, "yes");    // 更新已完成事項
		    	   
		       
		    	    break;
		        case "飼主與寵物資料":
		            // 刷新新增飼主與寵物資料的頁面邏輯
		        	refreshOwnerPetTable();
		        	
		            break;
		        case "寵物美容預約":
		            // 刷新寵物美容預約的頁面邏輯
		            break;
		        case "寵物醫療預約":
		            // 刷新寵物醫療預約的頁面邏輯
		            break;
		        case "結帳":
		            // 刷新結帳頁面的邏輯
		            break;
		        default:
		            System.out.println("未知的頁面: " + selectedPage);
		    }
		}
	public void  updateTodoList(JTable table,DefaultTableModel tableModel, String finished) {
		Object[][] tableData= tdsi.searchfished(finished);
		 
		  if(tableModel != null)
		{
		tableModel.setDataVector(tableData, 
	                new String[]{"編號", "日期", "時間", "交接人員", "類別", "內容", "是否完成", "完成人員"});
		table.revalidate();  // 重新驗證表格佈局
		table.repaint();     // 重繪表格
	        }
		else
		{
			System.out.println("tableModel 末初始化");
		}
		
	}
	
	

	public void initTableModels() {
		 if (table_unfinished == null || table_finished == null) {
		        System.out.println("表格未初始化！");
		        return;
		    }
		 String[] columnNames = {"編號", "日期", "時間", "交接人員", "類別", "內容", "是否完成", "完成人員"};
	    
	    // 未完成事項
	    Object[][] initialData_unfinish = tdsi.searchfished("false");  // 取得未完成的事項
	    tableModelUnfinished = new DefaultTableModel(initialData_unfinish, columnNames);
	    table_unfinished.setModel(tableModelUnfinished);

	    // 已完成事項
	    Object[][] initialData_finished =  tdsi.searchfished("yes");      // 取得已完成的事項
	    tableModelFinished = new DefaultTableModel(initialData_finished, columnNames);
	    table_finished.setModel(tableModelFinished);
	    
	    
	}

	
	  private void refreshOwnerPetTable() {
		  String[] petInfoColumn = {"編號","飼主姓名","飼主電話","地址","寵物姓名","物種","品種","性別","生日","年齡","是否結紮","毛色","餵藥習慣","藥物過敏","藥物過敏項目","其他注意事項"};
		    Object[][] petData = psi.selectAll();
		    petModel = new DefaultTableModel(petData, petInfoColumn);
		    tablePetInfo.setModel(petModel);
		    tablePetInfo.revalidate();
		    tablePetInfo.repaint();
		}
		

	  	
		public void updateTableData(JTable table,DefaultTableModel tableModel, Object[][] data) {
			//System.out.println("line 719: "+data.length);
			tableModel.setRowCount(0);
			if(data != null && data.length > 0) {
				//DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			for(Object[] row : data) {
				tableModel.addRow(row);
			}
			table.revalidate();
			table.repaint();
			/*
			for (MouseListener listener : table.getMouseListeners()) {
		        table.removeMouseListener(listener);
		    }
			*/
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int row = table.getSelectedRow();
					if(row >=0) {
						Object[] selectedRowData = new Object[table.getColumnCount()];
						for ( int i = 0; i < table.getColumnCount(); i++) {
							selectedRowData[i] = table.getValueAt(row, i);
						}
						//calfile.savefile(selectedRowData, "petInfo.txt");
						petAction frame = new petAction();
						frame.setVisible(true);
					}
				}
			});
			
			
			} else {
				JOptionPane.showMessageDialog(null, "找不到資料");
			}
			
			
			
		}
	
	  @Override
		public <T> void onItemAdded(T item) {
			// TODO Auto-generated method stub
			if(item instanceof to_do) {
				to_do todoItem = (to_do) item;
			updateTodoList(table_unfinished, tableModelUnfinished, "false");
	        updateTodoList(table_finished, tableModelFinished, "yes");
			}
		else if(item instanceof pet){
				pet petItem = (pet) item;
				refreshOwnerPetTable();
			}
			else {
				System.err.println("未知物件類型" + item.getClass().getSimpleName());
			}
		}
	}//最後的不可以不見
