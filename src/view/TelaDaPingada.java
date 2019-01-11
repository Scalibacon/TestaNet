package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.TestadorDePing;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaDaPingada extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtQuedas, txtIp, txtTempo, txtMedia;
	private JTextArea txtAreaCmd;
	private JScrollPane scrollpane;
	private JButton btnStart;
	private JLabel lblPseudocmd, lblQuedas, lblMedia;
	
	private TestadorDePing testadorDePing;

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
		super("Um teste pro foxtrotos");
		setTitle("Testador de Ping \u2665");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPseudocmd = new JLabel("PseudoCMD");
		lblPseudocmd.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblPseudocmd.setBounds(176, 6, 97, 24);
		contentPane.add(lblPseudocmd);
		
		txtAreaCmd = new JTextArea();
		txtAreaCmd.setEditable(false);
		txtAreaCmd.setBounds(10, 38, 400, 250);
		
		scrollpane = new JScrollPane(txtAreaCmd);
		scrollpane.setBounds(10, 38, 400, 250);
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
		btnStart.setBounds(420, 256, 89, 32);
		contentPane.add(btnStart);		
		
		txtIp = new JTextField("8.8.8.8");
		txtIp.setFont(new Font("Verdana", Font.PLAIN, 13));
		txtIp.setColumns(10);
		txtIp.setBounds(417, 96, 97, 26);
		contentPane.add(txtIp);
		
		JLabel lblIp = new JLabel("IP para Teste");
		lblIp.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblIp.setBounds(417, 72, 97, 14);
		contentPane.add(lblIp);
		
		txtTempo = new JTextField();
		txtTempo.setFont(new Font("Verdana", Font.PLAIN, 15));
		txtTempo.setEditable(false);
		txtTempo.setColumns(10);
		txtTempo.setBounds(417, 159, 97, 26);
		contentPane.add(txtTempo);
		
		JLabel lblTempoCorrido = new JLabel("Tempo Corrido");
		lblTempoCorrido.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblTempoCorrido.setBounds(417, 135, 97, 14);
		contentPane.add(lblTempoCorrido);
		
		lblMedia = new JLabel("M\u00E9dia");
		lblMedia.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblMedia.setBounds(417, 195, 97, 14);
		contentPane.add(lblMedia);
		
		txtMedia = new JTextField();
		txtMedia.setFont(new Font("Verdana", Font.PLAIN, 15));
		txtMedia.setEditable(false);
		txtMedia.setColumns(10);
		txtMedia.setBounds(417, 219, 97, 26);
		contentPane.add(txtMedia);
		
		testadorDePing = new TestadorDePing(txtAreaCmd, txtQuedas, btnStart, txtIp, txtTempo);		
		btnStart.addActionListener(testadorDePing);	      
	        
	}
}
