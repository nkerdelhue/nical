package control;

import view.*;

import java.awt.Choice;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JTextArea;


/**
 * @author CHAIGNE Alexandre - KERDELHUE Nicolas
 * @version 1.0
 *
 * <BR>Enseignement : UE1, LP S2IMa
 * <BR>Ann�e Universitaire : 2013/2014
 * <BR>Vannes
 *
 * <BR>Sujet : Application.
 * <BR>Class: ListenerRun.java
 */


public class ListenerRun implements ActionListener {


    /** La r�f�rence sur Ihm */
     private Ihm theIhm;


    /** Constructeur: Lui donner la r�f�rence sur Ihm 
    * sinon l'acc�s aux m�thodes de Ihm est impossible
    * @param ihm -- r�f�rence sur Ihm
    */
    public ListenerRun(Ihm ihm) {
      
    	this.theIhm = ihm;
    }

    public void actionPerformed ( ActionEvent e ) {
	
    	JTextArea jta = theIhm.getJtaLog();
 	
    	//Choice jbc = theIhm.getcProtocol();
    	//if( jbc.getSelectedItem()=="TCP"){
    	
    	//	jta.setText(jta.getText() + "\nLancement du protocole " + jbc.getSelectedItem() + " de transfert de donn�es.");
    	//}
    	//if( jbc.getSelectedItem()=="UDP"){
        	
    	//	jta.setText(jta.getText() + "\nLancement du protocole " + jbc.getSelectedItem() + " de transfert de donn�es.");
    	//}
    }

}
