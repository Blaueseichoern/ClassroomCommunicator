package com.connection;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Client
{
	ServerSocket server;
	
	Socket client;
	
	Communicator communicator;
	
	public Client(Communicator com)
	{
		try 
		{
			this.communicator = com;
			
			server = new ServerSocket(2008);
			
			client = new Socket("localhost", 2008);
			
			ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
			
			out.writeObject(new JoinEvent(com.getNickname(), com.getPCName(), client.getInetAddress()));
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
			
	}
		
	private class Receive extends Thread
	{
		@Override
		public void run()
		{
				try 
				{
					ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(server.accept().getInputStream()));
					
					while(true)
					{
						Object obj = ois.readObject();
						
						if(obj != null)
						{
							communicator.handleInput(obj);
						}
					}
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				} 
				catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
				}
		}
	}
	/**
	 * Sends the specified object to the receivers
	 * @param receivers
	 * @param msg
	 */
	public void send(List<Socket> receivers, Object msg)
	{
		for(Socket s : receivers)
		{
			try 
			{
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
				
				oos.writeObject(msg);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * sends to all in the Lan-network (port 2008)
	 * @param msg
	 */
	public void send(Object msg)
	{
		try 
		{
			ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
			
			oos.writeObject(msg);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}

