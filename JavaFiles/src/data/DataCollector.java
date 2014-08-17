package data;

import java.io.*;
import java.net.*;

public class DataCollector {
	private static CommandCollection cc = new CommandCollection();
	public static void main(String[] args) throws Exception{
		String clientSentence;
		ServerSocket welcomeSocket = new ServerSocket(6789);
		while(true){
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			clientSentence = inFromClient.readLine();
			System.out.println("received: " + clientSentence);
			if(!clientSentence.contains("RequestCommand")){
				Thread process = new Thread(new DataProcessor(clientSentence, cc));
				process.start();
			} else {
				String coords = clientSentence.substring(clientSentence.indexOf("("), clientSentence.indexOf(")"));
				outToClient.writeBytes(cc.grabCommand(coords));
			}
			connectionSocket.close();
		}
	}
}
