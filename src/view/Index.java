package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Index extends JFrame {
	
	//private Imposto imposto;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
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
	public Index() {
		
		super("Calculadora de Impostos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIss = new JButton("ISS");
		btnIss.setBounds(37, 102, 117, 25);
		contentPane.add(btnIss);
		
		JButton btnIpi = new JButton("COFINS");
		btnIpi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cofins();
			}
		});
		btnIpi.setBounds(181, 102, 117, 25);
		contentPane.add(btnIpi);
		
		JButton btnPis = new JButton("PIS");
		btnPis.setBounds(319, 102, 117, 25);
		contentPane.add(btnPis);
		
		JButton btnFgts = new JButton("FGTS");
		btnFgts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fgts();
			}
		});
		btnFgts.setBounds(118, 139, 117, 25);
		contentPane.add(btnFgts);
		
		JButton btnCsll = new JButton("CSLL");
		btnCsll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csll();
			}
		});
		btnCsll.setBounds(247, 139, 117, 25);
		contentPane.add(btnCsll);
		
		//implementar fachada
	}
	
	private void cofins() {
		COFINSCalculator cofinsFrame = new COFINSCalculator();
		cofinsFrame.setVisible(true);
		dispose();	
	}
	
	private void fgts() {
		FGTSCalculator fgtsFrame = new FGTSCalculator();
		fgtsFrame.setVisible(true);
		dispose();	
	}
	
	private void csll() {
		CSLLCalculator csllFrame = new CSLLCalculator();
		csllFrame.setVisible(true);
		dispose();	
	}
	//Receita entrar no banco? 
	//this.imposto = new Imposto();
	
}
