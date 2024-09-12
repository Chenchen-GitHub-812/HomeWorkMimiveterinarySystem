package controller;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

public class test extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
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
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		 // 创建页面内容面板和CardLayout
        JPanel cards = new JPanel(new CardLayout());

        // 页面1
        JPanel page1 = new JPanel();
        page1.add(new JLabel("This is Page 1"));
        cards.add(page1, "Page 1");

        // 页面2
        JPanel page2 = new JPanel();
        page2.add(new JLabel("This is Page 2"));
        cards.add(page2, "Page 2");

        // 页面3
        JPanel page3 = new JPanel();
        page3.add(new JLabel("This is Page 3"));
        cards.add(page3, "Page 3");

        // 创建JList用于选择页面
        String[] pages = {"Page 1", "Page 2", "Page 3"};
        JList<String> list = new JList<>(pages);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0); // 默认选中第一页

        // 监听JList选择事件，切换到相应的页面
        list.addListSelectionListener(e -> {
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards, list.getSelectedValue());
        });
        contentPane.setLayout(new BorderLayout());
        contentPane.add(new JScrollPane(list), BorderLayout.WEST);
        contentPane.add(cards, BorderLayout.CENTER);
	}

}
