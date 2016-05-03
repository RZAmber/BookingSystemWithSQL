package reserve;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextArea;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class resultpage extends JFrame {

	private JPanel contentPane;
	ImageIcon bg =new ImageIcon("spbackground.jpg");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					resultpage frame = new resultpage();
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
	public resultpage() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		bg.setImage(bg.getImage().getScaledInstance(600,550,Image.SCALE_DEFAULT));
		JLabel l=new JLabel(bg);
		l.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());
		getLayeredPane().add(l,new Integer(Integer.MIN_VALUE));
		contentPane.setOpaque(false);
		setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("congratulation！Predetermined success ！");
		lblNewLabel.setFont(new Font("Cochin", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(6, 6, 326, 40);
		panel.add(lblNewLabel);
		
		JLabel lblOrderInformation = new JLabel("Order Information:");
		lblOrderInformation.setBounds(16, 48, 130, 16);
		panel.add(lblOrderInformation);
		
		JButton btnNewButton = new JButton("Finish");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(434, 455, 117, 29);
		panel.add(btnNewButton);
		
		JRadioButton rdbtnSentTheOrder = new JRadioButton("Sent the order information to my E-mail");
		rdbtnSentTheOrder.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdbtnSentTheOrder.setBounds(26, 456, 284, 23);
		panel.add(rdbtnSentTheOrder);
		
		JList list = new JList();
		list.setBounds(343, 202, 1, 1);
		panel.add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(50, 76, 452, 349);
		panel.add(list_1);
	}
}
