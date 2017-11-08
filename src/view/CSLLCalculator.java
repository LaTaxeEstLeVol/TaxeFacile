package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import abstracts.CSLL;
import csll.CSLLProfitReal;
import services.Validator;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CSLLCalculator extends JFrame {

	private JPanel contentPane;
	private String[] typeRegiment = { "Lucro Real", "Lucro Presumido" };
	private JTextField firstTrimester;
	private JTextField secondTrimester;
	private JTextField thirdTrimester;
	private JTextField profixTrimestral;
	private JTextField totalText;
	private JTextField fourthTrimestre;
	private JTextField totalFirstTrimester;
	private JTextField totalSecondTrimester;
	private JTextField totalThirdTrimester;
	private JTextField totalFourthTrimester;

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
		setBounds(100, 100, 450, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();

		JPanel panelReal = new JPanel();
		panelReal.setVisible(false);

		JPanel panelPresumed = new JPanel();

		JPanel panelTotal = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelPresumed, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panelReal, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelTotal, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelPresumed, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panelReal, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addComponent(panelTotal, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)))
		);

		JLabel lblTotalAPagar = new JLabel("Total a Pagar");

		totalText = new JTextField();
		totalText.setColumns(10);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblCsllFirstTrimester = new JLabel("CSLL Primeiro Trimestre");
		
		totalFirstTrimester = new JTextField();
		totalFirstTrimester.setColumns(10);
		
		JLabel lblCsllSecondTrimester = new JLabel("CSLL Segundo Trimestre");
		
		totalSecondTrimester = new JTextField();
		totalSecondTrimester.setColumns(10);
		
		JLabel lblCsllThirdTrimester = new JLabel("CSLL Terceiro Trimestre");
		
		totalThirdTrimester = new JTextField();
		totalThirdTrimester.setColumns(10);
		
		JLabel lblCsllQuartoTrimestre = new JLabel("CSLL Quarto Trimestre");
		
		totalFourthTrimester = new JTextField();
		totalFourthTrimester.setColumns(10);
		GroupLayout gl_panelTotal = new GroupLayout(panelTotal);
		gl_panelTotal.setHorizontalGroup(
			gl_panelTotal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTotal.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelTotal.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCsllFirstTrimester)
						.addComponent(totalFirstTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCsllSecondTrimester)
						.addComponent(totalSecondTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCsllThirdTrimester)
						.addComponent(totalThirdTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCsllQuartoTrimestre)
						.addComponent(totalFourthTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTotalAPagar)
						.addComponent(totalText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCalcular))
					.addContainerGap(5, Short.MAX_VALUE))
		);
		gl_panelTotal.setVerticalGroup(
			gl_panelTotal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTotal.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCsllFirstTrimester)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(totalFirstTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblCsllSecondTrimester)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(totalSecondTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCsllThirdTrimester)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(totalThirdTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCsllQuartoTrimestre)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(totalFourthTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblTotalAPagar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(totalText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCalcular)
					.addContainerGap(55, Short.MAX_VALUE))
		);
		panelTotal.setLayout(gl_panelTotal);

		JLabel lblLucroTrimestral = new JLabel("Lucro Trimestral");

		profixTrimestral = new JTextField();
		profixTrimestral.setColumns(10);
		GroupLayout gl_panelPresumed = new GroupLayout(panelPresumed);
		gl_panelPresumed.setHorizontalGroup(gl_panelPresumed.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPresumed.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelPresumed.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLucroTrimestral).addComponent(profixTrimestral, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(63, Short.MAX_VALUE)));
		gl_panelPresumed.setVerticalGroup(gl_panelPresumed.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPresumed.createSequentialGroup().addContainerGap().addComponent(lblLucroTrimestral)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(profixTrimestral,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(31, Short.MAX_VALUE)));
		panelPresumed.setLayout(gl_panelPresumed);

		JLabel lblFirstTrimester = new JLabel("Lucro Primeiro Trimestre");

		firstTrimester = new JTextField();
		firstTrimester.setColumns(10);

		JLabel lblSecondTrimester = new JLabel("Lucro Segundo Trimestre");

		secondTrimester = new JTextField();
		secondTrimester.setColumns(10);

		JLabel lblThirdTrimester = new JLabel("Lucro Terceiro Trimestre");

		thirdTrimester = new JTextField();
		thirdTrimester.setColumns(10);
		
		JLabel lblfourthTrimestre = new JLabel("Lucro Quarto Trimestre");
		
		fourthTrimestre = new JTextField();
		fourthTrimestre.setColumns(10);
		GroupLayout gl_panelReal = new GroupLayout(panelReal);
		gl_panelReal.setHorizontalGroup(
			gl_panelReal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelReal.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelReal.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFirstTrimester)
						.addComponent(firstTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSecondTrimester)
						.addComponent(secondTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblThirdTrimester)
						.addComponent(thirdTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblfourthTrimestre)
						.addComponent(fourthTrimestre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(69, Short.MAX_VALUE))
		);
		gl_panelReal.setVerticalGroup(
			gl_panelReal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelReal.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFirstTrimester)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(firstTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSecondTrimester)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(secondTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblThirdTrimester)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(thirdTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblfourthTrimestre)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(fourthTrimestre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
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
					
					Validator validator = new Validator();
					
					boolean first = validator.validateProfit(firstTrimester.getText());
					boolean second = validator.validateProfit(secondTrimester.getText());
					boolean third = validator.validateProfit(thirdTrimester.getText());
					boolean fourth = validator.validateProfit(fourthTrimestre.getText());
					
					if((first && second && third && fourth) == true) {
						
						CSLL csll = new CSLLProfitReal();
						
						csll.setFirstTrimester(Double.parseDouble(firstTrimester.getText()));
						csll.setSecondTrimester(Double.parseDouble(secondTrimester.getText()));
						csll.setThirdTrimester(Double.parseDouble(thirdTrimester.getText()));
						csll.setFourthTrimester(Double.parseDouble(fourthTrimestre.getText()));
						
						String finalValue = String.valueOf(csll.calcule(csll));
						String firstValue = String.valueOf(csll.firstTrimester(csll));
						String secondValue = String.valueOf(csll.secondTrimester(csll));
						String thirdValue = String.valueOf(csll.thirdTrimester(csll));
						String fourthValue = String.valueOf(csll.fourthTrimester(csll));
						
						totalFirstTrimester.setText("RS " + firstValue);
						totalSecondTrimester.setText("RS " + secondValue);
						totalThirdTrimester.setText("RS " + thirdValue);
						totalFourthTrimester.setText("RS " + fourthValue);
						totalText.setText("RS " + finalValue);
					}
				}
			}
		});
	}
}