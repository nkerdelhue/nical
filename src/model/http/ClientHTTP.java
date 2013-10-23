package model.http;

import java.io.*;
import java.net.*;

public class ClientHTTP {

    String proxy, host, url;
    int port;
    char[] buf;
    private final int BUF_SIZE = 8192;

    class ClientHTTP ( String params[] ) {
	proxy = params[0];
	port = (new Integer(params[1])).intValue();
	host = params[2];
	url = params[3];
	buf = new char[BUF_SIZE];
    }

    public void sendRequest() {
	Socket socketToWeb;
	PrintWriter toWeb;
	BufferedReader fromWeb;
	String str = "";
	int nb = 0;

	try {
	    socketToWeb = new Socket(InetAddress.getByName(proxy),port);
	    toWeb = new PrintWriter(
				    new BufferedWriter (
							new OutputStreamWriter (
										socketToWeb.getOutputStream())),true);
	    fromWeb = new BufferedReader(
					 new InputStreamReader (
								socketToWeb.getInputStream()));

	    str = "GET "+url+" HTTP/1.1\r\nHost: "+host+"\r\n";

	    toWeb.println(str);

	    boolean echoing = true;

	    int size = 0;
	    while ( true ) {
		if ( echoing ) {
		    str = fromWeb.readLine();
		    if ( str == null ) break;
		    if ( str.length() == 0 ) {
			echoing = false; // end of header
		    }
		    System.out.println(str);
		} else {
		    for (int i=0;i<nb;buf[i++]=0x00);
		    nb = fromWeb.read(buf,0,BUF_SIZE);
		    if ( nb == -1 ) {
			int j=BUF_SIZE-1;
			while ( buf[j] == 0x00 && j > 0 )
			    j--;
			break;
		    }
		    System.out.println(buf);
		}
	    }
	} catch (IOException e) {}
    }

    public static void main(String args[]) throws IOException {
        ClientHTTP c = new ClientHTTP(args);
        c.sendRequest();
    }
}