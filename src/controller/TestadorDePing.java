package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TestadorDePing implements ActionListener {
	private JTextArea txtAreaCmd;
	private JTextField txtQuedas, txtIp, txtTempo;
	private JButton btnStart;
	public static boolean pingando = false;

	public TestadorDePing(JTextArea txtAreaCmd, JTextField txtQuedas, JButton btnStart, JTextField txtIp,
			JTextField txtTempo) {
		this.txtAreaCmd = txtAreaCmd;
		this.txtQuedas = txtQuedas;
		this.btnStart = btnStart;
		this.txtTempo = txtTempo;
		this.txtIp = txtIp;
	}

	public void actionPerformed(ActionEvent arg0) {
		if (!pingando) {
			pingando = true;
			txtAreaCmd.setText("");
			txtQuedas.setText("");
			btnStart.setText("Cancelar");
			EscritorDePing pingWriter = new EscritorDePing(txtAreaCmd, txtQuedas, txtIp);
			pingWriter.execute();
			AtualizadorDeTempo attTempo = new AtualizadorDeTempo(txtTempo);
			attTempo.execute();
		} else {
			txtAreaCmd.append("--------------------- CANCELADO ---------------------");
			pingando = false;
			btnStart.setText("Iniciar");
		}
	}	
}
