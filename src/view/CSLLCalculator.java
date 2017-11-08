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
import csll.CSLLProfixPresumed;
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
	private JTextField totalText;
	private JTextField fourthTrimestre;
	private JTextField totalFirstTrimester;
	private JTextField totalSecondTrimester;
	private JTextField totalThirdTrimester;
	private JTextField totalFourthTrimester;
	private JList listTypeRegiment;
	private JPanel panel;
	private JPanel panelReal;
	private JPanel panelTotal;
	private JLabel lblTotalAPagar;
	private JButton btnCalcular;
	private JLabel lblCsllFirstTrimester;
	private JLabel lblCsllSecondTrimester;
	private JLabel lblCsllThirdTrimester;
	private JLabel lblFirstTrimester;
	private JLabel lblSecondTrimester; 
	private JLabel lblThirdTrimester;
	private JLabel lblfourthTrimestre;
	private JLabel lblQualOTipo;

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

	public CSLLCalculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		panel = new JPanel();

		panelReal = new JPanel();

		panelTotal = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(panelReal, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panelTotal, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(14, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(panelReal, GroupLayout.PREFERRED_SIZE, 211,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addComponent(panelTotal, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))));

		lblTotalAPagar = new JLabel("Total a Pagar no Ano");

		totalText = new JTextField();
		totalText.setColumns(10);

		btnCalcular = new JButton("Calcular");

		lblCsllFirstTrimester = new JLabel("CSLL Primeiro Trimestre");

		totalFirstTrimester = new JTextField();
		totalFirstTrimester.setColumns(10);

		lblCsllSecondTrimester = new JLabel("CSLL Segundo Trimestre");

		totalSecondTrimester = new JTextField();
		totalSecondTrimester.setColumns(10);

		lblCsllThirdTrimester = new JLabel("CSLL Terceiro Trimestre");

		totalThirdTrimester = new JTextField();
		totalThirdTrimester.setColumns(10);

		JLabel lblCsllQuartoTrimestre = new JLabel("CSLL Quarto Trimestre");

		totalFourthTrimester = new JTextField();
		totalFourthTrimester.setColumns(10);
		GroupLayout gl_panelTotal = new GroupLayout(panelTotal);
		gl_panelTotal.setHorizontalGroup(gl_panelTotal.createParallelGroup(Alignment.LEADING).addGroup(gl_panelTotal
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panelTotal.createParallelGroup(Alignment.LEADING).addComponent(lblCsllFirstTrimester)
						.addComponent(totalFirstTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCsllSecondTrimester)
						.addComponent(totalSecondTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCsllThirdTrimester)
						.addComponent(totalThirdTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCsllQuartoTrimestre)
						.addComponent(totalFourthTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTotalAPagar)
						.addComponent(totalText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCalcular))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panelTotal.setVerticalGroup(gl_panelTotal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTotal.createSequentialGroup().addContainerGap().addComponent(lblCsllFirstTrimester)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(totalFirstTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblCsllSecondTrimester)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(totalSecondTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblCsllThirdTrimester)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(totalThirdTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblCsllQuartoTrimestre)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(totalFourthTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblTotalAPagar)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(totalText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnCalcular)
						.addContainerGap(27, Short.MAX_VALUE)));
		panelTotal.setLayout(gl_panelTotal);

		lblFirstTrimester = new JLabel("Lucro Primeiro Trimestre");

		firstTrimester = new JTextField();
		firstTrimester.setColumns(10);

		lblSecondTrimester = new JLabel("Lucro Segundo Trimestre");

		secondTrimester = new JTextField();
		secondTrimester.setColumns(10);

		lblThirdTrimester = new JLabel("Lucro Terceiro Trimestre");

		thirdTrimester = new JTextField();
		thirdTrimester.setColumns(10);

		lblfourthTrimestre = new JLabel("Lucro Quarto Trimestre");

		fourthTrimestre = new JTextField();
		fourthTrimestre.setColumns(10);
		GroupLayout gl_panelReal = new GroupLayout(panelReal);
		gl_panelReal.setHorizontalGroup(gl_panelReal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelReal.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelReal.createParallelGroup(Alignment.LEADING).addComponent(lblFirstTrimester)
								.addComponent(firstTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSecondTrimester)
								.addComponent(secondTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblThirdTrimester)
								.addComponent(thirdTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblfourthTrimestre).addComponent(fourthTrimestre,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(69, Short.MAX_VALUE)));
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
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(thirdTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblfourthTrimestre)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(fourthTrimestre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelReal.setLayout(gl_panelReal);

		lblQualOTipo = new JLabel("Qual o tipo de regimento?");

		listTypeRegiment = new JList(typeRegiment);
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

		setProfitRealText(false);
		btnCalcular.setEnabled(false);
		listTypeRegiment.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (listTypeRegiment.getSelectedValue().equals("Lucro Real")) {
					setProfitRealText(true);
					cleanText();
				} else {
					setProfitRealText(true);
					cleanText();
				}
			}
		});

		btnCalcular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (listTypeRegiment.getSelectedValue().equals("Lucro Real")) {

					Validator validator = new Validator();

					boolean first = validator.validateProfit(firstTrimester.getText(),"Primeiro Trimestre");
					boolean second = validator.validateProfit(secondTrimester.getText(),"Segundo Trimestre");
					boolean third = validator.validateProfit(thirdTrimester.getText(),"Terceiro Trimestre");
					boolean fourth = validator.validateProfit(fourthTrimestre.getText(),"Quarto Trimestre");

					if ((first && second && third && fourth) == true) {
						
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
				} else {
					
					Validator validator = new Validator();

					boolean first = validator.validateProfit(firstTrimester.getText(),"Primeiro Trimestre");
					boolean second = validator.validateProfit(secondTrimester.getText(),"Segundo Trimestre");
					boolean third = validator.validateProfit(thirdTrimester.getText(),"Terceiro Trimestre");
					boolean fourth = validator.validateProfit(fourthTrimestre.getText(),"Quarto Trimestre");

					if ((first && second && third && fourth) == true) {
						
						CSLL csll = new CSLLProfixPresumed();

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

	private boolean setProfitRealText(boolean state) {
		
		if(state == true) {
			firstTrimester.setEnabled(true);
			secondTrimester.setEnabled(true);
			thirdTrimester.setEnabled(true);
			fourthTrimestre.setEnabled(true);
			totalFirstTrimester.setEnabled(false);
			totalSecondTrimester.setEnabled(false);
			totalThirdTrimester.setEnabled(false);
			totalFourthTrimester.setEnabled(false);
			totalText.setEnabled(false);
			btnCalcular.setEnabled(true);
		} else {
			firstTrimester.setEnabled(false);
			secondTrimester.setEnabled(false);
			thirdTrimester.setEnabled(false);
			fourthTrimestre.setEnabled(false);
			totalFirstTrimester.setEnabled(false);
			totalSecondTrimester.setEnabled(false);
			totalThirdTrimester.setEnabled(false);
			totalFourthTrimester.setEnabled(false);
			totalText.setEnabled(false);
			btnCalcular.setEnabled(true);
		}
		return state;
	}
	
	private void cleanText() {
		
		firstTrimester.setText("");
		secondTrimester.setText("");
		thirdTrimester.setText("");
		fourthTrimestre.setText("");
		totalFirstTrimester.setText("");
		totalSecondTrimester.setText("");
		totalThirdTrimester.setText("");
		totalFourthTrimester.setText("");
	}
}