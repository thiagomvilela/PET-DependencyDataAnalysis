package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.Normalizer.Form;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame {
	public GUI() throws IOException {
		super("Dependency Finder");
		guiMain();
	}
	Color azul = new Color(37,51,125);
	int select = 0;
	String localDir = System.getProperty("user.dir");
	BufferedImage logo = ImageIO.read(new File(localDir + "/resources/Logo-Stellantis.png"));
	
	int resizer = 5;
	
	Image logoR = logo.getScaledInstance(logo.getWidth()/resizer, logo.getHeight()/resizer, Image.SCALE_DEFAULT);
	
	public void varDirectory() throws IOException{
		setLayout(new BorderLayout());
		setTitle("Variable Directory");
		JPanel panel = new JPanel();
		JPanel logoPanel = new JPanel();
		logoPanel.setBackground(azul);
		panel.setBackground(azul);
		
		JLabel var = new JLabel("Enter Variable Name");
		var.setForeground(Color.white);
		JTextField varField = new JTextField(40);
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(new FlowLayout());
		panelBotoes.setBackground(azul);
		
		JButton botaoVoltar = new JButton("Back to Menu");
		
		panelBotoes.add(botaoVoltar);
		
		JButton botaoBuscar = new JButton("Generate Report");
		
		panelBotoes.add(botaoBuscar);
		
		
		JLabel logolabel = new JLabel(new ImageIcon(logoR));	
		
		panel.add(var);
		panel.add(varField);
		logoPanel.add(logolabel);
		add(logoPanel, BorderLayout.NORTH);
		add(panel,BorderLayout.CENTER);
		add(panelBotoes, BorderLayout.SOUTH);
		
		botaoVoltar.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	try {
					remove(panelBotoes);
					remove(logoPanel);
					remove(panel);
					guiMain();
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
	
	
	private void depFinderInput() throws IOException {
		setLayout(new BorderLayout());
		setTitle("DepFinder");
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(new FlowLayout());
		panelTitulo.setBackground(azul);
		
		//JLabel titulo = new JLabel ("C++ Parser");
		//titulo.setForeground(Color.white);
		//titulo.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		//panelTitulo.add(titulo);
		
		JPanel logoPanel = new JPanel();
		logoPanel.setBackground(azul);
		
		JPanel panelInput = new JPanel();
		panelInput.setLayout(new FlowLayout());
		panelInput.setBackground(azul);
		
		JLabel var = new JLabel("Enter Variable Name");
		var.setForeground(Color.white);
		JTextField varField = new JTextField(40);
		
		
		JLabel diretorio = new JLabel("Enter Variable Folder");
		diretorio.setForeground(Color.white);
		JTextField dirField = new JTextField(40);
		
		JLabel logolabel = new JLabel(new ImageIcon(logoR));	
		
		panelInput.add(var);
		panelInput.add(varField);
		panelInput.add(diretorio);
		panelInput.add(dirField);
		logoPanel.add(logolabel);
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(new FlowLayout());
		panelBotoes.setBackground(azul);
		
		JButton botaoVoltar = new JButton("Back to Menu");
		
		panelBotoes.add(botaoVoltar);
		
		JButton botaoBuscar = new JButton("Generate Report");
		
		panelBotoes.add(botaoBuscar);
		
		
		//add(panelTitulo, BorderLayout.NORTH);
		add(logoPanel, BorderLayout.NORTH);
		add(panelInput, BorderLayout.CENTER);
		add(panelBotoes, BorderLayout.SOUTH);	
		
		botaoVoltar.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	try {
					remove(panelBotoes);
					remove(panelTitulo);
					remove(panelInput);
					remove(logoPanel);
					guiMain();
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
	public void guiMain() throws IOException{
		setTitle("Dependency Finder");
		
		setLayout(new BorderLayout());
		JPanel panelBotoes = new JPanel();
		JPanel logoPanel = new JPanel();
		logoPanel.setBackground(azul);
		panelBotoes.setBackground(azul);
		JButton botaoVarDir = new JButton("Variable Directory");
		JButton botaoDepFinder = new JButton("DepFinder");
		
		JLabel logolabel = new JLabel(new ImageIcon(logoR));	
		logoPanel.add(logolabel);
		
		panelBotoes.add(botaoDepFinder);
		panelBotoes.add(botaoVarDir);
		
		add(panelBotoes, BorderLayout.CENTER);
		add(logoPanel, BorderLayout.NORTH);
		
		botaoVarDir.addActionListener(new ActionListener() {
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
		botaoDepFinder.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        try {
					remove(panelBotoes);
					remove(logoPanel);
					depFinderInput();
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
