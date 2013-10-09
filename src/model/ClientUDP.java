package model;

import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.SocketException;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class ClientUDP {

    public static void main(String[] args){

		try{
			int port = 8080;
			String ip = "127.0.0.1";
			File file = new File("C:\\Users\\Wicaonith\\Documents\\Pro_ue1\\pro_ue1\\socket.tar.gz");

			InetAddress adresseIP = InetAddress.getByName(ip);
			DatagramSocket socket = new DatagramSocket();
			FileInputStream stream = new FileInputStream(file);
			byte[] contenu = new byte[(int) file.length()];
			stream.read(contenu);
			DatagramPacket packet = new DatagramPacket(contenu, contenu.length,adresseIP, port);
			socket.send(packet);
			socket.close();

		}
		catch(UnknownHostException  uhe){
			System.out.println("Inconnu !");
		}
		catch(FileNotFoundException fnfException){ 
           System.out.println(fnfException.getMessage());
        }
        catch(IOException ioException){ 
            System.out.println(ioException.getMessage());
        }
	}
}