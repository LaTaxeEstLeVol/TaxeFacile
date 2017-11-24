package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import abstracts.PIS;
import pis.PISProfitRealStrategy;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;

public class PISCalculator extends JFrame implements ActionListener { //

	private JPanel contentPane;
	String[] list = new String[] {"Escolha...","Lucro Real", "Lucro Presumido"};
	private JTextField tFVendas;
	private JTextField tFValorTotal;
	private JTextField tFRevenda;
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
	//	comboBox.setSelectedItem(list);
		
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox combo = (JComboBox) e.getSource();
				
				Object selected = combo.getSelectedItem();
			//	PIS pisProfitReal = new PISProfitRealStrategy();
				if(selected.equals("Escolha...")) {
					opcaoEscolha();
				} else if(selected.toString().equals("Lucro Real")) {
					optionReal();
				} else if(selected.toString().equals("Lucro Presumido")) {
					optionPresumed();
				} else {
					// do nothing
				}
			}
		});
		comboBox.setBounds(48, 37, 162, 24);
		contentPane.add(comboBox);
		
		tFVendas = new JTextField();
		tFVendas.setFont(new Font("Dialog", Font.PLAIN, 12));
		tFVendas.setBounds(258, 86, 114, 24);
		contentPane.add(tFVendas);
		tFVendas.setColumns(10);
		
		tFValorTotal = new JTextField();
		tFValorTotal.setBounds(258, 189, 114, 21);
		contentPane.add(tFValorTotal);
		tFValorTotal.setColumns(10);
		
		lblVendaMes = new JLabel("Vendas no mês");
		lblVendaMes.setBounds(58, 90, 157, 15);
		contentPane.add(lblVendaMes);
		
		lblValorTotal = new JLabel("Valor a pagar:");
		lblValorTotal.setBounds(122, 192, 114, 15);
		contentPane.add(lblValorTotal);
		
		lbRevenda = new JLabel("Compras para revenda");
		lbRevenda.setBounds(58, 136, 172, 15);
		contentPane.add(lbRevenda);
		
		tFRevenda = new JTextField();
		tFRevenda.setBounds(258, 129, 114, 24);
		contentPane.add(tFRevenda);
		tFRevenda.setColumns(10);
		
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
				
				
				
			}
		});
		btnCalcular.setBounds(345, 236, 91, 25);
		contentPane.add(btnCalcular);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
/*		PIS pisProfitReal = new PISProfitRealStrategy();
		if(selectedProfit.equals("Escolha...")) {
			
		} else if(selectedProfit.equals("Lucro Real")) {
			JOptionPane.showMessageDialog(null, "REAaaaaaL");
			//pisProfitReal..PISProfitRealStrategy();
		} else if (selectedProfit == "Lucro Presumido") {
			//pis.PISProfitPresumedStrategy();
			JOptionPane.showMessageDialog(null, "PRESUMIDO");
		} else {
			JOptionPane.showMessageDialog(null, "Opção indisponível");
		}*/
		
	}
	
	private void index() {
		Index index  = new Index();
		index.setVisible(true);
		dispose();	
	}
	
	private void opcaoEscolha() {
		tFVendas.setEnabled(false);
		tFRevenda.setEnabled(false);
		tFValorTotal.setEnabled(false);
		lblVendaMes.setVisible(true);
		lblValorTotal.setVisible(true);
		lbRevenda.setVisible(true);
	}

	private void optionReal() { //boolean optionReal(boolean state) {
		tFVendas.setEnabled(true);
		tFRevenda.setEnabled(true);
		tFValorTotal.setEnabled(true);
		lblVendaMes.setVisible(true);
		lblValorTotal.setVisible(true);
		lbRevenda.setVisible(true);
		
		//return state
	}

	private void optionPresumed() {
		tFVendas.setEnabled(true);
		tFRevenda.setEnabled(false);
		tFRevenda.setVisible(false);
		tFValorTotal.setEnabled(true);
		lblVendaMes.setVisible(true);
		lblValorTotal.setVisible(true);
		lbRevenda.setVisible(false);
	}
	
	private void cleanText() {
		tFVendas.setText("");
		tFRevenda.setText("");
		tFValorTotal.setText("");
	}
}
