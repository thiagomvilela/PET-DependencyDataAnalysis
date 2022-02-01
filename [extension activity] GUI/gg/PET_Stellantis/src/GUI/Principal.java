package GUI;

import java.io.IOException;

import javax.swing.JFrame;


public class Principal {

	public static void main(String[] args) throws IOException {
		GUI gui = new GUI();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(550, 300);
		//gui.setContentPane(gui.varDirectory());
		gui.setVisible(true);
		
	}

}
