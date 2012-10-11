package com.connection;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client 
{
	ServerSocket receiver;
	
	Socket client;
	
	Communicator communicator;
	
	List<Socket> connections;
	
	public Client(Communicator com)
	{
		try 
		{
			this.communicator = com;
			
			receiver = new ServerSocket(2008);
			
			client = new Socket("localhost", 2008);
			
			connections = new ArrayList<Socket>();
			
			Thread connect = new Connect();
			connect.start();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	private class Connect extends Thread
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
	
	private class Receive extends Thread
	{
		@Override
		public void run()
		{
				try 
				{
					ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));
					
					while(true)
					{
						Object obj = ois.readObject();
						
						if(obj != null && obj instanceof Chat)
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
}

