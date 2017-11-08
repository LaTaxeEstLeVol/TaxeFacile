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
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Calculator extends JFrame {

	private JPanel contentPane;
	private JTextField firstTrimesterText;
	private JTextField secondTrimesterText;
	private JTextField thirdTrimesterText;
	private JTextField textField_3;
	private String[] typeRegiment = { "Lucro Real", "Lucro Presumido" };


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
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
	public Calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTypeRegiment = new JLabel("Qual o tipo de regimento?");
		
		JList listTypeRegiment = new JList(typeRegiment);
		listTypeRegiment.setVisibleRowCount(1);
		listTypeRegiment.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getContentPane().add(new JScrollPane(listTypeRegiment));
		
		listTypeRegiment.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(listTypeRegiment.getSelectedValue().equals("Lucro Real")) {
					System.out.println("bitcoin");
				} else {
					System.out.println();
				}
			}
		});
		
		JPanel panelReal = new JPanel();
		
		JPanel panelTax = new JPanel();
		
		JButton btnVoltar = new JButton("Voltar");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTypeRegiment)
						.addComponent(listTypeRegiment, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panelReal, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panelTax, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(btnVoltar)))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblTypeRegiment)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(listTypeRegiment, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panelTax, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnVoltar))
						.addComponent(panelReal, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JLabel lblTotal = new JLabel("Total a pagar");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GroupLayout gl_panelTax = new GroupLayout(panelTax);
		gl_panelTax.setHorizontalGroup(
			gl_panelTax.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTax.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelTax.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTotal)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_panelTax.setVerticalGroup(
			gl_panelTax.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTax.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTotal)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(140, Short.MAX_VALUE))
		);
		panelTax.setLayout(gl_panelTax);
		
		JLabel lblFirstTrimester = new JLabel("Primeiro Trimestre");
		
		firstTrimesterText = new JTextField();
		firstTrimesterText.setColumns(10);
		
		JLabel lblSecondTrimester = new JLabel("Segundo Trimestre");
		
		secondTrimesterText = new JTextField();
		secondTrimesterText.setColumns(10);
		
		JLabel lblThirdTrimester = new JLabel("Terceiro Trimestre");
		
		thirdTrimesterText = new JTextField();
		thirdTrimesterText.setColumns(10);
		GroupLayout gl_panelReal = new GroupLayout(panelReal);
		gl_panelReal.setHorizontalGroup(
			gl_panelReal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelReal.createSequentialGroup()
					.addGap(12)
					.addGroup(gl_panelReal.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelReal.createParallelGroup(Alignment.LEADING)
							.addComponent(firstTrimesterText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblSecondTrimester)
							.addComponent(secondTrimesterText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblThirdTrimester))
						.addGroup(gl_panelReal.createSequentialGroup()
							.addGroup(gl_panelReal.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFirstTrimester)
								.addComponent(thirdTrimesterText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(119, Short.MAX_VALUE))))
		);
		gl_panelReal.setVerticalGroup(
			gl_panelReal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelReal.createSequentialGroup()
					.addGap(12)
					.addComponent(lblFirstTrimester)
					.addGap(6)
					.addComponent(firstTrimesterText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblSecondTrimester)
					.addGap(12)
					.addComponent(secondTrimesterText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(lblThirdTrimester)
					.addGap(6)
					.addComponent(thirdTrimesterText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		panelReal.setLayout(gl_panelReal);
		contentPane.setLayout(gl_contentPane);
	}
}
