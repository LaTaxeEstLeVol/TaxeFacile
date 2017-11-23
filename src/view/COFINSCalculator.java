package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.COFINSProfitPresumedStrategy;
import controller.COFINSProfitRealStrategy;
import model.COFINS;
import services.Validator;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class COFINSCalculator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane = null;
	private String[] typeRegiment = { "Lucro Real", "Lucro Presumido" };
	private JList<?> typeRegimentList = null;
	private JTextField salesMonthText = null;
	private JTextField resalesText = null;
	private JTextField totalToPay = null;
	private JPanel panelTotal = null;
	private JLabel lblsalesMonth = null;
	private JLabel lblResales = null;
	private GroupLayout gl_panel = null;
	private JPanel panel = null;
	private JLabel lblTotal = null;
	private JButton btnCalcule = null;
	private GroupLayout gl_panelTotal = null;
	private Validator validator = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					COFINSCalculator frame = new COFINSCalculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public COFINSCalculator() {

		super("Calculadora do COFINS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		typeRegimentList = new JList(typeRegiment);
		lblsalesMonth = new JLabel("Vendas no mês");
		lblResales = new JLabel("Compras pra Revendas");
		panelTotal = new JPanel();
		salesMonthText = new JTextField();
		resalesText = new JTextField();
		lblTotal = new JLabel("Total a Pagar ");
		btnCalcule = new JButton("Calcular");
		totalToPay = new JTextField();
		gl_panelTotal = new GroupLayout(panelTotal);
		
		typeRegimentList.setFont(new Font("Arial", Font.PLAIN, 14));
		lblsalesMonth.setFont(new Font("Arial", Font.PLAIN, 14));
		lblResales.setFont(new Font("Arial", Font.PLAIN, 14));
		salesMonthText.setFont(new Font("Arial", Font.PLAIN, 14));
		salesMonthText.setFont(new Font("Arial", Font.PLAIN, 14));
		resalesText.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTotal.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCalcule.setFont(new Font("Arial", Font.PLAIN, 14));
		totalToPay.setFont(new Font("Arial", Font.PLAIN, 14));
		
		salesMonthText.setColumns(10);		
		resalesText.setColumns(10);
		
		validator = new Validator();
		
		panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(24)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(typeRegimentList, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(panelTotal, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(13, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_contentPane.createSequentialGroup().addContainerGap().addComponent(typeRegimentList).addGap(36)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panelTotal, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 150,
										Short.MAX_VALUE)
								.addComponent(panel, Alignment.LEADING, 0, 0, Short.MAX_VALUE))
						.addGap(32)));

		gl_panel = new GroupLayout(panel);

		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblsalesMonth)
								.addComponent(salesMonthText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblResales).addComponent(resalesText, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(17, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(lblsalesMonth)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(salesMonthText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblResales)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(resalesText,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(102, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		
		totalToPay.setColumns(10);
		
		gl_panelTotal.setHorizontalGroup(gl_panelTotal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTotal.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelTotal.createParallelGroup(Alignment.LEADING).addComponent(lblTotal)
								.addComponent(btnCalcule).addComponent(totalToPay, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(18, Short.MAX_VALUE)));
		gl_panelTotal.setVerticalGroup(gl_panelTotal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTotal.createSequentialGroup().addContainerGap().addComponent(lblTotal)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(totalToPay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE).addComponent(btnCalcule)
						.addGap(30)));
		panelTotal.setLayout(gl_panelTotal);
		contentPane.setLayout(gl_contentPane);

		lblResales.setVisible(false);
		salesMonthText.setEnabled(false);
		resalesText.setVisible(false);
		totalToPay.setEnabled(false);
		btnCalcule.setEnabled(false);
		totalToPay.setEnabled(false);

		typeRegimentList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				if (typeRegimentList.getSelectedValue().equals("Lucro Real")) {

					setLblText(false);
					cleanText();
				} else {
					setLblText(true);
					cleanText();
				}
			}
		});

		btnCalcule.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (typeRegimentList.getSelectedValue().equals("Lucro Real")) {

					boolean sales = validator.validateSalary(salesMonthText.getText());
					boolean resales = validator.validateSalary(resalesText.getText());

					if ((sales && resales) == true ) {

						COFINS cofins = new COFINSProfitRealStrategy();

						cofins.setTypeRegiment(typeRegimentList.getSelectedValue().toString());
						cofins.setMonthlyIncome(Double.parseDouble(salesMonthText.getText()));
						cofins.setAccreditedPurchase(Double.parseDouble(resalesText.getText()));

						String finalValue = String.valueOf(validator.format(cofins.calcule(cofins)));

						totalToPay.setText("RS " + finalValue + " Reais");
					}
				} else {

					boolean sales = validator.validateSalary(salesMonthText.getText());
					
					if(sales) {
						
						COFINS cofins = new COFINSProfitPresumedStrategy();
						
						cofins.setTypeRegiment(typeRegimentList.getSelectedValue().toString());
						cofins.setMonthlyIncome(Double.parseDouble(salesMonthText.getText()));
						
						String finalValue = String.valueOf(validator.format(cofins.calcule(cofins)));
						
						totalToPay.setText("R$ " + finalValue + " Reais");
					}
				}
			}
		});
	}

	private boolean setLblText(boolean state) {

		if (state == true) {

			salesMonthText.setEnabled(true);
			lblResales.setVisible(false);
			resalesText.setVisible(false);
			totalToPay.setEnabled(false);
			btnCalcule.setEnabled(true);
		} else {

			lblResales.setVisible(true);
			resalesText.setVisible(true);
			salesMonthText.setEnabled(true);
			resalesText.setEnabled(true);
			totalToPay.setEnabled(false);
			btnCalcule.setEnabled(true);
		}
		return state;
	}

	private void cleanText() {

		salesMonthText.setText("");
		resalesText.setText("");
		totalToPay.setText("");
	}
}
