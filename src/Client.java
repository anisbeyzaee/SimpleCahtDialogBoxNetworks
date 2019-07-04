import java.awt.BorderLayout;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client {
	private JFrame frm = new JFrame("chat App");
	private JPanel pnl = new JPanel();
	private JTextArea chatTxt = new JTextArea(20, 3);
	private JTextField msgTxt = new JTextField(20); 
	//private Socket socket;
	private String chatlog ="";
	
	  
	public Client(int port) {
		try {
			Socket socket = new Socket("localHost", port);
			
			System.out.println(" AGHA VASL SHODIM");
			
			// GUI here
			pnl.setLayout(new BorderLayout());
			pnl.add(new JScrollPane(chatTxt), BorderLayout.CENTER);
			pnl.add(msgTxt, BorderLayout.SOUTH);
			frm.add(pnl);
			
			
			ClientThread cThread = new ClientThread(this, socket);
			cThread.start();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		Client client = new Client(1234);

	}


	public void updateview(String message) {
		// TODO Auto-generated method stub
		
	}

}
