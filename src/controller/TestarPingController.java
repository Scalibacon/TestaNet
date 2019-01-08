package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TestarPingController implements ActionListener{
	JTextArea txtAreaCmd;
	JTextField txtQuedas;
	static int vezesQueCaiu = 0;
	
	public TestarPingController(JTextArea txtAreaCmd, JTextField txtQuedas) {
		this.txtAreaCmd = txtAreaCmd;
		this.txtQuedas = txtQuedas;
	}
	public void testarPing() {		
		
		try {
			Process proc = Runtime.getRuntime().exec("ping 8.8.8.8");
			InputStream fluxo = proc.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			while(linha != null) {
				ThreadEscrevePing escritorDePing = new ThreadEscrevePing(txtAreaCmd, txtQuedas, linha);
				escritorDePing.start();
				linha = buffer.readLine();
			}
			
			buffer.close();
		} catch(Exception e) {
			e.printStackTrace();
			String erro = e.getMessage();
			JOptionPane.showMessageDialog(null, erro, "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		testarPing();	
		//txtAreaCmd.append("foi\n");
	}
}
