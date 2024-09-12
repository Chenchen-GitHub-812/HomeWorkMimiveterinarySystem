package controller.log;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class error extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					error frame = new error();
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
	public error() {
		setTitle("Warning!");
		setIconImage(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(230, 242, 255));
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 350, 370, 174);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setOpaque(true);
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		ImageIcon icon=new ImageIcon(getClass().getResource("/Icon.png"));
		/*
		if (icon.getIconWidth() == -1)
		{
			System.out.println("加載失敗");
		}
		else
		{
			System.out.println("加載成功");
		}
		*/
		
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		icon = new ImageIcon(newImg);
		JLabel lblNewLabel = new JLabel("帳號密碼輸入錯誤 ! ");
		lblNewLabel.setLocation(5, 9);
		lblNewLabel.setSize(350, 65);
		lblNewLabel.setBackground(new Color(230, 242, 255));
		lblNewLabel.setOpaque(false);
		lblNewLabel.setIcon(icon);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel.setVerticalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("確定");
		btnNewButton.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(201, 201, 201));
		btnNewButton.setOpaque(true);
		btnNewButton.setBounds(140, 80, 85, 25);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(236, 245, 255));
		panel.setBounds(-1, -2, 359, 140);
		contentPane.add(panel);
		
	}
}
