package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.Normalizer.Form;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {
	public GUI() throws IOException {
		super("DepFinder");
		guiMain();
	}
	Color azul = new Color(37,51,125);
	int select = 0;
	String localDir = System.getProperty("user.dir");
	BufferedImage logo = ImageIO.read(new File(localDir + "/resources/Logo-Stellantis.png"));
	int resizer = 3;
	Image logoR = logo.getScaledInstance(logo.getWidth()/resizer, logo.getHeight()/resizer, Image.SCALE_DEFAULT);	

	Border margin = new EmptyBorder(20,10,20,10);

	int fontSize = 14;

	Font f = new Font("Arial", Font.BOLD, fontSize);
	
	private String var1; // variable
	private String var2; // workspace		
	private String var3; // output 
	
	public String getVar1() {
		return var1;
	}
	public void setVar1(String var1) {
		this.var1 = var1;
	}
	public String getVar2() {
		return var2;
	}
	public void setVar2(String var2) {
		this.var2 = var2;
	}
	public String getVar3() {
		return var3;
	}
	public void setVar3(String var3) {
		this.var3 = var3;
	}
	
	public JButton newBtn(String name){
		JButton btn;
		Color azul = new Color(37,51,125);
		btn = new JButton(name);	
		btn.setBackground(azul);
		btn.setForeground(Color.WHITE);
		btn.setBorder(javax.swing.BorderFactory.createLineBorder(Color.WHITE, 3));
		btn.setSize(getPreferredSize());
		btn.setPreferredSize(new Dimension(200, 30));
		btn.setFocusable(false);
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn.setFont(f);
		
		return btn;
	}
	
	public void createBrowse(JTextField field, JButton botaoBrowse) {
		botaoBrowse.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		        JFileChooser fileChooser = new JFileChooser();
	 
		        // diretorio
		        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		 
		        // arquivo
		        //fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		 
		        fileChooser.setAcceptAllFileFilterUsed(false);
		 
		        int rVal = fileChooser.showOpenDialog(null);
		        if (rVal == JFileChooser.APPROVE_OPTION) {
		          field.setText(fileChooser.getSelectedFile().toString());
		        }
		      }
		    });
	}
	
	public JLabel getLogo() {
		JLabel logo = new JLabel(new ImageIcon(logoR));
		Border border = logo.getBorder();
		Border marginL = new EmptyBorder(10,10,10,10);
		logo.setBorder(new CompoundBorder(border, marginL));
		return logo;
	}
	
	public JPanel getBigPanel(int rows) {
		JPanel bigPanel = new JPanel();
		bigPanel.setLayout(new GridLayout(rows,1));
		bigPanel.setBackground(azul);
		
		Border borderP = bigPanel.getBorder();
		Border marginP = new EmptyBorder(20,10,30,10);
		bigPanel.setBorder(new CompoundBorder(borderP, marginP));
		
		return bigPanel;
	}
	
	public void varDirectory() throws IOException{
		setLayout(new BorderLayout());
		setTitle("DepFinder");
		
		JPanel panel = new JPanel();
		JPanel logoPanel = new JPanel();
		logoPanel.setBackground(azul);
		panel.setBackground(azul);		
		Border borderPanel = panel.getBorder();
		panel.setBorder(new CompoundBorder(borderPanel, margin));
		
		JLabel var = new JLabel("Enter Variable Name");
		var.setForeground(Color.white);
		var.setFont(f);
		JTextField varField = new JTextField(30);
		varField.setFont(f);
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(new FlowLayout());
		panelBotoes.setBackground(azul);
		
		Border borderBtns = panelBotoes.getBorder();
		panelBotoes.setBorder(new CompoundBorder(borderBtns, margin));
		
		JButton botaoVoltar = newBtn("Back to Menu");
		
		panelBotoes.add(botaoVoltar);
		
		JButton botaoBuscar = newBtn("Find Variable File");
		
		botaoBuscar.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	setVar1(varField.getText());
		    }
		
		});	
		
		
		panelBotoes.add(botaoBuscar);
		
		
		JLabel logolabel = getLogo();	
		
		JPanel bigPanel = getBigPanel(3);
		panel.add(var);
		panel.add(varField);
		logoPanel.add(logolabel);
		
		add(bigPanel, BorderLayout.CENTER);
		
		bigPanel.add(logoPanel, BorderLayout.NORTH);
		bigPanel.add(panel,BorderLayout.CENTER);
		bigPanel.add(panelBotoes, BorderLayout.SOUTH);
		
		botaoVoltar.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	try {
					remove(bigPanel);
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
		
		JPanel logoPanel = new JPanel();
		logoPanel.setBackground(azul);
		
		JPanel panelInput = new JPanel();
		panelInput.setLayout(new FlowLayout());
		panelInput.setBackground(azul);
		panelInput.setFont(f);
		
		JLabel var = new JLabel("Enter Variable Name");
		var.setForeground(Color.white);
		var.setFont(f);
		JTextField varField = new JTextField(30);
		varField.setFont(f);
		
		JLabel diretorio = new JLabel("Enter Workspace Folder");
		diretorio.setFont(f);
		diretorio.setForeground(Color.white);

		JTextField dirField = new JTextField(30);
		dirField.setFont(f);
		JLabel logolabel = getLogo();
		
		JLabel output = new JLabel("Enter Output Folder");
		output.setFont(f);
		output.setForeground(Color.white);

		JTextField outField = new JTextField(30);
		outField.setFont(f);
		
		JButton dirBrowse = newBtn("Browse Workspase Folder");
		
		createBrowse(dirField, dirBrowse);
		
		JButton outputBrowse = newBtn("Browse Output Folder");
		
		createBrowse(outField, outputBrowse);	
		
		JPanel panelBrowse = new JPanel();
		panelBrowse.setBackground(azul);
		panelBrowse.setLayout(new FlowLayout());
		
		panelInput.add(var);
		panelInput.add(varField);
		panelInput.add(diretorio);
		panelInput.add(dirField);
		panelInput.add(output);
		panelInput.add(outField);
		
		panelBrowse.add(dirBrowse);
		panelBrowse.add(outputBrowse);
		
		logoPanel.add(logolabel);
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(new FlowLayout());
		panelBotoes.setBackground(azul);
		
		Border borderBtns = panelBotoes.getBorder();
		panelBotoes.setBorder(new CompoundBorder(borderBtns, margin));
		
		JButton botaoVoltar = newBtn("Back to Menu");
		
		panelBotoes.add(botaoVoltar);
		
		JButton botaoBuscar = newBtn("Generate Report");
		
		panelBotoes.add(botaoBuscar);
		
		JPanel bigPanel = getBigPanel(4);
		
		add(bigPanel, BorderLayout.CENTER);
		
		bigPanel.add(logoPanel);
		bigPanel.add(panelInput);
		bigPanel.add(panelBrowse);
		bigPanel.add(panelBotoes);	
		
		botaoVoltar.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	try {
					remove(bigPanel);
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
		
		botaoBuscar.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	setVar1(varField.getText());
		    	setVar2(dirField.getText());
				setVar3(outField.getText());

		    }
		
		});
	}
	
	public void guiMain() throws IOException{
		setTitle("DepFinder");
		
		setLayout(new BorderLayout());
		JPanel panelBotoes = new JPanel();
		JPanel logoPanel = new JPanel();
		logoPanel.setBackground(azul);
		panelBotoes.setBackground(azul);
		JButton botaoVarDir = newBtn("VarFinder");
		JButton botaoDepFinder = newBtn("DepFinder");
		
		JLabel logolabel = getLogo();	
		logoPanel.add(logolabel);
		
		panelBotoes.add(botaoVarDir);
		panelBotoes.add(botaoDepFinder);
		
		JPanel bigPanel = getBigPanel(2);
		
		add(bigPanel, BorderLayout.CENTER);
		
		
		bigPanel.add(logoPanel, BorderLayout.NORTH);
		bigPanel.add(panelBotoes, BorderLayout.CENTER);
		
		botaoVarDir.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	try {
					remove(bigPanel);
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
					remove(bigPanel);
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