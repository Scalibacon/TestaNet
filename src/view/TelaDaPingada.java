package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import controller.TestarPingController;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaDaPingada extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtQuedas;
	private JTextArea txtAreaCmd;
	private JScrollPane scrollpane;
	private JButton btnStart;
	private JLabel lblPseudocmd, lblQuedas;
	
	private TestarPingController testadorDePing;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Estilo estilo = new Estilo();
					estilo.aplicarEstilo();
					TelaDaPingada frame = new TelaDaPingada();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaDaPingada() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPseudocmd = new JLabel("PseudoCMD");
		lblPseudocmd.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblPseudocmd.setBounds(176, 3, 97, 24);
		contentPane.add(lblPseudocmd);
		
		txtAreaCmd = new JTextArea();
		txtAreaCmd.setEditable(false);
		txtAreaCmd.setBounds(10, 38, 400, 190);
		
		scrollpane = new JScrollPane(txtAreaCmd);
		scrollpane.setBounds(10, 38, 400, 190);
		contentPane.add(scrollpane);				
		
		txtQuedas = new JTextField();
		txtQuedas.setEditable(false);
		txtQuedas.setFont(new Font("Verdana", Font.PLAIN, 15));
		txtQuedas.setBounds(417, 35, 97, 26);
		contentPane.add(txtQuedas);
		txtQuedas.setColumns(10);
		
		lblQuedas = new JLabel("N\u00B0 de Quedas");
		lblQuedas.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblQuedas.setBounds(417, 11, 97, 14);
		contentPane.add(lblQuedas);		
		
		btnStart = new JButton("Iniciar");
		btnStart.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnStart.setBounds(417, 196, 89, 32);
		contentPane.add(btnStart);
		
		testadorDePing = new TestarPingController(txtAreaCmd, txtQuedas);
		btnStart.addActionListener(testadorDePing);		
		
	}
}
