import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread extends Thread{
	private Socket socket;
	private Client client;

	public ClientThread(Client client, Socket socket) {
		this.socket = socket;
		this.client = client;
		
	}
	public void run() {
		try {
	
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		while(true) {
			String message = in.readLine();
			client.updateview(message);
		}
		}catch (Exception e) {
			
		}
	}
	
}
