package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.PIS;
import controller.PISProfitPresumedStrategy;
import controller.PISProfitRealStrategy;
import services.Validator;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;

public class PISCalculator extends JFrame { 

	private JPanel contentPane;
	String[] list = new String[] { "Escolha...", "Lucro Real", "Lucro Presumido" };
	private JTextField tFSales;
	private JTextField tFTotal;
	private JTextField tFResales;
	private JLabel lblVendaMes;
	private JLabel lblValorTotal;
	private JLabel lbRevenda;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PISCalculator frame = new PISCalculator();
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
	public PISCalculator() {
		super("Calculadora do PIS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox<String> comboBox = new JComboBox(list);
		// comboBox.setSelectedItem(list);

		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox combo = (JComboBox) e.getSource();

				Object selected = combo.getSelectedItem();
				if (selected.equals("Escolha...")) {
					opcaoEscolha();
					cleanText();
				} else if (selected.toString().equals("Lucro Real")) {
					optionReal();
					cleanText();
				} else if (selected.toString().equals("Lucro Presumido")) {
					optionPresumed();
					cleanText();
				} else {
					// do nothing
				}
			}
		});
		comboBox.setBounds(48, 37, 162, 24);
		contentPane.add(comboBox);

		tFSales = new JTextField();
		tFSales.setFont(new Font("Dialog", Font.PLAIN, 12));
		tFSales.setBounds(258, 86, 114, 24);
		contentPane.add(tFSales);
		tFSales.setColumns(10);

		tFTotal = new JTextField();
		tFTotal.setBounds(258, 189, 114, 21);
		contentPane.add(tFTotal);
		tFTotal.setColumns(10);

		lblVendaMes = new JLabel("Vendas no mês");
		lblVendaMes.setBounds(58, 90, 157, 15);
		contentPane.add(lblVendaMes);

		lblValorTotal = new JLabel("Valor a pagar:");
		lblValorTotal.setBounds(122, 192, 114, 15);
		contentPane.add(lblValorTotal);

		lbRevenda = new JLabel("Compras para revenda");
		lbRevenda.setBounds(58, 136, 172, 15);
		contentPane.add(lbRevenda);

		tFResales = new JTextField();
		tFResales.setBounds(258, 129, 114, 24);
		contentPane.add(tFResales);
		tFResales.setColumns(10);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index();
			}
		});
		btnVoltar.setBounds(12, 236, 87, 25);
		contentPane.add(btnVoltar);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Object selected = comboBox.getSelectedItem();
				if (selected.equals("Escolha...")) {
					// do nothing
				} else if (selected.toString().equals("Lucro Real")) {
					Validator validator = new Validator();

					boolean sales = validator.validateSalary(tFSales.getText());
					boolean resales = validator.validateSalary(tFResales.getText());

					if ((sales && resales) == true) {

						PIS pis = new PISProfitRealStrategy();
						
						pis.setTypeRegiment("Lucro Real");
						pis.setMonthlyIncome(Double.parseDouble(tFSales.getText()));
						pis.setAccreditedPurchase(Double.parseDouble(tFResales.getText()));

						String finalValue = String.valueOf(validator.format(pis.calcule(pis)));

						tFTotal.setText("RS " + finalValue + " Reais");
					}

				} else if (selected.toString().equals("Lucro Presumido")) {
					Validator validator = new Validator();

					boolean sales = validator.validateSalary(tFSales.getText());

					if (sales) {

						PIS pis = new PISProfitPresumedStrategy();
						
						pis.setTypeRegiment("Lucro Presumido");
						pis.setMonthlyIncome(Double.parseDouble(tFSales.getText()));

						String finalValue = String.valueOf(validator.format(pis.calcule(pis)));

						tFTotal.setText("RS " + finalValue + " Reais");
					}

				} else {
					// do nothing
				}

			}
		});
		getContentPane().add(comboBox);
		getContentPane().add(tFTotal);
		
		btnCalcular.setBounds(345, 236, 91, 25);
		contentPane.add(btnCalcular);
	}

	private void index() {
		Index index = new Index();
		index.setVisible(true);
		dispose();
	}

	private void opcaoEscolha() {
		tFSales.setEnabled(false);
		tFResales.setEnabled(false);
		tFTotal.setEnabled(false);
		lblVendaMes.setVisible(true);
		lblValorTotal.setVisible(true);
		lbRevenda.setVisible(true);
	}

	private void optionReal() { 
		tFSales.setVisible(true);
		tFSales.setEnabled(true);
		tFResales.setVisible(true);
		tFResales.setEnabled(true);
		tFTotal.setVisible(true);
		tFTotal.setEnabled(false);
		lblVendaMes.setVisible(true);
		lblValorTotal.setVisible(true);
		lbRevenda.setVisible(true);
	}

	private void optionPresumed() {
		tFSales.setVisible(true);
		tFSales.setEnabled(true);
		tFResales.setVisible(false);
		tFResales.setEnabled(false);
		tFTotal.setVisible(true);
		tFTotal.setEnabled(false);
		lblVendaMes.setVisible(true);
		lblValorTotal.setVisible(true);
		lbRevenda.setVisible(false);
	}

	private void cleanText() {
		tFSales.setText("");
		tFResales.setText("");
		tFTotal.setText("");
	}
}
