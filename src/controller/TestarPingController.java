package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

public class TestarPingController implements ActionListener {
	private JTextArea txtAreaCmd;
	private JTextField txtQuedas;
	private JTextField txtIp;
	private JButton btnStart;
	private static int vezesQueCaiu = -1;
	private String linha = "";
	private boolean pingando = false;

	public TestarPingController(JTextArea txtAreaCmd, JTextField txtQuedas, JButton btnStart, JTextField txtIp) {
		this.txtAreaCmd = txtAreaCmd;
		this.txtQuedas = txtQuedas;
		this.btnStart = btnStart;
		this.txtIp = txtIp;
	}

	public void testarPing() {		
		
		try {
			SwingWorker<?, ?> worker = new SwingWorker<Object, Object>() {
				protected Object doInBackground() throws Exception {

					vezesQueCaiu = -1;
					Process proc = Runtime.getRuntime().exec("ping -t " + txtIp.getText());
					InputStream fluxo = proc.getInputStream();
					InputStreamReader leitor = new InputStreamReader(fluxo);
					BufferedReader buffer = new BufferedReader(leitor);
					linha = buffer.readLine();
					txtQuedas.setText(String.valueOf(TestarPingController.vezesQueCaiu));

					while (linha != null && pingando) {
						System.out.println(linha);
						txtAreaCmd.append(linha + "\n");
						if (!linha.contains("bytes") || linha.trim().length() <= 0) {
							TestarPingController.vezesQueCaiu++;
							txtQuedas.setText(String.valueOf(TestarPingController.vezesQueCaiu));
						}
						linha = buffer.readLine();
						// Thread.sleep(1000);
					}
					buffer.close();

					return null;
				}

			};
			worker.execute();

		} catch (Exception e) {
			e.printStackTrace();
			String erro = e.getMessage();
			JOptionPane.showMessageDialog(null, erro + "\n\nPara mais informações contate o Tetheus", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		if(!pingando) {
			pingando = true;
			txtAreaCmd.setText("");
			txtQuedas.setText("");
			btnStart.setText("Cancelar");
			testarPing();
		}else {
			txtAreaCmd.append("--------------------- CANCELADO ---------------------");
			pingando = false;
			btnStart.setText("Iniciar");
		}
	}
}
