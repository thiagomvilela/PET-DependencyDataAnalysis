package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame {
	public GUI() throws IOException {
		super("C++ Parser");
		guiMain();
	}
	Color azul = new Color(37,51,125);
	int select = 0;
	String localDir = System.getProperty("user.dir");
	BufferedImage logo = ImageIO.read(new File(localDir + "/resources/Logo-Stellantis.png"));
	
	public void varDirectory() throws IOException{
		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		JPanel logoPanel = new JPanel();
		logoPanel.setBackground(azul);
		panel.setBackground(azul);
		
		JLabel var = new JLabel("Variável");
		var.setForeground(Color.white);
		JTextField varField = new JTextField(40);
		JButton botaoBuscar = new JButton("Buscar");
		JLabel logolabel = new JLabel(new ImageIcon(logo));	
		
		panel.add(var);
		panel.add(varField);
		panel.add(botaoBuscar);
		logoPanel.add(logolabel);
		add(panel, BorderLayout.NORTH);
		add(logoPanel,BorderLayout.CENTER);
		
	}
	
	
	private void deepFinderInput() throws IOException {
		setLayout(new BorderLayout());
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(new FlowLayout());
		panelTitulo.setBackground(azul);
		
		JLabel titulo = new JLabel ("PARSER");
		titulo.setForeground(Color.white);
		titulo.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		panelTitulo.add(titulo);
		
		JPanel panelInput = new JPanel();
		panelInput.setLayout(new FlowLayout());
		panelInput.setBackground(azul);
		
		JLabel var = new JLabel("Variable");
		var.setForeground(Color.white);
		JTextField varField = new JTextField(40);
		
		
		JLabel diretorio = new JLabel("Directory");
		diretorio.setForeground(Color.white);
		JTextField dirField = new JTextField(40);
		
		JLabel logolabel = new JLabel(new ImageIcon(logo));	
		
		panelInput.add(var);
		panelInput.add(varField);
		panelInput.add(diretorio);
		panelInput.add(dirField);
		panelInput.add(logolabel);
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(new FlowLayout());
		panelBotoes.setBackground(azul);
		
		JButton botaoBuscar = new JButton("Buscar");
		
		
		panelBotoes.add(botaoBuscar);
		
		add(panelTitulo, BorderLayout.NORTH);
		add(panelInput, BorderLayout.CENTER);
		add(panelBotoes, BorderLayout.SOUTH);	
	}
	public void guiMain() throws IOException{
		setLayout(new BorderLayout());
		JPanel panelBotoes = new JPanel();
		JPanel logoPanel = new JPanel();
		logoPanel.setBackground(azul);
		panelBotoes.setBackground(azul);
		JButton botaoVarDeep = new JButton("Variable Directory");
		JButton botaoDeepFinder = new JButton("Deep Finder");
		JLabel logolabel = new JLabel(new ImageIcon(logo));	
		logoPanel.add(logolabel);
		panelBotoes.add(botaoDeepFinder);
		panelBotoes.add(botaoVarDeep);
		add(panelBotoes, BorderLayout.NORTH);
		add(logoPanel, BorderLayout.CENTER);
		
		botaoVarDeep.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	try {
					remove(panelBotoes);
					remove(logoPanel);
					varDirectory();
					invalidate();
					validate();
					repaint();
					
				} catch (IOException e1) {
					System.out.println("F no chat");
					e1.printStackTrace();
				}
		    }
		
		});
		botaoDeepFinder.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        try {
					remove(panelBotoes);
					remove(logoPanel);
					deepFinderInput();
					invalidate();
					validate();
					repaint();
					
				} catch (IOException e1) {
					System.out.println("F no chat");
					e1.printStackTrace();
				}
		    }
		
		});
		
		
	}
}
