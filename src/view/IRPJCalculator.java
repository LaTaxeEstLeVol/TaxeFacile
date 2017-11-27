package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.IRPJProfitRealStrategy;
import model.IRPJ;
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

	private static final long serialVersionUID = 1L;
	private JPanel contentPane = null;
	private String[] typeRegiment = { "Lucro Real", "Lucro Presumido" };
	private JTextField firstTrimester = null;
	private JTextField secondTrimester = null;
	private JTextField thirdTrimester = null;
	private JTextField totalText = null;
	private JTextField fourthTrimestre = null;
	private JTextField totalFirstTrimester = null;
	private JTextField totalSecondTrimester = null;
	private JTextField totalThirdTrimester = null;
	private JTextField totalFourthTrimester = null;
	private JList<?> listTypeRegiment = null;
	private JPanel panel = null;
	private JPanel panelReal = null;
	private JPanel panelTotal = null;
	private JLabel lblTotalAPagar = null;
	private JButton btnCalcular = null;
	private JLabel lblCsllFirstTrimester = null;
	private JLabel lblCsllSecondTrimester = null;
	private JLabel lblCsllThirdTrimester = null;
	private JLabel lblFirstTrimester = null;
	private JLabel lblSecondTrimester = null;
	private JLabel lblThirdTrimester = null;
	private JLabel lblfourthTrimestre = null;
	private JLabel lblQualOTipo = null;
	private JLabel lblCsllQuartoTrimestre = null;
	private Validator validator = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IRPJCalculator frame = new IRPJCalculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public IRPJCalculator() {

		super("Calculadora da IRPJ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		panel = new JPanel();
		panelReal = new JPanel();
		panelTotal = new JPanel();
		lblTotalAPagar = new JLabel("Total a Pagar no Ano");
		btnCalcular = new JButton("Calcular");
		lblIrpjFirstTrimester = new JLabel("IRPJ Primeiro Trimestre");
		totalText = new JTextField();
		totalFirstTrimester = new JTextField();
		lblIrpjSecondTrimester = new JLabel("IRPJ Segundo Trimestre");
		totalSecondTrimester = new JTextField();
		lblIrpjThirdTrimester = new JLabel("IRPJ Terceiro Trimestre");
		totalThirdTrimester = new JTextField();
		lblIrpjQuartoTrimestre = new JLabel("IRPJ Quarto Trimestre");
		totalFourthTrimester = new JTextField();
		lblFirstTrimester = new JLabel("Lucro Primeiro Trimestre");
		firstTrimester = new JTextField();
		lblSecondTrimester = new JLabel("Lucro Segundo Trimestre");
		secondTrimester = new JTextField();
		lblThirdTrimester = new JLabel("Lucro Terceiro Trimestre");
		thirdTrimester = new JTextField();
		lblfourthTrimestre = new JLabel("Lucro Quarto Trimestre");
		fourthTrimestre = new JTextField();
		lblQualOTipo = new JLabel("Qual o tipo de regimento?");
		listTypeRegiment = new JList(typeRegiment);
		
		lblTotalAPagar.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCsllFirstTrimester.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCsllSecondTrimester.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCsllThirdTrimester.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCsllQuartoTrimestre.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFirstTrimester.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSecondTrimester.setFont(new Font("Arial", Font.PLAIN, 14));
		lblThirdTrimester.setFont(new Font("Arial", Font.PLAIN, 14));
		lblfourthTrimestre.setFont(new Font("Arial", Font.PLAIN, 14));
		lblQualOTipo.setFont(new Font("Arial", Font.PLAIN, 14));
		listTypeRegiment.setFont(new Font("Arial", Font.PLAIN, 14));
		
		totalText.setFont(new Font("Arial", Font.PLAIN, 10));
		totalText.setColumns(10);
		firstTrimester.setFont(new Font("Arial", Font.PLAIN, 10));
		firstTrimester.setColumns(10);
		secondTrimester.setFont(new Font("Arial", Font.PLAIN, 10));
		secondTrimester.setColumns(10);
		thirdTrimester.setFont(new Font("Arial", Font.PLAIN, 10));
		thirdTrimester.setColumns(10);
		totalFirstTrimester.setFont(new Font("Arial", Font.PLAIN, 10));
		totalFirstTrimester.setColumns(10);
		totalSecondTrimester.setFont(new Font("Arial", Font.PLAIN, 10));
		totalSecondTrimester.setColumns(10);
		totalThirdTrimester.setFont(new Font("Arial", Font.PLAIN, 10));
		totalThirdTrimester.setColumns(10);
		totalFourthTrimester.setFont(new Font("Arial", Font.PLAIN, 10));
		totalFourthTrimester.setColumns(10);
		fourthTrimestre.setFont(new Font("Arial", Font.PLAIN, 10));
		fourthTrimestre.setColumns(10);
		btnCalcular.setFont(new Font("Arial", Font.PLAIN, 14));
		
		validator = new Validator();

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
		
		GroupLayout gl_panelTotal = new GroupLayout(panelTotal);
		gl_panelTotal.setHorizontalGroup(gl_panelTotal.createParallelGroup(Alignment.LEADING).addGroup(gl_panelTotal
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panelTotal.createParallelGroup(Alignment.LEADING).addComponent(lblCsllFirstTrimester)
						.addComponent(totalFirstTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIrpjSecondTrimester)
						.addComponent(totalSecondTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIrpjThirdTrimester)
						.addComponent(totalThirdTrimester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIrpjQuartoTrimestre)
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
				
				if (listTypeRegiment.getSelectedValue().equals("Lucro Real") || 
					listTypeRegiment.getSelectedValue().equals("Lucro Presumido")) {
	
					boolean first = validator.validateProfit(firstTrimester.getText(), "Primeiro Trimestre");
					boolean second = validator.validateProfit(secondTrimester.getText(), "Segundo Trimestre");
					boolean third = validator.validateProfit(thirdTrimester.getText(), "Terceiro Trimestre");
					boolean fourth = validator.validateProfit(fourthTrimestre.getText(), "Quarto Trimestre");

					if ((first && second && third && fourth) == true) {

						IRPJ irpj = new IRPJProfitRealStrategy();
						
						irpj.setTypeRegiment(listTypeRegiment.getSelectedValue().toString());
						irpj.setFirstTrimester(Double.parseDouble(firstTrimester.getText()));
						irpj.setSecondTrimester(Double.parseDouble(secondTrimester.getText()));
						irpj.setThirdTrimester(Double.parseDouble(thirdTrimester.getText()));
						irpj.setFourthTrimester(Double.parseDouble(fourthTrimestre.getText()));

						String finalValue = String.valueOf(validator.format(irpj.calcule(irpj)));
						String firstValue = String.valueOf(validator.format(irpj.calculeFirstTrimester(irpj)));
						String secondValue = String.valueOf(validator.format(irpj.calculeSecondTrimester(irpj)));
						String thirdValue = String.valueOf(validator.format(irpj.calculeThirdTrimester(irpj)));
						String fourthValue = String.valueOf(validator.format(irpj.calculeFourthTrimester(irpj)));

						totalFirstTrimester.setText("R$ " + firstValue);
						totalSecondTrimester.setText("R$ " + secondValue);
						totalThirdTrimester.setText("R$ " + thirdValue);
						totalFourthTrimester.setText("R$ " + fourthValue);
						totalText.setText("R$ " + finalValue + " Reais");
					}
				} else {

				}
			}
		});
	}

	private boolean setProfitRealText(boolean state) {

		if (state == true) {
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
		totalText.setText("");
	}
}
