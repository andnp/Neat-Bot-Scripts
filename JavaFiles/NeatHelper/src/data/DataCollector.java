package data;

import java.io.*;
import java.net.*;

public class DataCollector {
	private static CityList cl = new CityList();
	private static CommandCollection cc = new CommandCollection(cl);
	private static Thread tecThread = new Thread(new TimedEventCreator(cc, cl));
	public static void main(String[] args) throws Exception{
		tecThread.start();
		String clientSentence;
		ServerSocket welcomeSocket = new ServerSocket(6789);
		while(true){
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			clientSentence = inFromClient.readLine();
			System.out.println("received: " + clientSentence);
			if(!clientSentence.contains("RequestCommand")){
				Thread process = new Thread(new DataProcessor(clientSentence, cc, cl));
				process.start();
			} else {
				String coords = clientSentence.substring(clientSentence.indexOf("(") + 1, clientSentence.indexOf(")"));
				String output = cc.grabCommand(coords);
				outToClient.writeBytes(output);
				System.out.println(output);
				System.out.println(cc.size());
			}
			connectionSocket.close();
		}
	}
}
