package model;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ServeurTCP {


    public static void main(String[] args){
	try {
	    receiveFile("../test.pdf");
	} catch(Exception e) {
	    e.printStackTrace();
	}
	
     }


     public static void receiveFile(String pathname) throws Exception
     {
	     int port = 8080;
	     ServerSocket serveur = new ServerSocket(port);
	     System.err.println("Lancement du serveur sur le port " + port);
	     for(;;)
		 {
		     Socket call = serveur.accept();
		     int lu;
		     System.err.println("Client comming from "+call.getRemoteSocketAddress());

		     //Création de l'entrée
		     InputStream inpute = call.getInputStream();
		     OutputStream out = new FileOutputStream("../test.pdf");
		    
		    //Reception du client
		    BufferedInputStream inBuffer = new BufferedInputStream(inpute);
		    
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
		    inpute.close();
		    call.close();
		}
     }
}