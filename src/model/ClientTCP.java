package model;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;


public class ClientTCP {
    
    public static void main(String[] args){
        try {
            sendFile("C:\\Users\\Wicaonith\\Documents\\Pro_ue1\\pro_ue1\\src\\view\\Ihm.java", "127.0.0.1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendFile(String pathname,String serv) throws Exception{
        
        File f = new File(pathname);
        if(f.exists()){

            System.out.println("Envoi du fichier "+f.toURI().toURL());
            Socket s = new Socket(InetAddress.getByName(serv),8080);
            s.setSoTimeout(10000);
        
            OutputStream fluxSortie = s.getOutputStream();
	    

            long fileSize = f.length();
        
            System.out.println("Taille du fichier: "+ fileSize/1024 + " Kb");
        
            long nbPassages = fileSize / 4096;
        
            //System.out.println("Passages supposÈs : "+ nbPassages);
        
            InputStream in = new BufferedInputStream(new FileInputStream(f));
            ByteArrayOutputStream tableauBytes = new ByteArrayOutputStream();
            BufferedOutputStream tampon = new BufferedOutputStream(tableauBytes);
        
            int lu = in.read();
            int[] aEcrire = new int[4096];
            int compteur = 0;
            long avancement=0;
        
            //Tant qu'on est pas √† la fin fichier
            while(lu > -1){
                //On lit les donn√©es du fichier
                aEcrire[compteur] = lu;
		lu = in.read();
                compteur++;
            
                //Quand on a rempli le tableau, on envoie un paquet de 4096 octets
                if(compteur == 4096){
		    compteur = 0;
                    avancement++;
                    //On remplit le tampon
                    for(int x = 0; x < 4096; x++)
			{
			    tampon.write(aEcrire[x]);
			}
		                   
                    //Et on l'envoie
		    
                    fluxSortie.write(tableauBytes.toByteArray());		    
		                 
                    tableauBytes.reset();
                    System.out.println("Avancement : "+(float) avancement / nbPassages * 100 + "%");
                }
            }



        
            //On envoie le dernier paquet, qui ne fait pas forcement 4096 octets
            //On remplit le tampon
            for(int x = 0; x < 4096; x++)
		tampon.write(aEcrire[x]);
	    
            //Et on l'envoie
            tampon.flush();
            fluxSortie.write(tableauBytes.toByteArray());
            fluxSortie.flush();
        
            System.out.println("Avancement: "+(float) avancement/nbPassages * 100+"%");
        
            System.out.println("Transfert terminÈ");
            in.close();
            tampon.close();
            System.out.println("Passages effectuÈs : " + avancement);
            s.close();
        }
        else{    

	    System.out.println("Le fichier " + f + " est introuvable");    
	}
    } 
}