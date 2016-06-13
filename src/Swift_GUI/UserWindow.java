/**
 * @FileName:			init.java
 * @Description:		No description added.
 * @Author:				Floryan
 * @LastChanged:		9:39:04 PM Jun 8, 2016 by Floryan
 *
 */

package Swift_GUI;
import Database_Objects.Antwortmoeglichkeit;
import Database_Objects.Aufgabe;
import Database_Objects.Berufswahl;
import Database_Objects.Bewerber;
import Database_Objects.Ergebnis;
import Database_Objects.Kategorie;
import Database_Objects.SessionManager;
import database.Table.Helper.Helper;
import database.Table.Table_Ergebnis;
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
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UserWindow extends JFrame {
        
    
	private JPanel contentPane;
        private Antwortmoeglichkeit antwortMoeglichkeit;
        private Kategorie kategorie;
        private static Berufswahl berufswahl;
        private static Ergebnis ergebnis = new Ergebnis();
        
        private int aufgabenIndex = 0;
        private int erreichtePunkte = 0;
        private int questionNumber = 1;
        
        private Calendar cal = Calendar.getInstance();
        private SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        private ArrayList<Boolean> wrongAnswers = new ArrayList();
        private ArrayList<Boolean> rightAnswers = new ArrayList();
        private ArrayList<Boolean> answeredQuestions = new ArrayList();
        

	/**
	 * Launch the application.
     * @param b
     * @param a
     * @param sessionManager
	 */
	public static void UserWindow(Bewerber b, ArrayList<Aufgabe> a, SessionManager sessionManager) {
		EventQueue.invokeLater(() -> {
                    try {
                        
                        berufswahl = sessionManager.getBerufswahlById(b.getIdBerufswahl());
                        UserWindow frame = new UserWindow(b, a, sessionManager);
                        frame.setLocationRelativeTo(null); // Open window in center of screen
                        frame.setVisible(true);
                        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                        int height1 = screenSize.height;
                        int width1 = screenSize.width;
                        frame.setPreferredSize(new Dimension(width1, height1));
                        frame.setTitle("Angemeldet als: " +  b.getVorName() +" " +  b.getNachName() + " \u2212 Prüfungsbogen: " + berufswahl.getBerufsBeschreibung()); // SQL hook here.
                        frame.pack();
                    }catch (Exception e) {
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
     * @param aufgaben
     * @param sessionManager
         * @param b
	 */
	public UserWindow(Bewerber b, ArrayList<Aufgabe> aufgaben, SessionManager sessionManager) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

                ergebnis.setId_Bewerber(b.getId());
                    kategorie = sessionManager.getKategorieById(sessionManager.getBerufswahlById(b.getIdBerufswahl()).getId());
                antwortMoeglichkeit = sessionManager.getAntwortmoeglichkeitById(aufgaben.get(aufgabenIndex).getIdAntwortMoeglichkeit());
                
                
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		final JLabel label_UserInfoCurrentCategory = new JLabel("Kategorie der Frage: " + kategorie.getKategorieBezeichnung());
		panel.add(label_UserInfoCurrentCategory, BorderLayout.WEST);
		
		final JLabel label_UserInfoQuestion = new JLabel("Frage " + questionNumber + " von " + Helper.maxAufgaben);
		panel.add(label_UserInfoQuestion, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new MigLayout("", "[grow]", "[grow][][][][]"));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, "cell 0 0,grow");
		
		String PlaceholderAnswers = Helper.decodeString(aufgaben.get(aufgabenIndex).getAufgabenstellung());
		final JLabel label_currentQuestion = new JLabel(StringToHTML(PlaceholderAnswers));
		label_currentQuestion.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_currentQuestion.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
		panel_1.add(label_currentQuestion, "cell 0 1");
		
		final JCheckBox checkbox_answer01 =  new JCheckBox(Helper.decodeString(antwortMoeglichkeit.getAntwortMoeglichkeit1()));
		panel_1.add(checkbox_answer01, "flowy,cell 0 2,growx");
		
		final JCheckBox checkbox_answer02 = new JCheckBox(Helper.decodeString(antwortMoeglichkeit.getAntwortMoeglichkeit2()));
		panel_1.add(checkbox_answer02, "cell 0 2,growx");
		
		final JCheckBox checkbox_answer03 = new JCheckBox(Helper.decodeString(antwortMoeglichkeit.getAntwortMoeglichkeit3()));
		panel_1.add(checkbox_answer03, "cell 0 2");
		
		final JCheckBox checkbox_answer04 = new JCheckBox(Helper.decodeString(antwortMoeglichkeit.getAntwortMoeglichkeit4()));
		panel_1.add(checkbox_answer04, "cell 0 2");
		
		final JCheckBox checkbox_answer05 = new JCheckBox(Helper.decodeString(antwortMoeglichkeit.getAntwortMoeglichkeit5()));
		panel_1.add(checkbox_answer05, "cell 0 2");
		
		JButton button_next = new JButton("Weiter zur n\u00E4chsten Frage ...");
		button_next.addActionListener((ActionEvent arg0) -> {
                    if (aufgabenIndex != (Helper.maxAufgaben - 1)) {
                        /* ToDo:
                        1. Save users answer into his session.
                        2. If question counter equals 20 then show print the result of the test.
                        3. Query new question from the database and re-render this window.
                        */
                        
                        if (checkbox_answer01.isSelected()) {
                            answeredQuestions.add(sessionManager.checkAnswer(aufgaben.get(aufgabenIndex).getId(), checkbox_answer01.getText()));
                            checkbox_answer01.setSelected(false);
                        }
                        
                        if(checkbox_answer02.isSelected()){
                             answeredQuestions.add(sessionManager.checkAnswer(aufgaben.get(aufgabenIndex).getId(), checkbox_answer02.getText()));
                             checkbox_answer02.setSelected(false);
                        }
                        
                        if(checkbox_answer03.isSelected()){
                             answeredQuestions.add(sessionManager.checkAnswer(aufgaben.get(aufgabenIndex).getId(), checkbox_answer03.getText()));
                             checkbox_answer03.setSelected(false);
                        }
                        
                        if(checkbox_answer04.isSelected()){
                             answeredQuestions.add(sessionManager.checkAnswer(aufgaben.get(aufgabenIndex).getId(), checkbox_answer04.getText()));
                             checkbox_answer04.setSelected(false);
                        }
                        
                        if(checkbox_answer05.isSelected()){
                             answeredQuestions.add(sessionManager.checkAnswer(aufgaben.get(aufgabenIndex).getId(), checkbox_answer05.getText()));
                             checkbox_answer05.setSelected(false);
                        }
                        
                        
                        aufgabenIndex++;
                        questionNumber++;
                        
                        antwortMoeglichkeit = sessionManager.getAntwortmoeglichkeitById(aufgaben.get(aufgabenIndex).getIdAntwortMoeglichkeit());
                        
                        label_currentQuestion.setText(Helper.decodeString(aufgaben.get(aufgabenIndex).getAufgabenstellung()));
                        checkbox_answer01.setText(Helper.decodeString(antwortMoeglichkeit.getAntwortMoeglichkeit1()));
                        checkbox_answer02.setText(Helper.decodeString(antwortMoeglichkeit.getAntwortMoeglichkeit2()));
                        checkbox_answer03.setText(Helper.decodeString(antwortMoeglichkeit.getAntwortMoeglichkeit3()));
                        checkbox_answer04.setText(Helper.decodeString(antwortMoeglichkeit.getAntwortMoeglichkeit4()));
                        checkbox_answer05.setText(Helper.decodeString(antwortMoeglichkeit.getAntwortMoeglichkeit5()));
                        
                        
                        
                        // Debugging stuff ...
                        label_UserInfoQuestion.setText("Frage " + questionNumber + " von " + Helper.maxAufgaben); // SQL hook here.
                        label_UserInfoCurrentCategory.setText("Kategorie: " + kategorie.getKategorieBezeichnung()); // SQL hook here.
                    }else {
                        answeredQuestions.stream().forEach((B) -> {
                            if (B) {
                                rightAnswers.add(B);
                                erreichtePunkte += Helper.moeglichePunkte;
                            }else {
                                wrongAnswers.add(B);
                                erreichtePunkte -= Helper.moeglichePunkte;
                            }
                        });
                        
                        cal.add(Calendar.DATE, 1);
                        ergebnis.setPruefungsDatum(myFormat.format(cal.getTime()));
                        ergebnis.setPunktzahl(erreichtePunkte);
                        if (rightAnswers.size() > wrongAnswers.size()) {
                            JOptionPane.showMessageDialog(null, "Sie haben Ihren Einstellungstest bestanden!\nSie erhalten eine E-Mail mit ihrem Ergebnis.", "Herzlichen Glückwunsch", JOptionPane.INFORMATION_MESSAGE);
                            ergebnis.setErgebnis(1);
                        }else {
                        
                            ergebnis.setErgebnis(0);
                            JOptionPane.showMessageDialog(null, "Es tut uns leid, Sie sind leider durchgefallen.\nSie erhalten eine E-Mail mit Ihrem Ergebnis.", "Durchgefallen", JOptionPane.INFORMATION_MESSAGE);
                        }
                        Table_Ergebnis.getInstance().create(ergebnis);
                        
                        authentication login = new authentication();
                        
                        //TODO Bild für aufgaben
                        //TODO: mail?
                        //TODO: return to login
                        this.dispose();
                    }
                    
                });
		button_next.setHorizontalAlignment(SwingConstants.RIGHT);
		button_next.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_1.add(button_next, "cell 0 3,alignx right");
	}
}