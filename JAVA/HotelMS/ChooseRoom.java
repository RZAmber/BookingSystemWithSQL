package HotelBooking;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChooseRoom extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private static Order theOrder;
	private RoomDAO roomDAO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ChooseRoom dialog = new ChooseRoom(theOrder);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ChooseRoom(final Order theOrder) {
		setBounds(100, 100, 200, 130);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblRoomNumber = new JLabel("Room Number");
			contentPanel.add(lblRoomNumber);
		}
		{
			textField = new JTextField();
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String room = textField.getText();
						int roomNumber = Integer.parseInt(room);

						try {
							OrderDAO orderDAO = new OrderDAO();
							orderDAO.setRoom(roomNumber, theOrder);
							setVisible(false);
							roomDAO =new RoomDAO();
							roomDAO.setUnAvailable(roomNumber);						
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
