package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Metodos {
	JTextArea txtAreaCmd;
	JTextField txtQuedas;
	
	public Metodos(JTextArea txtAreaCmd, JTextField txtQuedas) {
		this.txtAreaCmd = txtAreaCmd;
		this.txtQuedas = txtQuedas;
	}
	public void testarPing() {
		int vezesQueCaiu = 0;
		
		try {
			Process proc = Runtime.getRuntime().exec("ping -t 8.8.8.8");
			InputStream fluxo = proc.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();			
			
			while(linha != null) {
				txtAreaCmd.append(linha);
				if(!linha.contains("ms")) {
					vezesQueCaiu++;
					txtQuedas.setText(String.valueOf(vezesQueCaiu));
				}
				linha = buffer.readLine();
			}
		} catch(Exception e) {
			e.printStackTrace();
			String erro = e.getMessage();
			JOptionPane.showMessageDialog(null, erro, "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
