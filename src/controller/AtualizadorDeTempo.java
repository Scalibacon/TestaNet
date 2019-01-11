package controller;

import javax.swing.JTextField;
import javax.swing.SwingWorker;

public class AtualizadorDeTempo extends SwingWorker<Object, Object>{

	private JTextField txtTempo;
	private int tempo;
	
	public AtualizadorDeTempo(JTextField txtTempo) {
		this.txtTempo = txtTempo;
		this.tempo = -1;
	}
	
	@Override
	protected Object doInBackground() throws Exception {
		escreveTempo();
		return null;
	}
	
	protected void escreveTempo() {
		txtTempo.setText(tempo + "s");
		while (TestadorDePing.pingando) {			
			tempo++;
			txtTempo.setText(tempo + "s");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
