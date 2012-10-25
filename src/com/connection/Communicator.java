package com.connection;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import com.screen.ComWindow;

public class Communicator 
{
	String nickname, pcName;
	
	ComWindow window;
	
	List<Participant> participants;
	
	public Communicator(String nick, String PC)
	{
		this.pcName = PC;
		this.nickname = nick;
		participants = new ArrayList<Participant>();
	}

	public void handleInput(Object obj) 
	{
		if(obj instanceof Chat)
		{
			this.window.handleText((Chat)obj);
		}
		if(obj instanceof JoinEvent)
		{
			this.addParticipant(((JoinEvent)obj).formParticipant());
		}
	}
	
	public void setWindow(ComWindow com)
	{
		this.window = com;
	}
	
	public static void main(String[] args)
	{
		String user = JOptionPane.showInputDialog("Enter a nickname");
		
		try
		{
			Communicator communicator = new Communicator(user, InetAddress.getLocalHost().getHostName());
			ComWindow com = new ComWindow(communicator);
			communicator.setWindow(com);
		} 
		catch (UnknownHostException e) 
		{
			e.printStackTrace();
		}
	}

	public void addParticipant(Participant part) 
	{
		participants.add(part);
	}

	public void send(String text) 
	{
		// TODO Auto-generated method stub
	}
	
	public String getNickname()
	{
		return this.nickname;
	}
	
	public String getPCName()
	{
		return this.pcName;
	}
	
}
