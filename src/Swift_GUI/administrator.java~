package Swift_GUI;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

import net.miginfocom.swing.MigLayout;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Font;

public class administrator {

	private JFrame frmAdministratorbereich;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField txtManuel;
	private JTextField txtWiesener;
	private JTextField field_email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		changeProgramStyle();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					administrator window = new administrator();
					window.frmAdministratorbereich.setVisible(true);
					window.frmAdministratorbereich.setLocationRelativeTo(null); // Open window in center of screen
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void changeProgramStyle() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void TableFiltering(JTable table, String filter) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		if (model == null)
			return;
		TableRowSorter<TableModel> sorter = new TableRowSorter<>();
		table.setRowSorter(sorter);
		sorter.setModel(model);
		if (!textField.getText().trim().equals("")) {
			try {
				sorter.setRowFilter(RowFilter.regexFilter("(?i)" + filter));
			} catch (java.util.regex.PatternSyntaxException ex) {
				return;
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
		boolean result = false;
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

		textField_1 = new JTextField();
		textField_1.setText("0");
		textField_1.setEditable(false);
		layeredPane.add(textField_1, "cell 1 1,growx");
		textField_1.setColumns(10);

		JLabel lblNewLabel = new JLabel("Prüfungen (Insgesamt)");
		layeredPane.add(lblNewLabel, "cell 0 2,alignx left");

		textField_2 = new JTextField();
		textField_2.setText("0");
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		layeredPane.add(textField_2, "cell 1 2,growx");

		JLabel lblNewLabel_1 = new JLabel("Durchschnitt (Punktzahl)");
		layeredPane.add(lblNewLabel_1, "cell 0 4,alignx left");

		textField_3 = new JTextField();
		textField_3.setText("0");
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		layeredPane.add(textField_3, "cell 1 4,growx");

		JLabel lblDurchschnittbestanden = new JLabel("Durchschnitt (Bestanden)");
		layeredPane.add(lblDurchschnittbestanden, "cell 0 5,alignx left");

		textField_4 = new JTextField();
		textField_4.setText("0");
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		layeredPane.add(textField_4, "cell 1 5,growx");

		JLayeredPane layeredPane_2 = new JLayeredPane();
		tabbedPane.addTab("Ergebnisse", null, layeredPane_2, null);
		layeredPane_2.setLayout(new MigLayout("", "[][grow]", "[grow][][][][][][][]"));
		
		final JLabel lblAdawd = new JLabel("");
		lblAdawd.setFont(new Font("Dialog", Font.PLAIN, 10));
		layeredPane_2.add(lblAdawd, "flowx,cell 1 6,alignx right");

		JScrollPane scrollPane = new JScrollPane();
		layeredPane_2.add(scrollPane, "cell 0 0 2 7,grow");

		table = new JTable();
		JTableHeader header = table.getTableHeader();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setModel(new DefaultTableModel(
				new Object[][] {
						{null, null, null, null, null, null},
						{"Mathias", "Olexer", "Fachinformatiker", "01.01.1990", "112", "Bestanden"},
						{null, null, null, null, null, null},
				},
				new String[] {
						"Vorname", "Nachname", "Berufswahl", "Pr\u00FCfungsdatum", "Punktzahl", "Ergebnis"
				}
				));
		table.getColumnModel().getColumn(3).setPreferredWidth(131);
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);

		JLabel filter_value = new JLabel("Suchfilter");
		filter_value.setToolTipText("Legen Sie einen beliebigen Filter für die obere Tabelle fest. Mit der ESC-Taste können Sie diesen Filter wieder entfernen.");
		layeredPane_2.add(filter_value, "cell 0 7,alignx trailing");
		layeredPane_2.add(header, BorderLayout.NORTH);


		textField = new JTextField();
		layeredPane_2.add(textField, "cell 1 7,growx");
		textField.setColumns(10);

		textField.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ESCAPE)
					textField.setText("");
					lblAdawd.setText(null);

			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				TableFiltering(table, textField.getText().trim());
				if (textField.getText().trim().length() >= 1)
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

		txtManuel = new JTextField();
		txtManuel.setText("Manuel");
		layeredPane_1.add(txtManuel, "cell 1 0,growx");
		txtManuel.setColumns(10);

		JLabel lblNachname = new JLabel("Nachname");
		layeredPane_1.add(lblNachname, "cell 0 1,alignx left");

		txtWiesener = new JTextField();
		txtWiesener.setText("Wiesener");
		txtWiesener.setColumns(10);
		layeredPane_1.add(txtWiesener, "cell 1 1,growx");

		JLabel label_email = new JLabel("E-Mail");
		layeredPane_1.add(label_email, "cell 0 2,alignx left");

		field_email = new JTextField();
		field_email.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!ValidatingEmailAdress(field_email.getText().trim()) == true) {
					field_email.setBorder(BorderFactory.createDashedBorder(Color.RED));
					field_email.setText(null);
				} else {
					field_email.setBorder(null);
				}
			}
		});
		field_email.setText("mw@xyz.de");
		layeredPane_1.add(field_email, "cell 1 2,growx");
		field_email.setColumns(10);

		JLabel label_birthday = new JLabel("Geburtstag");
		layeredPane_1.add(label_birthday, "cell 0 3,alignx left");
		DateFormatter dateFormatter = new DateFormatter(new SimpleDateFormat("dd.MM.yyyy"));
		final JFormattedTextField field_birthday = new JFormattedTextField(dateFormatter);
		field_birthday.setValue(new Date());
		field_birthday.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(ValidatingDateFormat(field_birthday.getText().trim(), "dd.MM.yyyy") == false) {
					field_birthday.setBorder(BorderFactory.createDashedBorder(Color.RED));
				} else {
					field_birthday.setBorder(null);
				}
			}
		});

		layeredPane_1.add(field_birthday, "cell 1 3,growx");

		JLabel lblBerufswahl = new JLabel("Abschluss");
		layeredPane_1.add(lblBerufswahl, "cell 0 4,alignx left");

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Abitur", "Fachabitur", "Realschule", "Hauptschule", "Keinen"}));
		layeredPane_1.add(comboBox_2, "cell 1 4,growx");

		JLabel lblGruppe = new JLabel("Berechtigung");
		layeredPane_1.add(lblGruppe, "cell 0 5,alignx left");

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Bewerber", "Administrator"}));
		layeredPane_1.add(comboBox_1, "cell 1 5,growx");

		JLabel lblFreigabestatus = new JLabel("Freigabestatus");
		layeredPane_1.add(lblFreigabestatus, "cell 0 6,alignx left");

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Deaktiviert", "Aktiv"}));
		layeredPane_1.add(comboBox, "cell 1 6,growx");

		JButton btnErstellen = new JButton("Erstellen.");
		btnErstellen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ToDo: Check if input fields are empty. Only create applicants if fields are set.
			}
		});
		layeredPane_1.add(btnErstellen, "cell 1 7,growx");
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
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
