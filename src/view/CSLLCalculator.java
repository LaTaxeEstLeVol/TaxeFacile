package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CSLLCalculator extends JFrame {

	private JPanel contentPane;
	private JTextField firstTrimesterText;
	private JTextField secondTrimesterText;
	private JTextField thirdThirdSemester;
	private JTextField totalText;
	private String[] typeRegiment = { "Lucro Real", "Lucro Presumido" };
	private JTextField firstTrimester;
	private JTextField secondTrimester;
	private JTextField thirdTrimester;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CSLLCalculator frame = new CSLLCalculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CSLLCalculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();

		JPanel panelReal = new JPanel();
		panelReal.setVisible(false);

		JPanel panelPresumed = new JPanel();

		JPanel panelTotal = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(panelPresumed,
										GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(panelReal, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panelTotal, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(14, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE).addComponent(
								panelPresumed, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panelTotal, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelReal, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(15, Short.MAX_VALUE)));

		JLabel lblTotalAPagar = new JLabel("Total a Pagar");

		textField_4 = new JTextField();
		textField_4.setColumns(10);

		JButton btnVoltar = new JButton("Avançar");

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout gl_panelTotal = new GroupLayout(panelTotal);
		gl_panelTotal.setHorizontalGroup(gl_panelTotal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTotal.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelTotal.createParallelGroup(Alignment.LEADING).addComponent(lblTotalAPagar)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnVoltar).addComponent(btnCalcular))
						.addContainerGap(61, Short.MAX_VALUE)));
		gl_panelTotal.setVerticalGroup(gl_panelTotal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTotal.createSequentialGroup().addContainerGap().addComponent(lblTotalAPagar)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE).addComponent(btnCalcular)
						.addGap(18).addComponent(btnVoltar).addContainerGap()));
		panelTotal.setLayout(gl_panelTotal);

		JLabel lblLucroTrimestral = new JLabel("Lucro Trimestral");

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GroupLayout gl_panelPresumed = new GroupLayout(panelPresumed);
		gl_panelPresumed.setHorizontalGroup(gl_panelPresumed.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPresumed.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelPresumed.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLucroTrimestral).addComponent(textField_3, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(63, Short.MAX_VALUE)));
		gl_panelPresumed.setVerticalGroup(gl_panelPresumed.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPresumed.createSequentialGroup().addContainerGap().addComponent(lblLucroTrimestral)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(textField_3,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(31, Short.MAX_VALUE)));
		panelPresumed.setLayout(gl_panelPresumed);

		JLabel lblFirstTrimester = new JLabel("Primeiro Trimestre");

		firstTrimester = new JTextField();
		firstTrimester.setColumns(10);

		JLabel lblSecondTrimester = new JLabel("Segundo Trimestre");

		secondTrimester = new JTextField();
		secondTrimester.setColumns(10);

		JLabel lblThirdTrimester = new JLabel("Terceiro Semestre");

		thirdTrimester = new JTextField();
		thirdTrimester.setColumns(10);
		GroupLayout gl_panelReal = new GroupLayout(panelReal);
		gl_panelReal.setHorizontalGroup(gl_panelReal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelReal.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelReal.createParallelGroup(Alignment.LEADING).addComponent(lblFirstTrimester)
								.addComponent(firstTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSecondTrimester)
								.addComponent(secondTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblThirdTrimester).addComponent(thirdTrimester,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(90, Short.MAX_VALUE)));
		gl_panelReal.setVerticalGroup(gl_panelReal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelReal.createSequentialGroup().addContainerGap().addComponent(lblFirstTrimester)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(firstTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblSecondTrimester)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(secondTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblThirdTrimester)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(thirdTrimester,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(164, Short.MAX_VALUE)));
		panelReal.setLayout(gl_panelReal);

		JLabel lblQualOTipo = new JLabel("Qual o tipo de regimento?");

		JList listTypeRegiment = new JList(typeRegiment);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblQualOTipo)
						.addComponent(listTypeRegiment, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(21, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(lblQualOTipo)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(listTypeRegiment, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
						.addContainerGap()));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

		listTypeRegiment.setVisibleRowCount(1);
		listTypeRegiment.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getContentPane().add(new JScrollPane(listTypeRegiment));

		panelReal.setVisible(false);
		panelPresumed.setVisible(false);
		panelTotal.setVisible(false);
		listTypeRegiment.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (listTypeRegiment.getSelectedValue().equals("Lucro Real")) {
					panelReal.setVisible(true);
					panelTotal.setVisible(true);
					panelPresumed.setVisible(false);
				} else {
					panelPresumed.setVisible(true);
					panelReal.setVisible(false);
					panelTotal.setVisible(true);
				}
			}
		});
		
		btnCalcular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(listTypeRegiment.getSelectedValue().equals("Lucro Real")) {
					
				}
			}
		});
	}
}
