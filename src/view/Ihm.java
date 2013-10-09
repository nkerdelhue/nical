/**
 * 
 */
package view;

import control.*;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Choice;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;

/**
 * @author CHAIGNE Alexandre - KERDELHUE Nicolas
 * @version 1.0
 *
 * <BR>Enseignement : UE1, LP S2IMa
 * <BR>Année Universitaire : 2013/2014
 * <BR>Vannes
 *
 * <BR>Sujet : Application.
 * <BR>Class: ihm.java
 */

public class Ihm extends JFrame{

	
	/*---------------------------------------------------------- */
    /*------------------------ATTRIBUT ------------------------- */
    /*---------------------------------------------------------- */
	/** Panneau général */
	private JPanel generalPanel;
	/* Panneau du menu*/
	private JPanel menuPanel;
	/* Panneau principal */
    private JPanel mainPanel;
    /* Panneau de gauche (log)*/
    private JPanel leftPanel;
    /* Panneau de droite (menu)*/
    private JPanel rightPanel;
    /* Panneau du centre de droite*/
    private JPanel rightCenterPanel;
    /* Panneau vide*/
    private JPanel blank;
    
    /* Zone de texte pour les logs*/
    private JTextArea jtaLog;
    
    /* Zone de text */
    private JTextField jtfFind;
    
    /* Etiquette Log */
    private JLabel labelLog;
    /* Etiquette Menu */
    private JLabel labelMenu;
    /* Etiquette Type de connexion */
    private JLabel typeCoLabel;
    /* Etiquette Fichier */
    private JLabel labelFile;
    
    /* Boutton Run */
    private JButton buttonRun;
    
    /** Barre de menu */
    private JMenuBar menuBar;
    
    /** Option Fichier du menu */
    private JMenu menuFichier;
    /** Option Aide du menu */
    private JMenu menuAide;
    
    /** Item Quitter du menu Fichier*/
    private JMenuItem menuItemQuitter;
    /** Item Init du menu Fichier */
    private JMenuItem menuItemInit;
    /** Item Aide du menu Aide */
    private JMenuItem menuItemAide;
    /** Item A propos du menu Aide */
    private JMenuItem menuItemAPropos;
	private JFileChooser jfcFind;
	private Choice cProtocol;
    
    
	/*-------------------------------------------------------------- */
    /*------------------------CONSTRUCTEUR ------------------------- */
    /*-------------------------------------------------------------- */
    /** Constructeur de la classe Ihm */
    public Ihm(){

	this.createInterface(); //Créé l'interface
	this.linkReactions(); //Attache les réactions
 	//this.init();
	
	this.setSize(1000,600); // Taille de la fenetre
	this.setVisible(true); // Rend la fenetre visible
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    /*---------------------------------------------------------- */
    /*------------------------ METHODES ------------------------ */
    /*---------------------------------------------------------- */
    /** Methode qui crée l'interface graphique de l'application */
    private void createInterface(){

    	/* ############# LA FENETRE COURANTE ############# */
		this.setLayout(new BorderLayout(20, 20));
		generalPanel = new JPanel();
		menuPanel = new JPanel();
		mainPanel = new JPanel(new GridLayout(1,2,10,1));
		
		/* ############# MENU ############# */
		menuBar = new JMenuBar();
		menuFichier = new JMenu("File");
		menuAide = new JMenu("Help");
		
		menuItemQuitter = new JMenuItem("Exit");
		menuItemInit = new JMenuItem("Initialisation");
		menuItemAide = new JMenuItem("?");
		menuItemAPropos = new JMenuItem("About");

		/* ############# PANEL GAUCHE ############# */
		leftPanel = new JPanel(new GridLayout(1,1));
		leftPanel.setBackground(Color.cyan);
		labelLog = new JLabel("Log");
		
		jtaLog = new JTextArea();
		jtaLog.setEditable(false);

		/* ############# PANEL DROITE ############# */
		rightPanel = new JPanel(new GridLayout(1,1));
		labelMenu = new JLabel("Menu");

		/* ############# PANEL DROITE ############# */
		rightCenterPanel = new JPanel(new GridLayout(3,3));
		typeCoLabel = new JLabel("Type de connexion");
		cProtocol = new Choice();
		cProtocol.addItem("TCP");
		cProtocol.addItem("UDP");
		blank = new JPanel();
		labelFile = new JLabel("Fichier");
		jtfFind = new JTextField(20);
		jfcFind = new JFileChooser("Find");
		buttonRun = new JButton("Run");



		



		/* ############# ADD ############# */
		this.setJMenuBar(menuBar);
		this.add(mainPanel);
		
		
		
		menuBar.add(menuFichier);
		menuBar.add(menuAide);
		menuFichier.add(menuItemInit);
		menuFichier.add(menuItemQuitter);
		menuAide.add(menuItemAide);
		menuAide.add(menuItemAPropos);
		
		
		menuPanel.add(labelLog);
		menuPanel.add(labelMenu);
		mainPanel.add(leftPanel);
		mainPanel.add(rightPanel);

		
		leftPanel.add(jtaLog);
		rightPanel.add(rightCenterPanel);

		rightCenterPanel.add(typeCoLabel);
		rightCenterPanel.add(cProtocol);
		rightCenterPanel.add(blank);
		rightCenterPanel.add(labelFile);
		rightCenterPanel.add(jtfFind);
		rightCenterPanel.add(jfcFind);
		rightCenterPanel.add(buttonRun);
    }



	/** Methode qui gère les réactions de l'application */
    private void linkReactions(){

	jfcFind.addActionListener(new ListenerFindFile(this)); //Ecouteur sur la le boutton Find
	buttonRun.addActionListener(new ListenerRun(this)); //Ecouteur sur la le boutton Run

    }

    /*------------------------------------------------------------ */
    /*------------------------ ACCESSEUR ------------------------- */
    /*------------------------------------------------------------ */
 	
     public JPanel getMenuPanel() {
 		return menuPanel;
 	}

 	public void setMenuPanel(JPanel menuPanel) {
 		this.menuPanel = menuPanel;
 	}

 	public JPanel getMainPanel() {
 		return mainPanel;
 	}

 	public void setMainPanel(JPanel mainPanel) {
 		this.mainPanel = mainPanel;
 	}

 	public JPanel getLeftPanel() {
 		return leftPanel;
 	}

 	public void setLeftPanel(JPanel leftPanel) {
 		this.leftPanel = leftPanel;
 	}

 	public JPanel getRightPanel() {
 		return rightPanel;
 	}

 	public void setRightPanel(JPanel rightPanel) {
 		this.rightPanel = rightPanel;
 	}

 	public JPanel getRightCenterPanel() {
 		return rightCenterPanel;
 	}

 	public void setRightCenterPanel(JPanel rightCenterPanel) {
 		this.rightCenterPanel = rightCenterPanel;
 	}

 	public JTextField getJtfFind() {
 		return jtfFind;
 	}

 	public void setJtfFind(JTextField jtfFind) {
 		this.jtfFind = jtfFind;
 	}

 	public JLabel getLabelLog() {
 		return labelLog;
 	}

 	public void setLabelLog(JLabel labelLog) {
 		this.labelLog = labelLog;
 	}

 	public JLabel getLabelMenu() {
 		return labelMenu;
 	}

 	public void setLabelMenu(JLabel labelMenu) {
 		this.labelMenu = labelMenu;
 	}

 	public JLabel getTypeCoLabel() {
 		return typeCoLabel;
 	}

 	public void setTypeCoLabel(JLabel typeCoLabel) {
 		this.typeCoLabel = typeCoLabel;
 	}

 	public JLabel getLabelFile() {
 		return labelFile;
 	}

 	public void setLabelFile(JLabel labelFile) {
 		this.labelFile = labelFile;
 	}

 	public JButton getButtonRun() {
 		return buttonRun;
 	}

 	public void setButtonRun(JButton buttonRun) {
 		this.buttonRun = buttonRun;
 	}
 	
	public Choice getcProtocol() {
		return cProtocol;
	}

	public void setcProtocol(Choice cProtocol) {
		this.cProtocol = cProtocol;
	}
 	
    /** Accesseur à jtaLog
     * @return JTextArea jtaLog */
     public JTextArea getJtaLog() { 
    	 return this.jtaLog; 
    }

 	public void setJtaLog(JTextArea jtaLog) {
 		this.jtaLog = jtaLog;
 	}
 	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Ihm i = new Ihm();

	}

}
