package com.connection;

import java.net.Socket;

/**
 * Klasse um die Teilnehmer im Chat anzuzeigen
 * @author Markus
 *
 */
public class Participant 
{
	String PCName, username;
	Socket socket;
	
	public Participant(Socket s, String PC, String user)
	{
		socket = s;
		PCName = PC;
		username = user;
	}
	
	@Override
	public String toString()
	{
		return ("["+PCName+"]"+username);
	}
}
