package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

public class EscritorDePing extends SwingWorker<Object, Object> {
	private JTextArea txtAreaCmd;
	private JTextField txtQuedas, txtIp;
	private static int vezesQueCaiu = -1;
	private String linha = "";

	public EscritorDePing(JTextArea txtAreaCmd, JTextField txtQuedas, JTextField txtIp) {
		this.txtAreaCmd = txtAreaCmd;
		this.txtQuedas = txtQuedas;
		this.txtIp = txtIp;
	}

	@Override
	protected Object doInBackground() throws Exception {
		pingAndWrite();
		return null;
	}
	
	protected void pingAndWrite() {
		try {
			vezesQueCaiu = -1;
			Process proc = Runtime.getRuntime().exec("ping -t " + txtIp.getText());
			InputStream fluxo = proc.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			linha = buffer.readLine();
			txtQuedas.setText(String.valueOf(vezesQueCaiu));

			while (linha != null && TestadorDePing.pingando) {
				System.out.println(linha);
				txtAreaCmd.append(linha + "\n");
				if (!linha.contains("bytes") || linha.trim().length() <= 0) {
					vezesQueCaiu++;
					txtQuedas.setText(String.valueOf(vezesQueCaiu));
				}
				linha = buffer.readLine();
			}
			buffer.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Deu ruim! \n\n Erro: " + e.getMessage());
		}
	}

}
