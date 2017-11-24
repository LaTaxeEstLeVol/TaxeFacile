package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.ICMS;
import dao.ICMSDao;
import services.Validator;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;

public class ICMSCalculator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane = null;
	private JList<String> listDestiny = null;
	private JTextField productValueText = null;
	private JList<String> listOrigin = null;
	private ICMSDao icmsDao = null;
	private DefaultListModel<String> listStates = new DefaultListModel<>();
	private JTextField totalToPrayText = null;
	private List<ICMS> listIcms = null;
	private JLabel lblProductValue = null;
	private JLabel lblStateOrigin = null;
	private JLabel lblStateDestiny = null;
	private JScrollPane scrollPaneOrigin = null;
	private JScrollPane scrollPaneDestiny = null;
	private JLabel lblTotalToPray = null;
	private JButton btnCalcule = null;
	private GroupLayout gl_contentPane = null;
	private Validator validator = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ICMSCalculator frame = new ICMSCalculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ICMSCalculator() {

		super("Calculadora de ICMS");
		icmsDao = new ICMSDao();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblProductValue = new JLabel("Valor do Produto");
		productValueText = new JTextField();
		lblStateOrigin = new JLabel("Estado de Origem");
		lblStateDestiny = new JLabel("Estado de Destino");
		scrollPaneOrigin = new JScrollPane();
		scrollPaneDestiny = new JScrollPane();
		lblTotalToPray = new JLabel("Total a Pagar");
		totalToPrayText = new JTextField();
		btnCalcule = new JButton("Calcular");

		lblProductValue.setFont(new Font("Arial", Font.PLAIN, 14));
		productValueText.setFont(new Font("Arial", Font.PLAIN, 14));
		lblStateOrigin.setFont(new Font("Arial", Font.PLAIN, 14));
		lblStateDestiny.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPaneOrigin.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPaneDestiny.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTotalToPray.setFont(new Font("Arial", Font.PLAIN, 14));
		totalToPrayText.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCalcule.setFont(new Font("Arial", Font.PLAIN, 14));

		productValueText.setColumns(10);
		totalToPrayText.setColumns(10);
		totalToPrayText.setEditable(false);

		validator = new Validator();

		gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
								.addComponent(scrollPaneDestiny, GroupLayout.PREFERRED_SIZE, 58,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(368, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblStateOrigin)
								.addContainerGap(302, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane
										.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
												.createSequentialGroup().addGap(12)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(lblProductValue).addComponent(productValueText,
																GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
												.addComponent(lblStateDestiny))
										.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(
												scrollPaneOrigin, GroupLayout.PREFERRED_SIZE, 54,
												GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(btnCalcule)
										.addComponent(lblTotalToPray).addComponent(totalToPrayText,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addContainerGap(56, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(12)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblProductValue)
						.addComponent(lblTotalToPray))
				.addGap(6)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(productValueText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(totalToPrayText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblStateOrigin)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(scrollPaneOrigin,
										GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnCalcule))
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblStateDestiny)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(scrollPaneDestiny, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(22, Short.MAX_VALUE)));

		listDestiny = new JList<String>(listStates);
		scrollPaneDestiny.setViewportView(listDestiny);
		listDestiny.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		listOrigin = new JList<String>(listStates);
		scrollPaneOrigin.setViewportView(listOrigin);
		listOrigin.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		listIcms = icmsDao.getListStates();
		for (int aux = 0; aux < listIcms.size(); aux++) {
			listStates.addElement(listIcms.get(aux).getStateOrigin());
		}

		contentPane.setLayout(gl_contentPane);

		btnCalcule.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				boolean value = validator.validateSalary(productValueText.getText());

				if (value) {

					ICMS icms = new ICMS();

					icms.setProductValue(Double.parseDouble(productValueText.getText()));
					icms.setStateOrigin(listOrigin.getSelectedValue());
					icms.setStateDestiny(listDestiny.getSelectedValue());

					String valueFinal = String.valueOf(validator.format(icms.calcule(icms)));

					totalToPrayText.setText("R$ " + valueFinal + " Reais");
				}
			}
		});
	}
}