package model.udp;

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

public class ServeurUDP {

    public static void main(String[] args){

        try{
            int TAILLE_MAXIMALE = 5000000;
            int port=8080;
            int nombre = 1000000;
            File repertoire = new File("C:\\Users\\Wicaonith\\Documents\\Pro_ue1\\pro_ue1\\");
            DatagramSocket dataSock = new DatagramSocket(port);
            FileOutputStream fis;
            DatagramPacket dataPac ;
            dataSock.setSoTimeout(10000);
            File f;
            byte[] b;
            String s = "socket.tar.gz";
            System.out.println("Lancement du serveur sur le port " + port);
            for(int i = 0 ; i < nombre ; i++){
                f = new File(repertoire.getAbsolutePath()+ File.separator +s);
                fis = new FileOutputStream(f);
                b = new byte[TAILLE_MAXIMALE];
                dataPac = new DatagramPacket(b,TAILLE_MAXIMALE);

                dataSock.receive(dataPac);
                fis.write(dataPac.getData(),0,dataPac.getLength());
            }
            dataSock.close();
                
        }
        catch(SocketException sException){ 
            System.out.println(sException.getMessage());
        }
        catch(FileNotFoundException fnfException){ 
            System.out.println(fnfException.getMessage());
        }
        catch(IOException ioException){ 
            System.out.println(ioException.getMessage());
        }
    }
}
