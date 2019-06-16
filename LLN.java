
package Main;

import java.io.*;
import java.net.*;

public class LLN {

	// Object Holder
	public LLN() {
		LL.LL_LINK();
	}

	// Tests If Current Host is Working
	public void currentHostTest() {
		InetAddress ip;
		try {
			ip = InetAddress.getLocalHost();
			LL.console("Local? " + ip.isSiteLocalAddress());
			LL.console("Your current LAN IP address : " + ip.getHostAddress());
			LL.console("Your current Hostname       : " + ip.getHostName());

		}
		catch (UnknownHostException e) {
			LL.console("Unknown Host Error.");
			e.printStackTrace();
		}
	}

	// Connected to internet?
	public boolean connectedToInternet() {
		try {
			return InetAddress.getByName("www.google.com").isReachable(200);
		}
		catch (MalformedURLException e) {}
		catch (IOException e) {}
		return false;
	}

	// Is a passed site online?
	public boolean siteonline(String url) {
		try {
			return InetAddress.getByName(url).isReachable(200);
		}
		catch (MalformedURLException e) {
			e.getMessage();
		}
		catch (IOException e) {
			e.getMessage();
		}
		return false;
	}

}
