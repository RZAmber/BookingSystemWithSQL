package HotelBooking;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class room4 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					room4 frame = new room4();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public room4() {
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		ImageIcon bg=new ImageIcon("room4.jpg");
		bg.setImage(bg.getImage().getScaledInstance(1000,600,Image.SCALE_DEFAULT));
		JLabel l=new JLabel(bg);
		l.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());
		getLayeredPane().add(l,new Integer(Integer.MIN_VALUE));
		contentPane.setOpaque(false);
		setSize(1000,600);
	}

}
