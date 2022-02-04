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

package com.stellantis.depfinder.gui;

import java.awt.Color;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) throws IOException {
		GUI gui = new GUI();
		Color azul = new Color(37,51,125);
//		Color azul = new Color(255,255,255); //White CIn UFPE
//		Color azul = new Color(219,30,47); RED CIn UFPE
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(500, 650);
		gui.setLocation((
				Toolkit.getDefaultToolkit().getScreenSize().width  - gui.getSize().width) / 2, 
				(Toolkit.getDefaultToolkit().getScreenSize().height - gui.getSize().height) / 2
		);
		gui.setVisible(true);
		gui.setBackground(azul);
	}
}
