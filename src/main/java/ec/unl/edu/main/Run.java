package ec.unl.edu.main;

import java.awt.EventQueue;

import ec.unl.edu.visual.VentanaPrincipal;

public class Run {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
			} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
