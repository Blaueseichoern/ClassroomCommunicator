package com.connection;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.screen.ComWindow;

public class Communicator 
{
	String username;
	
	List<Participant> participants;
	
	public Communicator()
	{
		participants = new ArrayList<Participant>();
	}

	public void handleInput(Object obj) 
	{
		if(obj instanceof Chat)
		{
			//TODO
		}
	}
	
	public static void main(String[] args)
	{
		ComWindow com = new ComWindow(new Communicator());
	}

	public void addParticipant(Socket client) 
	{
		//TODO PC-Namen und Nickname bekommen
		//participants.add();
	}

	public void send(String text) 
	{
		// TODO Auto-generated method stub
	}
	
}
