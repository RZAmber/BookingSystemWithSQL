package HotelBooking;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TotalPrice extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static double total;
	private static Order theOrder;
	private OrderDAO orderDAO;
	private RoomDAO roomDAO;
	private static int room;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TotalPrice dialog = new TotalPrice(theOrder,total,room);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TotalPrice(final Order theOrder, double total,final int roomNumber) {
		setBounds(100, 100, 250, 100);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JTextArea textArea = new JTextArea();
			
			textArea.setText("Total Price of This Order: " + total);
			textArea.setBounds(50, 76, 452, 349);
			contentPanel.add(textArea);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton ConfirmButton = new JButton("Confirm");
				ConfirmButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							orderDAO = new OrderDAO();
							orderDAO.deleteOrder(theOrder);
							setVisible(false);
							roomDAO =new RoomDAO();
							roomDAO.setAvailable(roomNumber);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				ConfirmButton.setActionCommand("OK");
				buttonPane.add(ConfirmButton);
				getRootPane().setDefaultButton(ConfirmButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
