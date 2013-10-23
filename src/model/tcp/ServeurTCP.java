package model.tcp;

import view.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import javax.swing.JTextArea;

public class ServeurTCP {

	/** La référence sur Ihm */
	private Ihm2 theIhm;
	
	public ServeurTCP( Ihm2 ihm) throws Exception{
		
		this.theIhm = ihm;
		
	} 
	
	public static void main(String[] args) throws Exception{
		
		ServeurTCP.receiveFile("../test.pdf");
	}
	
	public static void receiveFile(String pathname) throws Exception{
		//JTextArea jta = theIhm.getJtaLog();
		 
		int port = 8080; 
		ServerSocket serveur = new ServerSocket(port);
		//jta.setText(jta.getText() + "\nLancement du serveur sur le port " + port + "\n");
		System.err.print("\nLancement du serveur sur le port " + port + "\n");
		
		for(;;){
			
			Socket call = serveur.accept();
			int lu;
			System.err.println("Client comming from "+call.getRemoteSocketAddress());
			
			//Creation de l'entree
			InputStream input = call.getInputStream();
			OutputStream out = new FileOutputStream("../test.pdf");
			
			//Reception du client
			BufferedInputStream inBuffer = new BufferedInputStream(input);
			
			//Envoi vers le fichier
			BufferedOutputStream outBuffer = new BufferedOutputStream(out);
			
			lu = inBuffer.read();
			
			while(lu > 0)
			{
				outBuffer.write(lu);
				lu = inBuffer.read();
				System.out.println(lu+"");
			}
			
			if(lu > 0)
			outBuffer.write(lu);
			
			outBuffer.flush();
			outBuffer.close();
			inBuffer.close();
			
			out.flush();
			out.close();
			input.close();
			call.close();
		}
	}
}