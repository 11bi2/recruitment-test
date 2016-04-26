package Swift_GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		changeProgramStyle();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Function: changeProgramStyle
	 * Description: Use systems default style.
	 */
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

	/**
	 * Create the frame.
	 */
	public main() {
		setTitle("Cobra");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 391);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane MainTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(MainTabbedPane);
		
		JLayeredPane layeredPaneOverview = new JLayeredPane();
		MainTabbedPane.addTab("Bewerber�bersicht", null, layeredPaneOverview, null);
		layeredPaneOverview.setLayout(new BorderLayout(0, 0));
		
		JLayeredPane layeredPaneResults = new JLayeredPane();
		MainTabbedPane.addTab("Ergebnisse", null, layeredPaneResults, null);
		layeredPaneResults.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		layeredPaneResults.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JLayeredPane layeredPaneAccounts = new JLayeredPane();
		layeredPaneAccounts.setBorder(new EmptyBorder(10, 10, 10, 10));
		MainTabbedPane.addTab("Bewerber-Hub", null, layeredPaneAccounts, null);
		GridBagLayout gbl_layeredPaneAccounts = new GridBagLayout();
		gbl_layeredPaneAccounts.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_layeredPaneAccounts.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_layeredPaneAccounts.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_layeredPaneAccounts.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		layeredPaneAccounts.setLayout(gbl_layeredPaneAccounts);
		
		JLabel lblNewLabel = new JLabel("Vorname");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		layeredPaneAccounts.add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridwidth = 15;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 5;
		gbc_textField.gridy = 1;
		layeredPaneAccounts.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNachname = new JLabel("Nachname");
		GridBagConstraints gbc_lblNachname = new GridBagConstraints();
		gbc_lblNachname.anchor = GridBagConstraints.WEST;
		gbc_lblNachname.insets = new Insets(0, 0, 5, 5);
		gbc_lblNachname.gridx = 1;
		gbc_lblNachname.gridy = 2;
		layeredPaneAccounts.add(lblNachname, gbc_lblNachname);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridwidth = 15;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 5;
		gbc_textField_1.gridy = 2;
		layeredPaneAccounts.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblGeburtstag = new JLabel("Geburtstag");
		GridBagConstraints gbc_lblGeburtstag = new GridBagConstraints();
		gbc_lblGeburtstag.anchor = GridBagConstraints.WEST;
		gbc_lblGeburtstag.insets = new Insets(0, 0, 5, 5);
		gbc_lblGeburtstag.gridx = 1;
		gbc_lblGeburtstag.gridy = 3;
		layeredPaneAccounts.add(lblGeburtstag, gbc_lblGeburtstag);
		
		JComboBox comboBox_2 = new JComboBox();
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.gridx = 6;
		gbc_comboBox_2.gridy = 3;
		layeredPaneAccounts.add(comboBox_2, gbc_comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_3.gridx = 9;
		gbc_comboBox_3.gridy = 3;
		layeredPaneAccounts.add(comboBox_3, gbc_comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		GridBagConstraints gbc_comboBox_4 = new GridBagConstraints();
		gbc_comboBox_4.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_4.gridx = 11;
		gbc_comboBox_4.gridy = 3;
		layeredPaneAccounts.add(comboBox_4, gbc_comboBox_4);
		
		JLabel lblEmail = new JLabel("E-Mail");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 4;
		layeredPaneAccounts.add(lblEmail, gbc_lblEmail);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 15;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 5;
		gbc_textField_2.gridy = 4;
		layeredPaneAccounts.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblBerechtigungsgruppe = new JLabel("Berechtigungsgruppe");
		GridBagConstraints gbc_lblBerechtigungsgruppe = new GridBagConstraints();
		gbc_lblBerechtigungsgruppe.anchor = GridBagConstraints.WEST;
		gbc_lblBerechtigungsgruppe.insets = new Insets(0, 0, 5, 5);
		gbc_lblBerechtigungsgruppe.gridx = 1;
		gbc_lblBerechtigungsgruppe.gridy = 7;
		layeredPaneAccounts.add(lblBerechtigungsgruppe, gbc_lblBerechtigungsgruppe);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 15;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 5;
		gbc_comboBox.gridy = 7;
		layeredPaneAccounts.add(comboBox, gbc_comboBox);
		
		JLabel lblFreigabestatus = new JLabel("Freigabestatus");
		lblFreigabestatus.setToolTipText("");
		GridBagConstraints gbc_lblFreigabestatus = new GridBagConstraints();
		gbc_lblFreigabestatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblFreigabestatus.anchor = GridBagConstraints.WEST;
		gbc_lblFreigabestatus.gridx = 1;
		gbc_lblFreigabestatus.gridy = 8;
		layeredPaneAccounts.add(lblFreigabestatus, gbc_lblFreigabestatus);
		
		JComboBox comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 15;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 5;
		gbc_comboBox_1.gridy = 8;
		layeredPaneAccounts.add(comboBox_1, gbc_comboBox_1);
		
		JButton btnNewButton_1 = new JButton("Hinzuf\u00FCgen");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,  "Das Konto wurde erfolgreich erstellt.", "Bewerber-Hub", JOptionPane.PLAIN_MESSAGE );
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.gridwidth = 19;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 10;
		layeredPaneAccounts.add(btnNewButton_1, gbc_btnNewButton_1);
		
		// Right now there is no need for this menu ...
		/** JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		menuBar.setBorderPainted(false);
		contentPane.add(menuBar, BorderLayout.NORTH);
		
		JMenu mnNewMenu = new JMenu("Administrator");
		menuBar.add(mnNewMenu);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Beenden");
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});  */
	
	}
}