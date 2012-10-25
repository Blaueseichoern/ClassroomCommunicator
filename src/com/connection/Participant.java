package com.connection;

import java.net.InetAddress;
import java.net.Socket;

/**
 * Klasse um die Teilnehmer im Chat anzuzeigen
 * @author Markus
 *
 */
public class Participant 
{
	String PCName, username;
	InetAddress address;
	
	public Participant(String PC, String user, InetAddress add)
	{
		PCName = PC;
		username = user;
		this.address = add;
	}
	
	@Override
	public String toString()
	{
		return ("["+PCName+"]"+username);
	}
}
