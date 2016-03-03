package Charles.LazyLibrary;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class LLN extends LL{
	
	public LLN(){}
	
	public void currentHostTest(){
		InetAddress ip;
        try {
            ip = InetAddress.getLocalHost();
            console("Local? "+ip.isSiteLocalAddress());
            console("Your current LAN IP address : " + ip.getHostAddress());
            console("Your current Hostname       : " + ip.getHostName());
 
        } catch (UnknownHostException e) {
        	console("Unknown Host Error.");
            e.printStackTrace();
        }
	}
	public boolean connectedToInternet(){
		URL obj;
		try {
			obj = new URL("http://www.google.com");
			obj.getContent();
			return true;
		} 
		catch (MalformedURLException e) {} 
		catch (IOException e) {}
		return false;
	}
	public boolean siteonline(String url){
		URL obj;
		try {
			obj = new URL(url);
			obj.getContent();
			return true;
		} 
		catch (MalformedURLException e) {} 
		catch (IOException e) {}
		return false;
	}

}
