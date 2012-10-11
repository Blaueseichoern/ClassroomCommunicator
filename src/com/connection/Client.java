package com.connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * The CLient is used to recieve the data not to store connections, therefore use {@link Participant}
 * @author Markus
 *
 */
public class Client 
{
	ServerSocket receiver;
	Socket socket;
	
	List<Socket> connections;
	
	public Client()
	{
		try 
		{
			receiver  = new ServerSocket(1008);
			connections = new ArrayList<Socket>();
		} 
		catch (IOException e) 
		{			
			e.printStackTrace();
		}
	}
	
	public void startReceiving()
	{
		
	}
	
	public class Receive extends Thread
	{
		@Override
		public void run()
		{
			
		}
	}
	
	public class Connect extends Thread
	{
		@Override
		public void run()
		{
			while(true)
			{
				try 
				{
					connections.add(receiver.accept());
					
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
