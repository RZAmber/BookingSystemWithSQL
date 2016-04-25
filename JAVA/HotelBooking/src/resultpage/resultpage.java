package resultpage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class resultpage extends JFrame {

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("congratulation！Predetermined success ！");
		lblNewLabel.setFont(new Font("Cochin", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(6, 6, 326, 40);
		panel.add(lblNewLabel);
		
		JLabel lblOrderInformation = new JLabel("Order Information:");
		lblOrderInformation.setBounds(16, 48, 130, 16);
		panel.add(lblOrderInformation);
		
		JTextArea txtrOrderInfo = new JTextArea();
		txtrOrderInfo.setForeground(Color.LIGHT_GRAY);
		txtrOrderInfo.setText("order info");
		txtrOrderInfo.setBounds(26, 70, 510, 373);
		panel.add(txtrOrderInfo);
		
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
	}
}
