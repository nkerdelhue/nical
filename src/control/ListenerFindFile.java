package control;

import view.*;
import model.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author CHAIGNE Alexandre - KERDELHUE Nicolas
 * @version 1.0
 *
 * <BR>Enseignement : UE1, LP S2IMa
 * <BR>Année Universitaire : 2013/2014
 * <BR>Vannes
 *
 * <BR>Sujet : Application.
 * <BR>Class: ListenerFindFile.java
 */


public class ListenerFindFile implements ActionListener {


    /** La référence sur Ihm */
     private Ihm theIhm;


    /** Constructeur: Lui donner la référence sur Ihm 
    * sinon l'accès aux méthodes de Ihm est impossible
    * @param ihm -- référence sur Ihm
    */
    public ListenerFindFile( Ihm ihm) {
      
    	this.theIhm = ihm;
    }

    public void actionPerformed ( ActionEvent e ) {
	
    	JTextArea jta = theIhm.getJtaLog();
    	jta.setText(jta.getText() + "\nRecherche d'un fichier...");
    	
    	
    }

}

