package view;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import dao.ICMSDao;
import icms.ICMS;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;

public class ICMSCalculator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList<String> listDestiny;
	private JTextField productValueText;
	private JList<String> listOrigin;
	private ICMSDao icmsDao;
	private DefaultListModel<String> listStates = new DefaultListModel<>();
	private JTextField totalToPrayText;
	private List<ICMS> listIcms = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ICMSCalculator frame = new ICMSCalculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ICMSCalculator() {
		
		super("Calculadora de ICMS");
		icmsDao = new ICMSDao();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);		
		
		JLabel lblProductValue = new JLabel("Valor do Produto");
		
		productValueText = new JTextField();
		productValueText.setColumns(10);
		
		JLabel lblStateOrigin = new JLabel("Estado de Origem");
		
		JLabel lblStateDestiny = new JLabel("Estado de Destino");
		
		JScrollPane scrollPaneOrigin = new JScrollPane();
		
		JScrollPane scrollPaneDestiny = new JScrollPane();
		
		JLabel lblTotalToPray = new JLabel("Total a Pagar");
		
		totalToPrayText = new JTextField();
		totalToPrayText.setColumns(10);
		
		JButton btnCalcule = new JButton("Calcular");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblProductValue)
								.addComponent(productValueText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblStateOrigin))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblStateDestiny)
								.addComponent(scrollPaneOrigin, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPaneDestiny, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCalcule)
						.addComponent(lblTotalToPray)
						.addComponent(totalToPrayText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProductValue)
						.addComponent(lblTotalToPray))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(productValueText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(totalToPrayText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblStateOrigin)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPaneOrigin, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblStateDestiny)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPaneDestiny, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnCalcule))
					.addContainerGap(75, Short.MAX_VALUE))
		);
		
		listIcms = icmsDao.getListStates();
		for(int aux = 0; aux < listIcms.size(); aux ++) {
			listStates.addElement(listIcms.get(aux).getStateOrigin());
		}
		
		listDestiny = new JList<String>(listStates);
		listDestiny.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneDestiny.setViewportView(listDestiny);
		
		
		listOrigin = new JList<String>(listStates);
		listOrigin.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneOrigin.setViewportView(listOrigin);
		
		
		
		
		
		contentPane.setLayout(gl_contentPane);
		
		/*DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("USA");
        listModel.addElement("India");
        listModel.addElement("Vietnam");
        listModel.addElement("Canada");
        listModel.addElement("Denmark");
        listModel.addElement("France");
        listModel.addElement("Great Britain");
        listModel.addElement("Japan");
        listModel.addElement("France");
        listModel.addElement("Great Britain");
        listModel.addElement("Japan");
 
        //create the list
        countryList = new JList<>(listModel);
        add(countryList);
        add(new JScrollPane(countryList));
         
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JList Example");       
        this.setSize(100,100);
        this.setLocationRelativeTo(null);
        this.setVisible(true);*/
		
		
	}
}
