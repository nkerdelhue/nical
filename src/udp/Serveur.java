package udp;

import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;

import java.io.IOException;
import java.net.UnknownHostException;
import java.net.SocketException;

public class Serveur {

    public static void main(String[] args){

        try {

            DatagramSocket socket = new DatagramSocket(300);

            byte[] buffer = new byte[1500];

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            while(true) {

                socket.receive(packet);
                
                InetAddress clientAddress = packet.getAddress();
                int port = packet.getPort();

                System.out.println("Reception de : " + clientAddress.getHostName() + " : " + new String(packet.getData(), 0, packet.getLength()));
                
                String g = "PONG";
                byte[] b = g.getBytes();
                DatagramPacket clientPacket = new DatagramPacket(b, b.length, clientAddress, port);
                socket.send(clientPacket);
            }
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
