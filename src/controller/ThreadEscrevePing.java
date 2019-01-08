package controller;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ThreadEscrevePing extends Thread{

	JTextArea txtAreaCmd;
	JTextField txtQuedas;
	String retornoCmd;
	
	public ThreadEscrevePing(JTextArea txtAreaCmd, JTextField txtQuedas, String retornoCmd) {
		this.txtAreaCmd = txtAreaCmd;
		this.txtQuedas = txtQuedas;
		this.retornoCmd = retornoCmd;
	}
	
	public void run() {
		verificaPingDepoisEscreve();
	}
	
	public void verificaPingDepoisEscreve() {
		txtAreaCmd.append(retornoCmd + "\n");
		if(!retornoCmd.contains("bytes")) {
			TestarPingController.vezesQueCaiu++;
			txtQuedas.setText(String.valueOf(TestarPingController.vezesQueCaiu));
		}
		System.out.println("isto");
	}
}
