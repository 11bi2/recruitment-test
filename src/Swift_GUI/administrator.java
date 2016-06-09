package Swift_GUI;
import Database_Objects.Bewerber;
import Database_Objects.SessionManager;
import Mail.Mailer;
import database.Table.Table_Bewerber;
import java.awt.Color;
import java.awt.EventQueue;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.DateFormatter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFormattedTextField;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

import net.miginfocom.swing.MigLayout;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;

public class administrator {

	private JFrame frmAdministratorbereich;
	private JTextField tfErgebnissTabelleFilter;
	private JTable tableErgebnisse;
	private JTextField tfBewerberGesamt;
	private JTextField tfPruefungenGesamt;
	private JTextField tfDurchschnittPunktzahl;
	private JTextField tfDurchschnittBestanden;
	private JTextField tfNewBewerberVorname;
	private JTextField tfNewBewerberNachname;
	private JTextField tfNewBewerberEmail;

	/**
	 * Launch the application.
	 */
	public static void AdministratorWindow() {
		changeProgramStyle();
		EventQueue.invokeLater(() -> {
                    try {
                        administrator window = new administrator();
                        window.frmAdministratorbereich.setVisible(true);
                        window.frmAdministratorbereich.setLocationRelativeTo(null); // Open window in center of screen
                    } catch (Exception e) {
                        //Possible UIHook
                    }
                });
	}

	public static void changeProgramStyle() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e1) {
                    //Possible UIHook
                }
            // TODO Auto-generated catch block
            // TODO Auto-generated catch block
            // TODO Auto-generated catch block
            
	}

	public void TableFiltering(JTable table, String filter) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		if (model == null)
			return;
		TableRowSorter<TableModel> sorter = new TableRowSorter<>();
		table.setRowSorter(sorter);
		sorter.setModel(model);
		if (!tfErgebnissTabelleFilter.getText().trim().equals("")) {
			try {
				sorter.setRowFilter(RowFilter.regexFilter("(?i)" + filter));
			} catch (java.util.regex.PatternSyntaxException ex) {
                            //Possible UIHook
                        }
		} else {
			sorter.setRowFilter(null);
		}
	}

	public boolean ValidatingDateFormat(String checkdate, String checkformat) {
		if(checkdate == null || checkformat == null) {
			return false;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(checkformat);
		sdf.setLenient(false);

		try {
			sdf.parse(checkdate);
		} catch (ParseException ex) {
			return false;
		}
		return true;
	}

	public static boolean ValidatingEmailAdress(String email) {
		boolean result;
            result = false;
		try {
			InternetAddress object = new InternetAddress(email);
			object.validate();
			result = true;
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}

	/**
	 * Create the application.
	 */
	public administrator() {
		initialize();
	}

	private void initialize() {
		frmAdministratorbereich = new JFrame();
		frmAdministratorbereich.setTitle("Administratorbereich \u2212 Cobra");
		frmAdministratorbereich.setBounds(100, 100, 550, 350);
		frmAdministratorbereich.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdministratorbereich.getContentPane().setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmAdministratorbereich.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("Übersicht", null, layeredPane, null);
		layeredPane.setLayout(new MigLayout("", "[][grow]", "[][][][][][]"));

		JLabel lblB = new JLabel("Bewerber (Insgesamt)");
		layeredPane.add(lblB, "cell 0 1,alignx left");

		tfBewerberGesamt = new JTextField();
		tfBewerberGesamt.setText(SessionManager.getInstance().getBewerber().size() + "");
		tfBewerberGesamt.setEditable(false);
		layeredPane.add(tfBewerberGesamt, "cell 1 1,growx");
		tfBewerberGesamt.setColumns(10);

		JLabel lblNewLabel = new JLabel("Prüfungen (Insgesamt)");
		layeredPane.add(lblNewLabel, "cell 0 2,alignx left");

		tfPruefungenGesamt = new JTextField();
		tfPruefungenGesamt.setText(SessionManager.getInstance().getErgebnisse().size() + "");
		tfPruefungenGesamt.setEditable(false);
		tfPruefungenGesamt.setColumns(10);
		layeredPane.add(tfPruefungenGesamt, "cell 1 2,growx");

		JLabel lblNewLabel_1 = new JLabel("Durchschnitt (Punktzahl)");
		layeredPane.add(lblNewLabel_1, "cell 0 4,alignx left");

		tfDurchschnittPunktzahl = new JTextField();
		tfDurchschnittPunktzahl.setText(SessionManager.getInstance().getPunktezahlDurchschnitt() + "");
		tfDurchschnittPunktzahl.setEditable(false);
		tfDurchschnittPunktzahl.setColumns(10);
		layeredPane.add(tfDurchschnittPunktzahl, "cell 1 4,growx");

		JLabel lblDurchschnittbestanden = new JLabel("Durchschnitt (Bestanden)");
		layeredPane.add(lblDurchschnittbestanden, "cell 0 5,alignx left");

		tfDurchschnittBestanden = new JTextField();
		tfDurchschnittBestanden.setText(SessionManager.getInstance().getBestandenDurchschnitt() + "");
		tfDurchschnittBestanden.setEditable(false);
		tfDurchschnittBestanden.setColumns(10);
		layeredPane.add(tfDurchschnittBestanden, "cell 1 5,growx");

		JLayeredPane layeredPane_2 = new JLayeredPane();
		tabbedPane.addTab("Ergebnisse", null, layeredPane_2, null);
		layeredPane_2.setLayout(new MigLayout("", "[][grow]", "[grow][][][][][][][]"));

		final JLabel lblAdawd = new JLabel("");
		lblAdawd.setFont(new Font("Dialog", Font.PLAIN, 10));
		layeredPane_2.add(lblAdawd, "flowx,cell 1 6,alignx right");

		JScrollPane scrollPane = new JScrollPane();
		layeredPane_2.add(scrollPane, "cell 0 0 2 7,grow");

		tableErgebnisse = new JTable();
		JTableHeader header = tableErgebnisse.getTableHeader();
		tableErgebnisse.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableErgebnisse.setModel(new DefaultTableModel(
                        SessionManager.getInstance().resultsToTableSet(),
                        
                        new String[]{
                            "Vorname", "Nachname", "Berufswahl", "Pruefungs Datum", "Punktzahl", "Ergebnis"
                        }
                ));
		
                
		scrollPane.setColumnHeaderView(tableErgebnisse);
		scrollPane.setViewportView(tableErgebnisse);

		JLabel filter_value = new JLabel("Suchfilter");
		filter_value.setToolTipText("Legen Sie einen beliebigen Filter für die obere Tabelle fest. Mit der ESC-Taste können Sie diesen Filter wieder entfernen.");
		layeredPane_2.add(filter_value, "cell 0 7,alignx trailing");
		layeredPane_2.add(header, BorderLayout.NORTH);


		tfErgebnissTabelleFilter = new JTextField();
		layeredPane_2.add(tfErgebnissTabelleFilter, "cell 1 7,growx");
		tfErgebnissTabelleFilter.setColumns(10);

		tfErgebnissTabelleFilter.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ESCAPE)
					tfErgebnissTabelleFilter.setText("");
				lblAdawd.setText(null);

			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				TableFiltering(tableErgebnisse, tfErgebnissTabelleFilter.getText().trim());
				if (tfErgebnissTabelleFilter.getText().trim().length() >= 1)
					lblAdawd.setText("Es ist ein Filter aktiv. Es werden nicht alle Ergebnisse angezeigt.");
			}
			@Override
			public void keyTyped(KeyEvent arg0) {	
			}
		});



		JLayeredPane layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("Bewerberverwaltung", null, layeredPane_1, null);
		layeredPane_1.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][][]"));	        
		JLabel lblNewLabel_2 = new JLabel("Vorname");
		layeredPane_1.add(lblNewLabel_2, "cell 0 0,alignx left");

		tfNewBewerberVorname = new JTextField();
		tfNewBewerberVorname.setText("Manuel");
		layeredPane_1.add(tfNewBewerberVorname, "cell 1 0,growx");
		tfNewBewerberVorname.setColumns(10);

		JLabel lblNachname = new JLabel("Nachname");
		layeredPane_1.add(lblNachname, "cell 0 1,alignx left");

		tfNewBewerberNachname = new JTextField();
		tfNewBewerberNachname.setText("Wiesener");
		tfNewBewerberNachname.setColumns(10);
		layeredPane_1.add(tfNewBewerberNachname, "cell 1 1,growx");

		JLabel label_email = new JLabel("E-Mail");
		layeredPane_1.add(label_email, "cell 0 2,alignx left");

		tfNewBewerberEmail = new JTextField();
		tfNewBewerberEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!ValidatingEmailAdress(tfNewBewerberEmail.getText().trim()) == true) {
					tfNewBewerberEmail.setBorder(BorderFactory.createDashedBorder(Color.RED));
					tfNewBewerberEmail.setText(null);
				} else {
					tfNewBewerberEmail.setBorder(null);
				}
			}
		});
		tfNewBewerberEmail.setText("mw@xyz.de");
		layeredPane_1.add(tfNewBewerberEmail, "cell 1 2,growx");
		tfNewBewerberEmail.setColumns(10);

		JLabel label_birthday = new JLabel("Geburtstag");
		layeredPane_1.add(label_birthday, "cell 0 3,alignx left");
		DateFormatter dateFormatter = new DateFormatter(new SimpleDateFormat("dd.MM.yyyy"));
		final JFormattedTextField tfNewBewerberGeburtstag = new JFormattedTextField(dateFormatter);
		tfNewBewerberGeburtstag.setValue(new Date());
		tfNewBewerberGeburtstag.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(ValidatingDateFormat(tfNewBewerberGeburtstag.getText().trim(), "dd.MM.yyyy") == false) {
					tfNewBewerberGeburtstag.setBorder(BorderFactory.createDashedBorder(Color.RED));
				} else {
					tfNewBewerberGeburtstag.setBorder(null);
				}
			}
		});

		layeredPane_1.add(tfNewBewerberGeburtstag, "cell 1 3,growx");

		JLabel lblBerufswahl = new JLabel("Abschluss");
		layeredPane_1.add(lblBerufswahl, "cell 0 4,alignx left");

		JComboBox cbAbschluss = new JComboBox();
		cbAbschluss.setModel(new DefaultComboBoxModel(new String[] {"Abitur", "Fachabitur", "Realschule", "Hauptschule", "Keinen"}));
		layeredPane_1.add(cbAbschluss, "cell 1 4,growx");
                
		JLabel lblGruppe = new JLabel("Berechtigung");
		layeredPane_1.add(lblGruppe, "cell 0 5,alignx left");

		JComboBox cbPermission = new JComboBox();
		cbPermission.setModel(new DefaultComboBoxModel(new String[] {"Bewerber", "Administrator"}));
		layeredPane_1.add(cbPermission, "cell 1 5,growx");

		JLabel lblFreigabestatus = new JLabel("Freigabestatus");
		layeredPane_1.add(lblFreigabestatus, "cell 0 6,alignx left");

		JComboBox cbFreigabestatus = new JComboBox();
		cbFreigabestatus.setModel(new DefaultComboBoxModel(new String[] {"Deaktiviert", "Aktiv"}));
		layeredPane_1.add(cbFreigabestatus, "cell 1 6,growx");

		JButton btnErstellen = new JButton("Erstellen.");
		btnErstellen.addActionListener((ActionEvent arg0) -> {
                    // ToDo: Check if input fields are empty. Only create applicants if fields are set.
                    try {
                        int permission;

                        if (cbPermission.getSelectedItem().toString().equals("Administrator")) {
                            permission = 1;
                        }else {
                            permission = 2;
                        }
                        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy.MM.dd");

                        Bewerber newBewerber = new Bewerber(permission, 1, tfNewBewerberVorname.getText(), tfNewBewerberNachname.getText(), myFormat.parse(tfNewBewerberGeburtstag.getText()), tfNewBewerberEmail.getText(), 1, "1234");

                        Table_Bewerber.getInstance().create(newBewerber);

                        Mailer.sendMail(newBewerber);
                        
                        JOptionPane.showMessageDialog(null, "Bewerber wurde erfolgreich erstellt und benarichtigt.", "Erfolg", JOptionPane.PLAIN_MESSAGE);
                    } catch (MessagingException | ParseException ex) {
                        Logger.getLogger(administrator.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
		layeredPane_1.add(btnErstellen, "cell 1 7,growx");
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
                        @Override
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
                        @Override
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

