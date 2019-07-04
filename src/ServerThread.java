import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread implements Runnable {
	private Server server;
	private Socket socket;
	
	public ServerThread(Server server, Socket socket) {
		this.server = server;
		this.socket= socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader inputStream = new BufferedReader (new InputStreamReader(socket.getInputStream()));
			
			while(true) {
				String message = inputStream.readLine(); // constantly looking for the message and pass it on to the server
				System.out.println("Serrver is  bc ing ....");
				server.broadcast(message);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
