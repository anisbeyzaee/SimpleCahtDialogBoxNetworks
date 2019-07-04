import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

public class Server {
	private ServerSocket server;
	private HashMap<Socket, PrintWriter> outStream = 
			new HashMap<Socket, PrintWriter>();
	
	public Server(int port) {
		try {
			server = new ServerSocket(port);
			System.out.println("Server REady");
			
			
			while(true) {
				Socket socket = server.accept(); // client connected
				PrintWriter outstream = new PrintWriter(socket.getOutputStream());  //getoutputstream reads bite by bite
				//but printwriter reads it in a wraped string so I can use println
				outStream.put(socket, outstream);
				Thread serverThread = new Thread(new ServerThread(this, socket)); 	// creating a thread to look at the socket to see 
																					//what is coming from where
				serverThread.start();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void broadcast(String message) {
		for( Iterator iterator = outStream.keySet().iterator(); iterator.hasNext();) {
		Socket socket = (Socket) iterator.next();
		PrintWriter outstream = outStream.get(socket);
		outstream.println(message);
		outstream.flush();
		}
		
	}
	
	public static void main(String[]arg) {
		
	}
}
