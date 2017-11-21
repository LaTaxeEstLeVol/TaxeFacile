package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import abstracts.TemplateFGTS;
import fgts.FGTS;
import services.Validator;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class FGTSCalculator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField grossSalaryText;
	private JLabel lblMonthWorked;
	private JTextField monthWorkedText;
	private JLabel lblFGTSAccumulated;
	private JTextField fgtsAccumulatedText;
	private JLabel lblDepositedAmount;
	private JTextField depositedAmountText;
	private JPanel panel;
	private JLabel lblGrossSalaryText;
	private JButton btnCalcule;
	private JButton btnClear;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FGTSCalculator frame = new FGTSCalculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FGTSCalculator() {
		
		super("Calculadora de FGTS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new JPanel();
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		
		lblGrossSalaryText = new JLabel("Salário Bruto");
		grossSalaryText = new JTextField();
		lblMonthWorked = new JLabel("Meses Trabalhados");
		monthWorkedText = new JTextField();
		lblFGTSAccumulated = new JLabel("Saldo do FGTS Acumulado");
		fgtsAccumulatedText = new JTextField();
		lblDepositedAmount = new JLabel("Valor Depositado Mensal");
		depositedAmountText = new JTextField();
		btnCalcule = new JButton("Calcular");
		btnClear = new JButton("Limpar");
		
		lblGrossSalaryText.setFont(new Font("Arial", Font.PLAIN, 14));
		grossSalaryText.setFont(new Font("Arial", Font.PLAIN, 12));
		grossSalaryText.setColumns(10);
		lblMonthWorked.setFont(new Font("Arial", Font.PLAIN, 14));
		monthWorkedText.setFont(new Font("Arial", Font.PLAIN, 12));
		monthWorkedText.setColumns(10);
		lblFGTSAccumulated.setFont(new Font("Arial", Font.PLAIN, 14));
		fgtsAccumulatedText.setFont(new Font("Arial", Font.PLAIN, 12));
		fgtsAccumulatedText.setEnabled(false);
		fgtsAccumulatedText.setColumns(10);
		lblDepositedAmount.setFont(new Font("Arial", Font.PLAIN, 14));
		depositedAmountText.setFont(new Font("Arial", Font.PLAIN, 12));
		depositedAmountText.setEnabled(false);
		depositedAmountText.setColumns(10);
		btnCalcule.setFont(new Font("Arial", Font.PLAIN, 14));
		btnClear.setFont(new Font("Arial", Font.PLAIN, 14));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblGrossSalaryText)
								.addComponent(grossSalaryText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMonthWorked)
								.addComponent(monthWorkedText, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(39)
							.addComponent(btnCalcule)))
					.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(depositedAmountText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(fgtsAccumulatedText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFGTSAccumulated)
								.addComponent(lblDepositedAmount))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(btnClear)
							.addGap(32))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGrossSalaryText)
						.addComponent(lblFGTSAccumulated))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(grossSalaryText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(fgtsAccumulatedText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMonthWorked)
						.addComponent(lblDepositedAmount))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(monthWorkedText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(depositedAmountText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(59)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCalcule)
						.addComponent(btnClear))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		btnCalcule.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Validator validator = new Validator();
				
				boolean salary = validator.validateSalary(grossSalaryText.getText());
				boolean months = validator.validateMonths(monthWorkedText.getText());
				
				if((salary && months) == true) {
					
					TemplateFGTS fgts = new FGTS();
					
					fgts.setGrossSalary(Double.parseDouble(grossSalaryText.getText()));
					fgts.setMonthsWorked(Integer.parseInt(monthWorkedText.getText()));
					
					String fgtsAccumulated = String.valueOf(fgts.calculeDepositedAmount(fgts));
					String depositedAmount = String.valueOf(fgts.calcule(fgts));
					
					depositedAmountText.setText(fgtsAccumulated);
					fgtsAccumulatedText.setText(depositedAmount);
				}
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				clearText();
			}
		});
	}
	
	private void clearText() {
		
		grossSalaryText.setText("");
		monthWorkedText.setText("");
		depositedAmountText.setText("");
		fgtsAccumulatedText.setText("");
	}
}