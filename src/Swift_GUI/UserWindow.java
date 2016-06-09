/**
 * @FileName:			init.java
 * @Description:		No description added.
 * @Author:				Floryan
 * @LastChanged:		9:39:04 PM Jun 8, 2016 by Floryan
 *
 */

package Swift_GUI;
import Database_Objects.Aufgabe;
import Database_Objects.Bewerber;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;

import javax.swing.JCheckBox;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserWindow extends JFrame {
	private int counter = 0;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void UserWindow(Bewerber b, Aufgabe a) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserWindow frame = new UserWindow(a);
                                        frame.setLocationRelativeTo(null); // Open window in center of screen
					frame.setVisible(true);	
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					int height = screenSize.height;
					int width = screenSize.width;
					frame.setPreferredSize(new Dimension(width, height));
					frame.setTitle("Angemeldet als: " +  b.getVorName() +" " +  b.getNachName() + " \u2212 Prüfungsbogen: <Berufswahl>"); // SQL hook here.
					frame.pack();
		
				} catch (Exception e) {
				}
			}
		});
	}

	private String StringToHTML(String text) {
		String before = "<html>";
		String after = "</html>";
		return before + text + after;
	}
	
	/**
	 * Create the frame.
         * @param b
	 */
	public UserWindow(Aufgabe a) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		final JLabel label_UserInfoCurrentCategory = new JLabel("Kategorie der Frage: ");
		panel.add(label_UserInfoCurrentCategory, BorderLayout.WEST);
		
		final JLabel label_UserInfoQuestion = new JLabel("Frage ? von ?");
		panel.add(label_UserInfoQuestion, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new MigLayout("", "[grow]", "[grow][][][][]"));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, "cell 0 0,grow");
		
		String PlaceholderAnswers = a.getAufgabenstellung();
		final JLabel label_currentQuestion = new JLabel(StringToHTML(PlaceholderAnswers));
		label_currentQuestion.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_currentQuestion.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
		panel_1.add(label_currentQuestion, "cell 0 1");
		
		final JCheckBox checkbox_answer01 =  new JCheckBox(StringToHTML(PlaceholderAnswers));
		panel_1.add(checkbox_answer01, "flowy,cell 0 2,growx");
		
		final JCheckBox checkbox_answer02 = new JCheckBox(StringToHTML(PlaceholderAnswers));
		panel_1.add(checkbox_answer02, "cell 0 2,growx");
		
		final JCheckBox checkbox_answer03 = new JCheckBox(StringToHTML(PlaceholderAnswers));
		panel_1.add(checkbox_answer03, "cell 0 2");
		
		final JCheckBox checkbox_answer04 = new JCheckBox(StringToHTML(PlaceholderAnswers));
		panel_1.add(checkbox_answer04, "cell 0 2");
		
		final JCheckBox checkbox_answer05 = new JCheckBox(StringToHTML(PlaceholderAnswers));
		panel_1.add(checkbox_answer05, "cell 0 2");
		
		JButton button_next = new JButton("Weiter zur n\u00E4chsten Frage ...");
		button_next.addActionListener((ActionEvent arg0) -> {
                    /* ToDo:
                    1. Save users answer into his session.
                    2. If question counter equals 20 then show print the result of the test.
                    3. Query new question from the database and re-render this window.
                    */
                    
                    label_currentQuestion.setText("Get question ...");
                    checkbox_answer01.setText("Answer 01 ...");
                    checkbox_answer02.setText("Answer 02 ...");
                    checkbox_answer03.setText("Answer 03 ...");
                    checkbox_answer04.setText("Answer 04 ...");
                    checkbox_answer05.setText("Answer 05 ...");
                    
                    // Debugging stuff ...
                    counter += 1;
                    label_UserInfoQuestion.setText("Frage " + counter + " von X"); // SQL hook here.
                    label_UserInfoCurrentCategory.setText("Kategorie: Unbekannt"); // SQL hook here.
                });
		button_next.setHorizontalAlignment(SwingConstants.RIGHT);
		button_next.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_1.add(button_next, "cell 0 3,alignx right");
	}
}