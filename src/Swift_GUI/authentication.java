package Swift_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JTextField;


public class authentication {

	private JFrame frame;
	private JTextField field_user_id;
	private JTextField field_user_password;

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					authentication window = new authentication();
					window.frame.setLocationRelativeTo(null); // Open window in center of screen
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public authentication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setLayout(null);

		JTextPane txtpnLoremIpsumDolor = new JTextPane();
		txtpnLoremIpsumDolor.setEditable(false);
		txtpnLoremIpsumDolor.setBackground(UIManager.getColor("Button.background"));
		txtpnLoremIpsumDolor.setText("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.");
		txtpnLoremIpsumDolor.setBounds(12, 12, 424, 156);
		frame.getContentPane().add(txtpnLoremIpsumDolor);

		JLabel lblNewLabel = new JLabel("Benutzerkennung");
		lblNewLabel.setBounds(12, 180, 152, 15);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblAuthentifizierungscode = new JLabel("Authentifizierungscode");
		lblAuthentifizierungscode.setBounds(12, 214, 175, 15);
		frame.getContentPane().add(lblAuthentifizierungscode);

		field_user_id = new JTextField();
		field_user_id.setBounds(186, 180, 250, 19);
		frame.getContentPane().add(field_user_id);
		field_user_id.setColumns(10);

		field_user_password = new JTextField();
		field_user_password.setColumns(10);
		field_user_password.setBounds(186, 212, 250, 19);
		frame.getContentPane().add(field_user_password);

		JButton btnNewButton = new JButton("Verbindung aufbauen ...");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (field_user_id.getText().equals(field_user_password.getText()) == true)
					JOptionPane.showMessageDialog(null, "Erfolgreich angemeldet.");
				frame.dispose();
				administrator nw = new administrator();
				nw.AdministratorWindow();
			}
		});
		btnNewButton.setBounds(218, 242, 218, 25);
		frame.getContentPane().add(btnNewButton);
		frame.setBounds(100, 100, 449, 312);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

