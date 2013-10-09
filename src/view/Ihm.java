/**
 * 
 */
package view;

import control.*;
//import model.*;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
//import javax.swing.JMenuBar;
//import javax.swing.JMenu;
//import javax.swing.JMenuItem;

import java.awt.GridLayout;
import java.awt.BorderLayout;
//import java.awt.Color;

/**
 * @author CHAIGNE Alexandre - KERDELHUE Nicolas
 * @version 1.0
 *
 * <BR>Enseignement : UE1, LP S2IMa
 * <BR>Annee Universitaire : 2013-2014
 * <BR>Vannes
 *
 * <BR>Sujet : Application.
 * <BR>Class: ihm.java
 */

public class Ihm extends JFrame{

	
    /*---------------------------------------------------------- */
    /*------------------------ATTRIBUT ------------------------- */
    /*---------------------------------------------------------- */
    private JPanel menuPanel;
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel rightCenterPanel;
    private JPanel blank;
    
    
    private JTextArea jtaLog;
    
    private JTextField jtfFind;
    
    private JLabel labelLog;
    private JLabel labelMenu;
    private JLabel typeCoLabel;
    private JLabel labelFile;
    
    private JComboBox<String> jcbProtocol;
    
    private JButton buttonFind;
    private JButton buttonRun;


    /*-------------------------------------------------------------- */
    /*------------------------CONSTRUCTEUR ------------------------- */
    /*-------------------------------------------------------------- */
    /** Constructeur de la classe Ihm */
    public Ihm(){

	this.createInterface();
	this.linkReactions();
 	//this.init();
	
	this.setSize(1000,250);
	this.setVisible(true);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    /*---------------------------------------------------------- */
    /*------------------------ METHODES ------------------------ */
    /*---------------------------------------------------------- */
    /** Methode qui cree l'interface graphique de l'application */
    private void createInterface(){

    	/* ############# LA FENETRE COURANTE ############# */
	this.setLayout(new BorderLayout(20, 20));
	menuPanel = new JPanel(new GridLayout(1,2));
	mainPanel = new JPanel(new GridLayout(1,2,10,1));

	/* ############# PANEL GAUCHE ############# */
	leftPanel = new JPanel(new GridLayout(1,1));
	labelLog = new JLabel("Log");
	jtaLog = new JTextArea();
	jtaLog.setEditable(false);

	/* ############# PANEL DROITE ############# */
	rightPanel = new JPanel(new GridLayout(1,1));
	labelMenu = new JLabel("Menu");

	/* ############# PANEL DROITE ############# */
	rightCenterPanel = new JPanel(new GridLayout(3,3,1,50));
	typeCoLabel = new JLabel("Type de connexion");
	jcbProtocol = new JComboBox<String>();
	jcbProtocol.addItem("TCP");
	jcbProtocol.addItem("UDP");
	blank = new JPanel();
	labelFile = new JLabel("Fichier");
	jtfFind = new JTextField(20);
	buttonFind = new JButton("Find");
	buttonRun = new JButton("Run");

		



	/* ############# ADD ############# */
	this.add(menuPanel, BorderLayout.NORTH);
	this.add(mainPanel);
		
	menuPanel.add(labelLog);
	menuPanel.add(labelMenu);
		
	mainPanel.add(leftPanel);
	mainPanel.add(rightPanel);

		
	leftPanel.add(jtaLog);
	rightPanel.add(rightCenterPanel);

	rightCenterPanel.add(typeCoLabel);
	rightCenterPanel.add(jcbProtocol);
	rightCenterPanel.add(blank);
	rightCenterPanel.add(labelFile);
	rightCenterPanel.add(jtfFind);
	rightCenterPanel.add(buttonFind);
	rightCenterPanel.add(buttonRun);
    }

    /** Methode qui gere les réactions de l'application */
    private void linkReactions(){

	buttonFind.addActionListener(new ListenerFindFile(this)); //Ecouteur sur la le boutton Find
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

    public JButton getButtonFind() {
	return buttonFind;
    }

    public void setButtonFind(JButton buttonFind) {
	this.buttonFind = buttonFind;
    }

    public JButton getButtonRun() {
	return buttonRun;
    }

    public void setButtonRun(JButton buttonRun) {
	this.buttonRun = buttonRun;
    }
    
    public JComboBox<String> getJcbProtocol() {
	return jcbProtocol;
    }

    public void setJcbProtocol(JComboBox<String> jcbProtocol) {
	this.jcbProtocol = jcbProtocol;
    }
 	
    /** Accesseur a jtaLog
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
