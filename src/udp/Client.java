package udp;

import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;

import java.io.IOException;
import java.net.UnknownHostException;
import java.net.SocketException;

public class Client {

    public static void main(String[] args){


    	try {

	    DatagramSocket socket = new DatagramSocket();
	    InetAddress serverAddress = InetAddress.getLocalHost();
	    int port = 300;
	 
	    String g = "Coucou";
	    byte[] bG = g.getBytes();
	    DatagramPacket packet = new DatagramPacket(bG, bG.length, serverAddress, port);
	    packet.setData("Coucou".getBytes());
	 
	    socket.send(packet);
	 
	    byte[] buffer = new byte[1500];
	    DatagramPacket pong = new DatagramPacket(buffer, buffer.length, serverAddress, port);
	 
	    //on met un timeout
	    socket.setSoTimeout(2000);
	    socket.receive(pong);
	    System.out.println("Client a recu : " + new String(pong.getData(), 0, pong.getLength()));
	 
	    socket.close();

	}
        catch(SocketException e){
            System.out.println("Erreur socket : " + e.getMessage());
        }
        catch(UnknownHostException e){
            System.out.println("Erreur hote inconnu : " + e.getMessage());
        }
        catch(IOException e){
            System.out.println("Erreur IO : " + e.getMessage());
        }
    }
}