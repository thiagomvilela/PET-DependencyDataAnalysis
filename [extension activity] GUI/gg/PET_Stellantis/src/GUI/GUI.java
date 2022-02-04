/* *******************************************************************
 * Copyright (c) 2021 Universidade Federal de Pernambuco (UFPE) and
 * Stellantis.
 * 
 * This file is part of DepFinder
 * 
 * All rights reserved. 
 * Orpheus can be used either under the terms of
 * a) the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * b) the terms of the Apache License
 *
 * Orpheus is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of both licenses in LICENCE.LGPL and
 * LICENCE.APACHE. Please refer to those files for details.
 *  
 * Contributors: 
 *     PET team at CIn-UFPE      initial design and implementation 
 *     Stellantis                             product owner
 *     FACEPE                               team financial support
 * ******************************************************************/

//package com.stellantis.depfinder.gui;
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

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
	private static final long serialVersionUID = 1L;

	private String varName; // variable
	private String workspaceFolder; // workspace		
	private String outputFolder; // output 

	public GUI() throws IOException {
		super("DepFinder");
		depFinderInput();		
	}
	Color azul = new Color(37,51,125);
//	Color azul = new Color(224,225,224); //White CIn UFPE
//	Color azul = new Color(219,30,47); RED CIn UFPE
	Color preto = new Color(35,31,32); //Black CIn UFPE	
	
	int select = 0;
	String localDir = System.getProperty("user.dir");
	// the following line for .jar file
//	BufferedImage logo = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("Logo-Stellantis.png"));
	// using the next one for IDE use...
	BufferedImage logo = ImageIO.read(new File("resources/Logo-Stellantis.png"));
//	BufferedImage logo = ImageIO.read(new File("resources/logo-cin.png")); // CIn UFPE
	int resizer = 1;
//	int resizer = 10; // CIn UFPE
	Image logoR = logo.getScaledInstance(logo.getWidth()/resizer, logo.getHeight()/resizer, Image.SCALE_DEFAULT);	

	Border margin = new EmptyBorder(20,10,2,10);

	int fontSize = 14;

	Font f = new Font("Arial", Font.BOLD, fontSize);

	public JButton newBtn(String name){
		JButton btn;
		Color azul = new Color(37,51,125);
//		Color azul = new Color(219, 30, 47); // Red CIn UFPE
		
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
		Border marginL = new EmptyBorder(2,42,2,30);
		logo.setBorder(new CompoundBorder(border, marginL));
		return logo;
	}

	public JPanel getBigPanel(int rows) {
		JPanel bigPanel = new JPanel();
		bigPanel.setLayout(new GridLayout(rows,1));
		bigPanel.setBackground(azul);

		Border borderP = bigPanel.getBorder();
		Border marginP = new EmptyBorder(1,10,30,10);
		bigPanel.setBorder(new CompoundBorder(borderP, marginP));

		return bigPanel;
	}


	public String getVarName() {
		return varName;
	}

	public String getWorkspaceFolder() {
		return workspaceFolder;
	}

	public String getOutputFolder() {
		return outputFolder;
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
//		var.setForeground(preto); // CIn UFPE
		var.setFont(f);
		JTextField varField = new JTextField(30);
		varField.setFont(f);

		JLabel diretorio = new JLabel("Enter Workspace Folder");
		diretorio.setFont(f);
		diretorio.setForeground(Color.white);
//		diretorio.setForeground(preto); // CIn UFPE
		
		JTextField workDirField = new JTextField(30);
		workDirField.setFont(f);
		JLabel logolabel = getLogo();

		JLabel output = new JLabel("Enter Output Folder");
//		output.setFont(f);
		output.setForeground(Color.white);
//		output.setForeground(preto); // CIn UFPE
		
		JTextField outDirField = new JTextField(30);
		outDirField.setFont(f);

		JButton dirBrowse = newBtn("Browse Workspase Folder");

		createBrowse(workDirField, dirBrowse);

		JButton outputBrowse = newBtn("Browse Output Folder");

		createBrowse(outDirField, outputBrowse);	

		JPanel panelBrowse = new JPanel();
		panelBrowse.setBackground(azul);
		panelBrowse.setLayout(new FlowLayout());

		panelInput.add(var);
		panelInput.add(varField);
		panelInput.add(diretorio);
		panelInput.add(workDirField);
		panelInput.add(output);
		panelInput.add(outDirField);
		
		
		
		panelBrowse.add(dirBrowse);
		panelBrowse.add(outputBrowse);
		Border border = panelInput.getBorder();
		Border marginL = new EmptyBorder(15,0,15,0);
//		Border marginL = new EmptyBorder(-5,0,15,0); // CIn UFPE
		panelInput.setBorder(new CompoundBorder(border, marginL));
		
		logoPanel.add(logolabel);

		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(new FlowLayout());
		panelBotoes.setBackground(azul);

		Border borderBtns = panelBotoes.getBorder();
		panelBotoes.setBorder(new CompoundBorder(borderBtns, margin));

		JButton botaoVar = newBtn("VarFinder");
		panelBotoes.add(dirBrowse);
		panelBotoes.add(outputBrowse);

		panelBotoes.add(botaoVar);

		JButton botaoDep = newBtn("DepFinder");

		panelBotoes.add(botaoDep);
		Border borderBotoes = panelBotoes.getBorder();
		Border marginLbotoes = new EmptyBorder(0,15,15,15);
		panelBotoes.setBorder(new CompoundBorder(borderBotoes, marginLbotoes));
		
		JPanel bigPanel = getBigPanel(4);

		add(bigPanel, BorderLayout.CENTER);

		bigPanel.add(logoPanel);
		bigPanel.add(panelInput);
//		bigPanel.add(panelBrowse);
		bigPanel.add(panelBotoes);	

		botaoVar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				varName = varField.getText();				
			}
		});	


		botaoDep.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				varName = varField.getText();
				if(workDirField.getText().contains(":")) {
					workspaceFolder = workDirField.getText().split(Pattern.quote(":"))[1];
				}
				else {
					workspaceFolder = workDirField.getText();
				}
//				workspaceFolder = workDirField.getText();
				outputFolder = outDirField.getText();
				
//				 integration with DepFInder core tool
//				String [] depFinderArgs = {varName, workspaceFolder, outputFolder};
//				try {
//					com.stellantis.depfinder.core.Main.main(depFinderArgs);
//				} catch (IOException e1) {
//					e1.printStackTrace();
//				}
			}
//
		});
	}


}